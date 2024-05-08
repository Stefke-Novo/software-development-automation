package fon.basketball.analyzer.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player_match")
public class PlayerMatch {

    @EmbeddedId
    private PlayerMatchId playerMatchId;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Match.class)
    @JoinColumn(name = "match_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Match match;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Player.class)
    @JoinColumn(name = "player_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Player player;

    @Column(name = "points")
    private int points;

    @Column(name = "rebounds")
    private int rebounds;

    @Column(name = "offensive_rebounds")
    private int offensiveRebounds;

    @Column(name = "defensive_rebounds")
    private int defensiveRebounds;

    @Column(name = "assists")
    private int assists;

    @Column(name = "steals")
    private int steals;

    @Column(name = "blocks")
    private int blocks;

    @Column(name = "field_goals")
    private int fieldGoals;

    @Column(name = "field_goal_attempts")
    private int fieldGoalAttempts;

    @Column(name = "free_throws")
    private int freeThrows;

    @Column(name = "free_throws_attempts")
    private int freeThrowsAttempts;

    @Column(name = "turnovers")
    private int turnovers;

    @Column(name = "personal_fouls")
    private int personalFouls;

    @Column(name = "minutes_played")
    private Date minutesPlayed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerMatch that)) return false;
        return points == that.points && rebounds == that.rebounds && offensiveRebounds == that.offensiveRebounds && defensiveRebounds == that.defensiveRebounds && assists == that.assists && steals == that.steals && blocks == that.blocks && fieldGoals == that.fieldGoals && fieldGoalAttempts == that.fieldGoalAttempts && freeThrows == that.freeThrows && freeThrowsAttempts == that.freeThrowsAttempts && turnovers == that.turnovers && personalFouls == that.personalFouls && Objects.equals(playerMatchId, that.playerMatchId) && Objects.equals(match, that.match) && Objects.equals(player, that.player) && Objects.equals(minutesPlayed, that.minutesPlayed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerMatchId, match, player, points, rebounds, offensiveRebounds, defensiveRebounds, assists, steals, blocks, fieldGoals, fieldGoalAttempts, freeThrows, freeThrowsAttempts, turnovers, personalFouls, minutesPlayed);
    }

}
