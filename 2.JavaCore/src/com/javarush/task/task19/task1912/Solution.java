package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //Записываем переменную System.out в переменную
        PrintStream consoleStream = System.out;
        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //Создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Меняем поток
        System.setOut(stream);
        //Вызываем функцию которая ничего незнает о наших манипуляциях
        //Данные вывода функции запиисываются в массив outputStream
        testString.printSomething();
        //Заменияем все подстроки "te" на "??"
        StringBuilder sb = new StringBuilder(outputStream.toString().replaceAll("te", "??"));

        //Возвращаем поток System.out на место
        System.setOut(consoleStream);
        //Выводим результат
        System.out.println(sb.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
