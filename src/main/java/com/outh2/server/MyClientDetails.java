package com.outh2.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

public class MyClientDetails implements ClientDetails {

	AppClient appClient;

	public MyClientDetails(AppClient appClient) {
		super();
		this.appClient = appClient;
	}

	@Override
	public String getClientId() {
		// TODO Auto-generated method stub
		return appClient.getClientId();
	}

	@Override
	public Set<String> getResourceIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSecretRequired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getClientSecret() {
		// TODO Auto-generated method stub
		return appClient.getClientSecret();
	}

	@Override
	public boolean isScoped() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Set<String> getScope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {

		String[] authorizedGrantTypes = appClient.getAuthorizedGrantTypes().split(",");

		List<String> list = Arrays.asList(authorizedGrantTypes);
		return new HashSet<>(list);
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> authorities=new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
		return authorities;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return appClient.getAccessTokenValidity();
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return appClient.getRefreshTokenValidity();
	}

	@Override
	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return null;
	}

}
