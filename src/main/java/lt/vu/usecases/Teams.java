package lt.vu.usecases;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import lt.vu.persistence.TeamsDAO;
import lt.vu.entities.Team;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Teams {

    @Inject
    private TeamsDAO teamsDAO;

    @Getter @Setter
    private Team teamToCreate = new Team();

    @Getter
    private List<Team> allTeams;
    @Getter
    private List<Team> loadedTeams;
    @Getter @Setter
    private String teamToSearch = "";

    @PostConstruct
    public void init(){
        loadAllTeams();
    }

    @Transactional
    public void createTeam(){
        this.teamsDAO.persist(teamToCreate);
    }

    private void loadAllTeams(){
        this.allTeams = teamsDAO.loadAll();
    }

    @Transactional
    public void loadTeamLike(){
        this.loadedTeams = teamsDAO.loadTeam(teamToSearch);
    }
}
