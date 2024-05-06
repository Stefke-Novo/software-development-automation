package fon.basketball.analyzer.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fon.basketball.analyzer.models.PlayerMatch;
import fon.basketball.analyzer.services.PlayerMatchService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(PlayerMatchController.class)
class PlayerMatchControllerTest {

    @MockBean
    private PlayerMatchService playerMatchService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAll() throws Exception {
        ArrayList<PlayerMatch> matches = new ArrayList<>(Arrays.asList(new PlayerMatch(),new PlayerMatch()));
        when(playerMatchService.getAll()).thenReturn(matches);
        MvcResult result = mockMvc.perform(get("/api/player-match/all")).andReturn();
        List<PlayerMatch> resultPlayerMatches = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<PlayerMatch>>() {
        });
        assertInstanceOf(ArrayList.class,resultPlayerMatches);
        assertFalse(resultPlayerMatches.isEmpty());
        verify(playerMatchService,times(1)).getAll();
    }
}