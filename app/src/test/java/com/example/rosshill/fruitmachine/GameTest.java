package com.example.rosshill.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rosshill on 30/01/2018.
 */

public class GameTest {

    FruitMachine fruitMachine;
    Player player;
    Game game;

    @Before
    public void before() {
    fruitMachine = new FruitMachine();
    player = new Player("Ross", 2.50);
    game = new Game(fruitMachine, player);}

    @Test
    public void playerHasName() {
        assertEquals("Ross", game.player.getName());
    }

    @Test
    public void playerHasMoney() {
        assertEquals(2.50, game.player.getWallet(), 0.01);
    }

    @Test
    public void fruitMachineCanAddReels() {
        assertEquals(10, game.fruitMachine.reel1.size());
        assertEquals(10, game.fruitMachine.reel2.size());
        assertEquals(10, game.fruitMachine.reel3.size());
    }

    @Test
    public void fruitMachineSetsThreeReelArrays() {
        assertEquals(3, game.fruitMachine.getPlayfield().size());
    }
}