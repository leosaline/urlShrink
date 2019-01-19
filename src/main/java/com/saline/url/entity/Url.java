package com.saline.url.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Url {
	
	@Id
	public String id;
	public String originalUrl;
	public String shrinkUrl;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public String getShrinkUrl() {
		return shrinkUrl;
	}
	public void setShrinkUrl(String shrinkUrl) {
		this.shrinkUrl = shrinkUrl;
	}

}
