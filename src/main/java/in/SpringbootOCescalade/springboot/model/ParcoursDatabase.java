package in.SpringbootOCescalade.springboot.model;


public class ParcoursDatabase {
	  //ID
	private int parcours_id = 0;
	private String nom;
	private Integer taille;
	private Integer difficulte;
	private String localisation;
	
	public ParcoursDatabase(int parcours_id, String nom, int taille, int  difficulte, String localisation) {
	    this.parcours_id = parcours_id;
	    this.nom = nom;
	    this.taille = taille;
	    this.difficulte = difficulte;
	    this.localisation = localisation;
	  }
	  public ParcoursDatabase(){};

	
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
	
}
