package org.openscoring.service;

import java.security.Principal;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.SecurityContext;

public class RoleSecurityContext implements SecurityContext {

	private ServletRequest request = null;


	public RoleSecurityContext(ServletRequest request){
		setRequest(request);
	}

	@Override
	public String getAuthenticationScheme(){
		return "BASIC_AUTH";
	}

	@Override
	public boolean isSecure(){
		return getRequest().isSecure();
	}

	@Override
	public Principal getUserPrincipal(){
		return Anonymous.INSTANCE;
	}

	@Override
	public boolean isUserInRole(String role){
		HttpServletRequest request = (HttpServletRequest) getRequest();
		return request.isUserInRole(role);
	}

	private ServletRequest getRequest(){
		return this.request;
	}

	private void setRequest(ServletRequest request){
		this.request = request;
	}

	static
	private class Anonymous implements Principal {

		private Anonymous(){
		}

		@Override
		public String getName(){
			return "ANONYMOUS";
		}

		private static final Anonymous INSTANCE = new Anonymous();
	}

}