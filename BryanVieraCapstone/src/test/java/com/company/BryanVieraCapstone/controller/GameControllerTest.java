package com.company.BryanVieraCapstone.controller;

import com.company.BryanVieraCapstone.model.Game;
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
@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Game> gameList;

    @Before
    public void setUp() throws Exception{

    }

    @Test
    public void shouldReturnAllGames() throws Exception {

        String outputJson = mapper.writeValueAsString(gameList);

        mockMvc.perform(get("/games"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnNewGameOnPostRequest() throws Exception{

        Game inputGame = new Game();
        inputGame.setStudio("Nintendo");
        inputGame.setTitle("Mario Kart 8 Deluxe");
        inputGame.setEsrbRating("Everyone");
        inputGame.setDescription("Hit the road with the definitive version of Mario Kart 8 and play" +
                "anytime, anywhere! Race your friends or battle them in a revised battle mode" +
                "on new and returning battle courses.");
        inputGame.setPrice(new BigDecimal("39.99"));
        inputGame.setQuantity(37);
    }
}
