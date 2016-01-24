package com.sean.mavendemo.main.service;

import com.sean.mavendemo.main.mapper.persistencemodal.Goal;

/**
 * Created by sean on 1/17/16.
 */

public interface GoalService {

    Goal getById(Integer id);
    void insertMultiple() throws Exception;
}
