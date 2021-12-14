package com.company.BryanVieraCapstone.controller;

import com.company.BryanVieraCapstone.dao.ConsoleDao;
import com.company.BryanVieraCapstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsoleController {

    @Autowired
    ConsoleDao dao;

    @RequestMapping(value = "/console", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Console createRsvp(@RequestBody Console console) {
        System.out.println("CREATING CONSOLE");
        return dao.addConsole(console);
    }
    @RequestMapping(value="/console/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Console getConsole(@PathVariable int id){
        System.out.println("GETTING CONSOLE ID=" + id );
        return dao.getConsole(id);
    }
    @RequestMapping(value = "/console/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Console getConsoleByManufacturer(@PathVariable String manufacturer){
        System.out.println("GETTING CONSOLE MANUFACTURER = "+ manufacturer);
        return dao.getConsoleByManufacturer(manufacturer);
    }
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getAllConsole() {
        System.out.println("GETTING ALL CONSOLE");
        return dao.getAllConsole();
    }

    @RequestMapping(value = "/console", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateConsole(@RequestBody Console console) {
        System.out.println("UPDATING CONSOLE ID = " + console.getId());
        dao.updateConsole(console);
    }
    @RequestMapping(value = "/console/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteConsole(@PathVariable int id) {
        System.out.println("DELETING CONSOLE ID = " + id   );
        dao.deleteConsole(id);
    }


}
