package shop.service;

import shop.dao.DaoCode;

public class ServiceCode {

    public void checkCode(String code) {
        DaoCode dc = new DaoCode();
        dc.checkCode(code);
    }
}
