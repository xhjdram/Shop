package shop.web.servlet;

import com.google.gson.Gson;
import shop.daomian.Category;
import shop.daomian.Product;
import shop.service.FindProductService;

import java.util.List;

public class FindProductServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        FindProductService fps = new FindProductService();
        List<Product> hotProductService = fps.findHotProductService();
        request.setAttribute("hotProductService",hotProductService);
        List<Product> newProductService = fps.findNewProductService();
        request.setAttribute("newProductService",newProductService);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doPost(request,response );
    }
}
