package in.SpringbootOCescalade.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "parcours")





//rajout 30/03
@NamedQueries({
    @NamedQuery(name = "Parcourss.findByName",
            query = "SELECT b FROM Parcourss b WHERE b.nom = :name"),
    @NamedQuery(name = "Parcourss.findAll",
            query = "SELECT b FROM Parcourss b")
})
public class Parcourss {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer parcours_id;
	@Column
	private String nom;
	@Column
	private Integer taille;
	@Column
	private String difficulte;
	@Column
	private String localisation;
	@Column
	private String validation;
	
	public String getValidation() {
		return validation;
	}
	public void setValidation(String validation) {
		this.validation = validation;
	}
	public Integer getparcours_id() {
		return parcours_id;
	}
	public void setId(Integer parcours_id) {
		this.parcours_id = parcours_id;
	}
	public String getnom() {
		return nom;
	}
	public void setnom(String nom) {
		this.nom = nom;
	}
	public Integer gettaille() {
		return taille;
	}
	public void settaille(Integer taille) {
		this.taille = taille;
	}
	public String getdifficulte() {
		return difficulte;
	}
	public void setdifficulte(String difficulte) {
		this.difficulte = difficulte;
	}
	public String getlocalisation() {
		return localisation;
	}
	public void setlocalisation(String localisation) {
		this.localisation = localisation;
	}

	@Override
	public String toString() {
		return "Parcourss [parcours_id=" + parcours_id + ", name=" + nom +", taille=" + taille +
				", difficulte="+ difficulte + ", localisation=" + localisation + "]";
	}
	
}
