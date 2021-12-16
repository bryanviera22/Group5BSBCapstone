package com.company.BryanVieraCapstone.dao;

import com.company.BryanVieraCapstone.model.Console;

import java.util.List;

public interface ConsoleDao {

    Console addConsole (Console console);
    Console getConsole (int id);
    List<Console> getConsoleByManufacturer(String manufacturer);
    List<Console> getAllConsole();
    void updateConsole (Console console);
    void deleteConsole (int id);
}
