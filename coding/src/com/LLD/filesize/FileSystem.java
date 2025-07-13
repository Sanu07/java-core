package com.LLD.filesize;

import com.LLD.filesize.strategy.NodeSearchStrategy;

import java.util.List;
import java.util.Map;

public class FileSystem {

    private final DirectoryNode root;

    public FileSystem() {
        this.root = new DirectoryNode("/");
    }

    private DirectoryNode traverse(String filePath, boolean createIfMissing) {
        String[] paths = filePath.split("/");
        DirectoryNode current = root;
        for (int i = 1; i < paths.length; i++) {
            AbstractNode nextNode = current.getNode(paths[i]);
            if (!(nextNode instanceof DirectoryNode)) {
                if (!createIfMissing) {
                    return null;
                } else {
                    current.addNode(new DirectoryNode(paths[i]));
                }
            }
            current = (DirectoryNode) current.getNode(paths[i]);
        }
        return current;
    }

    public void mkdir(String path) {
        traverse(path, true);
    }

    public void addFile(String fileName, String content) {
        String parentFilePath = fileName.substring(0, fileName.lastIndexOf("/"));
        String filePath = fileName.substring(fileName.lastIndexOf("/") + 1);
        DirectoryNode parent = traverse(parentFilePath, true);

        FileNode fileNode = (FileNode) parent.getNode(filePath);
        if (fileNode == null) {
            fileNode = new FileNode(filePath);
            parent.addNode(fileNode);
        }
        fileNode.appendContent(content);
    }

    public List<AbstractNode> searchNodes(String dirPath, NodeSearchStrategy nodeSearchStrategy, Map<String, Object> params) {
        DirectoryNode directory = traverse(dirPath, false);
        return nodeSearchStrategy.search(directory, params);
    }
}
