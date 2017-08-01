package com.sxjs.jd.composition.main.classicfragment_lry;

import java.util.List;

/**
 * Created by Administrator on 2017/7/25 0025.
 */

public class HetiFenlei {
    Fenlei fenlei;
    List<Fenlei>  fenleiList;

    public Fenlei getFenlei() {
        return fenlei;
    }

    public void setFenlei(Fenlei fenlei) {
        this.fenlei = fenlei;
    }

    public List<Fenlei> getFenleiList() {
        return fenleiList;
    }

    public void setFenleiList(List<Fenlei> fenleiList) {
        this.fenleiList = fenleiList;
    }
}
