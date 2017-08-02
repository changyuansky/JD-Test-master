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
import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.base.BaseActivity;
import com.sxjs.common.bean.UserInfo;
import com.sxjs.common.model.DataManager;
import com.sxjs.common.model.dao.DataBaseHelper;
import com.sxjs.common.model.http.HttpHelper;
import com.sxjs.common.model.sp.SharePreferenceHelper;
import com.sxjs.jd.R;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.observers.DisposableObserver;

@Route(path = "/test/findpwdActivity")
public class FindpwdActivity extends BaseActivity {
    private EditText findNumber;
    private EditText findCode;
    private EditText findPwd;
    private Button codeBtn;
    private Button completeBtn;
    final String TAG="code";
    private DataManager dataManager;
    private String number;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findpwd_activity);
        Context context=getApplication().getApplicationContext();
        findCode=(EditText)findViewById(R.id.findpwd_input_code_et);
        findNumber=(EditText)findViewById(R.id.iphone_findpwd);

        findPwd=(EditText)findViewById(R.id.new_password);
        codeBtn=(Button)findViewById(R.id.findpwd_code_btn);
        completeBtn=(Button)findViewById(R.id.complete_btn);
        final DataManager dataManager = GlobalAppComponent.getAppComponent().getDataManager();
        codeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick");
                if(isvalidate()){
                    dataManager.getVcode(new DisposableObserver<UserInfo>() {
                        @Override
                        public void onNext(UserInfo userInfo) {
                            //serverCode=userInfo.msg;
                            if(userInfo.code.equals("1")){
                                Toast.makeText(FindpwdActivity.this,"该用户已存在",Toast.LENGTH_SHORT).show();

                            }/*else if(userInfo.code.equals("-1")) {
                                Toast.makeText(RegisterActivity.this,"电话号码有误",Toast.LENGTH_SHORT).show();
                            }*/
                            else if(userInfo.code.equals("False")) {
                                Toast.makeText(FindpwdActivity.this,"发送验证码失败",Toast.LENGTH_SHORT).show();
                            }
                            else if (userInfo.code.equals("Ok")){
                                //ti'jiao
                                final MyCountDownTimer myCountDownTimer=new MyCountDownTimer(codeBtn,60000,1000);
                                Log.d(TAG,"myCountDownTimer");
                                myCountDownTimer.start();
                                Log.d(TAG,"start");
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            Toast.makeText(FindpwdActivity.this,"onError",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onComplete() {

                        }
                    },number);
                }
            }
        });

    }
    private boolean isvalidate(){
        Log.d(TAG,"isvalidate");
        number=findNumber.getText().toString().trim();
        Log.d(TAG,number);
        if(findNumber.equals("")){
            Toast.makeText(FindpwdActivity.this,"手机号不能为空",Toast.LENGTH_SHORT).show();
            return false;
        }else if (!isPhoneNumberValid(number) ){
            Toast.makeText(FindpwdActivity.this,"手机号不正确",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    public static boolean isPhoneNumberValid(String phoneNumber) {
        boolean isValid = false;
        String expression = "((^(13|15|18)[0-9 ]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches() ) {
            isValid = true;
        }
        return isValid;
    }

}
