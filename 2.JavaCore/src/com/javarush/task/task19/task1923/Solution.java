package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(args[1]));
        String line;
        String result = "";
        while ((line = fileIn.readLine()) != null)
        {
            for (String word : line.split(" "))
                if (word.matches(".*\\d.*"))
                    result += word + " ";

        }
        fileIn.close();
        fileOut.write(result);
        fileOut.close();
    }
}
