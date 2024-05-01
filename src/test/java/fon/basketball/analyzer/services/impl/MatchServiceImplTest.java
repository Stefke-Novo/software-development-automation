package fon.basketball.analyzer.services.impl;

import fon.basketball.analyzer.models.Match;
import fon.basketball.analyzer.repository.MatchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;

@SpringBootTest
class MatchServiceImplTest {

    @InjectMocks
    private MatchServiceImpl matchServiceImpl;
    @Mock
    private MatchRepository matchRepository;
    @BeforeEach
    public void SetUp(){
        when(this.matchRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Match[]{
             new Match(),
             new Match(),
             new Match()
        })));
    }

    @Test
    public void returnMatchMock(){
        Assert.isInstanceOf(ArrayList.class,matchRepository.findAll());
    }

}