package com.sxjs.jd.composition.main.goodsinfo_xqs.MyData;

import com.sxjs.common.bean.HomeWares;

/**
 * Created by Administrator on 2017/7/21.
 */

public class GoodsPinInfo{
    /*public int goods_id;
    public String cat_id;
    public String goods_sn;
    public String goods_name;
    public String goods_name_style;
    public String click_count;
    public String brand_id;
    public int goods_weight;
    public String goods_number;
    public int market_price;
    public int shop_price;
    public int promote_price;
    public String promote_start_date;
    public String promoteEndDate;
    public String keywords;
    public String goods_brief;
    public String goods_thumb;
    public String goods_img;
    public String add_time;
    public String is_on_sale;
    public int salenum;
    public String sort_order;
    public String is_delete;
    public String is_best;
    public String is_new;
    public int is_hot;
    public int is_promote;
    public String is_discount;
    public String return_money;
    public String last_update;
    public String goods_type;
    public String seller_note;
    public String supplier_id;
    public String supplier_status;
    public String special_goods;
    HomeWares homeWares;
    public int getGoods_id() {
        return homeWares.getItems().get(0).getItemList().get(0).getGoodsId();
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getCat_id() {
        return homeWares.getItems().get(0).getItemList().get(0).getCatId();
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getGoods_sn() {
        return homeWares.getItems().get(0).getItemList().get(0).getGoodsSn();
    }

    public void setGoods_sn(String goods_sn) {
        this.goods_sn = goods_sn;
    }

    public String getGoods_name() {
        return homeWares.getItems().get(0).getItemList().get(0).getGoodsName();
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_name_style() {
        return homeWares.getItems().get(0).getItemList().get(0).getGoods_name_style();}

    public void setGoods_name_style(String goods_name_style) {
        this.goods_name_style = goods_name_style;
    }

    public int getClick_count() {
        return homeWares.getItems().get(0).getItemList().get(0).getClick_count();
    }

    public void setClick_count(String click_count) {
        this.click_count = click_count;
    }

    public String getBrand_id() {
        return homeWares.getItems().get(0).getItemList().get(0).getBrand_id();
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public int getGoods_weight() {
        return homeWares.getItems().get(0).getItemList().get(0).getGoods_weight();
    }

    public void setGoods_weight(int goods_weight) {
        this.goods_weight = goods_weight;
    }

    public String getGoods_number() {
        return homeWares.getItems().get(0).getItemList().get(0).getGoods_number();
    }

    public void setGoods_number(String goods_number) {
        this.goods_number = goods_number;
    }

    public int getMarket_price() {
        return homeWares.getItems().get(0).getItemList().get(0).getMarket_price();
    }

    public void setMarket_price(int market_price) {
        this.market_price = market_price;
    }

    public int getShop_price() {
        return homeWares.getItems().get(0).getItemList().get(0).getShop_price();
    }

    public void setShop_price(int shop_price) {
        this.shop_price = shop_price;
    }

    public int getPromote_price() {
        return homeWares.getItems().get(0).getItemList().get(0).getPromote_price();
    }

    public void setPromote_price(int promote_price) {
        this.promote_price = promote_price;
    }

    public String getPromote_start_date() {
        return homeWares.getItems().get(0).getItemList().get(0).getPromote_start_date();
    }

    public void setPromote_start_date(String promote_start_date) {
        this.promote_start_date = promote_start_date;
    }

    public String getPromoteEndDate() {
        return homeWares.getItems().get(0).getItemList().get(0).getPromoteEndDate();
    }

    public void setPromoteEndDate(String promoteEndDate) {
        this.promoteEndDate = promoteEndDate;
    }

    public String getKeywords() {
        return homeWares.getItems().get(0).getItemList().get(0).getKeywords();
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getGoods_brief() {
        return homeWares.getItems().get(0).getItemList().get(0).getGoods_brief();
    }

    public void setGoods_brief(String goods_brief) {
        this.goods_brief = goods_brief;
    }

    public String getGoods_thumb() {
        return homeWares.getItems().get(0).getItemList().get(0).getGoods_thumb();
    }
//
//    public void setGoods_thumb(String goods_thumb) {
//        this.goods_thumb = goods_thumb;
//    }
//
//    public String getGoods_img() {
//        return homeWares.getItems().get(0).getItemList().get(0).getGoods_img();
//    }

    public void setGoods_thumb(String goods_thumb) {
        this.goods_thumb = goods_thumb;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public HomeWares getHomeWares() {
        return homeWares;
    }

    public void setHomeWares(HomeWares homeWares) {
        this.homeWares = homeWares;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public String getAdd_time() {
        return homeWares.getItems().get(0).getItemList().get(0).getAdd_time();
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getIs_on_sale() {
        return homeWares.getItems().get(0).getItemList().get(0).getIs_on_sale();
    }

    public void setIs_on_sale(String is_on_sale) {
        this.is_on_sale = is_on_sale;
    }

    public int getSalenum() {
        return homeWares.getItems().get(0).getItemList().get(0).getSalenum();
    }

    public void setSalenum(int salenum) {
        this.salenum = salenum;
    }

    public String getSort_order() {
        return homeWares.getItems().get(0).getItemList().get(0).getSort_order();
    }

    public void setSort_order(String sort_order) {
        this.sort_order = sort_order;
    }

    public String getIs_delete() {
        return homeWares.getItems().get(0).getItemList().get(0).getIs_delete();
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    public String getIs_best() {
        return homeWares.getItems().get(0).getItemList().get(0).getIs_best();
    }

    public void setIs_best(String is_best) {
        this.is_best = is_best;
    }

    public String getIs_new() {
        return homeWares.getItems().get(0).getItemList().get(0).getIs_new();
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public int getIs_hot() {
        return homeWares.getItems().get(0).getItemList().get(0).getIs_hot();
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public int getIs_promote() {
        return homeWares.getItems().get(0).getItemList().get(0).getIs_promote();
    }

    public void setIs_promote(int is_promote) {
        this.is_promote = is_promote;
    }

    public String getIs_discount() {
        return homeWares.getItems().get(0).getItemList().get(0).getIs_discount();
    }

    public void setIs_discount(String is_discount) {
        this.is_discount = is_discount;
    }

    public String getReturn_money() {
        return homeWares.getItems().get(0).getItemList().get(0).getReturn_money();
    }

    public void setReturn_money(String return_money) {
        this.return_money = return_money;
    }

    public String getLast_update() {
        return homeWares.getItems().get(0).getItemList().get(0).getLast_update();
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getGoods_type() {
        return homeWares.getItems().get(0).getItemList().get(0).getGoods_type();
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public String getSeller_note() {
        return homeWares.getItems().get(0).getItemList().get(0).getSeller_note();
    }

    public void setSeller_note(String seller_note) {
        this.seller_note = seller_note;
    }

    public String getSupplier_id() {
        return homeWares.getItems().get(0).getItemList().get(0).getSupplier_id();
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_status() {
        return homeWares.getItems().get(0).getItemList().get(0).getSupplier_status();
    }

    public void setSupplier_status(String supplier_status) {
        this.supplier_status = supplier_status;
    }

    public String getSpecial_goods() {
        return homeWares.getItems().get(0).getItemList().get(0).getSpecial_goods();
    }
    public void setSpecial_goods(String special_goods) {
        this.special_goods = special_goods;
    }*/
}
