package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Anya", 10);
    Player player2 = new Player(2, "Petya", 8);
    Player player3 = new Player(3, "Kolya", 8);


    @Test
    public void firstPlayerIsNotRegistered() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Olya", "Anya");

        });
    }

    @Test
    public void secondPlayerIsNotRegistered() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anya", "Alice");

        });
    }

    @Test
    public void testDuplicatePlayerRegistration() {
        Game game = new Game();

        game.register(player1);
        game.register(player1);

        int expected = 1;
        int actual = game.getPlayers().size();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void firstPlayerWon() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);


        int expected = 1;
        int actual = game.round("Anya", "Petya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWon() {
        Game game = new Game();
        Player player1 = new Player(1, "Anya", 10);
        Player player2 = new Player(2, "Petya", 12);

        game.register(player1);
        game.register(player2);


        int expected = 2;
        int actual = game.round("Anya", "Petya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void drawAtTheTournament() {
        Game game = new Game();

        game.register(player2);
        game.register(player3);


        int expected = 0;
        int actual = game.round("Petya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }


}