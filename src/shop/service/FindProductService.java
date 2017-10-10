package shop.service;

import shop.dao.FindProductDao;
import shop.daomian.Category;
import shop.daomian.Product;

import java.util.List;

public class FindProductService {
    FindProductDao fpd = new FindProductDao();
    public List<Product> findHotProductService() {

       return fpd.findHotProductDao();
    }

    public List<Product> findNewProductService() {

        return fpd.findNewProductDao();
    }

    public List<Category> findCategory() {

        return fpd.findCategory();
    }
}
