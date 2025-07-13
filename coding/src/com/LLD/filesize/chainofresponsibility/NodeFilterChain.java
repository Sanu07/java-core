package com.LLD.filesize.chainofresponsibility;

import com.LLD.filesize.AbstractNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NodeFilterChain {

    private List<NodeFilter> filters;

    public NodeFilterChain() {
        this.filters = new ArrayList<>();
    }

    public void addFilter(NodeFilter filter) {
        filters.add(filter);
    }

    public boolean applyFilter(AbstractNode node, Map<String, Object> params) {
        for (NodeFilter nodeFilter: filters) {
            if (!nodeFilter.apply(node, params)) {
                return false;
            }
        }
        return true;
    }
}
