package lt.vu.persistence;

import lt.vu.entities.Team;
import lt.vu.entities.Division;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Locale;

@ApplicationScoped
public class DivisionsDAO {

    @Inject
    private EntityManager em;

    public List<Division> loadAll() {
        return em.createNamedQuery("Division.findAll", Division.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Division division) {
        this.em.persist(division);
    }

    public Division findOne(Integer id) {
        return em.find(Division.class, id);
    }

    public List loadDivision(String s) {
        s = s.toUpperCase();
        return em.createQuery(
                "select d " +
                        "from Division as d " +
                        "where upper(d.name) like :divisionName")
                .setParameter("divisionName", s == null ? "" : "%" + s + "%").
                        getResultList();
    }
}
