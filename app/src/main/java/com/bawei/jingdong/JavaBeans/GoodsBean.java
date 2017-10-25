package com.bawei.jingdong.JavaBeans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 张祺钒
 * on2017/10/17.
 */

public class GoodsBean implements Serializable {


    /**
     * code : 200
     * hasmore : true
     * page_total : 2
     * datas : {"goods_list":[{"goods_id":"100009","store_id":"1","goods_name":"劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品","goods_jingle":"【雅欧国际】：所有商品全新原装正品　　","goods_price":"42800.00","goods_marketprice":"52800.00","goods_image":"1_04752627958339099.jpg","goods_salenum":"0","evaluation_good_star":"5","evaluation_count":"0","is_virtual":"0","is_presell":"0","is_fcode":"0","have_gift":"0","store_name":"好商城V5","is_own_shop":"1","sole_flag":false,"group_flag":true,"xianshi_flag":false,"goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627958339099_360.jpg"},{"goods_id":"100008","store_id":"1","goods_name":"劳力士Rolex 宇宙计型迪通拿 自动机械皮带男表 正品116519 CR.TB","goods_jingle":"【雅欧国际】：所有商品全新原装正品　　","goods_price":"188550.00","goods_marketprice":"209500.00","goods_image":"1_04752627931531971.jpg","goods_salenum":"0","evaluation_good_star":"5","evaluation_count":"0","is_virtual":"0","is_presell":"0","is_fcode":"0","have_gift":"0","store_name":"好商城V5","is_own_shop":"1","sole_flag":false,"group_flag":false,"xianshi_flag":true,"goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627931531971_360.jpg"},{"goods_id":"100007","store_id":"1","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593","goods_jingle":"","goods_price":"146300.00","goods_marketprice":"146300.00","goods_image":"1_04752627900055146.png","goods_salenum":"0","evaluation_good_star":"5","evaluation_count":"0","is_virtual":"0","is_presell":"0","is_fcode":"0","have_gift":"0","store_name":"好商城V5","is_own_shop":"1","sole_flag":false,"group_flag":false,"xianshi_flag":false,"goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627900055146_360.png"},{"goods_id":"100006","store_id":"1","goods_name":"劳力士Rolex 蚝式恒动系列 自动机械钢带男表 正品116231-G-63201","goods_jingle":"","goods_price":"100500.00","goods_marketprice":"100500.00","goods_image":"1_04752627871532105.png","goods_salenum":"0","evaluation_good_star":"5","evaluation_count":"0","is_virtual":"0","is_presell":"0","is_fcode":"0","have_gift":"0","store_name":"好商城V5","is_own_shop":"1","sole_flag":false,"group_flag":false,"xianshi_flag":false,"goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627871532105_360.png"},{"goods_id":"100005","store_id":"1","goods_name":"劳力士Rolex 蚝式恒动 115234-CA-72190自动机械钢带男表联保正品","goods_jingle":"","goods_price":"65900.00","goods_marketprice":"65900.00","goods_image":"1_04752627843241680.jpg","goods_salenum":"0","evaluation_good_star":"5","evaluation_count":"0","is_virtual":"0","is_presell":"0","is_fcode":"0","have_gift":"0","store_name":"好商城V5","is_own_shop":"1","sole_flag":false,"group_flag":false,"xianshi_flag":false,"goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627843241680_360.jpg"}]}
     */

    public int code;
    public boolean hasmore;
    public int page_total;
    public DatasBean datas;

    public static class DatasBean implements Serializable{
        public List<GoodsListBean> goods_list;

        public static class GoodsListBean implements Serializable {
            /**
             * goods_id : 100009
             * store_id : 1
             * goods_name : 劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品
             * goods_jingle : 【雅欧国际】：所有商品全新原装正品　　
             * goods_price : 42800.00
             * goods_marketprice : 52800.00
             * goods_image : 1_04752627958339099.jpg
             * goods_salenum : 0
             * evaluation_good_star : 5
             * evaluation_count : 0
             * is_virtual : 0
             * is_presell : 0
             * is_fcode : 0
             * have_gift : 0
             * store_name : 好商城V5
             * is_own_shop : 1
             * sole_flag : false
             * group_flag : true
             * xianshi_flag : false
             * goods_image_url : http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627958339099_360.jpg
             */

            public String goods_id;
            public String store_id;
            public String goods_name;
            public String goods_jingle;
            public String goods_price;
            public String goods_marketprice;
            public String goods_image;
            public String goods_salenum;
            public String evaluation_good_star;
            public String evaluation_count;
            public String is_virtual;
            public String is_presell;
            public String is_fcode;
            public String have_gift;
            public String store_name;
            public String is_own_shop;
            public boolean sole_flag;
            public boolean group_flag;
            public boolean xianshi_flag;
            public String goods_image_url;

            @Override
            public String toString() {
                return "GoodsListBean{" +
                        "goods_id='" + goods_id + '\'' +
                        ", store_id='" + store_id + '\'' +
                        ", goods_name='" + goods_name + '\'' +
                        ", goods_jingle='" + goods_jingle + '\'' +
                        ", goods_price='" + goods_price + '\'' +
                        ", goods_marketprice='" + goods_marketprice + '\'' +
                        ", goods_image='" + goods_image + '\'' +
                        ", goods_salenum='" + goods_salenum + '\'' +
                        ", evaluation_good_star='" + evaluation_good_star + '\'' +
                        ", evaluation_count='" + evaluation_count + '\'' +
                        ", is_virtual='" + is_virtual + '\'' +
                        ", is_presell='" + is_presell + '\'' +
                        ", is_fcode='" + is_fcode + '\'' +
                        ", have_gift='" + have_gift + '\'' +
                        ", store_name='" + store_name + '\'' +
                        ", is_own_shop='" + is_own_shop + '\'' +
                        ", sole_flag=" + sole_flag +
                        ", group_flag=" + group_flag +
                        ", xianshi_flag=" + xianshi_flag +
                        ", goods_image_url='" + goods_image_url + '\'' +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "GoodsBean{" +
                "code=" + code +
                ", hasmore=" + hasmore +
                ", page_total=" + page_total +
                ", datas=" + datas +
                '}';
    }
}
