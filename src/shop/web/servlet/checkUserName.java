package shop.web.servlet;

import shop.service.CheckUserName;

public class checkUserName extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String userName = request.getParameter("username");
        CheckUserName cun = new CheckUserName();
        Boolean flag = cun.CheckUserName(userName);
        String json = "{\"flag\":"+flag+"}";
        response.getWriter().write(json);


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
           doPost(request,response );
    }
}
