package com.sean.mavendemo.main.mapper.persistencemodal;

import org.apache.ibatis.type.Alias;

/**
 * Created by sean on 1/24/16.
 */
@Alias("Sequence")
public class Sequence {

    public static Sequence createNew(String entityName) {
        Sequence seq = new Sequence();
        seq.setEntityName(entityName);
        seq.setHigh(1);
        seq.setInterval(3);
        return seq;
    }

    private int high;
    private int interval;
    private String entityName;

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
