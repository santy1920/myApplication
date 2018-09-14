package com.ideas2it.employeemanagement.filters;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ideas2it.employeemanagement.commons.constants.Constants;
      
public class AuthenticationFilter implements Filter { 

	private ServletContext context;     
      
    public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log(Constants.FILTER_INITIALIZED);
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {  
        HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
		HttpSession session = req.getSession(true);
        if(uri.endsWith(".css")){
            chain.doFilter(request,response);
            return;
        } 
        if(null != session && null == session.getAttribute(Constants.USER)) {
            if(uri.endsWith(Constants.USER_CONTROLLER) || 
                    uri.endsWith(Constants.REGISTER)) {
                chain.doFilter(req, res);
            } else {
                req.getRequestDispatcher(Constants.LOGIN).
                    forward(req, res);
            }
		} else if(session != null && 
                session.getAttribute(Constants.USER) != null) {
            if(uri.endsWith(Constants.LOGIN) || uri.endsWith(Constants.REGISTER) 
                    || uri.equals(Constants.MYAPP)) {
                req.getRequestDispatcher(Constants.INDEX).
                    forward(req, res);
            } else {
                chain.doFilter(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }            
    }

	public void destroy() {		
	}
}
