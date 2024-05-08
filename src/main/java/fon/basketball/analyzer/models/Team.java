package fon.basketball.analyzer.models;

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
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Player.class, mappedBy = "team")
    private List<Player> roster;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team team)) return false;
        return id == team.id && Objects.equals(name, team.name) && Objects.equals(city, team.city) && Objects.equals(state, team.state) && Objects.equals(roster, team.roster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, state, roster);
    }
}
