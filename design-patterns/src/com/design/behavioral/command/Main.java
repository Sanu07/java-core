package com.design.behavioral.command;

public class Main {
    public static void main(String[] args) {
        TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
        TextFileOperation openTextFileOperation = new OpenTextFileOperation(new TextFile("file-1.txt"));
        TextFileOperation saveTextFileOperation = new SaveTextFileOperation(new TextFile("file-2.txt"));

        textFileOperationExecutor.executeOperation(openTextFileOperation);
        textFileOperationExecutor.executeOperation(saveTextFileOperation);
    }
}
