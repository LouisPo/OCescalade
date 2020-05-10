package in.SpringbootOCescalade.springboot.model;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
//import org.springframework.test.util.*;


public class EmployeeDatabaseRepository {

	private EntityManager entityManager;
    public EmployeeDatabaseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
  
    
    public Optional<EmployeeDatabase> findById(Integer id) {
        EmployeeDatabase employee = entityManager.find(EmployeeDatabase.class, id);
        return employee != null ? Optional.of(employee) : Optional.empty();
    }
    public List<EmployeeDatabase> findAll() {
        return entityManager.createQuery("from Parcours").getResultList();
    }
    public Optional<EmployeeDatabase> findByName(String name) {
        EmployeeDatabase employee = entityManager.createQuery("SELECT b FROM Parcours b WHERE b.nom = :name", EmployeeDatabase.class)
                .setParameter("name", name)
                .getSingleResult();
        return employee != null ? Optional.of(employee) : Optional.empty();
    }
    public Optional<EmployeeDatabase> findByNameNamedQuery(String name) {
        EmployeeDatabase employee = entityManager.createNamedQuery("Parcours.findByName", EmployeeDatabase.class)
                .setParameter("name", name)
                .getSingleResult();
        return employee != null ? Optional.of(employee) : Optional.empty();
    }
    public Optional<EmployeeDatabase> save(EmployeeDatabase employee) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            return Optional.of(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
