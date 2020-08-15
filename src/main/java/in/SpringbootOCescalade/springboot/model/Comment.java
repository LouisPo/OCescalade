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
@Table(name = "commentaire")






public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer comment_id;
	@Column
	private String textarea;
	@Column
	private Integer user;
	@Column
	private String identite;
	public String getIdentite() {
		return identite;
	}


	public void setIdentite(String identite) {
		this.identite = identite;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}




	@Column
	private String date;
	@Column
	private Integer parcoursidentifiant;
	public Integer getParcoursidentifiant() {
		return parcoursidentifiant;
	}


	public void setParcoursidentifiant(Integer parcoursidentifiant) {
		this.parcoursidentifiant = parcoursidentifiant;
	}


	public Integer getComment_id() {
		return comment_id;
	}


	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}


	public String getTextarea() {
		return textarea;
	}


	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}


	public Integer getUser() {
		return user;
	}


	public void setUser(Integer user) {
		this.user = user;
	}



	
	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", textarea=" + textarea +", user=" + user  + "]";
	}
	
}
