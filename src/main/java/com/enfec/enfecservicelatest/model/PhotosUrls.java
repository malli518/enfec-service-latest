package com.enfec.enfecservicelatest.model;

public class PhotosUrls {
	private String url;
	private String thumbnailUrl;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	@Override
	public String toString() {
		return "PhotosUrls [url=" + url + ", thumbnailUrl=" + thumbnailUrl + "]";
	}
}
