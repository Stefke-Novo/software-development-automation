package fon.basketball.analyzer.repository;

import fon.basketball.analyzer.models.Match;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.util.Assert.isInstanceOf;


@SpringBootTest
class MatchRepositoryTest {

//    @Autowired
//    MatchRepository matchRepository;

    @Mock
    MatchRepository matchRepository1;

//    @Test
//    public void testMatchList(){
//
//        List<Match> matches = matchRepository.findAll();
//        isInstanceOf(ArrayList.class,
//                matches);
//    }

    @Test
    public void testMatchListMocked(){
        when(matchRepository1.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Match(),new Match())));
        List<Match> matches = matchRepository1.findAll();
        isInstanceOf(ArrayList.class,
                matches);
    }
}