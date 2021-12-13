package com.company.BriannaJohnsonCapstone.gameDao.dao;

public interface TitleDao {
    Title addTitle(Title title);
    Title getTitle(int id);
    List<Title> getAllTitles();
    void updateTitle(Title title);
    void deleteTitle(int id);
}
