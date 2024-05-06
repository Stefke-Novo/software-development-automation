package fon.basketball.analyzer.repository;

import fon.basketball.analyzer.models.PlayerMatch;
import fon.basketball.analyzer.models.PlayerMatchId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerMatchRepository extends JpaRepository<PlayerMatch, PlayerMatchId> {

}
