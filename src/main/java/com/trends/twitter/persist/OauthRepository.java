package com.trends.twitter.persist;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.trends.twitter.model.Oauth;

public interface OauthRepository extends MongoRepository<Oauth, String>{
	
	public Oauth findByApplication (String application);

}
