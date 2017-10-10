package shop.dao;

import org.apache.commons.dbutils.QueryRunner;
import shop.daomian.User;
import shop.util.DataSourceUtils;

import java.sql.SQLException;

public class UserDao {
    public Boolean register(User user) {
        Boolean flag = false;
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "INSERT  INTO USER (uid,username,PASSWORD,NAME,email ,telephone,birthday,sex,state,CODE) VALUES (?,?,?,?,?,?,?,?,?,?)";

         int update = 0;
        try {
            update = qr.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (update!=0){
            flag=true;
        }
        return flag;
    }
}
