package in.SpringbootOCescalade.springboot.model;


public class EmployeeDatabase {
	  //ID
	private int user_id = 0;
	private String nom;
	private String prenom;
	private String mail;
	private Integer tel;
	private String mdp;
	
	public EmployeeDatabase(int user_id, String nom,String prenom,String mail, int tel, String mdp) {
	    this.user_id = user_id;
	    this.nom = nom;
	    this.prenom = prenom;
	    this.mail = mail;
	    this.tel = tel;
	    this.mdp = mdp;
	  }
	public EmployeeDatabase(){};


	public String getnom() {
		return nom;
	}
	public void setnom(String nom) {
		this.nom = nom;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getTel() {
		return tel;
	}
	public void setTel(Integer tel) {
		this.tel = tel;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
}
