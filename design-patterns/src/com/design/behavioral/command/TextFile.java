package com.design.behavioral.command;

public class TextFile {

    private String fileName;

    public TextFile(String fileName) {
        this.fileName = fileName;
    }

    public void open() {
        System.out.println("Opening file " + this.fileName);
    }

    public void save() {
        System.out.println("Saving file " + this.fileName);
    }
}
