package com.sxjs.jd.composition.main.regist_login_ylj;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sxjs.common.GlobalAppComponent;
import com.sxjs.common.bean.UserInfo;
import com.sxjs.common.model.DataManager;

import com.sxjs.jd.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.observers.DisposableObserver;

@Route(path = "/test/registerActivity")
public class RegisterActivity extends AppCompatActivity {
    private EditText ipRegister;
    private EditText pwdRegister;
    private EditText code;
    private Button codeBtn;
    private Button registerBtn;
    private String userName;
    private String password;
    private String userCode;
    final String TAG="code";
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        ARouter.init(getApplication());
        ipRegister = (EditText) findViewById(R.id.login_input_phone_et);
        pwdRegister = (EditText) findViewById(R.id.login_input_phone_pwd);
        /*pwdRegister = (EditText) findViewById(R.id.one);*/
        code = (EditText) findViewById(R.id.login_input_code_et);
        codeBtn = (Button) findViewById(R.id.login_request_code_btn);
        registerBtn = (Button) findViewById(R.id.login_commit_btn);
        Context context = getApplication().getApplicationContext();
        final DataManager dataManager = GlobalAppComponent.getAppComponent().getDataManager();

        //获取验证码
        codeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick");
                if(isvalidate()){
                    dataManager.getVcode(new DisposableObserver<UserInfo>() {
                        @Override
                        public void onNext(UserInfo userInfo) {
                          //  serverCode=userInfo.msg;
                            if(userInfo.getCode().equals("1")){
                                Toast.makeText(RegisterActivity.this,"该用户已存在",Toast.LENGTH_SHORT).show();

                            }/*else if(userInfo.code.equals("-1")) {
                                Toast.makeText(RegisterActivity.this,"电话号码有误",Toast.LENGTH_SHORT).show();
                            }*/
                            else if(userInfo.getCode().equals("False")) {
                                Toast.makeText  (RegisterActivity.this,"发送验证码失败",Toast.LENGTH_SHORT).show();
                            }
                            else if (userInfo.getCode().equals("Ok")){
                                //ti'jiao
                                final MyCountDownTimer myCountDownTimer=new MyCountDownTimer(codeBtn,60000,1000);
                                Log.d(TAG,"myCountDownTimer");
                                myCountDownTimer.start();
                                Log.d(TAG,"start");
                            }
                             }

                        @Override
                        public void onError(Throwable e) {
                            Toast.makeText(RegisterActivity.this,"onError",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onComplete() {
                            Toast.makeText(RegisterActivity.this,"onComplete",Toast.LENGTH_SHORT).show();

                        }
                    },userName);
                }
            }
        });

        //注册
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName=ipRegister.getText().toString().trim();
                userCode=code.getText().toString().trim();
                password=pwdRegister.getText().toString().trim();
                user=new User(userName,password,userCode);
                 dataManager.getRegistUserInfo(new DisposableObserver<UserInfo>(){
                    @Override
                    public void onNext(UserInfo userInfo) {
                        //拿到数据userinfo
                        if(userInfo.getCode().equals("200")){
                            ARouter.getInstance().build("/test/activity2").navigation();

                        }

                        else {
                            Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                },user);
            }
        });


    }
    //手机号的判断
    private boolean isvalidate(){
        Log.d(TAG,"isvalidate");
        userName=ipRegister.getText().toString().trim();
        Log.d(TAG,userName);
        if(userName.equals("")){
            Toast.makeText(RegisterActivity.this,"手机号不能为空",Toast.LENGTH_SHORT).show();
            return false;
        }else if (!isPhoneNumberValid(userName) ){
            Toast.makeText(RegisterActivity.this,"手机号不正确",Toast.LENGTH_SHORT).show();
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
