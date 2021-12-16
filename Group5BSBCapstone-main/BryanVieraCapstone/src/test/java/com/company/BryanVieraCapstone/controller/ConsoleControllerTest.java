package com.company.BryanVieraCapstone.controller;

import com.company.BryanVieraCapstone.model.Console;
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

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Console> consoleList;

    @Before
    public void setUp() throws Exception{

    }
    @Test
    public void shouldReturnAllConsole() throws Exception{
        String outputJson = mapper.writeValueAsString(consoleList);

        mockMvc.perform(get("/consoles"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnNewConsoleOnPostRequest() throws Exception{

        //ARRANGE
        Console inputConsole = new Console();
        inputConsole.setModel("X-Box S");
        inputConsole.setManufacturer("Microsoft");
        inputConsole.setMemory_amount("700.2GB");
        inputConsole.setProcessor("Intel");
        inputConsole.setPrice(new BigDecimal("299.00"));
        inputConsole.setQuantity(2);

        String inputJson = mapper.writeValueAsString(inputConsole);

        Console outputConsule = new Console();
        outputConsule.setModel("PS5");
        outputConsule.setManufacturer("Sony");
        outputConsule.setMemory_amount("667.2GB");
        outputConsule.setProcessor("AMD");
        outputConsule.setPrice(new BigDecimal("599.95"));
        outputConsule.setQuantity(28);

        String outputJson = mapper.writeValueAsString(outputConsule);

        mockMvc.perform(
                post("/console")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)

                        .andDo(print())
                        .andExpect(status().isCreated()));

    }
    @Test
    public void shouldReturnConsoleById() throws Exception{
        Console outputConsole = new Console();
        outputConsole.setModel("X-Box S");
        outputConsole.setManufacturer("Microsoft");
        outputConsole.setMemory_amount("700.2GB");
        outputConsole.setProcessor("Intel");
        outputConsole.setPrice(new BigDecimal("299.00"));
        outputConsole.setQuantity(2);
        outputConsole.setId(3);

        String outputJson = mapper.writeValueAsString(outputConsole);

        mockMvc.perform(get("/console/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode()throws Exception{
        Console inputConsole= new Console();
        inputConsole.setModel("X-Box S");
        inputConsole.setManufacturer("Microsoft");
        inputConsole.setMemory_amount("700.2GB");
        inputConsole.setProcessor("Intel");
        inputConsole.setPrice(new BigDecimal("299.00"));
        inputConsole.setQuantity(2);
        inputConsole.setId(3);

        String inputJson = mapper.writeValueAsString(inputConsole);

        mockMvc.perform(
                put("/console/2")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .andDo(Print())
                        .andExpect(status().isNoContent()));


    }
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode()throws Exception{
        mockMvc.perform(delete("console/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}