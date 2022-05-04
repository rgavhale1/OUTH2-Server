package com.outh2.server;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AppClientRepository extends MongoRepository<AppClient, Integer> {
	
	AppClient findByClientId(String clientId);

}
