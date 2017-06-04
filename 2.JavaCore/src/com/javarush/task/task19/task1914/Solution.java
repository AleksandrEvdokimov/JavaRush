package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream console = new PrintStream(outputStream);
        System.setOut(console);
        testString.printSomething();
        System.setOut(consoleStream);
        String[] array = outputStream.toString().split(" ");
        int a, b, c = 0;
        a = Integer.parseInt(array[0]);
        b = Integer.parseInt(array[2]);
        if (array[1].equals("+"))
            c = a + b;
        else if (array[1].equals("-"))
            c = a - b;
        else if (array[1].equals("*"))
            c = a * b;
        System.out.println(a + " " + array[1] + " " + b + " = " + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

