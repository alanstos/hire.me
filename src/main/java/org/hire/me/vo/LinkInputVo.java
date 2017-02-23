package org.hire.me.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkInputVo {
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("CUSTOM_ALIAS")
	private String customAlias;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCustomAlias() {
		return customAlias;
	}

	public void setCustomAlias(String customAlias) {
		this.customAlias = customAlias;
	}

	@Override
	public String toString() {
		return "RequestLinkVo [url=" + url + ", customAlias=" + customAlias + "]";
	}
	
}
