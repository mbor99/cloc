package com.boroda.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PrinterImpl implements Printer {

    private LineCounterImpl lineCounter;

    PrinterImpl() {
        this.lineCounter = new LineCounterImpl();
    }

    public String printDirectoryTree(File folder) {
        if (!folder.isDirectory()) {
            return printFile(folder, 0, new StringBuilder()).toString();
        }
        int indent = 0;
        StringBuilder sb = new StringBuilder();
        printDirectoryTree(folder, indent, sb);
        return sb.toString();
    }

    private String printDirectoryTree(File folder, int indent, StringBuilder sb) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("folder is not a Directory");
        }
        sb.append(getIndentString(indent));
        sb.append("+--");
        sb.append(folder.getName());
        sb.append("/");
        sb.append(" : ");
        sb.append(lineCounter.calculateLinesInFolder(folder));
        sb.append("\n");
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                printDirectoryTree(file, indent + 1, sb);
            } else {
                printFile(file, indent + 1, sb);
            }
        }
        return sb.toString();
    }

    private StringBuilder printFile(File file, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent));
        sb.append("+--");
        sb.append(file.getName());
        sb.append(" : ");
        try (BufferedReader br = Files.newBufferedReader(Paths.get(file.getAbsolutePath()))) {
            sb.append(lineCounter.calculateLinesOfCode(br));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb.append("\n");
        return sb;
    }

    private static String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("|  ");
        }
        return sb.toString();
    }
}
