package org.openscoring.service;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import com.typesafe.config.Config;

@Provider
@PreMatching
@Priority (
	value = Priorities.AUTHENTICATION
)
public class RoleSecurityContextFilter implements ContainerRequestFilter {

	@Context
	private HttpServletRequest request;

	@Inject
	public RoleSecurityContextFilter(@Named("openscoring") Config config){
	}

	@Override
	public void filter(ContainerRequestContext context){
		context.setSecurityContext(new RoleSecurityContext(this.request));
	}
}