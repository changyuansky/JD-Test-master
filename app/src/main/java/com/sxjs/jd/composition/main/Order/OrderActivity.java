package com.sxjs.jd.composition.main.Order;

import android.support.annotation.IdRes;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
//import com.example.administrator.order.dfhfragment.DfhAdapter;
//import com.example.administrator.order.dfhfragment.DfhFragment;
//import com.example.administrator.order.dfkfragment.DfkFragment;
//import com.example.administrator.order.dshfragment.DshFragment;
//import com.example.administrator.order.qbfragment.QbFragment;
//import com.example.administrator.order.yqxfragment.YqxFragment;
//import com.example.administrator.order.ywcfragment.YwcFragment;
import com.sxjs.common.base.BaseActivity;
import com.sxjs.jd.R;
import com.sxjs.jd.composition.main.Order.dfhfragment.DfhFragment;
import com.sxjs.jd.composition.main.Order.dfkfragment.DfkFragment;
import com.sxjs.jd.composition.main.Order.dshfragment.DshFragment;
import com.sxjs.jd.composition.main.Order.qbfragment.QbFragment;
import com.sxjs.jd.composition.main.Order.yqxfragment.YqxFragment;
import com.sxjs.jd.composition.main.Order.ywcfragment.YwcFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/order/OrderActivity")
public class OrderActivity extends BaseActivity {


    @BindView(R.id.r_qb)
    RadioButton r_qb;
    @BindView(R.id.R1)
    RadioGroup RG;
    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    private QbFragment qbFragment;
    private DfkFragment dfkFragment;
    private DfhFragment dfhFragment;
    private DshFragment dshFragment;
    private YwcFragment ywcFragment;
    private YqxFragment yqxFragment;
    private FragmentManager mFragmentManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        mFragmentManager = getSupportFragmentManager();
        unbinder =ButterKnife.bind(this);
        initView();
        swithbutton();



    }
    public void initView(){

        qbFragment=(QbFragment)mFragmentManager.findFragmentByTag("qb_fg");
        dfkFragment=(DfkFragment)mFragmentManager.findFragmentByTag("dfk_fg");
        dshFragment=(DshFragment)mFragmentManager.findFragmentByTag("dsh_fg");
        ywcFragment=(YwcFragment)mFragmentManager.findFragmentByTag("ywc_fg");
        yqxFragment=(YqxFragment)mFragmentManager.findFragmentByTag("yqc_fg");
        dfhFragment=(DfhFragment)mFragmentManager.findFragmentByTag("dfh_fg");
        if(qbFragment==null){
            qbFragment=QbFragment.newInstance();
            addFragment(R.id.main_container,qbFragment,"qb_fg");
        }
        if(dfkFragment==null){
            dfkFragment=DfkFragment.newInstance();
            addFragment(R.id.main_container,dfkFragment,"dfk_fg");
        }
        if (dshFragment==null){
          dshFragment=DshFragment.newInstance();
            addFragment(R.id.main_container,dshFragment,"dsh_fg");
        }
        if(ywcFragment==null){
            ywcFragment=YwcFragment.newInstance();
            addFragment(R.id.main_container,ywcFragment,"ywc_fg");

        }
        if(yqxFragment==null){
            yqxFragment= YqxFragment.newInstance();
            addFragment(R.id.main_container,yqxFragment,"yqc_fg");
        }
        if(dfhFragment==null){
            dfhFragment=DfhFragment.newInstance();
            addFragment(R.id.main_container,dfhFragment,"dfh_fg");
        }
//        mFragmentManager.beginTransaction().show(qbFragment).hide(dfkFragment).hide(dshFragment).hide(yqcFragment).hide(ywcFragment)
//           .commitAllowingStateLoss();

    }
    public void swithbutton(){
        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(i==R.id.r_qb){
                    mFragmentManager.beginTransaction().show(qbFragment).hide(dfkFragment).hide(dshFragment).hide(yqxFragment).hide(ywcFragment).hide(dfhFragment)
                            .commitAllowingStateLoss();

                }
                if(i==R.id.r_dfk){
                    mFragmentManager.beginTransaction().show(dfkFragment).hide(qbFragment).hide(dshFragment).hide(yqxFragment).hide(ywcFragment).hide(dfhFragment)
                            .commitAllowingStateLoss();

                }
                if(i==R.id.r_dsh){
                    mFragmentManager.beginTransaction().show(dshFragment).hide(dfkFragment).hide(qbFragment).hide(yqxFragment).hide(ywcFragment).hide(dfhFragment)
                            .commitAllowingStateLoss();

                }
                if (i==R.id.r_ywc){
                    mFragmentManager.beginTransaction().show(ywcFragment).hide(dfkFragment).hide(dshFragment).hide(yqxFragment).hide(qbFragment).hide(dfhFragment)
                            .commitAllowingStateLoss();

                }
                if(i==R.id.r_yqx){
                    mFragmentManager.beginTransaction().show(yqxFragment).hide(dfkFragment).hide(dshFragment).hide(qbFragment).hide(ywcFragment).hide(dfhFragment)
                            .commitAllowingStateLoss();
                }
                if(i==R.id.r_dfh){
                    mFragmentManager.beginTransaction().show(dfhFragment).hide(dfkFragment).hide(dshFragment).hide(qbFragment).hide(ywcFragment).hide(yqxFragment)
                            .commitAllowingStateLoss();
                }
            }
        });
        r_qb.setChecked(true);
    }

    @OnClick({R.id.back_img, R.id.search_img, R.id.notice_img})
    public void imagclick(ImageView image) {
        switch (image.getId()) {
            case R.id.back_img:
                Toast.makeText(this, "你按到了back_img", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_img:
                Toast.makeText(this, "你按到了search_img", Toast.LENGTH_SHORT).show();
                break;
            case R.id.notice_img:
                Toast.makeText(this, "你按到了notice_img", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
