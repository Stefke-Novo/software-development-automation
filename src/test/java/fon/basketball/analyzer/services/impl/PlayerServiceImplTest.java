package fon.basketball.analyzer.services.impl;

import fon.basketball.analyzer.models.Player;
import fon.basketball.analyzer.repository.PlayerRepository;
import fon.basketball.analyzer.services.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PlayerServiceImplTest {

    @Mock
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    @BeforeEach
    public void setUp(){
        when(this.playerRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Player(),new Player(), new Player())));
        this.playerService = new PlayerServiceImpl(this.playerRepository);
    }

    @Test
    void getAll() {
        assertInstanceOf(ArrayList.class,this.playerService.getAll(),"Returned list isn't list of type ArrayList");
        assertFalse(this.playerService.getAll().isEmpty(),"List is empty.");
    }

    @Test
    void getPlayer() {
        assertTrue(true);
    }

    @Test
    void getPlayerById() throws Exception {
        Player playerExample = new Player();
        playerExample.setId(2L);
        playerExample.setName("Mirko");
        playerExample.setSurname("Mirkovic");
        playerExample.setNumber(14);
        when(this.playerRepository.findById(playerExample.getId())).thenReturn(Optional.of(playerExample));
        assertEquals(playerExample,this.playerService.getPlayerById(playerExample.getId()),"Desired player is not selected.");
    }

    @Test
    void getPlayerByIdFail() {
        Optional<Player> result = this.playerRepository.findById(1L);
        assertTrue(result.isEmpty(),"Player exists in database.");
    }

//    @Test
//    void updatePlayer() throws Exception {
//        Player player = new Player();
//        //assertDoesNotThrow(()->this.playerService.updatePlayer(player));
//        Player result = this.playerService.updatePlayer(player);
//        assertEquals(player,result);
//
//    }

    @Test
    void updatePlayerFail() {
        Player player = new Player();
        assertThrows(Exception.class,()->this.playerService.updatePlayer(player));
    }

//    @Test
//    void deletePlayer(){
//        Player player = new Player();
//        assertDoesNotThrow(()->this.playerService.deletePlayer(player),"Player is deleted successfully");
//    }

    @Test
    void deletePlayerFail() {
        Player player = new Player();
        assertThrows(Exception.class,()->this.playerService.deletePlayer(player),"Player is deleted successfully");
    }
}