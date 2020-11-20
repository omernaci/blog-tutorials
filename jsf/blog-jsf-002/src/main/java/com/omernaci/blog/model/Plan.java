package com.omernaci.blog.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Plan implements Serializable {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("space")
	@Expose
	private int space;
	@SerializedName("collaborators")
	@Expose
	private int collaborators;
	@SerializedName("private_repos")
	@Expose
	private int privateRepos;
	private final static long serialVersionUID = -172798393510015819L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpace() {
		return space;
	}

	public void setSpace(int space) {
		this.space = space;
	}

	public int getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(int collaborators) {
		this.collaborators = collaborators;
	}

	public int getPrivateRepos() {
		return privateRepos;
	}

	public void setPrivateRepos(int privateRepos) {
		this.privateRepos = privateRepos;
	}

}