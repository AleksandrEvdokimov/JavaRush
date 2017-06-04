package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String file_name1 = reader.readLine();
            String file_name2 = reader.readLine();
            reader.close();

            allLines = Files.readAllLines(Paths.get(file_name1)/*, StandardCharsets.UTF_8*/);
            forRemoveLines = Files.readAllLines(Paths.get(file_name2)/*, StandardCharsets.UTF_8*/);
        } catch (IOException e) {}

        Solution solution = new Solution();

        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            /*e.printStackTrace();*/
            /*System.err.println("Обработанное в main исключение");*/

        }

    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
