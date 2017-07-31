package com.sxjs.jd.composition.main.shopcar;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.bean.ShopCar;
import com.sxjs.common.model.sp.SharePreferenceHelper;
import com.sxjs.jd.R;

import java.util.ArrayList;
import java.util.List;


public class ShopCart1Adapter extends RecyclerView.Adapter<ShopCart1Adapter.MyViewHolder>  {


    private Context context;
    private String TAG = "newubru";
    private List<ShopCar.ItemsBean> datas = new ArrayList<>();
    private OnDeleteClickListener mOnDeleteClickListener;
    private OnEditClickListener mOnEditClickListener;
    private OnEditClickListenerjian mOnEditClickListenerjian;
    private OnResfreshListener mOnResfreshListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private OnItemClickListener mOnItemClickListener;


    public ShopCart1Adapter(Context context,List<ShopCar.ItemsBean> datas) {
        Log.d(TAG, "ShopCart1Adapter");
        this.datas = datas;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.carrecycle_item_type_choice,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final  MyViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder----index="+position);
        holder.tvShopCartClothName.setText(datas.get(0).getItemList().get(position).getGoodsName());
        holder.tvShopCartClothPrice.setText(datas.get(0).getItemList().get(position).getGoodsPrice()+"");
        holder.etShopCartClothNum.setText(datas.get(0).getItemList().get(position).getGoodsNumber()+"");
        holder.ivShopCartClothPic.setImageURI(Uri.parse("http://"+Uri.parse(datas.get(0).getItemList().get(position).getGoodsImg())));
       if(datas.get(0).getItemList().get(position).getGoodsAttr().equals("")){

       }
       else{
           holder.tvShopCartClothSize.setText("属性："+datas.get(0).getItemList().get(position).getGoodsAttr());
       }


        //长按删除
        if(mOnItemLongClickListener != null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = holder.getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(holder.itemView,position);
                    //返回true 表示消耗了事件 事件不会继续传递
                    return true;
                }
            });
        }

        //是否刷新
        if(mOnResfreshListener != null){
            boolean isSelect = false;
            for(int i = 0;i < datas.get(0).getItemList().size(); i++){
                if(!datas.get(0).getItemList().get(i).getIsSelect()){
                    isSelect = false;
                    break;
                }else{
                    isSelect = true;
                }
            }
            mOnResfreshListener.onResfresh(isSelect);
        }

        //为加商品设置监控器
        holder.ivShopCartClothAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"jian",Toast.LENGTH_SHORT).show();
                    int count = datas.get(0).getItemList().get(position).getGoodsNumber() + 1;
                    if (mOnEditClickListener != null){
                        mOnEditClickListener.onEditClick(position, datas.get(0).getItemList().get(position).getGoodsId(), count);
                    }
        }
        });

        //为减商品设置监控器
        holder.ivShopCartClothMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"jia",Toast.LENGTH_SHORT).show();
                if(datas.get(0).getItemList().get(position).getGoodsNumber() > 1){
                    int count = datas.get(0).getItemList().get(position).getGoodsNumber() - 1;
                    if (mOnEditClickListenerjian != null){
                        mOnEditClickListenerjian.onEditClickjian(position, datas.get(0).getItemList().get(position).getGoodsId(), count);
                    }
                    else {
                    }
                }

            }
        });

        //如果商品被选择设置选中图案
        if(datas.get(0).getItemList().get(position).getIsSelect()){
            holder.IsSelect.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_selected));
        }else {
            holder.IsSelect.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_unselected));
        }

        //为店选择框添加点击事件
        holder.IsSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    datas.get(0).getItemList().get(position).setSelect(!datas.get(0).getItemList().get(position).getIsSelect());
                    notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.get(0).getItemList().size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvShopCartClothName;
        public TextView tvShopCartClothPrice;
        public TextView etShopCartClothNum;
        public ImageView ivShopCartClothPic;
        public ImageView IsSelect;
        public TextView tvShopCartClothSize;
        public Button ivShopCartClothMinus;
        public Button ivShopCartClothAdd;
        public MyViewHolder(View itemView) {
            super(itemView);
            Log.d(ContentValues.TAG, "MyViewHolder");
            tvShopCartClothName = (TextView) itemView.findViewById(R.id.tvItemChild);//商品名
            tvShopCartClothPrice = (TextView) itemView.findViewById(R.id.tvPriceNew);//价格
            etShopCartClothNum = (TextView) itemView.findViewById(R.id.tvNum2);//数量
            ivShopCartClothMinus = (Button) itemView.findViewById(R.id.ivReduce);//商品加
            ivShopCartClothAdd = (Button) itemView.findViewById(R.id.ivAdd);//商品减
            ivShopCartClothPic = (ImageView) itemView.findViewById(R.id.ivGoods);//商品图片
            IsSelect=(ImageView)itemView.findViewById(R.id.ivCheckGood);
            tvShopCartClothSize = (TextView) itemView.findViewById(R.id.size);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnDeleteClickListener{
        void onDeleteClick(View view, int position, int cartid);
    }

    public void setOnDeleteClickListener(OnDeleteClickListener mOnDeleteClickListener){
        this.mOnDeleteClickListener = mOnDeleteClickListener;
    }

    public interface OnEditClickListener{
        void onEditClick(int position, int cartid, int count);
    }

    public void setOnEditClickListener(OnEditClickListener mOnEditClickListener){
        this.mOnEditClickListener = mOnEditClickListener;
    }
    public interface OnEditClickListenerjian{
        void onEditClickjian(int position, int cartid, int count);
    }

    public void setOnEditClickListenerjian(OnEditClickListenerjian mOnEditClickListenerjian){
        this.mOnEditClickListenerjian = mOnEditClickListenerjian;
    }
    public interface OnResfreshListener{
        void onResfresh(boolean isSelect);
    }

    public void setResfreshListener(OnResfreshListener mOnResfreshListener){
        this.mOnResfreshListener = mOnResfreshListener;
    }

    public interface OnItemLongClickListener{
        void onItemLongClick(View view, int position);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

}
