package shop.web.servlet;

import shop.service.ServiceCode;

public class ActiveServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
           doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String code = request.getParameter("activeCode");
        ServiceCode sc = new ServiceCode();
        sc.checkCode(code);
        response.sendRedirect(request.getContextPath()+"/login.jsp");

    }
}
