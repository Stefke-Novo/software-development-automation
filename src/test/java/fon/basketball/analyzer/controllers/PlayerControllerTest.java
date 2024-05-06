package fon.basketball.analyzer.controllers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fon.basketball.analyzer.models.Player;
import fon.basketball.analyzer.models.PlayerMatch;
import fon.basketball.analyzer.models.Team;
import fon.basketball.analyzer.services.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(PlayerController.class)
class PlayerControllerTest {

    @MockBean
    private PlayerService playerService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAll() throws Exception {
        Player player1 = new Player();
        Player player2 = new Player();
        ArrayList<Player> players = new ArrayList<>(Arrays.asList(player1,player2));
        when(playerService.getAll()).thenReturn(players);
        MvcResult result = mockMvc.perform(get("/api/player/all").contentType(MediaType.APPLICATION_JSON)).andReturn();
        List<Player> returnedPlayers = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Player>>() {
        });
        assertTrue(returnedPlayers.contains(player1));
        assertTrue(returnedPlayers.contains(player2));
        verify(playerService, times(1)).getAll();
    }

    @Test
    void getPlayerById() throws Exception {
        Player player = new Player();
        player.setId(1);
        when(playerService.getPlayerById(player.getId())).thenReturn(player);
        MvcResult result = mockMvc.perform(get("/api/player/1").contentType(MediaType.APPLICATION_JSON)).andReturn();
        Player resultPlayer = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<Player>() {
        });
        assertEquals(player,resultPlayer);
        verify(playerService,times(1)).getPlayerById(player.getId());
    }

    @Test
    void getPlayerByNameSurenameAndNumber() {
        assertTrue(true);
    }

    @Test
    void updatePlayer() throws Exception {
        Team team = new Team();
        team.setId(1);
        team.setCity("City1");
        team.setName("Team1");
        team.setState("State1");
        team.setRoster(new ArrayList<>());
        Player player = new Player();
        player.setId(1);
        player.setNumber(11);
        player.setName("Mika");
        player.setSurname("Mikic");
        player.setMatches(new ArrayList<>());
        Player changedPlayer = new Player();
        changedPlayer.setId(1);
        changedPlayer.setNumber(15);
        player.setName("Mika");
        player.setSurname("Mikic");
        changedPlayer.setTeam(team);
        changedPlayer.setMatches(new ArrayList<>());

        when(playerService.updatePlayer(player)).thenReturn(changedPlayer);

        MvcResult result = mockMvc.perform(post("/api/player/update").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(player))).andReturn();
        Player resultPlayer = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<Player>() {
        });
        assertNotEquals(resultPlayer,changedPlayer);
        verify(playerService,times(1)).updatePlayer(player);
    }

    @Test
    void deletePlayer() throws Exception {
        Player player = new Player();
        when(playerService.deletePlayer(player)).thenReturn(player);
        MvcResult result = mockMvc.perform(post("/api/player/delete").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(player))).andReturn();
        Player resultPlayer = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<Player>() {
        });
        assertEquals(resultPlayer,player);
        verify(playerService, times(1)).deletePlayer(player);
    }
}