package com.LLD.filesize.chainofresponsibility;

import com.LLD.filesize.AbstractNode;

import java.util.Map;

public interface NodeFilter {
    boolean apply(AbstractNode node, Map<String, Object> params);
}
