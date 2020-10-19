package com.boroda.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;


class CalculateLinesOfCodeTest {

    @Test
    void calculateFile() {
        LineCounterImpl lineCounter = new LineCounterImpl();
        String fileName = Paths.get("./src/test/java/com/boroda/interview/CalculateLinesOfCodeTest.java").toAbsolutePath().toString();
        Assertions.assertEquals(37, lineCounter.calculateLinesInFolder(new File(fileName)));
    }

    @Test
    void calculateFolder() {
        LineCounterImpl lineCounter = new LineCounterImpl();
        String fileName = Paths.get("./src/test/java/com/boroda/interview").toAbsolutePath().toString();
        Assertions.assertEquals(40, lineCounter.calculateLinesInFolder(new File(fileName)));
    }

    @Test
    void checkOutputForFile() {
        PrinterImpl printer = new PrinterImpl();
        String fileName = Paths.get("./src/test/java/com/boroda/interview/CalculateLinesOfCodeTest.java").toAbsolutePath().toString();
        String expectedOutput = "+--CalculateLinesOfCodeTest.java : 37\n";
        Assertions.assertEquals(expectedOutput, printer.printDirectoryTree(new File(fileName)));
    }

    @Test
    void checkOutputForFolder() {
        PrinterImpl printer = new PrinterImpl();
        String fileName = Paths.get("./src/test/java/com/boroda/interview").toAbsolutePath().toString();
        String expectedOutput = "+--interview/ : 40\n" +
                "|  +--CalculateLinesOfCodeTest.java : 37\n" +
                "|  +--testFolder/ : 3\n" +
                "|  |  +--TestFile.java : 3\n";
        String actualOutput = printer.printDirectoryTree(new File(fileName));
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

}
