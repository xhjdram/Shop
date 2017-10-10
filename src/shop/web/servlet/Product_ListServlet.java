package shop.web.servlet;

import shop.daomian.PageBean;
import shop.service.FindPageBean;

public class Product_ListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String cid = request.getParameter("cid");
        int showCount = 12;
        int currentPage=1;
      if (request.getParameter("currentPage")!=null ){
          currentPage=Integer.parseInt(request.getParameter("currentPage"));
      };

        PageBean pb = new PageBean();
        FindPageBean fpb = new FindPageBean();
        pb=fpb.findPageBean(cid,currentPage,showCount);
        request.setAttribute("pb",pb);
        request.setAttribute("cid",cid);
        request.getRequestDispatcher("/product_list.jsp").forward(request ,response );
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
          doPost(request ,response );
    }
}
