package com.company.BryanVieraCapstone.service;

import com.company.BryanVieraCapstone.dao.ConsoleDao;
import com.company.BryanVieraCapstone.dao.GameDao;
import com.company.BryanVieraCapstone.dao.TShirtDao;
import com.company.BryanVieraCapstone.model.Console;
import com.company.BryanVieraCapstone.model.Game;
import com.company.BryanVieraCapstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLayer {
    private TShirtDao tShirtDao;
    private ConsoleDao consoleDao;

    @Autowired
    public ServiceLayer(TShirtDao tShirtDao, ConsoleDao consoleDao){

        this.tShirtDao = tShirtDao;
        this.consoleDao = consoleDao;
    }

    //TShirt API-----------------------------

    //create
    public TShirt saveTShirt(TShirt tShirt){
        return tShirtDao.addTShirt(tShirt);
    }

    //readByID
    public TShirt getTShirtByID(int id){
        return tShirtDao.getTShirt(id);
    }

    //getAllTShirts
    public List<TShirt> getAllTShirts(){
        return tShirtDao.getAllTShirts();
    }

    //updateTShirt
    public void updateTShirt(TShirt tShirt){
        tShirtDao.updateTShirt(tShirt);
    }

    //deleteTShirt
    public void deleteTShirt(int id){
        tShirtDao.deleteTShirt(id);
    }

    //getByCOLOR
    public List<TShirt> getTShirtByColor(String color){
        return tShirtDao.getTShirtByColor(color);
    }

    //getBySIZE
    public List<TShirt> getTShirtBySize(String size){
        return tShirtDao.getTShirtSize(size);
    }

    //Console API----------------------------------

    public Console saveConsole(Console console){
        return consoleDao.addConsole(console);
    }

    public Console getConsoleByID(int id){
        return consoleDao.getConsole(id);
    }

    public List<Console>getAllConsole() {
        return consoleDao.getAllConsole();
    }

    public void updateConsole(Console console){
        consoleDao.updateConsole(console);
    }

    public void deleteConsole(int id){
        consoleDao.deleteConsole(id);
    }

    public List<Console> getConsoleByManufacturer(String manufacturer){
        return consoleDao.getConsoleByManufacturer(manufacturer);
    }

    //Game API-----------------------------------
    public Game saveGame(Game game) {
        return GameDao.addGame(game);
    }
    public Game getGameById(int id) {
        return GameDao.getGame(id);
    }
    public List<Game> getAllGames() {
        return GameDao.getAllGames();
    }
    public void updateGame(Game game) { GameDao.updateGame(game);
    }
    public void deleteGame(int id) {
        return GameDao.deleteGame(id);
    }
    public List<Game> getGameByStudio(String studio) { return GameDao.getGameByStudio(studio);
    }
    public List<Game> getGameByESRBRating(String esrbRating) {
        return GameDao.getGameByEsrb(esrbRating);
    }
    public List<Game> getGameByTitle(String title) {
        return GameDao.getGameByTitle(title);
    }
}
