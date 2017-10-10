package shop.web.servlet;

import org.apache.commons.beanutils.BeanUtils;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import shop.daomian.User;
import shop.service.ServiceCode;
import shop.service.UserService;
import shop.util.CommUtils;
import shop.util.MailUtils;

import javax.mail.MessagingException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class RegisterServlete extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();

        try {
            ConvertUtils.register(new Converter() {
                @Override
                public Object convert(Class aClass, Object o) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date parse =null;
                    try {
                         parse = format.parse(o.toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return parse;
                }
            },Date.class);
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String code = UUID.randomUUID().toString();
        user.setUid(CommUtils.getUUID());
        user.setCode(code);
        user.setState("0");
        user.setTelephone(null);
        UserService userservice = new UserService();
        Boolean register = userservice.register(user);
        String email = user.getEmail();
        if(register==true)
        {
            String emailMessage = "恭喜您注册成功，请点击下面的连接进行激活账户"
                    + "<a href='http://www.myspan.top/shop/active?activeCode="+code+"'>"
                    + "http://www.myspan.top/shop/active?activeCode="+code+"</a>";

            try {
                MailUtils.sendMail(email,emailMessage);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            response.sendRedirect(request.getContextPath()+"/registerSuccess.jsp");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/registerFail.jsp");
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {
           doPost(request,response);
    }
}
