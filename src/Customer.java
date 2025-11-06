/**
 * ========================================================
 * File: FruitMarket.java
 * Author: Jake Balula
 * Course: CS451
 * Date: 11/5
 * Description:
 * The Customer class represents a consumer thread.
 * Each customer attempts to buy one specific type of fruit.
 * If the desired fruit is sold out, the customer waits until
 * the fruit becomes available again.
 */

public class Customer extends Thread {
  private int id;
  private FruitMarket market;

  public Customer(int id, FruitMarket market){
    this.id = id;
    this.market = market;
  }

  public void run(){
    for (int i = 0; i < 5; i++) { //Each customer tries to buy 5 fruits
      //Randomly pick what fruit to buy
      String desiredFruit = market.getRandomFruit();

      //Attempt to buy that fruit
      market.consumeFruit(desiredFruit, id);
    }
  }
}
