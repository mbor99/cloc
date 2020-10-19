package com.boroda.interview;

import java.io.File;
import java.util.Scanner;

public class SourceCodeLineCounter {

    final static String QUIT_PATTERN = "q";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PrinterImpl printer = new PrinterImpl();

        String input = "";
        while (!QUIT_PATTERN.equalsIgnoreCase(input)) {

            System.out.print("Enter file or folder path to calculate lines of code : ");

            input = scanner.nextLine();
            System.out.println("Calculate lines of code for next path : " + input);
            System.out.println(printer.printDirectoryTree(new File(input)));
        }
    }
}




