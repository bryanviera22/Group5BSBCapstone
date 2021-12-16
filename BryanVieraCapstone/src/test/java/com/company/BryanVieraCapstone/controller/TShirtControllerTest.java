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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
    public void shouldReturnNewTShirtOnPostRequest() throws Exception{

        //ARRANGE
        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("Medium");
        inputTShirt.setColor("Black");
        inputTShirt.setDescription("Old Popular Movie");
        inputTShirt.setPrice(new BigDecimal("8.99"));
        inputTShirt.setQuantity(11);

        //Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(inputTShirt);

        TShirt outputTShirt = new TShirt();
        outputTShirt.setSize("Medium");
        outputTShirt.setColor("Black");
        outputTShirt.setDescription("Old Popular Movie");
        outputTShirt.setPrice(new BigDecimal("8.99"));
        outputTShirt.setQuantity(11);
        outputTShirt.settShirtId(10);

        String outputJson = mapper.writeValueAsString(outputTShirt);

        //ACT
        mockMvc.perform(
                post("/tshirt")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }

    //TESTING GET /tshirts/{id}
    @Test
    public void shouldReturnTShirtById() throws Exception{

        TShirt outputTShirt = new TShirt();
        outputTShirt.setSize("Large");
        outputTShirt.setColor("Pink");
        outputTShirt.setDescription("A Beautiful Landscape");
        outputTShirt.setPrice(new BigDecimal("9.99"));
        outputTShirt.setQuantity(21);
        outputTShirt.settShirtId(16);

        String outputJson = mapper.writeValueAsString(outputTShirt);

        mockMvc.perform(get("/tshirts/16"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    //TESTING PUT /tshirts/{id}
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception{

        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("Small");
        inputTShirt.setColor("Orange");
        inputTShirt.setDescription("Pokemon");
        inputTShirt.setPrice(new BigDecimal("7.99"));
        inputTShirt.setQuantity(18);
        inputTShirt.settShirtId(4);

        String inputJson = mapper.writeValueAsString(inputTShirt);

        mockMvc.perform(
                put("/tshirt/4")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturn422statusCodeIfIdsDoNotMatch() throws Exception{

        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("Small");
        inputTShirt.setColor("Orange");
        inputTShirt.setDescription("Pokemon");
        inputTShirt.setPrice(new BigDecimal("7.99"));
        inputTShirt.setQuantity(18);
        inputTShirt.settShirtId(4);

        String inputJson = mapper.writeValueAsString(inputTShirt);

        mockMvc.perform(
                put("/tshirt/5")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn404StatusIfTShirtNotfound() throws Exception{
        mockMvc.perform(get("/tshirts/0"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidRequestBody() throws Exception{

        //ARRANGE
        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("Medium");
        inputTShirt.setColor("Black");
        inputTShirt.setDescription("Old Popular Movie");
        inputTShirt.setPrice(new BigDecimal("8.99"));
        inputTShirt.setQuantity(11);

        //Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(inputTShirt);

        TShirt outputTShirt = new TShirt();
        outputTShirt.setSize("Medium");
        outputTShirt.setColor("Black");
        outputTShirt.setDescription("Old Popular Movie");
        outputTShirt.setPrice(new BigDecimal("8.99"));
        outputTShirt.setQuantity(11);
        outputTShirt.settShirtId(6);

        String outputJson = mapper.writeValueAsString(outputTShirt);

        //ACT
        mockMvc.perform(
                post("/tshirt")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422statusCodeIfRequestBodyIsInvalid() throws Exception{

        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("Small");
        inputTShirt.setColor("Orange");
        inputTShirt.setPrice(new BigDecimal("7.99"));
        inputTShirt.setQuantity(18);
        inputTShirt.settShirtId(4);

        String inputJson = mapper.writeValueAsString(inputTShirt);

        mockMvc.perform(
                put("/tshirt/4")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception{

        mockMvc.perform(delete("/record/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }









}
