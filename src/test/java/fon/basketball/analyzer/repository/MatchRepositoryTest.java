package fon.basketball.analyzer.repository;

import fon.basketball.analyzer.models.Match;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.Assert.isInstanceOf;


@SpringBootTest
class MatchRepositoryTest {

    @Autowired
    MatchRepository matchRepository;

    @Test
    public void testMatchList(){

        List<Match> matches = matchRepository.findAll();
        isInstanceOf(ArrayList.class,
                matches);
    }
}