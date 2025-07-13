package com.LLD.filesize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DirectoryNode extends AbstractNode {

    private final Map<String, AbstractNode> children;

    public DirectoryNode(String name) {
        super(name);
        this.children = new ConcurrentHashMap<>();
    }

    @Override
    int getSize() {
        int totalSize = 0;
        for (AbstractNode node: children.values()) {
            totalSize += node.getSize();
        }
        return totalSize;
    }

    public AbstractNode getNode(String key) {
        return this.children.get(key);
    }

    public void addNode(AbstractNode node) {
        this.children.put(node.getName(), node);
    }

    public List<AbstractNode> getChildren() {
        return new ArrayList<>(children.values());
    }
}
