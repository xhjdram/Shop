package shop.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import shop.util.DataSourceUtils;
import sun.util.resources.ga.LocaleNames_ga;

import java.sql.SQLException;

public class CheckUserNameDao {
    public long CheckUserName(String userName) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql ="select count(*) from user where username=?";
        long query = 0l;
        try {
           query = (Long)qr.query(sql, new ScalarHandler(), userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
