package in.SpringbootOCescalade.springboot.model;


public class TopoDatabase {
	  //ID
	private int comment_id = 0;
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
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
	public Integer getparcoursidentifiant() {
		return parcoursidentifiant;
	}
	public void setparcoursidentifiant(Integer user) {
		this.parcoursidentifiant = parcoursidentifiant;
	}
	private String textarea;
	private Integer user;
	private Integer parcoursidentifiant;
	
	public TopoDatabase(int comment_id, String textarea, int use,int parcoursidentifiant) {
	    this.comment_id = comment_id;
	    this.textarea = textarea;
	    this.user = user;
	    this.parcoursidentifiant = parcoursidentifiant;    
	  }
	public TopoDatabase(){};


	
}
