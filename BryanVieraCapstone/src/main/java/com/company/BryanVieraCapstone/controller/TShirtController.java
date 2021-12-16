package com.company.BryanVieraCapstone.controller;

import com.company.BryanVieraCapstone.dao.TShirtDao;
import com.company.BryanVieraCapstone.model.TShirt;
import com.company.BryanVieraCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TShirtController {

    @Autowired
    ServiceLayer serviceLayer;


    //create
    @RequestMapping(value = "/tshirt", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TShirt createTShirt(@RequestBody @Valid TShirt tShirt){

        return serviceLayer.saveTShirt(tShirt);
    }

    //getByID
    @RequestMapping(value = "/tshirts/{id}", method = RequestMethod.GET)     //  /tshirt/id/{id} ??
    @ResponseStatus(value = HttpStatus.OK)
    public TShirt getTShirtById(@PathVariable int id){

        return serviceLayer.getTShirtByID(id);
    }

    //getALL
    @RequestMapping(value = "/tshirts", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getAllTShirts(){

        return serviceLayer.getAllTShirts();
    }

    //update
    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@RequestBody TShirt tShirt){
        serviceLayer.updateTShirt(tShirt);
    }

    //delete
    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirtById(@PathVariable int id){

        serviceLayer.deleteTShirt(id);
    }

    //getByColor
    @RequestMapping(value = "/tshirt/color/{color}", method = RequestMethod.GET) // "/tshirt/color/{color}
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getTShirtByColor(@PathVariable String color){

        return serviceLayer.getTShirtByColor(color);
    }

    //getBySize
    @RequestMapping(value = "/tshirt/size/{size}", method = RequestMethod.GET) // "/tshirt/size/{size}
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getTShirtBySize(@PathVariable String size){

        return serviceLayer.getTShirtBySize(size);
    }

}
