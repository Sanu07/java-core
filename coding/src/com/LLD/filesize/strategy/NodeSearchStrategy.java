package com.LLD.filesize.strategy;

import com.LLD.filesize.AbstractNode;
import com.LLD.filesize.DirectoryNode;

import java.util.List;
import java.util.Map;

public interface NodeSearchStrategy {

    List<AbstractNode> search(DirectoryNode dir, Map<String, Object> params);
}
