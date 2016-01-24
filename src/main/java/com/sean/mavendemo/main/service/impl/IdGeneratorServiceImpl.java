package com.sean.mavendemo.main.service.impl;

import com.sean.mavendemo.main.mapper.IdGeneratorMapper;
import com.sean.mavendemo.main.mapper.persistencemodal.Sequence;
import com.sean.mavendemo.main.service.IdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sean on 1/24/16.
 */

@Component
public class IdGeneratorServiceImpl implements IdGeneratorService {

    private final IdGeneratorMapper idGeneratorMapper;
    private Map<String, Hilo> map = new ConcurrentHashMap<>();

    private final static int INTERVAL = 3;

    @Autowired
    public IdGeneratorServiceImpl(IdGeneratorMapper idGeneratorMapper) {
        this.idGeneratorMapper = idGeneratorMapper;
    }

    @Override
    public Integer nextId(Class<?> entityClass) {
        if (!map.containsKey(entityClass.getName())) {
            Integer nextHigh = getnextHigh(entityClass);
            Integer low = (nextHigh - 1) * INTERVAL + 1;
            map.put(entityClass.getName(), new Hilo(nextHigh, low, INTERVAL));
            return low;
        }
        Hilo hilo = map.get(entityClass.getName());
        if (hilo.getLow() < (hilo.getHigh() * hilo.getInterval())) {
            AtomicInteger ai = new AtomicInteger(hilo.getLow());
            int andAdd = ai.addAndGet(1);
            hilo.setLow(andAdd);
            return andAdd;
        }
        int nextHigh = this.getnextHigh(entityClass);
        int result = ((nextHigh - 1) * hilo.getInterval()) + 1;
        hilo.setLow(result);
        hilo.setHigh(nextHigh);
        return result;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
    private Integer getnextHigh(Class<?> entityClass) {
        String typeName = entityClass.getTypeName();
        Sequence sequenceByEntityName = this.idGeneratorMapper.getSequenceByEntityName(typeName);
        if (sequenceByEntityName != null) {
            this.idGeneratorMapper.updateHighNumber(entityClass.getName());
            return sequenceByEntityName.getHigh() + 1;
        }
        Sequence newSeq = Sequence.createNew(entityClass.getName());
        this.idGeneratorMapper.insert(newSeq);
        return newSeq.getHigh();
    }

    private static class Hilo {
        private int high;
        private int low;
        private int interval;

        public Hilo(int high, int low, int interval) {
            this.high = high;
            this.low = low;
            this.interval = interval;
        }

        public int getHigh() {
            return high;
        }

        public int getLow() {
            return low;
        }

        public void setLow(int low){
            this.low = low;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        public int getInterval() {
            return interval;
        }
    }
}
