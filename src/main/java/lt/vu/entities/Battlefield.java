package lt.vu.entities;

import javax.persistence.*;

@Entity
public class Battlefield {
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

    private String city;

    @Basic
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private Long pc_count;

    @Basic
    public Long getPc_count() {
        return pc_count;
    }

    public void setPc_count(Long pc_count) {
        this.pc_count = pc_count;
    }


    private Team championTeam;

    @OneToOne
    public Team getChampionTeam() {
        return championTeam;
    }

    public void setChampionTeam(Team championTeam) {
        this.championTeam = championTeam;
    }
}
