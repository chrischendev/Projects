package com.chris.registry.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.chris.registry.config.Constants;
import com.chris.registry.security.oauth2.AuthorizationHeaderUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
@Profile(Constants.PROFILE_OAUTH2)
public class OAuth2TokenRelayFilter extends ZuulFilter {
	private final Logger log = LoggerFactory.getLogger(OAuth2TokenRelayFilter.class);
    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Override
    public Object run() {
    	log.debug("OAuth2TokenRelayFilter");
        RequestContext ctx = RequestContext.getCurrentContext();
        // Add specific authorization headers for OAuth2
        ctx.addZuulRequestHeader(AUTHORIZATION_HEADER,
            AuthorizationHeaderUtil.getAuthorizationHeader());

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
