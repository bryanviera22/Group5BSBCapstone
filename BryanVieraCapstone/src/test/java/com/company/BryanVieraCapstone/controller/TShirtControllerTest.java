package com.company.BryanVieraCapstone.controller;

import com.company.BryanVieraCapstone.model.TShirt;
import com.company.BryanVieraCapstone.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TShirtController.class)
public class TShirtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    private List<TShirt> tShirtList;

    @Before
    public void setUp() throws Exception{

    }

    // TESTING GET /tshirts
    @Test
    public void shouldReturnAllTShirtsInCollection() throws Exception{

        String outputJson = mapper.writeValueAsString(tShirtList);

        mockMvc.perform(get("/tshirts"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //TESTING POST /tshirts
    @Test
    public void shouldReturnNewRecordOnPostRequest() throws Exception{

        //ARRANGE
        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("Medium");
        inputTShirt.setColor("Black");
        inputTShirt.setDescription("Old Popular Movie");
        inputTShirt.setPrice(new BigDecimal("8.99"));
        inputTShirt.setQuantity(11);


    }





}
