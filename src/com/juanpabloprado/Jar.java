package com.juanpabloprado;

import java.util.Random;

public class Jar {
  private final Random random;
  private String itemName;
  private int randomNumber;
  private int capacity;

  public Jar(String itemName, int capacity) {
    if (capacity > Game.MAX_ITEMS_ALLOWED) {
      throw new IllegalArgumentException("Specify a capacity that stays in the bounds of reality");
    }
    this.capacity = capacity;
    this.itemName = itemName;
    random = new Random();
  }

  public void fill() {
    randomNumber = random.nextInt(capacity) + 1;
  }

  public String getItemName() {
    return itemName;
  }

  public int getCapacity() {
    return capacity;
  }

  public int getNumber() {
    return randomNumber;
  }
}
