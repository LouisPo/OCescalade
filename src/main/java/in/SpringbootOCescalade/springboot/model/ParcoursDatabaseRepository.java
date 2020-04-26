package in.SpringbootOCescalade.springboot.model;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
//import org.springframework.test.util.*;


public class ParcoursDatabaseRepository {

	private EntityManager entityManager;
    public ParcoursDatabaseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
  
    
    public Optional<ParcoursDatabase> findById(Integer id) {
        ParcoursDatabase parcours = entityManager.find(ParcoursDatabase.class, id);
        return parcours != null ? Optional.of(parcours) : Optional.empty();
    }
    public List<ParcoursDatabase> findAll() {
        return entityManager.createQuery("from Parcours").getResultList();
    }
    public Optional<ParcoursDatabase> findByName(String name) {
        ParcoursDatabase parcours = entityManager.createQuery("SELECT b FROM Parcours b WHERE b.nom = :name", ParcoursDatabase.class)
                .setParameter("name", name)
                .getSingleResult();
        return parcours != null ? Optional.of(parcours) : Optional.empty();
    }
    public Optional<ParcoursDatabase> findByNameNamedQuery(String name) {
        ParcoursDatabase parcours = entityManager.createNamedQuery("Parcours.findByName", ParcoursDatabase.class)
                .setParameter("name", name)
                .getSingleResult();
        return parcours != null ? Optional.of(parcours) : Optional.empty();
    }
    public Optional<ParcoursDatabase> save(ParcoursDatabase parcours) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(parcours);
            entityManager.getTransaction().commit();
            return Optional.of(parcours);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
