package com.trends.twitter.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrendsResponse {

	private ArrayList<Trend> trends;
	private ArrayList<Location> locations;
	
	@JsonProperty("as_of")
	private String asOf;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	public ArrayList<Trend> getTrends() {
		return trends;
	}
	public void setTrends(ArrayList<Trend> trends) {
		this.trends = trends;
	}
	public ArrayList<Location> getLocations() {
		return locations;
	}
	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}
	public String getAsOf() {
		return asOf;
	}
	public void setAsOf(String asOf) {
		this.asOf = asOf;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "TrendsResponse [trends=" + trends + ", locations=" + locations + ", asOf=" + asOf + ", createdAt="
				+ createdAt + "]";
	}
	
	
	
	
}
