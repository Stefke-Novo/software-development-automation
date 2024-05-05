package fon.basketball.analyzer.services.impl;

import fon.basketball.analyzer.models.Player;
import fon.basketball.analyzer.repository.PlayerRepository;
import fon.basketball.analyzer.services.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository){
        this.playerRepository=playerRepository;
    }

    @Override
    public List<Player> getAll() {
        return this.playerRepository.findAll();
    }

    @Override
    public Player getPlayer(String name, String surname, long teamId) {
        return null;
    }

    @Override
    public Player getPlayerById(long id) throws Exception {
        Optional<Player> result = ensurePlayerExists(id, "Player doesn't exist in database.");
        return result.get();
    }

    @Override
    public Player updatePlayer(Player player) throws Exception {
        ensurePlayerExists(player.getId(), "Player " + player.getName() + " " + player.getSurname() + " doesn't exist.");
        player = this.playerRepository.save(player);
        return player;
    }

    private Optional<Player> ensurePlayerExists(long player, String player1) throws Exception {
        Optional<Player> result = this.playerRepository.findById(player);
        if (result.isEmpty())
            throw new Exception(player1);
        return result;
    }

    @Override
    public Player deletePlayer(Player player) throws Exception {
        Optional<Player> result = ensurePlayerExists(player.getId(),"Player with id "+player.getId()+", name "+player.getName()+" and surname "+player.getSurname()+"doesn't exist in database.");
        this.playerRepository.delete(player);
        return result.get();
    }
}
