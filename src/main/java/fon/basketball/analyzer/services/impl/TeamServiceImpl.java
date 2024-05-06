package fon.basketball.analyzer.services.impl;

import fon.basketball.analyzer.models.Team;
import fon.basketball.analyzer.repository.TeamRepository;
import fon.basketball.analyzer.services.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    public TeamServiceImpl(TeamRepository teamRepository){
        this.teamRepository=teamRepository;
    }
    @Override
    public List<Team> getAll() {
        return this.teamRepository.findAll();
    }
}
