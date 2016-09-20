package com.ll.ydmusic.a.login_regist.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import com.imooc.weixin6_0.R;
import com.ll.ydmusic.a.login_regist.bmob.MyUserMoreDetails;

public class RegistFragment extends Fragment implements OnClickListener {

	private EditText regist_et_phone; //手机号码
	private EditText regist_et_yzm;//验证码
	private EditText regist_et_nickname;//昵称
	private EditText regist_et_password;//密码
	private EditText regist_et_true_name;//真名
	private EditText regist_et_identity_card;//身份证
	private EditText regist_et_email;//邮箱
	private Button regist_bt_regist;//注册按钮

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("tag", "oncreate_RegistFragment");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("tag", "oncreateView_RegistFragment");

		View view1 = inflater.inflate(R.layout.fragment_regist, null);
		
		init_attach_view2object(view1);
		
		init_add_listeners();
		
		return view1;
	}

	private void init_add_listeners() {
		// TODO 自动生成的方法存根
		
		regist_bt_regist.setOnClickListener(this);
	}

	private void init_attach_view2object(View view1) {
		// TODO 自动生成的方法存根
		
		//关联EditText
		regist_et_phone=(EditText) view1.findViewById(R.id.regist_et_phone);
		regist_et_yzm=(EditText) view1.findViewById(R.id.regist_et_yzm);
		regist_et_nickname=(EditText) view1.findViewById(R.id.regist_et_nickname);
		regist_et_password=(EditText) view1.findViewById(R.id.regist_et_password);
		regist_et_true_name=(EditText) view1.findViewById(R.id.regist_et_true_name);
		regist_et_identity_card=(EditText) view1.findViewById(R.id.regist_et_identity_card);
		regist_et_email=(EditText) view1.findViewById(R.id.regist_et_email);
		
		//关联Button
		regist_bt_regist=(Button) view1.findViewById(R.id.regist_bt_regist);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		Log.d("tag", "onViewcreate_RegistFragment");
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.regist_bt_regist:
		
			//检查与添加
			check_phone_isExisted();
			
			break;

		default:
			break;
		}

	}

	/**
	 * 
	 */
	private void add_one_new_data() {
		final String str_phone=regist_et_phone.getEditableText().toString();
		String str_yzm=regist_et_yzm.getEditableText().toString();
		String str_nickName=regist_et_nickname.getEditableText().toString();
		String str_password=regist_et_password.getEditableText().toString();
		String str_trueName=regist_et_true_name.getEditableText().toString();
		String str_identityCard=regist_et_identity_card.getEditableText().toString();
		String str_email=regist_et_email.getEditableText().toString();
		
		//  |位运算符      ||或
		if(str_phone.equals("")||str_password.equals("")){
			Toast.makeText(getActivity(), "账户(手机密码)或密码为空，注册失败", Toast.LENGTH_LONG).show();
			return;
		}
		//先过滤一下，看看此手机号码是否已经注册过。
		/*if(check_phone_isExisted())
		{
			Toast.makeText(getActivity(), "很抱歉，此账号已经存在。", Toast.LENGTH_LONG).show();
			return ;
		}	*/		
		
		
		final MyUserMoreDetails myUserMoreDetails=
				new MyUserMoreDetails(str_password, str_nickName, str_phone,
						str_email, str_identityCard, str_trueName);
		
		myUserMoreDetails.save(getActivity(), new SaveListener() {
			
			

			
			@Override
			public void onFailure(int arg0, String arg1) {
				//注册失败
	        	Toast.makeText(getActivity(),"由于系统繁忙，注册失败，请稍候重试", Toast.LENGTH_LONG).show();
	            //toast("创建数据失败：" + e.getMessage());
	        
			}

			@Override
			public void onSuccess() {
				//注册成功
				 
				 Toast.makeText(getActivity(), "欢迎进入悦动的世界。请记住您的账户："+str_phone, Toast.LENGTH_LONG).show();
		            //toast("添加数据成功，返回objectId为："+objectId);
				 
				//把数据持久化到SQLite里面。
				data_persistence(myUserMoreDetails);
					
				 //关闭此fragment
				 close_RegistFragment();
		
			}
			
			/**
			 * 当注册页面的数据成功 提交到服务器以后，把数据持久化到本地。（SQLite）
			 * @param myUserMoreDetails
			 */
			private void data_persistence(MyUserMoreDetails myUserMoreDetails) {
				// TODO 自动生成的方法存根
				
				
				
			}

			private void close_RegistFragment() {
				// TODO 自动生成的方法存根
				Fragment frag = getActivity().getFragmentManager().findFragmentByTag("RegistFragment");
				
				getActivity().getFragmentManager().beginTransaction().remove(frag).commit();
				
				try {
					((EditText)(getActivity().findViewById(R.id.et_login_phone))).setText(str_phone);
					//((EditText)(getActivity().findViewById(R.id.et_login_password))).findFocus();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

		});
		
		
		
	}


	private void check_phone_isExisted() {
		
//		final ArrayList<Boolean> container=new ArrayList<Boolean>();
//		container.add(false);
//		Log.v("TAG0add", container.get(0).toString());
		// boolean isExisted = false;
		
		BmobQuery<MyUserMoreDetails> query = new BmobQuery<MyUserMoreDetails>();
		//查询playerName叫“比目”的数据
		query.addWhereEqualTo("userPhone", regist_et_phone.getEditableText().toString());
		
		
		//返回50条数据，如果不加上这条语句，默认返回10条数据
		//query.setLimit(50);
		
		
		
		//执行查询方法
		query.findObjects(getActivity(), new FindListener<MyUserMoreDetails>() {
			

			@Override
			public void onError(int arg0, String arg1) {
				
				Log.v("TAG0query", "else");
	        	//查询失败
	        	//Toast.makeText(getActivity(),"由于系统繁忙，查询失败，请稍候重试", Toast.LENGTH_LONG).show();
	       
			}

			@Override
			public void onSuccess(List<MyUserMoreDetails> object) {
				//查询成功
	        	Log.v("TAG0query", "e==null");
	        	if(object.size()>=1)
		    	{
	            	
	        		Toast.makeText(getActivity(), "很抱歉，此账号已经存在。", Toast.LENGTH_LONG).show();
	            	return ;
		    	}
	        	//检查到没有被注册后，再添加
				add_one_new_data();
				
				
				
	            //toast("查询成功：共"+object.size()+"条数据。");
	            
	           // for (MyUserMoreDetails gameScore : object) {
	               //获得playerName的信息
	               //gameScore.getUserPhone();
	               //获得数据的objectId信息
	               // gameScore.getObjectId();
	               //获得createdAt数据创建时间（注意是：createdAt，不是createAt）
	               //gameScore.getCreatedAt();
	        	
			}

		});
		/*try {
			Thread.sleep(15000);
		} catch (InterruptedException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}*/
		//Log.v("TAG0return", container.get(0).toString());
	//	Log.v("TAG0return", container.get(0)+"");*/
		
	}
}
