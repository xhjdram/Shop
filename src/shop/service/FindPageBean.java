package shop.service;

import shop.dao.FindPageBeanDao;
import shop.daomian.PageBean;
import shop.daomian.Product;

import java.util.ArrayList;
import java.util.List;

public class FindPageBean {
    public PageBean findPageBean(String cid,int currentPage,int showCount) {

        List<Product> list = new ArrayList<Product>();
        PageBean pb = new PageBean();
        pb.setCurrentPage(currentPage );
        pb.setShowCount(showCount );
        FindPageBeanDao fd = new FindPageBeanDao();
        int totalCount = fd.findPageBean(cid);
        int totalPage =(int) Math.ceil(1.0*(totalCount/showCount));
        pb.setTotalPage(totalPage);
        int index = (currentPage-1)*showCount;
        list= fd.findProduct(index,showCount,cid);
        pb.setList( list );
        return pb;
    }
}
