package fon.basketball.analyzer.services.impl;

import fon.basketball.analyzer.models.PlayerMatch;
import fon.basketball.analyzer.repository.PlayerMatchRepository;
import fon.basketball.analyzer.services.PlayerMatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerMatchServiceImpl implements PlayerMatchService {

    private final PlayerMatchRepository playerMatchRepository;

    public PlayerMatchServiceImpl(PlayerMatchRepository playerMatchRepository){
        this.playerMatchRepository=playerMatchRepository;
    }
    @Override
    public List<PlayerMatch> getAll() {
        return this.playerMatchRepository.findAll();
    }
}
