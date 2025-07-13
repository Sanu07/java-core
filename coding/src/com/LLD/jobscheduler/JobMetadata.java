package com.LLD.jobscheduler;

import lombok.Data;

@Data
public class JobMetadata {

    private int id;
    private String name;
    private Job job;
    private long startTimeInMillis;
    private long intervalInMillis;
    private boolean cancelled;

    public JobMetadata(int id, String name, Job job, long startTimeInMillis, long intervalInMillis) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.startTimeInMillis = startTimeInMillis;
        this.intervalInMillis = intervalInMillis;
    }
}
