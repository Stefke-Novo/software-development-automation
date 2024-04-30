package fon.basketball.analyzer.services.impl;

import fon.basketball.analyzer.models.Match;
import fon.basketball.analyzer.repository.MatchRepository;
import fon.basketball.analyzer.services.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    public MatchServiceImpl(MatchRepository matchRepository){
        this.matchRepository=matchRepository;
    }

    @Override
    public List<Match> getAll() {
        return matchRepository.findAll();
    }
}
