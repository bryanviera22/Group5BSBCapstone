package com.company.BriannaJohnsonCapstone.gameDao.dao;

import com.company.BriannaJohnsonCapstone.gameDao.model.ESRBRating;

import java.util.List;

public interface ESRBRatingDao {
    ESRBRating addESRBRating(ESRBRating esrbRating);
    ESRBRating getESRBRating(int id);
    List<ESRBRating> getAllESRBRatings();
    void updateESRBRating(ESRBRating esrbRating);
    void deleteESRBRating(int id);
}
