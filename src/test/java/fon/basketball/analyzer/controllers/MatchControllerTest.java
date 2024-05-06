package fon.basketball.analyzer.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fon.basketball.analyzer.models.Match;
import fon.basketball.analyzer.services.MatchService;
import fon.basketball.analyzer.services.TeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MatchController.class)
class MatchControllerTest {

    @MockBean
    private MatchService matchService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void getAll() throws Exception {
        Match match1 = new Match();
        Match match2 = new Match();
        List<Match> matchList = Arrays.asList(match1,match2);
        when(matchService.getAll()).thenReturn(matchList);
        MvcResult result = mockMvc.perform(get("/api/match/all")).andExpect(status().isOk()).andReturn();
        List<Match> returnedMatches =objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Match>>() {
        });
        assertTrue(returnedMatches.contains(match1));
        assertTrue(returnedMatches.contains(match2));
    }
}