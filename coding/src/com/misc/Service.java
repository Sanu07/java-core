package com.misc;

import java.util.List;

public class Service {
    private int id;
    private String serviceName;
    private List<Part> parts;


    public Service(int id, String serviceName, List<Part> parts) {
        this.id = id;
        this.serviceName = serviceName;
        this.parts = parts;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public Service() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
