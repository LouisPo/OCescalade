package in.SpringbootOCescalade.springboot.model;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public class TopoDatabaseRepository {

	private EntityManager entityManager;
    public TopoDatabaseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
  
    
    public Optional<TopoDatabase> findById(Integer id) {
        TopoDatabase topo = entityManager.find(TopoDatabase.class, id);
        return topo != null ? Optional.of(topo) : Optional.empty();
    }
    public List<TopoDatabase> findAll() {
        return entityManager.createQuery("from Topo").getResultList();
    }
    public Optional<TopoDatabase> findByNameTopo(String name) {
        TopoDatabase topo = entityManager.createQuery("SELECT b FROM Parcours b WHERE b.nom = :name", TopoDatabase.class)
                .setParameter("name", name)
                .getSingleResult();
        return topo != null ? Optional.of(topo) : Optional.empty();
    }
    public Optional<TopoDatabase> findByNameNamedQueryy(String name) {
        TopoDatabase topo = entityManager.createNamedQuery("Topo.findByName", TopoDatabase.class)
                .setParameter("name", name)
                .getSingleResult();
        return topo != null ? Optional.of(topo) : Optional.empty();
    }
    public Optional<TopoDatabase> save(TopoDatabase topo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(topo);
            entityManager.getTransaction().commit();
            return Optional.of(topo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
