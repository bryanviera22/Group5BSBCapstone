package com.company.BryanVieraCapstone.dao;

import com.company.BryanVieraCapstone.model.Game;
import com.company.BryanVieraCapstone.model.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameDaoTest {

    @Autowired
    GameDao dao;

    @Before
    public void setUp() throws Exception {

        List<Game> games = dao.getAllGames();

        games.stream()
                .forEach(game -> dao.deleteGame(game.getGameId()) );
    }

    @Test
    public void addGetDeleteGame(){

        Game game = new Game();
        game.setStudio("Sqaure Enix Holdings Co. Ltd");
        game.setTitle("Life Is Strange: True Colors");
        game.setEsrbRating("Mature");
        game.setDescription("A bold new era of the award-winning Life Is Strange begins, with all-new playable" +
                "lead character and a thrilling mystery to solve! Alex Chen has ling suppressed her 'curse': the " +
                "supernatural ability to experience, absorb, and manipulate the string emotions of others, " +
                "which she sees as blazing, colored auras. When her brother dies in a so-called accident," +
                "Alex must embrace her volatile power to find the truth--and unciver the dark secrets" +
                "buried by a small town.");
        game.setPrice(new BigDecimal("34.99"));
        game.setQuantity(16);

        game = dao.addGame(game);
        Game fromDao = dao.getGame(game.getGameId());
        assertEquals(fromDao, game);
        dao.deleteGame(game.getGameId());
        fromDao = dao.getGame(game.getGameId());
        assertNull(fromDao);
    }

    @Test
    public void getAllGames() {

        Game game = new Game();
        game.setStudio("SEGA Games Co. Ltd");
        game.setTitle("Demon Slayer - Kimetsu no Yaiba - The Hinokami Chronicles");
        game.setEsrbRating("Teen");
        game.setDescription("It is the Taisho Period in Japan. Tanjiro, a kindhearted boy who sells" +
                "charcoal for a living, finds his family slaughtered by a demon. To make matters worse," +
                "his younger sister Nezuko, the sole survivor, has been transformed into a demon herself." +
                "Though devastated by this grim reality, Tanjiro resolves to become a 'demon slayer' so that" +
                "he can turn his sister back into a human and kill the demon that massacred his family. A" +
                "sorrowful tale of siblings in which the fates of humans and demons intertwine . . . begins now!");
        game.setPrice(new BigDecimal("39.99"));
        game.setQuantity(3);
        dao.addGame(game);

        Game game = new Game();
        game.setStudio("Activision Blizzard");
        game.setTitle("Call of Duty Vanguard");
        game.setEsrbRating("Mature");
        game.setDescription("Rise on every front: Dogfight over the Pacific, airdrop over France, " +
                "defend Stalingrad with a sniper's precision and blast through advancing forces in North Africa.");
        game.setPrice(new BigDecimal("69.99"));
        game.setQuantity(21);
        dao.addGame(game);

        List<Game> games = dao.getAllGames();

        assertEquals(2, games.size());
    }

    @Test
    public void getGameByStudio(){

        Game game = new Game();
        game.setStudio("SEGA Games Co. Ltd");
        game.setTitle("Demon Slayer - Kimetsu no Yaiba - The Hinokami Chronicles");
        game.setEsrbRating("Teen");
        game.setDescription("It is the Taisho Period in Japan. Tanjiro, a kindhearted boy who sells" +
                "charcoal for a living, finds his family slaughtered by a demon. To make matters worse," +
                "his younger sister Nezuko, the sole survivor, has been transformed into a demon herself." +
                "Though devastated by this grim reality, Tanjiro resolves to become a 'demon slayer' so that" +
                "he can turn his sister back into a human and kill the demon that massacred his family. A" +
                "sorrowful tale of siblings in which the fates of humans and demons intertwine . . . begins now!");
        game.setPrice(new BigDecimal("39.99"));
        game.setQuantity(3);
        dao.addGame(game);

        Game game = new Game();
        game.setStudio("Activision Blizzard");
        game.setTitle("Call of Duty Vanguard");
        game.setEsrbRating("Mature");
        game.setDescription("Rise on every front: Dogfight over the Pacific, airdrop over France, " +
                "defend Stalingrad with a sniper's precision and blast through advancing forces in North Africa.");
        game.setPrice(new BigDecimal("69.99"));
        game.setQuantity(21);
        dao.addGame(game);

        List<Game> segaGames = dao.getGameByStudio("SEGA Games Co. Ltd");
        assertEquals(1, segaGames.size());
    }

    @Test
    public void getGameByESRBRating(){

        Game game = new Game();
        game.setStudio("SEGA Games Co. Ltd");
        game.setTitle("Demon Slayer - Kimetsu no Yaiba - The Hinokami Chronicles");
        game.setEsrbRating("Teen");
        game.setDescription("It is the Taisho Period in Japan. Tanjiro, a kindhearted boy who sells" +
                "charcoal for a living, finds his family slaughtered by a demon. To make matters worse," +
                "his younger sister Nezuko, the sole survivor, has been transformed into a demon herself." +
                "Though devastated by this grim reality, Tanjiro resolves to become a 'demon slayer' so that" +
                "he can turn his sister back into a human and kill the demon that massacred his family. A" +
                "sorrowful tale of siblings in which the fates of humans and demons intertwine . . . begins now!");
        game.setPrice(new BigDecimal("39.99"));
        game.setQuantity(3);
        dao.addGame(game);

        Game game = new Game();
        game.setStudio("Activision Blizzard");
        game.setTitle("Call of Duty Vanguard");
        game.setEsrbRating("Mature");
        game.setDescription("Rise on every front: Dogfight over the Pacific, airdrop over France, " +
                "defend Stalingrad with a sniper's precision and blast through advancing forces in North Africa.");
        game.setPrice(new BigDecimal("69.99"));
        game.setQuantity(21);
        dao.addGame(game);

        List<Game> gameESRBRating = dao.getGameByEsrb("Mature");
        assertEquals(1, gameESRBRating.size());
    }

    @Test
    public void getGameByTitle(){

        Game game = new Game();
        game.setStudio("SEGA Games Co. Ltd");
        game.setTitle("Demon Slayer - Kimetsu no Yaiba - The Hinokami Chronicles")
        game.setEsrbRating("Teen");
        game.setDescription("It is the Taisho Period in Japan. Tanjiro, a kindhearted boy who sells" +
                "charcoal for a living, finds his family slaughtered by a demon. To make matters worse," +
                "his younger sister Nezuko, the sole survivor, has been transformed into a demon herself." +
                "Though devastated by this grim reality, Tanjiro resolves to become a 'demon slayer' so that" +
                "he can turn his sister back into a human and kill the demon that massacred his family. A" +
                "sorrowful tale of siblings in which the fates of humans and demons intertwine . . . begins now!");
        game.setPrice(new BigDecimal("39.99"));
        game.setQuantity(3);
        dao.addGame(game);

        Game game = new Game();
        game.setStudio("Activision Blizzard");
        game.setTitle("Call of Duty Vanguard");
        game.setEsrbRating("Mature");
        game.setDescription("Rise on every front: Dogfight over the Pacific, airdrop over France, " +
                "defend Stalingrad with a sniper's precision and blast through advancing forces in North Africa.");
        game.setPrice(new BigDecimal("69.99"));
        game.setQuantity(21);
        dao.addGame(game);

        List<Game> gameTitle = dao.getGameByTitle("Demon Slayer - Kimetsu no Yaiba - The Hinokami Chronicles");
        assertEquals(1, gameTitle.size());
    }

    @Test
    public void updateGame(){
        Game game = new Game();
        game.setStudio("Electronic Arts");
        game.setTitle("Madden NFL 22");
        game.setEsrbRating("Everyone");
        game.setDescription("Create your avatar and play your rookie NFL season the way you want. Earn rep " +
                "to level up, and max out. Play through a redesigned campaign featuring stunning locations" +
                "around the globe.");
        game.setPrice(new BigDecimal("39.99"));
        game.setQuantity(46);
        dao.addGame(game);

        game = dao.addGame(game);
        game.setPrice("69.99");
        dao.updateGame(game);
        Game fromDao = dao.getGame(game.getGameId());
        assertEquals(game, fromDao);
    }
}