package com.boroda.interview;

import java.io.BufferedReader;
import java.io.File;

public interface LineCounter {

    int calculateLinesInFolder(File folderOrFile);

    int calculateLinesOfCode(BufferedReader bReader);

}
