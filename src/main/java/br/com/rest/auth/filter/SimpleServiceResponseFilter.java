package br.com.rest.auth.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class SimpleServiceResponseFilter implements ContainerResponseFilter{

	@Override
	public void filter(ContainerRequestContext resquestCtx, ContainerResponseContext responseCtx) throws IOException {
        responseCtx.getHeaders().add( "Access-Control-Allow-Origin", "*" ); 
        responseCtx.getHeaders().add( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Headers","Authorization" );       
	}

}
