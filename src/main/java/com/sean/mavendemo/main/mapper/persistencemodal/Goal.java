package com.sean.mavendemo.main.mapper.persistencemodal;

import org.apache.ibatis.type.Alias;

/**
 * Created by sean on 12/19/15.
 */

@Alias("Goal")
public class Goal {
    private int id;
    private int minutes;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", minutes=" + minutes +
                '}';
    }
}
