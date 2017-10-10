package shop.daomian;

import java.util.Date;

public class Product {
    private  String pid ;
    private  String pname ;
    private  double mark_price ;
    private  double shop_price ;
    private  String pimage ;
    private Date pdata ;
    private  int  is_hot;
    private  String pdesc ;
    private  String pfalg ;
    private  String cid ;
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getMark_price() {
        return mark_price;
    }

    public void setMark_price(double mark_price) {
        this.mark_price = mark_price;
    }

    public double getShop_price() {
        return shop_price;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Date getPdata() {
        return pdata;
    }

    public void setPdata(Date pdata) {
        this.pdata = pdata;
    }

    public int getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getPfalg() {
        return pfalg;
    }

    public void setPfalg(String pfalg) {
        this.pfalg = pfalg;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
