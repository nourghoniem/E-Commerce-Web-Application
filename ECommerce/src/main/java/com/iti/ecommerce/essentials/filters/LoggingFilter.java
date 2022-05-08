package com.iti.ecommerce.essentials.filters;

import com.iti.ecommerce.essentials.dbconnection.DatabaseManagement;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoggingFilter implements Filter {

    DatabaseManagement DM;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         DM =new DatabaseManagement();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (session != null) {
            if (session.getAttribute("id") == null || session.getAttribute("user_type") == null) {
                response.sendRedirect("/ECommerce/JSPfiles/Login.jsp");
                System.out.println("id == null and type == null");
                return;
            } else {
                try {
                    int user = DM.getUserType((int)session.getAttribute("id"));
                    System.out.println("user equal: "+user+" session Attribute :"+(int) session.getAttribute("user_type") );
                    if (user == (int) session.getAttribute("user_type") && user==2) {
                        System.out.println("passed user==2");
                        filterChain.doFilter(request, response);
                    } else {
                        response.sendRedirect("/ECommerce/JSPfiles/error.jsp");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    @Override
    public void destroy() {

    }
}
