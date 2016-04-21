package com.juanpabloprado;

import java.util.Random;

public class Game {

  public static final int MAX_ITEMS_ALLOWED = 20;

  public static void main(String[] args) {
    Random random = new Random();
    int someNumber = random.nextInt(MAX_ITEMS_ALLOWED);
    // Some number will be between 0 and 19
    System.out.printf("The random number is %d.%n", someNumber);
  }
}
