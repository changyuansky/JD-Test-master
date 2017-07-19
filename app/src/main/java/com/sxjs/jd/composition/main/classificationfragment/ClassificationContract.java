package com.sxjs.jd.composition.main.classificationfragment;

import com.sxjs.common.bean.ClassFication;

import java.util.List;

/**
 * Created by admin on 2017/3/12.
 */

public interface ClassificationContract {
 interface View {
    void setTypeOfNameData(List<ClassFication.ItemsBean> list);

     void setTypeIconsData(String text);

}

 interface Presenter {
    void getTypeOfNameData(boolean update);

     void getTypeIconsData();
}

}