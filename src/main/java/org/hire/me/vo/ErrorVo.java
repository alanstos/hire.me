package org.hire.me.vo;

public class ErrorVo extends BaseVo{
	
	private String errCode;
	
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
