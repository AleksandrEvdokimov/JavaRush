package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //Сохраняем поток вывода в переменную
        PrintStream consoleStream = System.out;
        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //Создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Меняем поток, теперь весь вывод будет писаться в массив
        System.setOut(stream);
        //Вызываем функцию, которая не знает по подмене вывода
        //теперь она будет писать данные в массив outputStream
        testString.printSomething();
        //Возвращаем переменной System.out первоначальный поток
        System.setOut(consoleStream);
        //Фильтруем вывод, остовляем только цифры
        String result = outputStream.toString().replaceAll("[^0-9]", "");
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
