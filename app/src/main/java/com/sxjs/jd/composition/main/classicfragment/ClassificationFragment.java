package com.sxjs.jd.composition.main.classicfragment;

import android.app.Fragment;
import android.support.annotation.Nullable;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.base.BaseFragment;
import com.sxjs.common.bean.ClassFication;
import com.sxjs.common.model.DataManager;
import com.sxjs.jd.R;
import com.sxjs.jd.composition.main.homefragment.MainHomeFragment;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.observers.DisposableObserver;


public class ClassificationFragment extends BaseFragment {
    @BindView(R.id.scanning_img)
    ImageView scanningImg;
    @BindView(R.id.advisory_img)
    ImageView advisoryImg;
    ListView lv_left;//左边
    ListView lv_right;//右边

    public TypeOfGoodsNameAdapter adapter;//一级适配
    List<ClassFication.ItemsBean.ItemListBean> booklist_depth1;//一级数据
    public TypeOfGoodsNameAdapter23 adapter23;//二级适配
    private DataManager mDataManager;
    List<ClassFication.ItemsBean.ItemListBean> mItemList_all; //从服务器拿到的所有分类信息
    private View classview;
    public static ClassificationFragment newInstance() {
        return new ClassificationFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        classview = inflater.inflate(R.layout.activity_class,container, false);
        ButterKnife.bind(this,classview);
        lv_left = (ListView) classview.findViewById(R.id.lv_left);
        lv_right = (ListView) classview.findViewById(R.id.lv_right);
        mDataManager = GlobalAppComponent.getAppComponent().getDataManager();
        initData();
        OnClick();
        ARouter.init(getActivity().getApplication());
        return classview;
    }

    public void initData() {
        getTypeOfNameData();
    }


    public void setTypeOfNameData(ClassFication classFication) {
        mItemList_all = classFication.getItems().get(0).getItemList();//拿到全部数据
        booklist_depth1 = new ArrayList<>();
        for (ClassFication.ItemsBean.ItemListBean itemListBean1 : mItemList_all) {
            if (itemListBean1.getParentId() == 0) {//筛选出一级的数据
                booklist_depth1.add(itemListBean1);//拿到一级数据
                Log.d("lry", "itemListBean");
            }
        }
        adapter = new TypeOfGoodsNameAdapter(getActivity(), booklist_depth1);
        Log.d("lry", "初始化容量:" + booklist_depth1.size());
        lv_left.setAdapter(adapter);//绑定数据
        Log.d("lry", "绑定数据");
        adapter.notifyDataSetChanged();
        bind2(booklist_depth1.get(0).getCatId());

    }


    public void getTypeOfNameData() {
        mDataManager.getClassFication(new DisposableObserver<ClassFication>() {
            @Override
            public void onNext(ClassFication classFication) {
                setTypeOfNameData(classFication);
                Log.d("lry", "onNext:" + classFication.getMsg());
            }
            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onComplete() {

            }
        }, 1, false);

    }

    public void OnClick() {
        lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
               // Toast.makeText(ClassificationFragment.this,"position= " +position+ "__索引id= " + id+"分类id="+booklist_depth1.get(position).getCat_id(), Toast.LENGTH_SHORT).show();
                adapter.setCurPositon(position);
                adapter.notifyDataSetChanged();
                lv_left.smoothScrollToPositionFromTop(position,(adapterView.getHeight()-view.getHeight())/2);//平滑滚动到制定位置并偏移顶部多少距离
                Log.e("lry",adapterView.getHeight()+""+view.getHeight());

                int fvindex = lv_left.getFirstVisiblePosition();//获得第一个可见view的位置
                for (int i = 0 + fvindex; i < adapterView.getCount(); i++) {
                    View v = lv_left.getChildAt(i - fvindex);
                    Log.d("TAG", "onItemClick:  " + v);
                }
                int oneID = booklist_depth1.get(position).getCatId();
                bind2(oneID);

            }

        });
        //一级绑定结束.默认绑定第一个
        if (booklist_depth1 != null && booklist_depth1.size() > 0) {
            Log.d("lry","默认绑定");
            int oneID = booklist_depth1.get(0).getCatId();
            bind2(oneID);
        }

    }
    //绑定二级
    private void bind2(int cid) {
        //获取二级分类数据
        List<HetiFenlei> hetiFenleiList=new ArrayList<>();
        for (int i = 0; i < mItemList_all.size(); i++) {
            if (mItemList_all.get(i).getParentId() == cid) {
                HetiFenlei hetiFenlei = new HetiFenlei();
                Fenlei fenlei = new Fenlei();
                fenlei.setCatId(mItemList_all.get(i).getCatId());
                fenlei.setParentId(mItemList_all.get(i).getParentId());
                fenlei.setCatName(mItemList_all.get(i).getCatName());
                hetiFenlei.setFenlei(fenlei);
                //获取三级分类数据
                List<Fenlei> list_grade3 = new ArrayList<>();
                for (int j = 0; j < mItemList_all.size(); j++) {
                    if (mItemList_all.get(j).getParentId() == fenlei.getCatId()) {
                        Fenlei fenlei3 = new Fenlei();
                        fenlei3.setCatId(mItemList_all.get(j).getCatId());
                        fenlei3.setParentId(mItemList_all.get(j).getParentId());
                        fenlei3.setCatName(mItemList_all.get(j).getCatName());
                        list_grade3.add(fenlei3);
                    }
                    hetiFenlei.setFenleiList(list_grade3);
                }
                Log.d("lry", "获取到的三级分类的数据数量是"+list_grade3.size());
                hetiFenleiList.add(hetiFenlei);
            }

        }
        //绑定三级
        adapter23 = new TypeOfGoodsNameAdapter23(getActivity(), hetiFenleiList);
        lv_right.setAdapter(adapter23);
        adapter.notifyDataSetChanged();

    }



}

