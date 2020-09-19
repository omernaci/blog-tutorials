package com.omernaci.blog;

public class Blog {
	
	@ValidateString(start = "omernaci")
	private String blogTitle;

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

}
