package fon.basketball.analyzer.services.impl;

import fon.basketball.analyzer.models.Team;
import fon.basketball.analyzer.services.TeamService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class TeamServiceImplTest {

    @Mock
    private TeamService teamService;
    @Test
    void getAll() {
        when(teamService.getAll()).thenReturn(new ArrayList<>(Arrays.asList(new Team(),new Team())));
        assertFalse(this.teamService.getAll().isEmpty());
    }
}