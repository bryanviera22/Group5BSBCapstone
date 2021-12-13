package com.company.BriannaJohnsonCapstone.gameDao.dao;

import com.company.BriannaJohnsonCapstone.gameDao.model.Studio;

import java.util.List;

public interface StudioDao {
    Studio addStudio(Studio studio);
    Studio getStudio(int id);
    List<Studio> getAllStudios();
    void updateStudio(Studio studio);
    void deleteStudio(int id);
}
