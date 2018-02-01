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
    fruitMachine = new FruitMachine(0.50);
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
    public void cantSpendWhenNoFunds() {
        game.player.setWallet(0);
        assertEquals("Sorry, not enough funds.", game.startGame(1,5,9));
    }

    @Test
    public void canGetFruitMachineCost() {
        assertEquals(0.50, game.fruitMachine.getCost(), 0.01);
    }

    @Test
    public void canSetFruitMachineCost() {
        assertEquals(5.00, game.fruitMachine.setCost(5.00), 0.01);
    }

    @Test
    public void fruitMachineCanAddReels() {
        assertEquals(10, game.fruitMachine.reel1.size());
        assertEquals(10, game.fruitMachine.reel2.size());
        assertEquals(10, game.fruitMachine.reel3.size());
    }

    @Test
    public void fruitMachineSetsThreeReelArrays() {
        game.fruitMachine.setupPlayfield(5,5, 5);
        assertEquals(3, game.fruitMachine.getPlayfield().size());
    }

    @Test
    public void canCalculateWinnings() {
        assertEquals(3, game.fruitMachine.calculateWinnings(Symbol.CHERRY));
        assertEquals(6, game.fruitMachine.calculateWinnings(Symbol.ORANGE));
        assertEquals(15, game.fruitMachine.calculateWinnings(Symbol.LEMON));
        assertEquals(30, game.fruitMachine.calculateWinnings(Symbol.BAR));
        assertEquals(180, game.fruitMachine.calculateWinnings(Symbol.DIAMOND));
    }
}
