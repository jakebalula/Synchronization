/**
 * File: FruitMarket.java
 * Author: Jake Balula
 * Course: CS451
 * Date: 11/5
 * Description:
 * The FruitMarket class manages the marketplace.
 * Each fruit type has its own buffer (a list) to store available fruits.
 * Farmers can add fruits to the buffer if there’s space,
 * and customers can remove fruits if available.
 * The class uses synchronized methods, wait(), and notifyAll()
 * for thread synchronization
 */

import java.util.*;

public class FruitMarket {
  //A map that holds each fruit type and its current buffer list
  private Map<String, List<String>> fruitBuffers;
  //The max number of fruits of each type that can exist
  private int capacity;
  //List of fruit types to pick at random
  private List<String> fruitTypes = Arrays.asList("Apple", "Orange", "Grape", "Watermelon");

  //Constructor
  public FruitMarket(int capacity){

    this.capacity = capacity;
    fruitBuffers = new HashMap<>();
    fruitBuffers.put("Apple", new ArrayList<>());
    fruitBuffers.put("Orange", new ArrayList<>());
    fruitBuffers.put("Grape", new ArrayList<>());
    fruitBuffers.put("Watermelon", new ArrayList<>());
  }

  //Method called by Farmer to add fruit to the market
  public synchronized void produceFruit(String fruit, int farmerId){
    //Get the correct buffer for the fruit type
    List<String> buffer = fruitBuffers.get(fruit);

    //check if buffer is full and wait
    while(buffer.size() == capacity){
      System.out.println("Farmer " + farmerId + " is waiting to put one " + fruit);
      try{
        wait();
      } catch (InterruptedException e){
        System.out.println(e);
      }
    }

    //Add fruit to the buffer
    buffer.add(fruit);
    System.out.println("Farmer " + farmerId + " put one " + fruit + " up for sale.");
    notifyAll();
  }

  //Method called by customers to buy fruit from the market
  public synchronized void consumeFruit(String fruit, int customerId){
    //Get the correct buffer for the fruit type
    List<String> buffer = fruitBuffers.get(fruit);

    //Check if there are fruits if available, if not wait
    while(buffer.isEmpty()){
      System.out.println("Customer " + customerId + " is waiting to buy one " + fruit + "...");
      try{
        wait();
      } catch (InterruptedException e){
        System.out.println(e);
      }
    }
    //Remove one fruit from buffer
    buffer.remove(0);
    System.out.println("Customer " + customerId + " bought one " + fruit + ".");
    notifyAll();
  }

  public String getRandomFruit(){
    int index = (int)(Math.random() * fruitTypes.size());
    return fruitTypes.get(index);
  }
}
