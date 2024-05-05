package fon.basketball.analyzer.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private List<Match> homeMatches;
    @OneToMany(fetch = FetchType.LAZY,targetEntity = Match.class,mappedBy = "awayTeam")
    @JsonBackReference
    private List<Math> awayMatches;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Player.class, mappedBy = "team")
    private List<Player> roster;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Match> getHomeMatches() {
        return homeMatches;
    }

    public void setHomeMatches(List<Match> homeMatches) {
        this.homeMatches = homeMatches;
    }

    public List<Math> getAwayMatches() {
        return awayMatches;
    }

    public void setAwayMatches(List<Math> awayMatches) {
        this.awayMatches = awayMatches;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }
}
