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
@Table(name = "topo")

public class Topo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer topo_id;
	@Column
	private String nomtopo;
	@Column
	private Integer user_id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String dispo;
	@Column
	private String textarea;
	@Column
	private String identifiantpret;
	public String getDatedecreation() {
		return datedecreation;
	}
	public void setDatedecreation(String datedecreation) {
		this.datedecreation = datedecreation;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	private String datedecreation;
	@Column
	private String lieu;
	public String getIdentifiantpret() {
		return identifiantpret;
	}
	public void setIdentifiantpret(String identifiantpret) {
		this.identifiantpret = identifiantpret;
	}
	public Integer getTopo_id() {
		return topo_id;
	}
	public void setTopo_id(Integer topo_id) {
		this.topo_id = topo_id;
	}
	public String getNomtopo() {
		return nomtopo;
	}
	public void setNomtopo(String nomtopo) {
		this.nomtopo = nomtopo;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDispo() {
		return dispo;
	}
	public void setDispo(String dispo) {
		this.dispo = dispo;
	}
	public String getTextarea() {
		return textarea;
	}
	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}


	
}
