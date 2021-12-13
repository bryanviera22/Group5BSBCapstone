package com.company.consolesdao.dao;

import com.company.consolesdao.model.Console;

import java.util.List;

public interface ConsoleDao{
    Console addConsole (Console console);
    Console getConsole (int id);
    Console getConsoleByManufacturer(String manufacturer);
    List<Console> getAllConsole();
    void updateConsole (Console console);
    void deleteConsole (int id);

}
