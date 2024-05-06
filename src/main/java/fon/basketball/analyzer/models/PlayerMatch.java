package fon.basketball.analyzer.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

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

    public PlayerMatchId getPlayerMatchId() {
        return playerMatchId;
    }

    public void setPlayerMatchId(PlayerMatchId playerMatchId) {
        this.playerMatchId = playerMatchId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public void setOffensiveRebounds(int offensiveRebounds) {
        this.offensiveRebounds = offensiveRebounds;
    }

    public int getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(int defensiveRebounds) {
        this.defensiveRebounds = defensiveRebounds;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getFieldGoals() {
        return fieldGoals;
    }

    public void setFieldGoals(int fieldGoals) {
        this.fieldGoals = fieldGoals;
    }

    public int getFieldGoalAttempts() {
        return fieldGoalAttempts;
    }

    public void setFieldGoalAttempts(int fieldGoalAttempts) {
        this.fieldGoalAttempts = fieldGoalAttempts;
    }

    public int getFreeThrows() {
        return freeThrows;
    }

    public void setFreeThrows(int freeThrows) {
        this.freeThrows = freeThrows;
    }

    public int getFreeThrowsAttempts() {
        return freeThrowsAttempts;
    }

    public void setFreeThrowsAttempts(int freeThrowsAttempts) {
        this.freeThrowsAttempts = freeThrowsAttempts;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }

    public int getPersonalFouls() {
        return personalFouls;
    }

    public void setPersonalFouls(int personalFouls) {
        this.personalFouls = personalFouls;
    }

    public Date getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(Date minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

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

    public PlayerMatch() {
    }

    public PlayerMatch(PlayerMatchId playerMatchId, Match match, Player player, int points, int rebounds, int offensiveRebounds, int defensiveRebounds, int assists, int steals, int blocks, int fieldGoals, int fieldGoalAttempts, int freeThrows, int freeThrowsAttempts, int turnovers, int personalFouls, Date minutesPlayed) {
        this.playerMatchId = playerMatchId;
        this.match = match;
        this.player = player;
        this.points = points;
        this.rebounds = rebounds;
        this.offensiveRebounds = offensiveRebounds;
        this.defensiveRebounds = defensiveRebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.fieldGoals = fieldGoals;
        this.fieldGoalAttempts = fieldGoalAttempts;
        this.freeThrows = freeThrows;
        this.freeThrowsAttempts = freeThrowsAttempts;
        this.turnovers = turnovers;
        this.personalFouls = personalFouls;
        this.minutesPlayed = minutesPlayed;
    }
}
