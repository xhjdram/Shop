package shop.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import shop.daomian.Category;
import shop.daomian.Product;
import shop.util.DataSourceUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindProductDao {
    public List<Product> findHotProductDao() {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM  product WHERE is_hot=? LIMIT ?,?";
        List<Product> products = new ArrayList<Product>();
        try {
            products=qr.query(sql,new BeanListHandler<Product>(Product.class),1,0,9);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  products;
    }

    public List<Product> findNewProductDao() {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM  product ORDER BY pdate DESC LIMIT ?,?";
        List<Product> products = new ArrayList<Product>();
        try {
            products=qr.query(sql,new BeanListHandler<Product>(Product.class),0,9);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  products;
    }

    public List<Category> findCategory() {
         QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM  category";
        List<Category> category = new ArrayList<Category>();
        try {
            category=qr.query(sql,new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  category;
    }
}
