package org.hire.me.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Link implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String alias;
	
	private String urlFinal;
	
	private String urlOriginal;
	
	private Integer qtdAcesso;
	

	public Link() {
		super();
	}

	public Link(String alias, String urlFinal, String urlOriginal) {
		super();
		this.alias = alias;
		this.urlFinal = urlFinal;
		this.urlOriginal = urlOriginal;
		this.qtdAcesso = Integer.valueOf(0);
	}

	public String getUrlFinal() {
		return urlFinal;
	}

	public void setUrlFinal(String urlFinal) {
		this.urlFinal = urlFinal;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}

	public Integer getQtdAcesso() {
		return qtdAcesso;
	}

	public void setQtdAcesso(Integer qtdAcesso) {
		this.qtdAcesso = qtdAcesso;
	}
	
}
