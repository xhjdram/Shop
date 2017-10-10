package shop.service;

import shop.dao.CheckUserNameDao;

public class CheckUserName {
    public Boolean CheckUserName(String userName) {
        CheckUserNameDao cud = new CheckUserNameDao();
        long l = cud.CheckUserName(userName);
        Boolean flag = l>0?true:false;
        return  flag;
    }
}
