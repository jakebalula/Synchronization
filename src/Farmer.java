/**
 * ========================================================
 * File: FruitMarket.java
 * Author: Jake Balula
 * Course: CS451
 * Date: 11/5
 * Description:
 * The Farmer class represents a producer thread.
 * Each farmer produces one specific type of fruit and tries to
 * put it up for sale in the market. If the market buffer for that
 * fruit is full, the farmer must wait.
 */

public class Farmer extends Thread{
  private int id;
  private String fruitType;
  private FruitMarket market; // Reference to the shared market object

  //Constructor
  public Farmer(int id, String fruitType, FruitMarket market){
    this.id = id;
    this.fruitType = fruitType;
    this.market = market;
  }

  //Run method has the farmer repeatedly produces fruit and puts them into the market
  public void run(){
    for (int i = 0; i < 10; i++){ //Each farmer produces 10 fruits
      market.produceFruit(fruitType, id);
    }
  }
}
