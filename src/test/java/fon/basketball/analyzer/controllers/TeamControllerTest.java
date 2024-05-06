package fon.basketball.analyzer.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fon.basketball.analyzer.models.Team;
import fon.basketball.analyzer.services.TeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeamController.class)
class TeamControllerTest {

    @MockBean
    private TeamService teamService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    @Test
    void getAll() throws Exception {
        Team team1 = new Team();
        Team team2 = new Team();
        ArrayList<Team> list = new ArrayList<>();
        list.add(team1);
        list.add(team2);
        when(this.teamService.getAll()).thenReturn(list);
        MvcResult result = mockMvc.perform(get("/api/team/all").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        List<Team> returnedTeams = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Team>>() {
        });
        assertTrue(returnedTeams.contains(team1));
        assertTrue(returnedTeams.contains(team2));
        verify(teamService,times(1)).getAll();
    }
}