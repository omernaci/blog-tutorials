package com.omernaci.blog.faces.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.GitHubTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;

import com.google.gson.Gson;
import com.omernaci.blog.constant.ApplicationConstant;
import com.omernaci.blog.model.GithubUser;

@Named
@ViewScoped
public class ApplicationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String authorizationCode;
	
	private String accessToken;
	
	private GithubUser githubUser;
	
	@PostConstruct
	public void init() {
		//
	}
	
	public void authWithGithub() throws IOException, OAuthSystemException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		externalContext.redirect(OAuthClientRequest
				.authorizationLocation(ApplicationConstant.AUTHORIZATION_LOCATION)
				.setClientId(ApplicationConstant.CLIENT_ID)
				.setRedirectURI(ApplicationConstant.REDIRECT_URI)
				.setScope(ApplicationConstant.SCOPE)
				.buildQueryMessage()
				.getLocationUri());
	}
	
	public void getAccessTokenFromAuthorizationCode() throws OAuthSystemException, OAuthProblemException {
		
		OAuthClientRequest request = OAuthClientRequest
				.tokenLocation(ApplicationConstant.TOKEN_LOCATION)
				.setGrantType(GrantType.AUTHORIZATION_CODE)
				.setClientId(ApplicationConstant.CLIENT_ID)
				.setClientSecret(ApplicationConstant.CLIENT_SECRET)
				.setScope(ApplicationConstant.SCOPE)
				.setRedirectURI(ApplicationConstant.REDIRECT_URI)
				.setCode(getAuthorizationCode())
				.buildQueryMessage();
		
		OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
		
		GitHubTokenResponse gitHubTokenResponse = oAuthClient.accessToken(request, GitHubTokenResponse.class);
		
		setAccessToken(gitHubTokenResponse.getAccessToken());
		
		// Accessing user information
		OAuthClientRequest bearerClientRequest = new OAuthBearerClientRequest("https://api.github.com/user")
				.setAccessToken(getAccessToken())
				.buildQueryMessage();
		
		OAuthResourceResponse resourceResponse = oAuthClient.resource(bearerClientRequest, 
				OAuth.HttpMethod.GET, OAuthResourceResponse.class);
		System.out.println(resourceResponse.getBody());
		
		if (resourceResponse.getResponseCode() == 200) {
			Gson gson = new Gson();
			setGithubUser(gson.fromJson(resourceResponse.getBody(), GithubUser.class));
		}
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public GithubUser getGithubUser() {
		return githubUser;
	}

	public void setGithubUser(GithubUser githubUser) {
		this.githubUser = githubUser;
	}

}
