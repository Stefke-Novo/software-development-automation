package fon.basketball.analyzer.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PlayerMatchId implements Serializable {

    @Column(name = "player_id")
    private long playerId;

    @Column(name = "match_id")
    private long matchId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerMatchId that)) return false;
        return playerId == that.playerId && matchId == that.matchId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, matchId);
    }
}
