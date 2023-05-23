package lt.vu.usecases;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Division;
import lt.vu.persistence.DivisionsDAO;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Divisions {

    @Inject
    private DivisionsDAO divisionsDAO;

    @Getter
    @Setter
    private Division divisionToCreate = new Division();

    @Getter
    private List<Division> allDivisions;
    @Getter
    private List<Division> loadedDivisions;
    @Getter @Setter
    private String divisionToSearch = "";

    @PostConstruct
    public void init() {
        loadAllDivisions();
    }

    @Transactional
    private void createDivision() {
        this.divisionsDAO.persist(divisionToCreate);
    }

    private void loadAllDivisions() {
        this.allDivisions = divisionsDAO.loadAll();
    }

    @Transactional
    public void loadDivisionLike() {
        this.loadedDivisions = divisionsDAO.loadDivision(divisionToSearch);
    }
}
