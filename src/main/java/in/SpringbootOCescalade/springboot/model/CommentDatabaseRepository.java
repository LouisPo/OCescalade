package in.SpringbootOCescalade.springboot.model;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
//import org.springframework.test.util.*;


public class CommentDatabaseRepository {

	private EntityManager entityManager;
    public CommentDatabaseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
  
    
    public Optional<CommentDatabase> findById(Integer id) {
        CommentDatabase commentaire = entityManager.find(CommentDatabase.class, id);
        return commentaire != null ? Optional.of(commentaire) : Optional.empty();
    }
    public List<CommentDatabase> findAll() {
        return entityManager.createQuery("from Comment").getResultList();
    }
    public Optional<CommentDatabase> findByNameComment(String name) {
        CommentDatabase commentaire = entityManager.createQuery("SELECT b FROM Parcours b WHERE b.nom = :name", CommentDatabase.class)
                .setParameter("name", name)
                .getSingleResult();
        return commentaire != null ? Optional.of(commentaire) : Optional.empty();
    }
    public Optional<CommentDatabase> findByNameNamedQueryy(String name) {
        CommentDatabase commentaire = entityManager.createNamedQuery("Comment.findByName", CommentDatabase.class)
                .setParameter("name", name)
                .getSingleResult();
        return commentaire != null ? Optional.of(commentaire) : Optional.empty();
    }
    public Optional<CommentDatabase> save(CommentDatabase commentaire) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(commentaire);
            entityManager.getTransaction().commit();
            return Optional.of(commentaire);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
