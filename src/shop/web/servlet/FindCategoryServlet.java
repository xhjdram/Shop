package shop.web.servlet;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import shop.daomian.Category;
import shop.service.FindProductService;
import shop.util.JedisPoolUtils;

import java.util.List;

public class FindCategoryServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        Jedis jedis = JedisPoolUtils.getJedis();
        String s = jedis.get("s");
        if(s!=null){
            System.out.println("redis中有数据");
        }
        if(s==null){
            Gson gson = new Gson();
            FindProductService fps = new FindProductService();
            List<Category> category = fps.findCategory();
             s = gson.toJson(category);
            jedis.set("s",s);
            //主意编码  带中文！！！！！！！！！！！！！！！！！！

            System.out.println("redis中没有数据");
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(s);


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
      doPost(request,response);
    }
}
