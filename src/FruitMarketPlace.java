/**
 * File: FruitMarketPlace.java
 * Author: Jake Balula
 * Course: CS451
 * Date: 11/5
 * Description:
 * This program simulates a fruit marketplace where multiple farmers
 * and customers interact using threads.
 * Each fruit type (apple, orange, grape, watermelon) has its own
 * buffer to represent its limited market capacity.
 */

public class FruitMarketPlace {
  public static void main(String[] args){
    int bufferSize = 5; // Capacity for each fruit

    //Create new FruitMarket Object
    FruitMarket market = new FruitMarket(bufferSize);

    new Farmer(1, "Apple", market).start();
    new Farmer(2, "Orange", market).start();
    new Farmer(3, "Grape", market).start();
    new Farmer(4, "Watermelon", market).start();

    new Customer(1, market).start();
    new Customer(2, market).start();
    new Customer(3, market).start();
    new Customer(4, market).start();
    new Customer(5, market).start();
    new Customer(6, market).start();
  }
}
