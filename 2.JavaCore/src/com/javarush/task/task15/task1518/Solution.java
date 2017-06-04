package com.javarush.task.task15.task1518;

/* 
Статики 3
*/

public class Solution {

    static class Cat
    {
        public String name;
    }

    public static Cat cat;
    static {
        Cat newCat = new Cat();
        newCat.name = "Vasiliy";
        cat = newCat;
        System.out.println(cat.name);
    }

    public static void main(String[] args) {

    }
}
