package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {
        LatteMaker cupOfLatte = new LatteMaker();
        cupOfLatte.makeDrink();

        TeaMaker cupOfTea = new TeaMaker();
        cupOfTea.makeDrink();
    }
}
