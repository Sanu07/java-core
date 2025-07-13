package com.LLD.filesize;

import lombok.Data;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
public abstract class AbstractNode {

    private String name;
    private ZonedDateTime createdAt;
    private int size;

    public AbstractNode(String name) {
        this.name = name;
        this.createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
        this.size = 0;
    }

    abstract int getSize();
}
