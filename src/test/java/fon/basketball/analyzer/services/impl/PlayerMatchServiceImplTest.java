package fon.basketball.analyzer.services.impl;

import fon.basketball.analyzer.models.PlayerMatch;
import fon.basketball.analyzer.repository.PlayerMatchRepository;
import fon.basketball.analyzer.services.PlayerMatchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PlayerMatchServiceImplTest {

    @MockBean
    private PlayerMatchRepository playerMatchRepository;

    @Autowired
    private PlayerMatchService playerMatchService;

    @BeforeEach
    public void setUp(){
        when(playerMatchService.getAll()).thenReturn(new ArrayList<>(Arrays.asList(new PlayerMatch(), new PlayerMatch())));
        this.playerMatchService = new PlayerMatchServiceImpl(playerMatchRepository);
    }
    @Test
    void getAll() {
        assertInstanceOf(ArrayList.class,this.playerMatchService.getAll());
        assertFalse(this.playerMatchService.getAll().isEmpty());
    }
}