package com.company.BryanVieraCapstone.controller;

import com.company.BryanVieraCapstone.model.Game;
import com.company.BryanVieraCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game){

        return serviceLayer.saveGame(game);
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGameById(@PathVariable int id){

        return serviceLayer.getGameById(id);
    }

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGames(){

        return serviceLayer.getAllGames();
    }

    @RequestMapping(value = "/game", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateGame(@RequestBody Game game){
        serviceLayer.updateGame(game);
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGameById(@PathVariable int id){

        serviceLayer.deleteGame(id);
    }

    @RequestMapping(value = "/game/studio/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByStudio(@PathVariable String studio){

        return serviceLayer.getGameByStudio(studio);
    }

    @RequestMapping(value = "/game/esrbRating/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByesrbRating(@PathVariable String esrbRating){

        return serviceLayer.getGameByESRBRating(esrbRating);
    }

    @RequestMapping(value = "/game/title/{title}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByTitle(@PathVariable String title){

        return  serviceLayer.getGameByTitle(title);
    }

}
