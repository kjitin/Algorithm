package com.oreilly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {


  private BowlingGame game;

  @Before
  public void setUp() throws Exception {
    game = new BowlingGame();
  }

  @Test
  public void gameWorks() {
    game.roll(0);
  }

  private void rollMany(int n, int pins) {
    for (int i = 0; i < n; i++) {
      game.roll(pins);
    }
  }
  @Test
  public void gutterGame() {
    rollMany(20, 0);
    assertEquals(0, game.score());
  }


  @Test
  public void allOnes() {
    rollMany(20, 1);
    assertEquals(20, game.score());
  }

  @Test
  public void oneSpare() {
    rollSpare();
    game.roll(3);
    rollMany(17, 0);
    assertEquals(16, game.score());
  }

  @Test
  public void oneStrike() {
    game.roll(10); //strike
    game.roll(3);
    game.roll(4);
    rollMany(16, 0);
    assertEquals(24, game.score());
  }

  private void rollSpare() {
    game.roll(5);
    game.roll(5);
  }
}
