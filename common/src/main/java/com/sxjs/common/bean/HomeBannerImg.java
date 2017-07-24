package com.sxjs.common.bean;

import com.sxjs.common.base.baseadapter.entity.MultiItemEntity;
import com.sxjs.common.data.Constant;

import java.util.List;

/**
 * Created by Administrator on 2017/7/16.
 */

public class HomeBannerImg {

    /**
     * code : 200
     * msg : 访问成功
     * isOver : null
     * timstamp : 1500555519516
     * pageindex : 0
     * items : [{"itemType":"topBanner","module":"topBanner","itemList":[{"ad_id":90,"position_id":65,"media_type":null,"ad_name":"首页幻灯片1","ad_link":null,"ad_code":"49.122.47.185:8080/XJD/data/images/afficheimg/20150722uzphik.jpg","start_time":null,"end_time":null,"link_man":null,"link_email":null,"link_phone":null,"click_count":null,"enabled":null},{"ad_id":91,"position_id":65,"media_type":null,"ad_name":"首页幻灯片2","ad_link":null,"ad_code":"49.122.47.185:8080/XJD/data/images/afficheimg/20150722zsmllz.jpg","start_time":null,"end_time":null,"link_man":null,"link_email":null,"link_phone":null,"click_count":null,"enabled":null},{"ad_id":92,"position_id":65,"media_type":null,"ad_name":"首页环丁片3","ad_link":null,"ad_code":"49.122.47.185:8080/XJD/data/images/afficheimg/20150723axsewo.jpg","start_time":null,"end_time":null,"link_man":null,"link_email":null,"link_phone":null,"click_count":null,"enabled":null}]}]
     */

    public String code;
    public String msg;
    public String isOver;
    public long timstamp;
    public int pageindex;
    public List<ItemsBean> items;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getIsOver() {
        return isOver;
    }

    public void setIsOver(String isOver) {
        this.isOver = isOver;
    }

    public long getTimstamp() {
        return timstamp;
    }

    public void setTimstamp(long timstamp) {
        this.timstamp = timstamp;
    }

    public int getPageindex() {
        return pageindex;
    }

    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean implements MultiItemEntity{
        /**
         * itemType : topBanner
         * module : topBanner
         * itemList : [{"ad_id":90,"position_id":65,"media_type":null,"ad_name":"首页幻灯片1","ad_link":null,"ad_code":"49.122.47.185:8080/XJD/data/images/afficheimg/20150722uzphik.jpg","start_time":null,"end_time":null,"link_man":null,"link_email":null,"link_phone":null,"click_count":null,"enabled":null},{"ad_id":91,"position_id":65,"media_type":null,"ad_name":"首页幻灯片2","ad_link":null,"ad_code":"49.122.47.185:8080/XJD/data/images/afficheimg/20150722zsmllz.jpg","start_time":null,"end_time":null,"link_man":null,"link_email":null,"link_phone":null,"click_count":null,"enabled":null},{"ad_id":92,"position_id":65,"media_type":null,"ad_name":"首页环丁片3","ad_link":null,"ad_code":"49.122.47.185:8080/XJD/data/images/afficheimg/20150723axsewo.jpg","start_time":null,"end_time":null,"link_man":null,"link_email":null,"link_phone":null,"click_count":null,"enabled":null}]
         */

        public String itemType;
        public String module;
        public List<ItemListBean> itemList;

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        @Override
        public int getItemType() {
            //if("topBanner".equals(itemType))
            return Constant.TYPE_TOP_BANNER;

            //return Constant.TYPE_RECOMMENDED_WARE;
        }

        public int getSpanSize() {
            if("recommended_ware".equals(itemType)){
                return 2;
            }
            return 4;
        }


        public static class ItemListBean {
            /**
             * ad_id : 90
             * position_id : 65
             * media_type : null
             * ad_name : 首页幻灯片1
             * ad_link : null
             * ad_code : 49.122.47.185:8080/XJD/data/images/afficheimg/20150722uzphik.jpg
             * start_time : null
             * end_time : null
             * link_man : null
             * link_email : null
             * link_phone : null
             * click_count : null
             * enabled : null
             */

            public int ad_id;
            public int position_id;
            public String media_type;
            public String ad_name;
            public String ad_link;
            public String ad_code;
            public String start_time;
            public String end_time;
            public String link_man;
            public String link_email;
            public String link_phone;
            public String click_count;
            public String enabled;

            public int getAd_id() {
                return ad_id;
            }

            public void setAd_id(int ad_id) {
                this.ad_id = ad_id;
            }

            public int getPosition_id() {
                return position_id;
            }

            public void setPosition_id(int position_id) {
                this.position_id = position_id;
            }

            public String getMedia_type() {
                return media_type;
            }

            public void setMedia_type(String media_type) {
                this.media_type = media_type;
            }

            public String getAd_name() {
                return ad_name;
            }

            public void setAd_name(String ad_name) {
                this.ad_name = ad_name;
            }

            public String getAd_link() {
                return ad_link;
            }

            public void setAd_link(String ad_link) {
                this.ad_link = ad_link;
            }

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getLink_man() {
                return link_man;
            }

            public void setLink_man(String link_man) {
                this.link_man = link_man;
            }

            public String getLink_email() {
                return link_email;
            }

            public void setLink_email(String link_email) {
                this.link_email = link_email;
            }

            public String getLink_phone() {
                return link_phone;
            }

            public void setLink_phone(String link_phone) {
                this.link_phone = link_phone;
            }

            public String getClick_count() {
                return click_count;
            }

            public void setClick_count(String click_count) {
                this.click_count = click_count;
            }

            public String getEnabled() {
                return enabled;
            }

            public void setEnabled(String enabled) {
                this.enabled = enabled;
            }
        }
    }
}
