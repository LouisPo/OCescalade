package in.SpringbootOCescalade.springboot.model;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
//import org.springframework.test.util.*;


public class ParcoursRepository {

	private EntityManager entityManager;
    public ParcoursRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
  
    
    public Optional<Parcourss> findById(Integer id) {
        Parcourss parcours = entityManager.find(Parcourss.class, id);
        return parcours != null ? Optional.of(parcours) : Optional.empty();
    }
    public List<Parcourss> findAll() {
        return entityManager.createQuery("from Parcours").getResultList();
    }
    public Optional<Parcourss> findByName(String name) {
        Parcourss parcours = entityManager.createQuery("SELECT b FROM Parcours b WHERE b.nom = :name", Parcourss.class)
                .setParameter("name", name)
                .getSingleResult();
        return parcours != null ? Optional.of(parcours) : Optional.empty();
    }
    public Optional<Parcourss> findByNameNamedQuery(String name) {
        Parcourss parcours = entityManager.createNamedQuery("Parcours.findByName", Parcourss.class)
                .setParameter("name", name)
                .getSingleResult();
        return parcours != null ? Optional.of(parcours) : Optional.empty();
    }
    public Optional<Parcourss> save(Parcourss parcours) {
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
