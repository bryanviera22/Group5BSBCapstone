package com.company.BryanVieraCapstone.service;

import com.company.BryanVieraCapstone.dao.TShirtDao;
import com.company.BryanVieraCapstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLayer {
    private TShirtDao tShirtDao;

    @Autowired
    public ServiceLayer(TShirtDao tShirtDao){
        this.tShirtDao = tShirtDao;
    }

    //TShirt API------------------

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

}
