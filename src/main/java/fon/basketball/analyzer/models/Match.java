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

    @Column(name = "date_played")
    private Date datePlayed;

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
}
