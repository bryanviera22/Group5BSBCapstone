package com.company.BryanVieraCapstone.controller;

import com.company.BryanVieraCapstone.dao.ConsoleDao;
import com.company.BryanVieraCapstone.model.Console;
import com.company.BryanVieraCapstone.service.ServiceLayer;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConsoleController {

    @Autowired
    ServiceLayer serviceLayer;

    //create /post
    @RequestMapping(value = "/console", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console){
        return serviceLayer.saveConsole(console);
    }

    //Get by id
    @RequestMapping(value="/console/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Console getConsole(@PathVariable int id){

        return serviceLayer.getConsoleByID(id);
    }

    //Get All
    @RequestMapping(value = "/consoles", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public  List<Console> getAllConsoles(){

        return serviceLayer.getAllConsole();
    }

    //get by manufacturer
    @RequestMapping(value = "/console/manufacturer/{manufacturer}", method = RequestMethod.GET)
    public List<Console> getConsoleByManufacturer(@PathVariable String manufacturer){

        return serviceLayer.getConsoleByManufacturer(manufacturer);
    }

    //update
    @RequestMapping(value = "/console", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateConsole(@RequestBody Console console) {
        serviceLayer.updateConsole(console);
    }

    //delete
    @RequestMapping(value = "/console/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        serviceLayer.deleteConsole(id);
    }


}
