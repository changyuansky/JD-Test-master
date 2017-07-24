package com.sxjs.jd.composition.main.classificationfragment;

import com.sxjs.common.base.baseadapter.BaseQuickAdapter;
import com.sxjs.common.base.baseadapter.BaseViewHolder;
import com.sxjs.common.bean.ClassFication;
import com.sxjs.jd.R;

/**
 * Created by admin on 2017/3/22.
 */

public class TypeOfGoodsNameAdapter extends BaseQuickAdapter<ClassFication.ItemsBean,BaseViewHolder> {

    public TypeOfGoodsNameAdapter(int layoutResId) {
        super(layoutResId);
    }


    @Override
    protected void convert(BaseViewHolder helper, ClassFication.ItemsBean item , int position) {
        //自己根据需要更改数据
        helper.setText(R.id.goods_type_name,item.getItemList().get(position).getCat_name());
    }
}
