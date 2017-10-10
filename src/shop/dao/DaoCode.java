package shop.dao;

import org.apache.commons.dbutils.QueryRunner;
import shop.util.DataSourceUtils;

import java.sql.SQLException;

public class DaoCode {
    public void checkCode(String code) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set state=? where code=?";
         int i =0;
        try {
           i= qr.update(sql, 1, code);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
