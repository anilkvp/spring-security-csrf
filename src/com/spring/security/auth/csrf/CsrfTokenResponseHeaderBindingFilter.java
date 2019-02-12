package com.spring.security.auth.csrf;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

public class CsrfTokenResponseHeaderBindingFilter extends OncePerRequestFilter
{
	  protected static final String RESPONSE_TOKEN_COOKIE = "X-CSRF-COOKIE";
	  protected static final String RESPONSE_TOKEN_NAME = "X-CSRF-TOKEN";
	  
	  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	    throws ServletException, IOException
	  {
	    CsrfToken token = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
	    if (token != null)
	    {
	      Cookie cookie = WebUtils.getCookie(request, RESPONSE_TOKEN_COOKIE);
	      String csrfToken = token.getToken();
	      if ((cookie == null) || ((token != null) && (!csrfToken.equals(cookie.getValue()))))
	      {
	        cookie = new Cookie(RESPONSE_TOKEN_COOKIE, csrfToken);
	        cookie.setPath("/");
	        cookie.setHttpOnly(false);
	        response.addCookie(cookie);
	        
	      }
	      response.setHeader(RESPONSE_TOKEN_NAME, csrfToken);
	    }
	    filterChain.doFilter(request, response);
	  }
}