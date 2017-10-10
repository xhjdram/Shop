package shop.service;

import shop.dao.UserDao;
import shop.daomian.User;

public class UserService {

    public Boolean register(User user) {
        UserDao userdao = new UserDao();
       return   userdao.register(user);
    }
}
