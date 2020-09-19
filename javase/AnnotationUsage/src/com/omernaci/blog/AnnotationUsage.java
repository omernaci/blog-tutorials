package com.omernaci.blog;

public class AnnotationUsage {

	public static void main(String[] args) {
		
		Blog blog = new Blog();
		blog.setBlogTitle("omer-blog");
		
		ValidationEngine engine = new ValidationEngine();
		engine.process(blog);
		
		
	}

}
