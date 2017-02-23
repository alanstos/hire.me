package org.hire.me.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorVo extends BaseVo{
	
	@JsonProperty("err_code")
	private String errCode;
	
	@JsonProperty("description")
	private String descricao;
	
	public static BaseVo parse(String alias, String code, String message) {
		return new ErrorVo(alias, code, message);
	}	
	
	public ErrorVo(String alias,String errCode, String descricao) {
		super(alias);
		this.errCode = errCode;
		this.descricao = descricao;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
