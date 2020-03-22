package in.SpringbootOCescalade.springboot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parcours")
public class Parcours {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer parcours_id;
	@Column
	private String nom;
	@Column
	private Integer taille;
	@Column
	private Integer difficulte;
	@Column
	private String localisation;
	
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
	public Integer getdifficulte() {
		return difficulte;
	}
	public void setdifficulte(Integer difficulte) {
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
		return "Parcours [parcours_id=" + parcours_id + ", name=" + nom +", taille=" + taille +
				", difficulte="+ difficulte + ", localisation=" + localisation + "]";
	}
	
}
