package com.company.BryanVieraCapstone.dao;

import com.company.BryanVieraCapstone.model.TShirt;
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
public class TShirtDaoTest {

    @Autowired
    TShirtDao dao;

    @Before
    public void setUp() throws Exception{

        List<TShirt> tShirts = dao.getAllTShirts();

        tShirts.stream()
                .forEach(tShirt -> dao.deleteTShirt(tShirt.gettShirtId()) );
    }

    @Test
    public void addGetDeleteTShirt(){

        TShirt tShirt = new TShirt("Large", "Blue", "Race Cars", new BigDecimal("9.99"), 6);
        tShirt = dao.addTShirt(tShirt);
        TShirt fromDao = dao.getTShirt(tShirt.gettShirtId());
        assertEquals(fromDao, tShirt);
        dao.deleteTShirt(tShirt.gettShirtId());
        fromDao = dao.getTShirt(tShirt.gettShirtId());
        assertNull(fromDao);
    }

    @Test
    public void getAllTShirts(){

        TShirt tShirt = new TShirt("Small", "Pink", "Unicorn", new BigDecimal("7.99"), 9);
        dao.addTShirt(tShirt);

        tShirt = new TShirt("Medium", "Red", "Cool Flames", new BigDecimal("8.99"), 3);
        dao.addTShirt(tShirt);

        List<TShirt> tShirts = dao.getAllTShirts();

        assertEquals(2, tShirts.size());

    }

    @Test
    public void updateTShirt(){
        TShirt tShirt = new TShirt("Medium", "Black", "Famous Rock Band", new BigDecimal("9.99"), 7);
        tShirt = dao.addTShirt(tShirt);
        tShirt.setSize("Large");
        dao.updateTShirt(tShirt);
        TShirt fromDao = dao.getTShirt(tShirt.gettShirtId());
        assertEquals(tShirt, fromDao);
    }










}
