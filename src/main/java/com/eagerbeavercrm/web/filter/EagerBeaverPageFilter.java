package com.eagerbeavercrm.web.filter;

import com.google.inject.Provider;
import com.google.inject.servlet.RequestParameters;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by kimberlygrauer on 11/7/15.
 */
public class EagerBeaverPageFilter implements Filter {
    @Inject
    @RequestParameters
    private Provider<Map<String, String[]>> reqParamMapProvider;


    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)
            throws IOException, ServletException {
        boolean valid = true;

        try {
            Map<String, String[]> requestMap = reqParamMapProvider.get();

        } finally  {
            //catch (ParseException e) {
        }
           // valid = false;
        //}

        if (valid) {
            chain.doFilter(request, response);
        }else{
            ((HttpServletRequest)request).getSession().setAttribute("isException", true);
            ((HttpServletRequest)request).getSession().setAttribute("exceptionMessage", "Invalid request parameters");
            request.getRequestDispatcher("response.jsp").forward(request, response);
        }

    }
    public void init(FilterConfig arg0) throws ServletException {

    }

}

