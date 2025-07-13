package com.misc;

public class Part {
    private int id;
    private String partName;

    public Part() {
    }

    public Part(int id, String partName) {
        this.id = id;
        this.partName = partName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }
}
