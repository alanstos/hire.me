package org.hire.me.vo;

public class LinkVo {
	
	private String alias;
	private String url;
	
	private EstatisticaVo estatisticas;

	public LinkVo(String alias, String url, Long tempoGasto) {
		super();
		this.alias = alias;
		this.url = url;
		this.estatisticas = new EstatisticaVo(tempoGasto);
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public EstatisticaVo getEstatisticas() {
		return estatisticas;
	}

	public void setEstatisticas(EstatisticaVo estatisticas) {
		this.estatisticas = estatisticas;
	}
	
	

}
