//package com.company.BryanVieraCapstone.service;
//
//import com.company.BryanVieraCapstone.dao.TShirtDao;
//import com.company.BryanVieraCapstone.dao.TShirtDaoJdbcTemplateImpl;
//import com.company.BryanVieraCapstone.model.TShirt;
//import junit.framework.TestCase;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.mock;
//
//public class ServiceLayerTest extends TestCase {
//
//    ServiceLayer service;
//    TShirtDao tShirtDao;
//
//    @Before
//    public void setUp() throws Exception{
//        setUpTShirtDaoMock();
//
//        service = new ServiceLayer(tShirtDao);
//    }
//
//    @Test
//    public void saveFindAllTShirts(){
//        //Arrange
//        TShirt tShirt = new TShirt();
//        tShirt.setSize("Medium");
//        tShirt.setColor("Red");
//        tShirt.setDescription("Birds");
//        tShirt.setPrice(new BigDecimal("8.99"));
//        tShirt.setQuantity(10);
//
//        //act
//        tShirt = service.saveTShirt(tShirt);
//        TShirt fromService = service.getTShirtByID(tShirt.gettShirtId());
//        //assert
//        assertEquals(tShirt, fromService);
//
//        List<TShirt> aList = service.getAllTShirts();
//        assertEquals(1, aList.size());
//        assertEquals(tShirt, aList.get(0));
//    }
//
//
//
//    //TShirt Mock Set Up
//    private void setUpTShirtDaoMock() {
//
//        mock(TShirtDaoJdbcTemplateImpl.class);
//
//        TShirt tShirt = new TShirt();
//        tShirt.settShirtId(1);
//        tShirt.setSize("Large");
//        tShirt.setColor("Blue");
//        tShirt.setDescription("Flying Cats");
//        tShirt.setPrice(new BigDecimal("9.99"));
//        tShirt.setQuantity(9);
//
//        TShirt tShirt2 = new TShirt();
//        tShirt.settShirtId(25);
//        tShirt.setSize("Medium");
//        tShirt.setColor("Pink");
//        tShirt.setDescription("Nasa");
//        tShirt.setPrice(new BigDecimal("8.99"));
//        tShirt.setQuantity(4);
//
//        List<TShirt> aList = new ArrayList<>();
//        aList.add(tShirt);
//
//        doReturn(tShirt).when(tShirtDao).addTShirt(tShirt2);
//        doReturn(tShirt).when(tShirtDao).getTShirt(1);
//        doReturn(aList).when(tShirtDao).getAllTShirts();
//
//    }
//
//
//}
