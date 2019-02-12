package com.spring.security.auth.csrf;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class CsrfSecurityRequestMatcher implements RequestMatcher {
	
	private List<String> urls;

	private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
   // private RegexRequestMatcher unprotectedMatcher = new RegexRequestMatcher("/spring-bean/list.do", null);
    
    private RegexRequestMatcher [] unprotectedMatchers = {
    		new RegexRequestMatcher("/spring-bean/list.do", null)
    };
  

    @Override
    public boolean matches(HttpServletRequest request) {
        if(allowedMethods.matcher(request.getMethod()).matches()){
            return false;
        }
        
        for(RegexRequestMatcher regexRequestMatcher: unprotectedMatchers) {
        	if(regexRequestMatcher.matches(request)) return false;
        }

        return true;
    }	

}
