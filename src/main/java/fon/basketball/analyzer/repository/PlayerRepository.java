package fon.basketball.analyzer.repository;

import fon.basketball.analyzer.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
