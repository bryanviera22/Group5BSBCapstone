package com.company.BryanVieraCapstone.dao;

import com.company.BryanVieraCapstone.model.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsoleDaoTest {

    @Autowired
    ConsoleDao dao;

    @Before
    public void setUp() throws Exception{

        List<Console> consoles = dao.getAllConsole();

        consoles.stream()
                .forEach(console -> dao.deleteConsole(console.getId()));
    }
    @Test
    public void addGetDeleteConsole() {

        Console console = new Console();
        console.setModel("X-Box S");
        console.setManufacturer("Microsoft");
        console.setMemory_amount("700.2GB");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("299.00"));
        console.setQuantity(2);

        console = dao.addConsole(console);
        Console fromDao = dao.getConsole(console.getId());
        assertEquals(fromDao, console);
        dao.deleteConsole(console.getId());
        fromDao = dao.getConsole(console.getId());
        assertNull(fromDao);
    }


    @Test
    public void getAllConsole(){

        Console console = new Console();
        console.setModel("X-Box S");
        console.setManufacturer("Microsoft");
        console.setMemory_amount("700.2GB");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("299.00"));
        console.setQuantity(2);
        dao.addConsole(console);

        console = new Console();
        console.setModel("PS5");
        console.setManufacturer("Sony");
        console.setMemory_amount("667.2GB");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("599.95"));
        console.setQuantity(28);
        dao.addConsole(console);

        List<Console> consoles = dao.getAllConsole();

        assertEquals(2, consoles.size());

    }
    @Test
    public void updateConsole(){
        Console console = new Console();
        console.setModel("X-Box S");
        console.setManufacturer("Microsoft");
        console.setMemory_amount("700.2GB");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("299.00"));
        console.setQuantity(2);

        console = dao.addConsole(console);
        console.setManufacturer("Sony");
        dao.updateConsole(console);
        Console fromDao = dao.getConsole(console.getId());
        assertEquals(console, fromDao);
    }

    @Test
    public void getConsoleByManufacturer() {
        Console console = new Console();
        console.setModel("PS5");
        console.setManufacturer("Sony");
        console.setMemory_amount("667.2GB");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("599.95"));
        console.setQuantity(28);
        dao.addConsole(console);

        console = new Console();
        console.setModel("X-Box S");
        console.setManufacturer("Microsoft");
        console.setMemory_amount("700.2GB");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("299.00"));
        console.setQuantity(2);
        dao.addConsole(console);

        List<Console> sonyConsole = dao.getConsoleByManufacturer("Sony");
        assertEquals(1, sonyConsole.size());
    }

}
