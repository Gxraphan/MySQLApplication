package com.fanqfang.mysqlapplication;

import java.io.Serializable;

/**
 * Created by fanqfang on 2/10/2017 AD.
 */

public class TodoList implements Serializable{
    public int taskid;
    public String taskname;

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }
}
