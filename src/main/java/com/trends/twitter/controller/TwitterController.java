package com.trends.twitter.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.trends.twitter.model.Oauth;
import com.trends.twitter.model.TrendsResponse;
import com.trends.twitter.persist.OauthRepository;

@RestController
@RequestMapping("twitter")
public class TwitterController {
	
	
	//private static final String REST_URL = "https://techfeedyservice.herokuapp.com/tweet/trends";
	private static final String REST_URL = "https://api.twitter.com/1.1/trends/place.json?id=1";
	private static final String APP_NAME = "TWITTER";
	
	@Autowired
	public OauthRepository oauthRepo;
	
	@RequestMapping (method=RequestMethod.GET, value="/trends/{place}")
	public List<TrendsResponse> getTwitterTrends (@PathVariable String place) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Oauth twitterOauth = oauthRepo.findByApplication(APP_NAME);
		String accessToken = twitterOauth.getAccessToken();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + accessToken);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<List<TrendsResponse>> trendsResponse =
		        restTemplate.exchange(REST_URL,
		                    HttpMethod.GET, entity, new ParameterizedTypeReference<List<TrendsResponse>>() {
		            });
		List<TrendsResponse> trends = trendsResponse.getBody();
		
		return trends;
		
	}

}
