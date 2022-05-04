package com.outh2.server;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends MongoRepository<User, Integer>{
	
 User findByUserName(String userName);
}
