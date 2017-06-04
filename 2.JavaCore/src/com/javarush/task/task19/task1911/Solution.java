package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //Создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);
        //Вызываем функцию которая ничего не знает о наших манипуляциях
        testString.printSomething(); //Теперь данные вместо вывода на экран запишутся в массив
        //Преобразовываем массив в строку и преобразовываем все символы в заглавный регистр
        String result = outputStream.toString().toUpperCase();
        //Возвращаем поток System.out на место
        System.setOut(consoleStream);

        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
