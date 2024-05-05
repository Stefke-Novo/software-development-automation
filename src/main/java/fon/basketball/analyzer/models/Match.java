package fon.basketball.analyzer.models;

import jakarta.persistence.*;


import java.util.Date;
@Entity
@Table(name = "`match`")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "`date`")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Team.class)
    @JoinColumn(name = "home_team", referencedColumnName = "id")
    private Team homeTeam;

    @Column(name = "points_house_team")
    private int pointsHomeTeam;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Team.class)
    @JoinColumn(name = "away_team", referencedColumnName = "id")
    private Team awayTeam;

    @Column(name = "points_away_team")
    private int pointsAwayTeam;

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
}
