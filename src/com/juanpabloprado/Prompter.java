package com.juanpabloprado;

import java.io.Console;
import java.util.Set;

public class Prompter {

  private static final Console console = System.console();
  private Set<Integer> attempts;
  private int max;
  private String itemName;

  public Prompter(Set<Integer> attempts) {
    this.attempts = attempts;
  }

  public int promptForGuess() {
    String s = console.readLine("%nWhat is the number of items stored in the jar? ");
    return Integer.parseInt(s);
  }

  public void displayWelcome() {
    CharSequence separator = "\n=============\n";
    System.out.printf("%nTime to guess the random number! %s", separator);
  }

  public void displayProgress(String hint) {
    //System.out.printf("%s%n", toString());
    System.out.printf("Your guess is %s", hint);
    displayMax();
  }

  private void displayMax() {
    System.out.printf("\t\tRemember the maximum number of %s is %d%n", itemName, max);
  }


  public void promptForJar() {
    itemName = console.readLine("What type of item do you want to store in the jar? ");
  }

  public void promptForMax() {
    String s = console.readLine("What would be the maximum number of items for filling the jar? ");
    max = Integer.parseInt(s);
  }

  public void printStats(String jarType, int tries) {
    System.out.printf("%nGreat work! It took you %d attempt%s to guess the random number of %s%n",
        tries,
        tries > 1 ? "s" : "", jarType);
  }

  public int getMax() {
    return max;
  }

  public String getItemName() {
    return itemName;
  }

  @Override public String toString() {
    return "Prompter{" +
        "attempts=" + attempts +
        ", max=" + max +
        ", itemName='" + itemName + '\'' +
        '}';
  }

  public boolean promptForPlayingAgain() {
    String s = console.readLine("Do you want to play again? (Y/n)");
    return s.equals("") || s.equals("Y") || s.equals("y");
  }

  public void displayWelcomeAgain() {
    System.out.printf("%nThe jar has been filled randomly again, good luck!%n");
  }
}
