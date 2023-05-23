package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Team.searchForTeam", query ="select a from Team as a where a.name like :name"),
        @NamedQuery(name = "Team.findAll", query = "select t from Team as t")
})
@Table(name = "TEAM")
@Getter @Setter
public class Team {

    public Team(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Player> players = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @OneToOne
    private Battlefield championBattlefield;

    public Battlefield getChampionBattlefield() {
        return championBattlefield;
    }

    public void setChampionBattlefield(Battlefield championBattlefield) {
        this.championBattlefield = championBattlefield;
    }

    @ManyToMany
    private List<Division> divisions;

    public List<Division> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<Division> divisions) {
        this.divisions = divisions;
    }
}
