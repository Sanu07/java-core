package com.LLD.filesize.chainofresponsibility;

import com.LLD.filesize.AbstractNode;

import java.util.Map;

public class FileNameFilter implements NodeFilter {
    @Override
    public boolean apply(AbstractNode node, Map<String, Object> params) {
        return true;
    }
}
