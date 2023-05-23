package lt.vu.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Division.findAll", query = "select a from Division as a")
})
public class Division {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    private String name;

    @Basic(optional = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String game;

    @Basic
    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    //Cia eina override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return id.equals(division.id) && Objects.equals(name, division.name) && Objects.equals(game, division.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, game);
    }
    //-----------------

    private List<Team> teams;

    @ManyToMany(mappedBy = "divisions")
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
