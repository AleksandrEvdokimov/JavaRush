package com.javarush.task.task15.task1521;

import java.math.BigDecimal;

/* 
ООП - перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        //Блок 2.
        //Вызов для Object (задание 2)
        new Tree().info(new Integer("4"));
        new Tree().info(new Short("4"));
        new Tree().info(new BigDecimal("4"));

        //Блок 3.
        //Вызов для Number (Задание 3)
        new Tree().info(new Integer("4"));
        new Tree().info(new Short("4"));
        new Tree().info(new BigDecimal("4"));

        //Блок 4.
        //Вызов для String (Задание 4)
        new Tree().info(new String("4"));
        new Tree().info(new Integer("4").toString());
        new Tree().info(new Short("4").toString());
        new Tree().info(new BigDecimal("4").toString());
    }
}
