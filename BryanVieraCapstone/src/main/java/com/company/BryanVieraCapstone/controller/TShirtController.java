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
    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.GET)     //  /tshirt/id/{id} ??
    @ResponseStatus(value = HttpStatus.OK)
    public TShirt getTShirtById(@PathVariable int id){

        return serviceLayer.getTShirtByID(id);
    }

    //getALL
    @RequestMapping(value = "/tshirt", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getAllTShirts(){

        return serviceLayer.getAllTShirts();
    }

    //update
    @RequestMapping(value = "/tshirt", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
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
    @RequestMapping(value = "/tshirt/{color}", method = RequestMethod.GET) // "/tshirt/color/{color}
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getTShirtByColor(@PathVariable String color){

        return serviceLayer.getTShirtByColor(color);
    }

    //getBySize
    @RequestMapping(value = "/tshirt/{size}", method = RequestMethod.GET) // "/tshirt/size/{size}
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getTShirtBySize(@PathVariable String size){

        return serviceLayer.getTShirtBySize(size);
    }

}


//    //CREATE
//    @RequestMapping(value = "/tshirt", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public TShirt createTShirt(@RequestBody @Valid TShirt tShirt){
//
//        tShirt.settShirtId(idCounter++);
//        tShirtList.add(tShirt);
//
//        return tShirt;
//    }
//
//    //READ BY ID
//    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public TShirt getTShirtById(@PathVariable int id){
//       TShirt foundTShirt = null;
//
//       for(TShirt tShirt : tShirtList){
//           if(tShirt.gettShirtId() == id){
//               foundTShirt = tShirt;
//               break;
//           }
//       }
//
//       return foundTShirt;
//    }
//
//    //READ ALL
//    @RequestMapping(value= "/tshirts", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<TShirt> getAllTShirts(@RequestParam(required = false) String tshirt){
//
//        return tShirtDao.getAllTShirts();
//
//        //return service.t....
////        List<TShirt> returnList = new ArrayList<>();
////        return returnList;
//    }
//
//
//    //UPDATE
//    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.PUT)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void updateTShirtById(@PathVariable int id, @RequestBody TShirt tShirt){
//        int index =-1;
//
//        for(int i = 0; i<tShirtList.size(); i++){
//            if(tShirtList.get(i).gettShirtId() == id){
//                index = 1;
//                break;
//            }
//        }
//        if (index >=0){
//            tShirtList.set(index, tShirt);
//        }
//    }
//
//    //DELETE
//    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void deleteTShirtById(@PathVariable int id){
//
//        int index = -1;
//
//        for(int i = 0; i < tShirtList.size(); i++){
//            if(tShirtList.get(i).gettShirtId() == id){
//                index = 1;
//                break;
//            }
//
//        }
//        if (index >= 0){
//            tShirtList.remove(index);
//        }
//    }
//
//    //GET BY COLOR
//    @RequestMapping(value = "/tshirt/{color}", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public TShirt getTShirtByColor(@PathVariable String color){
//
//        TShirt foundTShirt = null;
//
//        for(TShirt tShirt : tShirtList){
//            if(tShirt.getColor() == color){
//                foundTShirt = tShirt;
//                break;
//            }
//        }
//        return foundTShirt;
//    }
//
//    //GET BY SIZE
//    @RequestMapping(value = "/tshirt/{size}", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public TShirt getTShirtBySize(@PathVariable String size){
//
//        TShirt foundTShirt = null;
//
//        for(TShirt tShirt : tShirtList){
//            if(tShirt.getSize() == size){
//                foundTShirt = tShirt;
//                break;
//            }
//        }
//
//        return foundTShirt;
//    }

