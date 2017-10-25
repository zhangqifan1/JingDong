package com.bawei.jingdong.JavaBeans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 张祺钒
 * on2017/10/18.
 */

public class InfoBean {

    /**
     * code : 200
     * datas : {"goods_info":{"goods_name":"劳力士Rolex 蚝式恒动系列 自动机械钢带男表 正品116231-G-63201","goods_jingle":"","gc_id_1":"530","gc_id_2":"540","gc_id_3":"587","spec_name":null,"spec_value":null,"goods_attr":"","goods_custom":"","mobile_body":"","goods_price":"100500.00","goods_marketprice":"100500.00","goods_costprice":"0.00","goods_discount":"0","goods_serial":"","goods_storage_alarm":"0","goods_barcode":"","transport_id":"0","transport_title":"","goods_freight":"0.00","goods_vat":"0","areaid_1":"0","areaid_2":"0","goods_stcids":"","plateid_top":"0","plateid_bottom":"0","is_virtual":"0","virtual_indate":"0","virtual_limit":"0","virtual_invalid_refund":"0","sup_id":"0","is_own_shop":"1","goods_id":"100006","goods_promotion_price":"100500.00","goods_promotion_type":"0","goods_click":3,"goods_salenum":"0","goods_collect":"0","goods_spec":null,"goods_storage":"100","color_id":"0","evaluation_good_star":"5","evaluation_count":"0","is_fcode":"0","is_presell":"0","presell_deliverdate":"0","is_book":"0","book_down_payment":"0.00","book_final_payment":"0.00","book_down_time":"0","book_buyers":"0","have_gift":"0","contract_1":"0","contract_2":"0","contract_3":"0","contract_4":"0","contract_5":"0","contract_6":"0","contract_7":"0","contract_8":"0","contract_9":"0","contract_10":"0","is_chain":"0","invite_rate":"0.00","sole_info":[],"groupbuy_info":null,"xianshi_info":null,"jjg_info":null,"cart":1,"buynow":1,"contractlist":[],"goods_url":"http://127.0.0.1/index.php?act=goods&op=index&goods_id=100006"},"spec_image":["http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627871532105_60.png"],"mansong_info":null,"gift_array":[],"goods_commend_list":[{"goods_id":"100002","goods_name":"劳力士Rolex MILGAUSS 116400GV-72400 自动机械钢带男表联保正品","goods_price":null,"goods_promotion_price":"63200.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627750479728_240.png"},{"goods_id":"100009","goods_name":"劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品","goods_price":null,"goods_promotion_price":"42800.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627958339099_240.jpg"},{"goods_id":"100005","goods_name":"劳力士Rolex 蚝式恒动 115234-CA-72190自动机械钢带男表联保正品","goods_price":null,"goods_promotion_price":"65900.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627843241680_240.jpg"},{"goods_id":"100001","goods_name":"劳力士Rolex 深海系列 自动机械钢带男士表 联保正品116660 98210","goods_price":null,"goods_promotion_price":"87500.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627707766698_240.png"},{"goods_id":"100007","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593","goods_price":null,"goods_promotion_price":"146300.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627900055146_240.png"},{"goods_id":"100003","goods_name":"劳力士Rolex 日志型系列 自动机械钢带男士表 联保正品 116333","goods_price":null,"goods_promotion_price":"89200.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627769865296_240.jpg"},{"goods_id":"100008","goods_name":"劳力士Rolex 宇宙计型迪通拿 自动机械皮带男表 正品116519 CR.TB","goods_price":null,"goods_promotion_price":"188550.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627931531971_240.jpg"},{"goods_id":"100004","goods_name":"劳力士Rolex 日志型系列 自动机械钢带男表 联保正品 116233","goods_price":null,"goods_promotion_price":"97800.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627799921979_240.jpg"}],"store_info":{"store_id":"1","store_name":"好商城V5","member_id":"1","member_name":"admin","is_own_shop":"1","goods_count":"10","store_credit":{"store_desccredit":{"text":"描述","credit":"5.0","percent_text":null},"store_servicecredit":{"text":"服务","credit":"5.0","percent_text":null},"store_deliverycredit":{"text":"物流","credit":"5.0","percent_text":null}}},"spec_list":{"":"100006"},"goods_image":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627871532105_360.png","IsHaveBuy":0,"goods_eval_list":[],"goods_evaluate_info":{"good":0,"normal":0,"bad":0,"all":0,"img":0,"good_percent":100,"normal_percent":0,"bad_percent":0,"good_star":5,"star_average":5},"goods_hair_info":{"content":"免运费","if_store_cn":"有货","if_store":true,"area_name":"全国"}}
     */

    public int code;
    public DatasBean datas;

    public static class DatasBean {
        /**
         * goods_info : {"goods_name":"劳力士Rolex 蚝式恒动系列 自动机械钢带男表 正品116231-G-63201","goods_jingle":"","gc_id_1":"530","gc_id_2":"540","gc_id_3":"587","spec_name":null,"spec_value":null,"goods_attr":"","goods_custom":"","mobile_body":"","goods_price":"100500.00","goods_marketprice":"100500.00","goods_costprice":"0.00","goods_discount":"0","goods_serial":"","goods_storage_alarm":"0","goods_barcode":"","transport_id":"0","transport_title":"","goods_freight":"0.00","goods_vat":"0","areaid_1":"0","areaid_2":"0","goods_stcids":"","plateid_top":"0","plateid_bottom":"0","is_virtual":"0","virtual_indate":"0","virtual_limit":"0","virtual_invalid_refund":"0","sup_id":"0","is_own_shop":"1","goods_id":"100006","goods_promotion_price":"100500.00","goods_promotion_type":"0","goods_click":3,"goods_salenum":"0","goods_collect":"0","goods_spec":null,"goods_storage":"100","color_id":"0","evaluation_good_star":"5","evaluation_count":"0","is_fcode":"0","is_presell":"0","presell_deliverdate":"0","is_book":"0","book_down_payment":"0.00","book_final_payment":"0.00","book_down_time":"0","book_buyers":"0","have_gift":"0","contract_1":"0","contract_2":"0","contract_3":"0","contract_4":"0","contract_5":"0","contract_6":"0","contract_7":"0","contract_8":"0","contract_9":"0","contract_10":"0","is_chain":"0","invite_rate":"0.00","sole_info":[],"groupbuy_info":null,"xianshi_info":null,"jjg_info":null,"cart":1,"buynow":1,"contractlist":[],"goods_url":"http://127.0.0.1/index.php?act=goods&op=index&goods_id=100006"}
         * spec_image : ["http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627871532105_60.png"]
         * mansong_info : null
         * gift_array : []
         * goods_commend_list : [{"goods_id":"100002","goods_name":"劳力士Rolex MILGAUSS 116400GV-72400 自动机械钢带男表联保正品","goods_price":null,"goods_promotion_price":"63200.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627750479728_240.png"},{"goods_id":"100009","goods_name":"劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品","goods_price":null,"goods_promotion_price":"42800.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627958339099_240.jpg"},{"goods_id":"100005","goods_name":"劳力士Rolex 蚝式恒动 115234-CA-72190自动机械钢带男表联保正品","goods_price":null,"goods_promotion_price":"65900.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627843241680_240.jpg"},{"goods_id":"100001","goods_name":"劳力士Rolex 深海系列 自动机械钢带男士表 联保正品116660 98210","goods_price":null,"goods_promotion_price":"87500.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627707766698_240.png"},{"goods_id":"100007","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593","goods_price":null,"goods_promotion_price":"146300.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627900055146_240.png"},{"goods_id":"100003","goods_name":"劳力士Rolex 日志型系列 自动机械钢带男士表 联保正品 116333","goods_price":null,"goods_promotion_price":"89200.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627769865296_240.jpg"},{"goods_id":"100008","goods_name":"劳力士Rolex 宇宙计型迪通拿 自动机械皮带男表 正品116519 CR.TB","goods_price":null,"goods_promotion_price":"188550.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627931531971_240.jpg"},{"goods_id":"100004","goods_name":"劳力士Rolex 日志型系列 自动机械钢带男表 联保正品 116233","goods_price":null,"goods_promotion_price":"97800.00","goods_image_url":"http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627799921979_240.jpg"}]
         * store_info : {"store_id":"1","store_name":"好商城V5","member_id":"1","member_name":"admin","is_own_shop":"1","goods_count":"10","store_credit":{"store_desccredit":{"text":"描述","credit":"5.0","percent_text":null},"store_servicecredit":{"text":"服务","credit":"5.0","percent_text":null},"store_deliverycredit":{"text":"物流","credit":"5.0","percent_text":null}}}
         * spec_list : {"":"100006"}
         * goods_image : http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627871532105_360.png
         * IsHaveBuy : 0
         * goods_eval_list : []
         * goods_evaluate_info : {"good":0,"normal":0,"bad":0,"all":0,"img":0,"good_percent":100,"normal_percent":0,"bad_percent":0,"good_star":5,"star_average":5}
         * goods_hair_info : {"content":"免运费","if_store_cn":"有货","if_store":true,"area_name":"全国"}
         */

        public GoodsInfoBean goods_info;
        public Object mansong_info;
        public StoreInfoBean store_info;
        public SpecListBean spec_list;
        public String goods_image;
        public int IsHaveBuy;
        public GoodsEvaluateInfoBean goods_evaluate_info;
        public GoodsHairInfoBean goods_hair_info;
        public List<String> spec_image;
        public List<?> gift_array;
        public List<GoodsCommendListBean> goods_commend_list;
        public List<?> goods_eval_list;

        public static class GoodsInfoBean {
            /**
             * goods_name : 劳力士Rolex 蚝式恒动系列 自动机械钢带男表 正品116231-G-63201
             * goods_jingle :
             * gc_id_1 : 530
             * gc_id_2 : 540
             * gc_id_3 : 587
             * spec_name : null
             * spec_value : null
             * goods_attr :
             * goods_custom :
             * mobile_body :
             * goods_price : 100500.00
             * goods_marketprice : 100500.00
             * goods_costprice : 0.00
             * goods_discount : 0
             * goods_serial :
             * goods_storage_alarm : 0
             * goods_barcode :
             * transport_id : 0
             * transport_title :
             * goods_freight : 0.00
             * goods_vat : 0
             * areaid_1 : 0
             * areaid_2 : 0
             * goods_stcids :
             * plateid_top : 0
             * plateid_bottom : 0
             * is_virtual : 0
             * virtual_indate : 0
             * virtual_limit : 0
             * virtual_invalid_refund : 0
             * sup_id : 0
             * is_own_shop : 1
             * goods_id : 100006
             * goods_promotion_price : 100500.00
             * goods_promotion_type : 0
             * goods_click : 3
             * goods_salenum : 0
             * goods_collect : 0
             * goods_spec : null
             * goods_storage : 100
             * color_id : 0
             * evaluation_good_star : 5
             * evaluation_count : 0
             * is_fcode : 0
             * is_presell : 0
             * presell_deliverdate : 0
             * is_book : 0
             * book_down_payment : 0.00
             * book_final_payment : 0.00
             * book_down_time : 0
             * book_buyers : 0
             * have_gift : 0
             * contract_1 : 0
             * contract_2 : 0
             * contract_3 : 0
             * contract_4 : 0
             * contract_5 : 0
             * contract_6 : 0
             * contract_7 : 0
             * contract_8 : 0
             * contract_9 : 0
             * contract_10 : 0
             * is_chain : 0
             * invite_rate : 0.00
             * sole_info : []
             * groupbuy_info : null
             * xianshi_info : null
             * jjg_info : null
             * cart : 1
             * buynow : 1
             * contractlist : []
             * goods_url : http://127.0.0.1/index.php?act=goods&op=index&goods_id=100006
             */

            public String goods_name;
            public String goods_jingle;
            public String gc_id_1;
            public String gc_id_2;
            public String gc_id_3;
            public Object spec_name;
            public Object spec_value;
            public String goods_attr;
            public String goods_custom;
            public String mobile_body;
            public String goods_price;
            public String goods_marketprice;
            public String goods_costprice;
            public String goods_discount;
            public String goods_serial;
            public String goods_storage_alarm;
            public String goods_barcode;
            public String transport_id;
            public String transport_title;
            public String goods_freight;
            public String goods_vat;
            public String areaid_1;
            public String areaid_2;
            public String goods_stcids;
            public String plateid_top;
            public String plateid_bottom;
            public String is_virtual;
            public String virtual_indate;
            public String virtual_limit;
            public String virtual_invalid_refund;
            public String sup_id;
            public String is_own_shop;
            public String goods_id;
            public String goods_promotion_price;
            public String goods_promotion_type;
            public int goods_click;
            public String goods_salenum;
            public String goods_collect;
            public Object goods_spec;
            public String goods_storage;
            public String color_id;
            public String evaluation_good_star;
            public String evaluation_count;
            public String is_fcode;
            public String is_presell;
            public String presell_deliverdate;
            public String is_book;
            public String book_down_payment;
            public String book_final_payment;
            public String book_down_time;
            public String book_buyers;
            public String have_gift;
            public String contract_1;
            public String contract_2;
            public String contract_3;
            public String contract_4;
            public String contract_5;
            public String contract_6;
            public String contract_7;
            public String contract_8;
            public String contract_9;
            public String contract_10;
            public String is_chain;
            public String invite_rate;
            public Object groupbuy_info;
            public Object xianshi_info;
            public Object jjg_info;
            public int cart;
            public int buynow;
            public String goods_url;
            public List<?> sole_info;
            public List<?> contractlist;
        }

        public static class StoreInfoBean {
            /**
             * store_id : 1
             * store_name : 好商城V5
             * member_id : 1
             * member_name : admin
             * is_own_shop : 1
             * goods_count : 10
             * store_credit : {"store_desccredit":{"text":"描述","credit":"5.0","percent_text":null},"store_servicecredit":{"text":"服务","credit":"5.0","percent_text":null},"store_deliverycredit":{"text":"物流","credit":"5.0","percent_text":null}}
             */

            public String store_id;
            public String store_name;
            public String member_id;
            public String member_name;
            public String is_own_shop;
            public String goods_count;
            public StoreCreditBean store_credit;

            public static class StoreCreditBean {
                /**
                 * store_desccredit : {"text":"描述","credit":"5.0","percent_text":null}
                 * store_servicecredit : {"text":"服务","credit":"5.0","percent_text":null}
                 * store_deliverycredit : {"text":"物流","credit":"5.0","percent_text":null}
                 */

                public StoreDesccreditBean store_desccredit;
                public StoreServicecreditBean store_servicecredit;
                public StoreDeliverycreditBean store_deliverycredit;

                public static class StoreDesccreditBean {
                    /**
                     * text : 描述
                     * credit : 5.0
                     * percent_text : null
                     */

                    public String text;
                    public String credit;
                    public Object percent_text;
                }

                public static class StoreServicecreditBean {
                    /**
                     * text : 服务
                     * credit : 5.0
                     * percent_text : null
                     */

                    public String text;
                    public String credit;
                    public Object percent_text;
                }

                public static class StoreDeliverycreditBean {
                    /**
                     * text : 物流
                     * credit : 5.0
                     * percent_text : null
                     */

                    public String text;
                    public String credit;
                    public Object percent_text;
                }
            }
        }

        public static class SpecListBean {
            /**
             *  : 100006
             */

            @SerializedName("")
            public String _$47; // FIXME check this code
        }

        public static class GoodsEvaluateInfoBean {
            /**
             * good : 0
             * normal : 0
             * bad : 0
             * all : 0
             * img : 0
             * good_percent : 100
             * normal_percent : 0
             * bad_percent : 0
             * good_star : 5
             * star_average : 5
             */

            public int good;
            public int normal;
            public int bad;
            public int all;
            public int img;
            public int good_percent;
            public int normal_percent;
            public int bad_percent;
            public int good_star;
            public int star_average;
        }

        public static class GoodsHairInfoBean {
            /**
             * content : 免运费
             * if_store_cn : 有货
             * if_store : true
             * area_name : 全国
             */

            public String content;
            public String if_store_cn;
            public boolean if_store;
            public String area_name;
        }

        public static class GoodsCommendListBean {
            /**
             * goods_id : 100002
             * goods_name : 劳力士Rolex MILGAUSS 116400GV-72400 自动机械钢带男表联保正品
             * goods_price : null
             * goods_promotion_price : 63200.00
             * goods_image_url : http://127.0.0.1/data/upload/shop/store/goods/1/1_04752627750479728_240.png
             */

            public String goods_id;
            public String goods_name;
            public Object goods_price;
            public String goods_promotion_price;
            public String goods_image_url;
        }
    }
}
