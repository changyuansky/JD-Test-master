package com.sxjs.jd.composition.main.regist_login_ylj;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.base.BaseActivity;
import com.sxjs.common.bean.UserInfo;
import com.sxjs.common.model.DataManager;
import com.sxjs.jd.R;

import io.reactivex.observers.DisposableObserver;
@Route(path = "/test/orderactivity_ylj")
public class OrderActivity extends BaseActivity {
    private EditText mAccount;
    private EditText mPwd;
    private Button mLoginBtn;
    private TextView ipLogin;
    private TextView findPwd;
    private TextView qqLogin;
    private SharedPreferences sp;
  /*  private String userNameValue,passwordValue;
    private View loginView;                           //登录
    private View loginSuccessView;
    private TextView loginSuccessShow;
    private TextView mChangepwdText;*/
    private DataManager dataManager;
    private User user;

    private String TAG = "newubru";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_ylj);
        Log.d(TAG,"isvalidate");
        ARouter.init(getApplication());
        Context context=getApplication().getApplicationContext();
        dataManager = GlobalAppComponent.getAppComponent().getDataManager();
        mAccount=(EditText) findViewById(R.id.login_input_name);
        mPwd=(EditText)findViewById(R.id.login_input_passwd);
        mLoginBtn=(Button)findViewById(R.id.login_btn);
        ipLogin=(TextView)findViewById(R.id.iphone_register);
        findPwd=(TextView)findViewById(R.id.find_pwd);
        qqLogin=(TextView)findViewById(R.id.login_qq);
        sp=getSharedPreferences("userInfor",0);
        String name=sp.getString("USER_NAME","");
        String pwd=sp.getString("PASSWORD","");
        View.OnClickListener clickListener=new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.iphone_register:
                        ARouter.getInstance().build("/test/registerActivity").navigation();
                        break;
                    case R.id.login_btn:
                        login();
                        break;
                    case R.id.find_pwd:
                        ARouter.getInstance().build("/test/findpwdActivity").navigation();
                        break;
                    case R.id.login_qq:
                        loginQQ();
                        break;
                }
            }
        };
        mLoginBtn.setOnClickListener(clickListener);
        findPwd.setOnClickListener(clickListener);
        ipLogin.setOnClickListener(clickListener);
        qqLogin.setOnClickListener(clickListener);

    }
    public void login(){
        if (isUserNameAndPwdValid()){
            final String username=mAccount.getText().toString().trim();
            final String userpwd=mPwd.getText().toString().trim();

            user=new User(username,userpwd);
            Log.d(username,userpwd);
          /*  JSONObject object=new JSONObject();
            try {
                object.put("Name",username);
                object.put("Name",userpwd);
            } catch (JSONException e) {
                e.printStackTrace();
            }*/
            dataManager.getLoginUserInfo(new DisposableObserver<UserInfo>() {

                @Override
                public void onNext(UserInfo userInfo) {
                    Log.d("111","222");
                    if(userInfo.getCode().equals("200")){
                        //ARouter.getInstance().build("主页路由路径").navigation();
                    }
                    else{
                        Toast.makeText(OrderActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onError(Throwable e) {
                    Toast.makeText(OrderActivity.this,"on Error",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onComplete() {

                }
            },user);
            /*SharedPreferences.Editor editor=sp.edit();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        URL url = new URL("http://10.10.140.231:81/shop/loginController/login");
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        //设置请求方式
                        httpURLConnection.setRequestMethod("POST");
                        // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
                        // http正文内，因此需要设为true, 默认情况下是false;
                        httpURLConnection.setDoOutput(true);
                        // 设置是否从httpUrlConnection读入，默认情况下是true;
                        httpURLConnection.setDoInput(true);
                        // Post 请求不能使用缓存
                        httpURLConnection.setUseCaches(false);
                        // 设置请求的超时时间
                        httpURLConnection.setReadTimeout(5000);
                        httpURLConnection.setConnectTimeout(5000);

                        httpURLConnection.setRequestProperty("Content-type", "application/json;charset=utf-8");
                        httpURLConnection.connect();

                        //POST请求
                        OutputStream out = httpURLConnection.getOutputStream();
                       JSONObject obj = new JSONObject();
                        obj.put("user_account", username);
                        obj.put("user_password", userpwd);
                       Log.v("TAG", obj.toString());

                        httpURLConnection.disconnect();

                        //接收完毕

                        Message msg = Message.obtain();
                        msg.obj = obj;
                        msg.what = 1;
                        // 发送这个消息到消息队列中
                        handler.sendMessage(msg);

                    } catch (Exception e) {
                        Log.getStackTraceString(e);
                    }
                }
            }).start();*/

        }
    }
    public boolean isUserNameAndPwdValid() {
        if (mAccount.getText().toString().trim().length()<1) {
            Toast.makeText(this, "帐号不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mPwd.getText().toString().trim().equals("")) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


    public void loginQQ(){

    }


    }

