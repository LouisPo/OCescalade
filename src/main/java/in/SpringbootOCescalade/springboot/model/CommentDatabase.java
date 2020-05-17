package in.SpringbootOCescalade.springboot.model;


public class CommentDatabase {
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
	private String textarea;
	private Integer user;
	
	public CommentDatabase(int comment_id, String textarea, int user) {
	    this.comment_id = comment_id;
	    this.textarea = textarea;
	    this.user = user;
	  }
	public CommentDatabase(){};


	
}
