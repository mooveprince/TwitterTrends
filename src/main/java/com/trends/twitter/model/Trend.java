package com.trends.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trend {

	private String name;
	private String url;
	
	@JsonProperty("promoted_content")
	private String promotedContent;
	
	@JsonProperty("tweet_volume")
	private String tweetVolume;
	private String query;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPromotedContent() {
		return promotedContent;
	}
	public void setPromotedContent(String promotedContent) {
		this.promotedContent = promotedContent;
	}
	public String getTweetVolume() {
		return tweetVolume;
	}
	public void setTweetVolume(String tweetVolume) {
		this.tweetVolume = tweetVolume;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	
}
