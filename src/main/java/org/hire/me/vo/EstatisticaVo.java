package org.hire.me.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstatisticaVo {
	
	@JsonProperty("time_taken")
	private Long tempoGasto;

	public EstatisticaVo(Long tempoGasto) {
		super();
		this.tempoGasto = tempoGasto;
	}

	public Long getTempoGasto() {
		return tempoGasto;
	}

	public void setTempoGasto(Long tempoGasto) {
		this.tempoGasto = tempoGasto;
	}
	
	

}
