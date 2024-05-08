package fon.basketball.analyzer.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return id == player.id && number == player.number && Objects.equals(name, player.name) && Objects.equals(surname, player.surname) && Objects.equals(team, player.team) && Objects.equals(matches, player.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, number, team, matches);
    }
}
