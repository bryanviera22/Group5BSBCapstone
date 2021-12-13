package com.company.BriannaJohnsonCapstone.gameDao.controller;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
public class GameController {

    @RequestMapping(value = "/gameStudio", method = RequestMethod.GET)
    public String viewStudio() {
        return "Here are the studios.";
    }

    @RequestMapping(value = "/registerGameStudio", method = RequestMethod.GET)
    public String registerGameStudio() {
        return "You are registering a studio game.";
    }

    @RequestMapping(value = "/privateEvent", method = RequestMethod.GET)
    public String viewESRBRating(Principal principal) {
        return "Here is the ESRB Rating" + principal.getName();
    }

    @RequestMapping(value = "/privateEvent/{id}", method = RequestMethod.DELETE)
    public String deletePrivateEvent(Principal principal, @PathVariable int id) {
        return "You (" + principal.getName() + ") have deleted the private event with id " + id + ".";
    }


    @RequestMapping(value = "/registerPrivateEvent", method = RequestMethod.GET)
    public String registerPrivateEvent(Principal principal) {
        return "Here are the private events from registerPrivateEvent endpoint, exclusively for you, " + principal.getName();
    }

    @RequestMapping(value = "/guestList", method = RequestMethod.GET)
    public String displayGuestList(Principal principal) {
        return "Hello, " + principal.getName() + ". Because you are an event publisher, you can see this guest list.";
    }

    @RequestMapping(value = "/eventPublishersList", method = RequestMethod.GET)
    public String showAllEventPublishers(Principal principal) {
        return "Hello, " + principal.getName() + ". You may view a list of event publishers.";
    }

    @RequestMapping(value = "/allDone", method = RequestMethod.GET)
    public String calledByLogout() {
        return "You are logged out.";
    }
}

