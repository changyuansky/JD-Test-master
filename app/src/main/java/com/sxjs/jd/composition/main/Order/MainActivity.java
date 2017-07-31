package com.sxjs.jd.composition.main.Order;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

import com.google.gson.Gson;
import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.bean.MyOrderInfo;
import com.sxjs.common.bean.OrdergoodsInfo;
import com.sxjs.common.model.DataManager;
import com.sxjs.jd.R;
import com.sxjs.jd.composition.main.Order.adapters.MyorderInfoAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.observers.DisposableObserver;

@Route(path = "/test/1")
public class MainActivity extends AppCompatActivity{
    @BindView(R.id.del) Button btn_del;
@BindView(R.id.rebuy) Button btn_rebuy;
    @BindView(R.id.apply) Button btn_apply;
    @BindView(R.id.copy) TextView tv_copy;
    @BindView(R.id.left) ImageView iv_left;
    @BindView(R.id.enter) ImageView iv_enter;
    ImageView phone;
    RecyclerView mRecyclerView;
    MyorderInfoAdapter mAdapter;
    TextView orderStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
        Log.d("aa","setContentView");
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager mlayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mlayoutManager);
        String d=getIntent().getStringExtra("details");
        Gson gson=new Gson();
        Detail detail=gson.fromJson(d,Detail.class);
        Log.d("aa",detail.getInfos().getSupplierName());
        initView(detail.getInfos());
        Log.d("aa",";;;;"+detail.getInfos().getSupplierName());
        mAdapter=new MyorderInfoAdapter(MainActivity.this,detail.getGoodslist());
        mRecyclerView.setAdapter(mAdapter);
    }
    public void initView(MyOrderInfo.ItemsBean.ItemListBean.OrderInfosBean orderInfosBean){
        Log.d("aa","initView");
        Log.d("aa","initView"+orderInfosBean.getShippingTime());
        orderStatus=(TextView)findViewById(R.id.orderstatus);
        //待发货
        if(orderInfosBean.getOrderStatus()==1&&orderInfosBean.getShippingStatus()==0&&orderInfosBean.getPayStatus()==2){
            orderStatus.setText("待发货");
           btn_del.setVisibility(View.VISIBLE);btn_del.setText("取消订单");
           btn_apply.setVisibility(View.INVISIBLE);btn_rebuy.setVisibility(View.INVISIBLE);
            btn_del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,"取消订单",Toast.LENGTH_SHORT).show();
                }
            });
        }
        //待付款--195
        if(orderInfosBean.getOrderStatus()==1&&orderInfosBean.getShippingStatus()==0&&orderInfosBean.getPayStatus()==0)  {
            orderStatus.setText("待付款");
            btn_apply.setVisibility(View.INVISIBLE);
            Log.d("aa","text;;;"+orderStatus);
            btn_del.setVisibility(View.VISIBLE);btn_del.setText("取消订单");
            btn_rebuy.setVisibility(View.VISIBLE);  btn_rebuy.setText("去支付");
            btn_del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,"取消订单",Toast.LENGTH_SHORT).show();
                }
            });
            btn_rebuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,"去支付",Toast.LENGTH_SHORT).show();
                }
            });
        }
        //待收货--192
        if(orderInfosBean.getOrderStatus()==1&&orderInfosBean.getShippingStatus()==1&&orderInfosBean.getPayStatus()==2){
            orderStatus.setText("待收货");   btn_apply.setVisibility(View.INVISIBLE);btn_del.setVisibility(View.INVISIBLE);
            Log.d("aa","text;;;"+orderStatus);
            btn_rebuy.setVisibility(View.VISIBLE);  btn_rebuy.setText("确认收货");
            btn_rebuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,"确认收货",Toast.LENGTH_SHORT).show();
                }
            });
        }
        //已取消--187
        if(orderInfosBean.getOrderStatus()==2&&orderInfosBean.getShippingStatus()==0&&orderInfosBean.getPayStatus()==0){
            orderStatus.setText("已取消");
           btn_apply.setVisibility(View.INVISIBLE);
          btn_del.setVisibility(View.VISIBLE);btn_del.setText("删除订单");
       btn_rebuy.setVisibility(View.VISIBLE);  btn_rebuy.setText("再次购买");
         btn_rebuy.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
              Toast.makeText(MainActivity.this,"再次购买",Toast.LENGTH_SHORT).show();
               }
           });
        }
        //已完成--184
        if(orderInfosBean.getOrderStatus()==1&&orderInfosBean.getShippingStatus()==2&&orderInfosBean.getPayStatus()==2){
            orderStatus.setText("已完成");
            btn_del.setVisibility(View.VISIBLE);btn_del.setText("删除订单");
            btn_apply.setVisibility(View.VISIBLE);btn_apply.setText("申请售后");
            btn_rebuy.setVisibility(View.VISIBLE);  btn_rebuy.setText("再次购买");
          btn_del.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Toast.makeText(MainActivity.this,"删除订单",Toast.LENGTH_SHORT).show();
              }
          });
            btn_apply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,"申请售后",Toast.LENGTH_SHORT).show();
                }
            });
            btn_rebuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,"再次购买",Toast.LENGTH_SHORT).show();
                }
            });
        }
        phone = (ImageView)findViewById(R.id.phone);
       TextView consignee=(TextView)findViewById(R.id.name);
        Log.d("aa","initview"+consignee);
        TextView mobile=(TextView)findViewById(R.id.mobile);
      TextView country=(TextView)findViewById(R.id.country) ;
        TextView province=(TextView)findViewById(R.id.province);
        TextView city=(TextView)findViewById(R.id.city);
        TextView district=(TextView)findViewById(R.id.district);
        TextView order_sn=(TextView)findViewById(R.id.orderhao);
        TextView pay_time=(TextView)findViewById(R.id.paytime);
        TextView shiping_time=(TextView)findViewById(R.id.paydate);
        TextView pay_name=(TextView)findViewById(R.id.paymode);
        TextView supplier_name=(TextView)findViewById(R.id.shop);
       TextView paysum=(TextView)findViewById(R.id.paysum);
        TextView goods_sum=(TextView)findViewById(R.id.goodsum);
        consignee.setText(orderInfosBean.getConsignee());
        mobile.setText(orderInfosBean.getMobile());
        Log.d("aa","initview"+orderInfosBean.getCountry());
        country.setText(orderInfosBean.getCountry()+" ");

        province.setText(orderInfosBean.getProvince()+"省2");
        city.setText(orderInfosBean.getCity()+" ");
        district.setText(orderInfosBean.getDistrict()+"");
        order_sn.setText("订单编号："+orderInfosBean.getOrderSn());
        pay_time.setText("下单时间："+orderInfosBean.getPayTime()+"");
        shiping_time.setText("配送日期："+orderInfosBean.getShippingTime()+"");
        pay_name.setText("支付方式："+orderInfosBean.getPayName());
        supplier_name.setText(orderInfosBean.getSupplierName());
        goods_sum.setText("￥："+orderInfosBean.getGoodsAmount()+"");
       paysum.setText("实付款￥："+orderInfosBean.getOrderAmount()+"");
        Log.d("aa","initview;;"+orderInfosBean.getOrderAmount()+"");
      phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "联系卖家", Toast.LENGTH_SHORT).show();
            }
        });
    }
@OnClick({R.id.left,R.id.enter,R.id.copy,})
    public void onClick(View view){
    switch (view.getId()){
        case R.id.left:
            iv_left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity.this,OrderActivity.class);
                    startActivity(intent);
                }
            });break;
           // Toast.makeText(this,"后退一页",Toast.LENGTH_SHORT).show();
        case R.id.enter:Toast.makeText(this,"进入店铺",Toast.LENGTH_SHORT).show();break;
        case R.id.copy:Toast.makeText(this,"复制编号",Toast.LENGTH_SHORT).show();break;
    }

    }
}
