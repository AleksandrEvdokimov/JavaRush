package com.javarush.task.task20.task2009;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
    }

    public static void main(String[] args) throws FileNotFoundException {
       /* FileOutputStream fileOut = new FileOutputStream("/home/saneok/Yandex.Disk/object.dat");*/

    }
}
