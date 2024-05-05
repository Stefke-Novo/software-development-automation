package fon.basketball.analyzer.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @OneToMany(fetch = FetchType.LAZY,targetEntity = Match.class,mappedBy = "homeTeam")
    private List<Match> homeMatches;
    @OneToMany(fetch = FetchType.LAZY,targetEntity = Match.class,mappedBy = "awayTeam")
    private List<Math> awayMatches;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Player.class, mappedBy = "team")
    private List<Player> roster;
}
