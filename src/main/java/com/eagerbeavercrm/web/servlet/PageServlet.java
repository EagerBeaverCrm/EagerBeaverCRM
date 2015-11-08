package com.eagerbeavercrm.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kimberlygrauer on 11/7/15.
 */
public class PageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getRequestDispatcher("response.jsp").forward(request, response);
        } catch (ServletException se) {
            System.out.println(se.getMessage()) ;
        }
    }
}
