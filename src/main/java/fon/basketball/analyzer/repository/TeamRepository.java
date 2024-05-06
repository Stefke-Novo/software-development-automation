package fon.basketball.analyzer.repository;

import fon.basketball.analyzer.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
