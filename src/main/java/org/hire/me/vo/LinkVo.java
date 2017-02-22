package org.hire.me.vo;

import org.hire.me.model.Link;

public class LinkVo extends BaseVo {
	
	private String url;
	
	private EstatisticaVo estatisticas;
	
	public static LinkVo parse(Link link, Long tempoGasto){
		LinkVo vo = new LinkVo(link.getAlias(), link.getUrlFinal(), tempoGasto);
		return vo;
	}
	
	public static LinkVo parseUrlOriginal(Link link, Long tempoGasto){
		LinkVo vo = new LinkVo(link.getAlias(), link.getUrlOriginal(), tempoGasto);
		return vo;
	}	

	public LinkVo(String alias, String url, Long tempoGasto) {
		super(alias);
		this.url = url;
		this.estatisticas = new EstatisticaVo(tempoGasto);
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
