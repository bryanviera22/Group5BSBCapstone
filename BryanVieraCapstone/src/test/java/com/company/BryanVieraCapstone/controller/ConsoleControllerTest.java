package com.company.BryanVieraCapstone.controller;

import com.company.BryanVieraCapstone.model.Console;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

    }

}
