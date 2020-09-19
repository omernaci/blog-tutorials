package com.omernaci.blog;

public class Blog {

	@TitleValidation
	private String title;
	
	private String post;
	
	public Blog() {
		
	}

	public Blog(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	

}
