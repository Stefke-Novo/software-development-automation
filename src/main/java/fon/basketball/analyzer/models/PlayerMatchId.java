package fon.basketball.analyzer.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlayerMatchId implements Serializable {

    @Column(name = "player_id")
    private long playerId;

    @Column(name = "match_id")
    private long matchId;


    public PlayerMatchId(long playerId, long matchId) {
        this.playerId = playerId;
        this.matchId = matchId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

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
