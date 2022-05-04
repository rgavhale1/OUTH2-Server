package com.outh2.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
@Service("myClientDetailsService")
public class MyClientDetailsService implements ClientDetailsService {

	@Autowired
	AppClientRepository appClientRepository;
	
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		AppClient appClient=appClientRepository.findByClientId(clientId);
		
		if(appClient==null) {
			throw new ClientRegistrationException("Client with" +clientId+" is not available");
		}
		
		return new MyClientDetails(appClient);
	}

}
