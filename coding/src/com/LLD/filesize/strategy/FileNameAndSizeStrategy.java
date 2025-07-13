package com.LLD.filesize.strategy;

import com.LLD.filesize.AbstractNode;
import com.LLD.filesize.DirectoryNode;
import com.LLD.filesize.chainofresponsibility.FileNameFilter;
import com.LLD.filesize.chainofresponsibility.FileSizeFilter;
import com.LLD.filesize.chainofresponsibility.NodeFilterChain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileNameAndSizeStrategy implements NodeSearchStrategy {

    private final NodeFilterChain filterChain;

    public FileNameAndSizeStrategy() {
        this.filterChain = new NodeFilterChain();
        this.filterChain.addFilter(new FileNameFilter());
        this.filterChain.addFilter(new FileSizeFilter());
    }

    @Override
    public List<AbstractNode> search(DirectoryNode node, Map<String, Object> params) {
        List<AbstractNode> results = new ArrayList<>();
        searchRec(node, params, results);
        return results;
    }

    private void searchRec(DirectoryNode node, Map<String, Object> params, List<AbstractNode> results) {
        for (AbstractNode abstractNode: node.getChildren()) {
            if (filterChain.applyFilter(abstractNode, params)) {
                results.add(abstractNode);
            }
            if (abstractNode instanceof DirectoryNode) {
                searchRec((DirectoryNode) abstractNode, params, results);
            }
        }
    }
}
