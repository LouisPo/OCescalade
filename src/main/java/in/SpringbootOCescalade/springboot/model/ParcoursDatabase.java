package in.SpringbootOCescalade.springboot.model;


public class ParcoursDatabase {
	  //ID
	private Integer parcours_id;
	private String nom;
	private Integer taille;
	private String difficulte;
	private String localisation;
	public String getValidation() {
		return validation;
	}
	public void setValidation(String validation) {
		this.validation = validation;
	}
	private String validation;
	
	public ParcoursDatabase(Integer parcours_id, String nom, int taille, String  difficulte, String localisation,String validation) {
	    this.parcours_id = parcours_id;
	    this.nom = nom;
	    this.taille = taille;
	    this.difficulte = difficulte;
	    this.localisation = localisation;
	    this.validation = validation;
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
	
}
