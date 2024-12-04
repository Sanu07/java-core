package com.design.behavioral.command;

import java.util.ArrayList;
import java.util.List;

// this call is responsible to store the commands being executed.
// helpful in redo undo
// should be the entry point for all the interaction with the Command classes like OpenTextFileOp and SaveTextFileOp
public class TextFileOperationExecutor {

    private final List<TextFileOperation> textFileOperations = new ArrayList<>();

    public void executeOperation(TextFileOperation textFileOperation) {
        textFileOperation.execute();
        textFileOperations.add(textFileOperation);
    }
}
