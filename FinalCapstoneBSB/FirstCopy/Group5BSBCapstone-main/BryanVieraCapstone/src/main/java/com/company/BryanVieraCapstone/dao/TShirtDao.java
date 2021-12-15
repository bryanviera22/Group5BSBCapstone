package com.company.BryanVieraCapstone.dao;

import com.company.BryanVieraCapstone.model.TShirt;

import java.util.List;

public interface TShirtDao {

    //create
    TShirt addTShirt(TShirt tshirt);

    //Read(get) TShirt by id
    TShirt getTShirt(int id);

    //Read(get) all
    List<TShirt> getAllTShirts();

    //Update
    void updateTShirt(TShirt tShirt);

    //Delete
    void deleteTShirt(int id);

    //Read(get) TShirt by Color
    List<TShirt> getTShirtByColor(String color);

    //Read(get) TShirt by Size
    List<TShirt> getTShirtSize(String size);


}
