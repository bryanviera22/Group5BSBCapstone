package com.company.BryanVieraCapstone.dao;

import com.company.BryanVieraCapstone.model.Game;

import java.util.List;

public interface GameDao {

    //Create
    Game addGame(Game game);

    //Read Game By id
    Game getGame(int id);

    //Read all
    List<Game> getAllGames();

    //Update
    void updateGame(Game game);

    //Delete
    void deleteGame(int id);

    //Read Game by Studio
    List<Game> getGameByStudio(String studio);

    //Read Game by ESRB
    List<Game> getGameByEsrb(String esrbRating);

    //Read Game by Title
    List<Game> getGameByTitle(String title);

}