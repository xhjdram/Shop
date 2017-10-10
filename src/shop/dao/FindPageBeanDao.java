package shop.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import shop.daomian.Product;
import shop.util.DataSourceUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindPageBeanDao {
    public int findPageBean(String cid) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT count(*)  FROM product WHERE cid=? ";
        Long l= null;
        try {
           l =(Long) qr.query(sql,new ScalarHandler(),cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l.intValue() ;
    }

    public List<Product> findProduct(int index, int showCount, String cid) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT *  FROM product WHERE  CID=? LIMIT ?,? ";
        List<Product> list = new ArrayList<Product>();
        try {
           list= qr.query(sql,new BeanListHandler<Product>(Product.class),cid,index,showCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
