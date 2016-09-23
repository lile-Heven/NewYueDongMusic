package com.ll.ydmusic.mlistener;

import com.imooc.weixin6_0.R;

import android.view.View;
import android.view.View.OnClickListener;

public class FragmentMeOnClickListener implements OnClickListener{

	public FragmentMeOnClickListener() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.iv_my_edit:
			//点击此图标后，跳出一个DialogFragment，里面GridView来选头像
			
			
			
			break;

		default:
			break;
		}
	}

}
