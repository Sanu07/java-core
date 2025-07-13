package com.LLD.filesize;

public class FileNode extends AbstractNode {

    private String content;
    private int size;

    public FileNode(String name) {
        super(name);
        this.content = "";
        this.size = 0;
    }

    @Override
    int getSize() {
        return this.size;
    }

    public void appendContent(String content) {
        this.content += content;
        this.size = content.getBytes().length;
    }

    public String readContent() {
        return this.content;
    }
}
