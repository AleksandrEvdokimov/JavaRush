package com.javarush.task.task15.task1530;

/**
 * Created by saneok777 on 17.02.17.
 */
public abstract class DrinkMaker {

    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    protected void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
