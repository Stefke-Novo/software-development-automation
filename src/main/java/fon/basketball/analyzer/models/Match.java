package fon.basketball.analyzer.models;

import jakarta.persistence.*;


import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "`match`")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "`date`")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "home_team")
    private Team homeTeam;

    @Column(name = "points_house_team")
    private int pointsHomeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team")
    private Team awayTeam;

    @Column(name = "points_away_team")
    private int pointsAwayTeam;

    @OneToMany(targetEntity = PlayerMatch.class,fetch = FetchType.LAZY,mappedBy = "match")
    private List<PlayerMatch> playerStatistics;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getPointsHomeTeam() {
        return pointsHomeTeam;
    }

    public void setPointsHomeTeam(int pointsHomeTeam) {
        this.pointsHomeTeam = pointsHomeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getPointsAwayTeam() {
        return pointsAwayTeam;
    }

    public void setPointsAwayTeam(int pointsAwayTeam) {
        this.pointsAwayTeam = pointsAwayTeam;
    }

    public List<PlayerMatch> getPlayerStatistics() {
        return playerStatistics;
    }

    public void setPlayerStatistics(List<PlayerMatch> playerStatistics) {
        this.playerStatistics = playerStatistics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match match)) return false;
        return id == match.id && pointsHomeTeam == match.pointsHomeTeam && pointsAwayTeam == match.pointsAwayTeam && Objects.equals(date, match.date) && Objects.equals(homeTeam, match.homeTeam) && Objects.equals(awayTeam, match.awayTeam) && Objects.equals(playerStatistics, match.playerStatistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, homeTeam, pointsHomeTeam, awayTeam, pointsAwayTeam, playerStatistics);
    }
}
