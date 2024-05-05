package fon.basketball.analyzer.services;

import fon.basketball.analyzer.models.Player;

import java.util.List;

public interface PlayerService {
    List<Player> getAll();
    Player getPlayer(String name, String surname, long teamId);
    Player getPlayerById(long id) throws Exception;
    Player updatePlayer(Player player) throws Exception;
    Player deletePlayer(Player player) throws Exception;
}
