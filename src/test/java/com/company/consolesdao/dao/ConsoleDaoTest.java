//package com.company.consolesdao.dao;
//
//import com.company.consolesdao.model.Console;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ConsoleDaoTest {
//    @Autowired
//    ConsoleDao dao;
//
//    @Before
//    public void setUp() throws Exception {
//
//        List<Console> rsvps = dao.getAllConsole();
//
//        rsvps.stream()
//                .forEach(rsvp -> dao.deleteConsole(rsvp.getId()));
//    }
//    @Test
//    public void addGetDeleteConsole() {
//        Console console = new Console("PS5","Sony","667.2GB","AMD",599.95,4);
//        console= dao.addConsole(console);
//        Console fromDao = dao.getConsole(console.getId());
//        assertEquals(fromDao, console);
//        dao.deleteConsole(console.getId());
//        fromDao = dao.getConsole(console.getId());
//        assertNull(fromDao);
//    }
//    @Test
//    public void getAllConsole() {
//        Console console = new Console("PS5","Sony","667.2GB","AMD", BigDecimal.valueOf("599.95") ,4);
//        dao.addConsole(console);
//
//        console = new Console("X-Box S","Microsoft","700.2GB","Intel",299.00., 5);
//        dao.addConsole(console);
//
//        List<Console> consoles = dao.getAllConsole();
//
//        assertEquals(2, consoles.size());
//    }
//    @Test
//    public void updateConsole() {
//        Console console = new Console("X-Box S","Microsoft","700.2GB","Intel",299.00., 8);
//        console = dao.addConsole(console);
//        console.setManufacturer("NEW NAME");
//        dao.updateConsole(console);
//        Console fromDao = dao.getConsole(console.getId());
//        assertEquals(console, fromDao);
//    }
//
//}