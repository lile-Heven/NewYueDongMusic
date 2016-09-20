package com.ll.ydmusic.a.login_regist;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;
import cn.bmob.v3.Bmob;

import com.imooc.weixin6_0.R;
import com.ll.ydmusic.a.login_regist.fragment.LoginFragment;

public class LoginRegistActivity extends Activity{
	
		private LoginFragment loginFragment;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			setContentView(R.layout.login);
			
			
			init_login_fragment();
			init();
			
			// 按照文档说明，已经在applicaiton那里初始化了，这里就不用初始化Bmob
			init_Bmob();
			
		}
		private void init_Bmob() {
			// TODO 自动生成的方法存根
			Bmob.initialize(this, "fe34202afa27d99a5476437a0aebe037");

		}

		private void init_login_fragment() {
			 loginFragment = new LoginFragment(); 
		}

		private void init() {
			FragmentManager fragmentManager=getFragmentManager();
			FragmentTransaction transcation = fragmentManager.beginTransaction();
			transcation.add(R.id.fl_login, loginFragment);
			transcation.commit();
		}
		
}
