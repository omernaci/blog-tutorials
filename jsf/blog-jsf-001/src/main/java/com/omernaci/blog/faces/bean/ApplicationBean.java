package com.omernaci.blog.faces.bean;

import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("applicationBean")
@ViewScoped
public class ApplicationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int value;
	
	@PostConstruct
	public void init() {

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Sweet Alert Message From Application Bean"));
		
		setValue(18);

	}

	public boolean getHasMessage() {
		Iterator<FacesMessage> iterator = FacesContext.getCurrentInstance().getMessages();
		return (iterator != null) && (iterator.hasNext());
	}

	public String getErrorMessage() {
		Iterator<FacesMessage> iterator = FacesContext.getCurrentInstance().getMessages();
		return iterator.hasNext() ? iterator.next().getSummary() : "";
	}

	public void action() {
		// set variable
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
