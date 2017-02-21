package org.hire.me.exception;

public class EncurtadorLinkException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String code;
	
	public EncurtadorLinkException(String code, String message) {
		this.message = message;
		this.code = code;
	}	

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}
	
	

}
