package com.sean.mavendemo.main.service.impl;

import com.sean.mavendemo.main.mapper.persistencemodal.Goal;
import com.sean.mavendemo.main.mapper.GoalMapper;
import com.sean.mavendemo.main.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sean on 1/17/16.
 */

@Component
public class GoalServiceImpl implements GoalService {

    private final GoalMapper mapper;

    @Autowired
    public GoalServiceImpl(final GoalMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Goal getById(Integer id) {
        return this.mapper.getGoalById(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public void insertMultiple() throws Exception {
        Goal g = new Goal();
        g.setMinutes(9876111);
        this.mapper.insert(g);

        g = new Goal();
        g.setMinutes(98762222);
//        this.mapper.insert(g);
    }

}
