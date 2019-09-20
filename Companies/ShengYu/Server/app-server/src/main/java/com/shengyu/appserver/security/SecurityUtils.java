package com.shengyu.appserver.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Utility class for Spring Security.
 */
public final class SecurityUtils {

    private SecurityUtils() {
    }

    /**
     * Get the login of the current user.
     * 获取当前用户的登录名
     *
     * @return the login of the current user.
     */
    public static Optional<String> getCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
            .map(authentication -> {
                if (authentication.getPrincipal() instanceof UserDetails) {
                    UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                    return springSecurityUser.getUsername();
                } else if (authentication.getPrincipal() instanceof String) {
                    return (String) authentication.getPrincipal();
                }
                return null;
            });
    }

    /**
     * Check if a user is authenticated.
     * 检查用户是否经过身份验证
     * @return true if the user is authenticated, false otherwise.
     * 如果用户经过身份验证，则为true；否则为false
     */
    public static boolean isAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
            .map(authentication -> {
                List<GrantedAuthority> authorities = new ArrayList<>();
                    authorities.addAll(authentication.getAuthorities());
                return authorities.stream()
                    .noneMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(AuthoritiesConstants.ANONYMOUS));
            })
            .orElse(false);
    }

    /**
     * If the current user has a specific authority (security role).
     * 如果当前用户具有特定权限
     * <p>
     * The name of this method comes from the {@code isUserInRole()} method in the Servlet API.
     *
     * @param authority the authority to check.
     * @return true if the current user has the authority, false otherwise.
     */
    public static boolean isCurrentUserInRole(String authority) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
            .map(authentication -> {
                List<GrantedAuthority> authorities = new ArrayList<>();
                    authorities.addAll(authentication.getAuthorities());
                return authorities.stream()
                    .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(authority));
            })
            .orElse(false);
    }
}
