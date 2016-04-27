package com.juanpabloprado;

import java.util.HashSet;
import java.util.Set;

public class GameHelper {
  private Jar jar;
  private Set<Integer> tries;
  private Prompter prompter;
  private int currentGuess;

  public GameHelper() {
    onStart();
  }

  private void onStart() {
    tries = new HashSet<Integer>();
    prompter = new Prompter(tries);
    prompter.promptForJar();
    prompter.promptForMax();
    jar = new Jar(prompter.getItemName(), prompter.getMax());
  }

  public void play() {
    jar.fill();
    prompter.displayWelcome();
    do {
      keepGuessing();
    } while (isGuessDifferent());
    prompter.printStats(jar.getItemName(), tries.size());
    boolean isPlayingAgain = prompter.promptForPlayingAgain();
    if(isPlayingAgain) {
      prompter.displayWelcomeAgain();
      play();
    }
  }

  private boolean isGuessDifferent() {
    return jar.getNumber() != currentGuess;
  }

  private void keepGuessing() {
    currentGuess = prompter.promptForGuess();
    tries.add(currentGuess);
    if (isHigh()) {
      prompter.displayProgress("too high!");
    } else if (isLow()) {
      prompter.displayProgress("too low!");
    } else {
      prompter.displayProgress("correct! :)");
    }
  }

  private boolean isLow() {
    return currentGuess < jar.getNumber();
  }

  private boolean isHigh() {
    return currentGuess > jar.getNumber();
  }
}
