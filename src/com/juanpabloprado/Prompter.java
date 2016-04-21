package com.juanpabloprado;

import java.io.Console;

public class Prompter {

  private static final Console console = System.console();

  public int promptForGuess() {
    String s = console.readLine("What is the number of items stored in the jar? ");
    return Integer.parseInt(s);
  }

  public void displayProgress(String hint) {
    System.out.printf("Your guess is %s%n", hint);
  }

  public String promptForJar() {
    return console.readLine("What type of item do you want to store in the jar? ");
  }

  public int promptForMax() {
    String s = console.readLine("What would be the maximum number of items for filling the jar? ");
    return Integer.parseInt(s);
  }

  public void printStats(String jarType, int tries) {
    System.out.printf("You guess the random number of %s in %d trie%s", jarType, tries,
        tries > 1 ? "s" : "");
  }
}
