package in.SpringbootOCescalade.springboot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer user_id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String mail;
	@Column
	private Integer tel;
	@Column
	private String mdp;
	public Integer getuser_id() {
		return user_id;
	}
	public void setId(Integer user_id) {
		this.user_id = user_id;
	}
	public String getnom() {
		return nom;
	}
	public void setnom(String nom) {
		this.nom = nom;
	}
	public String getprenom() {
		return prenom;
	}
	public void setprenom(String prenom) {
		this.prenom = prenom;
	}
	public String getmail() {
		return mail;
	}
	public void setmail(String mail) {
		this.mail = mail;
	}
	public Integer gettel() {
		return tel;
	}
	public void settel(Integer tel) {
		this.tel = tel;
	}
	public String getmdp() {
		return mdp;
	}
	public void setmdp(String mdp) {
		this.mdp = mdp;
	}
	@Override
	public String toString() {
		return "Employee [user_id=" + user_id + ", name=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", tel="
				+ tel + ", mdp=" + mdp + "]";
	}
	
}
