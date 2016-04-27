package com.juanpabloprado;

import java.util.HashSet;
import java.util.Set;

public class GameHelper {
  private Jar jar;
  private Set<Integer> tries;
  private Prompter prompter;
  private int currentGuess;
  private int highScore;

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

    int score = tries.size();
    //System.out.printf(String.valueOf(highScore));
    if(isHighScoreBeaten(score)) {
      highScore = score;
      prompter.printNewHighScore(highScore);
    }

    prompter.printStats(jar.getItemName(), score);
    boolean isPlayingAgain = prompter.promptForPlayingAgain();
    if (isPlayingAgain) {
      playAgain();
    }
  }

  private boolean isHighScoreBeaten(int score) {
    return highScore == 0 || highScore > score;
  }

  private void playAgain() {
    prompter.displayWelcomeAgain();
    tries.clear();
    play();
  }

  private boolean isGuessDifferent() {
    return jar.getNumber() != currentGuess;
  }

  private void keepGuessing() {
    currentGuess = prompter.promptForGuess();
    tries.add(currentGuess);
    if (currentGuess > jar.getCapacity()) {
      prompter.displayProgress("over the maximum amount." + jar.getCapacity());
    } else {
      if (isHigh()) {
        prompter.displayProgress("too high!");
      } else if (isLow()) {
        prompter.displayProgress("too low!");
      } else {
        prompter.displayProgress("correct! :)");
      }
    }
  }

  private boolean isLow() {
    return currentGuess < jar.getNumber();
  }

  private boolean isHigh() {
    return currentGuess > jar.getNumber();
  }
}
