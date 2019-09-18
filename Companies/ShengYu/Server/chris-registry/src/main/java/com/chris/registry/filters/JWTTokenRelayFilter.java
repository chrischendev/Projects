package com.chris.registry.filters;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.chris.registry.config.Constants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
@Profile("!" + Constants.PROFILE_OAUTH2)
public class JWTTokenRelayFilter extends ZuulFilter {
	private final Logger log = LoggerFactory.getLogger(JWTTokenRelayFilter.class);
	
    @Override
    public Object run() {
    	log.debug("JWTTokenRelayFilter");
        RequestContext ctx = RequestContext.getCurrentContext();
        Set<String> headers = (Set<String>) ctx.get("ignoredHeaders");
        // JWT tokens should be relayed to the resource servers
        //headers.remove("authorization");  //modify by wei.li
        
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10000;
    }
}
