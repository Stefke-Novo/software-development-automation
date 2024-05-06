package fon.basketball.analyzer.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "number")
    private int number;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Team.class,optional = false)
    @JoinColumn(name = "team_id",referencedColumnName = "id")
    @JsonBackReference
    private Team team;

    @OneToMany(fetch = FetchType.LAZY,targetEntity = PlayerMatch.class,mappedBy = "player")
    private List<PlayerMatch> matches;


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<PlayerMatch> getMatches() {
        return matches;
    }

    public void setMatches(List<PlayerMatch> matches) {
        this.matches = matches;
    }
}
