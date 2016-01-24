package com.sean.mavendemo.main.mapper;

import com.sean.mavendemo.main.mapper.persistencemodal.Goal;

import java.util.List;

/**
 * Created by sean on 12/19/15.
 */
public interface GoalMapper {

    Integer getCountForGoal();

    int getMinutesById(final int id);

    Goal getGoalById(final Integer id);

    void insert(final Goal goal) throws Exception;

    void update(final Goal goal);

    List<Goal> getGoals();
}
