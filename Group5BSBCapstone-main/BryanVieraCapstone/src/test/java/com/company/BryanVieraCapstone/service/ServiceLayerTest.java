//package com.company.BryanVieraCapstone.service;
//
//import com.company.BryanVieraCapstone.dao.ConsoleDao;
//import com.company.BryanVieraCapstone.dao.TShirtDao;
//import com.company.BryanVieraCapstone.dao.TShirtDaoJdbcTemplateImpl;
//import com.company.BryanVieraCapstone.model.TShirt;
//import junit.framework.TestCase;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.mock;
//
//public class ServiceLayerTest extends TestCase {
//
//    ServiceLayer service;
//    TShirtDao tShirtDao;
//    ConsoleDao consoleDao;
//
//    @Before
//    public void setUp() throws Exception{
//        setUpTShirtDaoMock();
//        setUpConsoleDaoMock();
//
//        service = new ServiceLayer(tShirtDao, consoleDao);
//
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
//    //Console service layer
//
//    @Test
//    public void saveFindConsole(){
//        ConsoleViewMo
//    }
////
////        AlbumViewModel avm = new AlbumViewModel();
////
////        avm.setListPrice((new BigDecimal("14.99")));
////        avm.setReleaseDate(LocalDate.of(1999,05,15));
////        avm.setTitle("Greatest Hits");
////
////        Artist artist = new Artist();
////        artist.setInstagram("@RockStar");
////        artist.setName("The GOAT");
////        artist.setTwitter("@TheRockStar");
////
////        artist = service.saveArtist(artist);
////        avm.setArtist(artist);
////
////        Label label = new Label();
////        label.setName("Blue Note");
////        label.setWebsite("www.bluenote.com");
////        label = service.saveLabel(label);
////
////        avm.setLabel(label);
////
////        Track track = new Track();
////        track.setRunTime(180);
////        track.setTitle("Number 1 Hit");
////
////        List<Track>tList= new ArrayList<>();
////        tList.add(track);
////
////        avm.setTracks(tList);
////        avm = service.saveAlbum(avm);
////
////        AlbumViewModel fromService =service.findAlbum(avm.getId());
////        assertEquals( avm, fromService);
////
////
////    }
//
//}
