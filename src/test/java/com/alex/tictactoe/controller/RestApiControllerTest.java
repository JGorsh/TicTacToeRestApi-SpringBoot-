package com.alex.tictactoe.controller;

import com.alex.tictactoe.model.GamePlay;
import com.alex.tictactoe.model.Player;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RestApiController.class)
class RestApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private GamePlay gamePlay;

    @Test
    void getGameplay() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/gameplay");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals("Введите в Body request (/gameplay/onePlayer), (/gameplay/twoPlayer) id, name, symbol игроков в JSON формате ",
                result.getResponse().getContentAsString());
    }

    @Test
    void getOnePlayer() throws Exception {
        Player mockPlayerOne = new Player(1,"ivan","X");
        List<Player> players = new ArrayList<>();
        players.add(mockPlayerOne);

        Mockito.when(gamePlay.getPlayers()).thenReturn(players);

        RequestBuilder request = MockMvcRequestBuilders.post("/gameplay/onePlayer").contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(players));
        MvcResult result = mockMvc.perform(request).andReturn();

        String expectedJson = this.mapToJson(players);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    void getTwoPlayer() {
    }

    @Test
    void getGame() {
    }

    @Test
    void getGamePosition() {
    }

    @Test
    void initGame() {
    }

    /**
     * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
     */
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}