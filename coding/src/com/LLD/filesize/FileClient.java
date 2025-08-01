package com.LLD.filesize;

import com.LLD.filesize.strategy.FileNameAndSizeStrategy;
import com.LLD.filesize.strategy.NodeSearchStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileClient {

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();

        fs.mkdir("/a/b/c/d");
        fs.addFile("/a/b/c/file1.txt", "Hello");
        fs.addFile("/a/b/c/file2.log", "Data");
        fs.addFile("/a/b/c/d/file5.log", "Data");
        fs.addFile("/a/file3.txt", "Some large content to increase file size...");
        fs.addFile("/a/file4.txt", "Short");

        System.out.println("Searching for files and directories matching regex 'file.*\\.txt' with size between 5 and 50 bytes:");

        NodeSearchStrategy strategy = new FileNameAndSizeStrategy();
        Map<String, Object> searchParams = new HashMap<>();
        searchParams.put("filenameRegex", "file.*\\.txt");
        searchParams.put("minSize", 5);
        searchParams.put("maxSize", 50);

        List<AbstractNode> foundNodes = fs.searchNodes("/a", strategy, searchParams);

        for (AbstractNode node : foundNodes) {
            if (node instanceof FileNode) {
                System.out.println("[FILE] " + node.getName() + " (Size: " + ((FileNode) node).getSize() + " bytes)");
            } else {
                System.out.println("[DIR] " + node.getName() + " ---> " + node.getSize());
            }
        }
    }
}
