package com.omernaci.blog.constant;

public class ApplicationConstant {
	
	private ApplicationConstant() { }
	
	public static final String CLIENT_ID = "YOUR_CLIENT_ID";

	public static final String CLIENT_SECRET = "YOUR_CLIENT_SECRET";
			
	public static final String AUTHORIZATION_LOCATION = "https://github.com/login/oauth/authorize";

	public static final String TOKEN_LOCATION = "https://github.com/login/oauth/access_token";

	public static final String REDIRECT_URI = "http://localhost:8080/user.jsf";

	public static final String SCOPE = "user";

}
