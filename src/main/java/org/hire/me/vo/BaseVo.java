package org.hire.me.vo;

public abstract class BaseVo {
	
	private String alias;
	
	public BaseVo(String alias) {
		super();
		this.alias = alias;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	

}
