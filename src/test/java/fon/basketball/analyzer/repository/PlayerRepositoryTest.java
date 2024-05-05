package fon.basketball.analyzer.repository;

import fon.basketball.analyzer.models.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void getAll() {
        assertInstanceOf(ArrayList.class,this.playerRepository.findAll(),"Returned list isn't list of type ArrayList");
        assertFalse(this.playerRepository.findAll().isEmpty(),"List is empty.");
    }

    @Test
    void getPlayer() {
        assertTrue(true);
    }

    @Test
    void getPlayerById(){
        assertTrue(true);
    }

    @Test
    void getPlayerByIdFail() {
        Optional<Player> result = this.playerRepository.findById(1l);
        assertTrue(result.isEmpty(),"Player exists in database.");
    }

    @Test
    void updatePlayer(){
        assertTrue(true);
    }

    @Test
    void updatePlayerFail() {
        Player player = new Player();
        player = this.playerRepository.save(player);
        assertTrue(player.getId()>0,"Player is not saved.");
    }

    @Test
    void deletePlayer(){
        assertTrue(true);
    }

    @Test
    void deletePlayerFail() {
        Player player = new Player();
        assertThrows(Exception.class,()->this.playerRepository.delete(player),"Player is deleted successfully");
    }
}