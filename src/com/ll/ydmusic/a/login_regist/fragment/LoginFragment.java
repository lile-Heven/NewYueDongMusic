package com.ll.ydmusic.a.login_regist.fragment;

import java.util.List;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import com.imooc.weixin6_0.R;
import com.ll.ydmusic.MainActivity;
import com.ll.ydmusic.a.login_regist.bmob.MyUser;
import com.ll.ydmusic.a.login_regist.bmob.MyUserMoreDetails;
import com.ll.ydmusic.net.NetUtils;

public class LoginFragment extends Fragment implements OnClickListener {

	private Button bt_login_regist;
	private EditText et_login_phone;
	private EditText et_login_password;
	private Button bt_login_login;

	private Button bt_login_backdoor;

	private Handler handler = new Handler(new Callback() {

		@Override
		public boolean handleMessage(Message msg) {

			et_login_phone.setText(msg.obj.toString());
			Log.d("tag", "success-et_login_name---change");
			return true;
		}
	});

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO �Զ���ɵķ������
		super.onCreate(savedInstanceState);
		Log.d("tag", "oncreate_LoginFragment");
		

	}

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("tag", "oncreateView_LoginFragment");

		View view1 = inflater.inflate(R.layout.fragment_login, null);

		init_attach_view2object(view1);

		init_add_listeners();

		/*
		 * EditText edit=(EditText)findViewById(R.id.edit); edit.clearFocus();
		 */
		return view1;
	}

	private void init_add_listeners() {
		bt_login_regist.setOnClickListener(this);
		bt_login_login.setOnClickListener(this);
		bt_login_backdoor.setOnClickListener(this);
	}

	/**
	 * @param view1
	 */
	private void init_attach_view2object(View view1) {
		// 按钮
		bt_login_regist = (Button) view1.findViewById(R.id.bt_login_regist);

		bt_login_login = (Button) view1.findViewById(R.id.bt_login_login);

		bt_login_backdoor = (Button) view1.findViewById(R.id.bt_login_backdoor);

		// 账户名跟密码
		et_login_phone = (EditText) view1.findViewById(R.id.et_login_phone);
		et_login_password = (EditText) view1
				.findViewById(R.id.et_login_password);

		// 尝试关闭et的默认焦点
		et_login_phone.clearFocus();
		et_login_password.clearFocus();
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO �Զ���ɵķ������
		Log.d("tag", "onViewcreate_LoginFragment");
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_login_regist:
			FragmentTransaction fragmentTransaction = getActivity()
					.getFragmentManager().beginTransaction();

			fragmentTransaction.add(R.id.fl_login, new RegistFragment(),
					"RegistFragment");

			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();
			
			break;
			
		case R.id.bt_login_login:
			// 开启新线程去执行网络行为
			/*
			 * new Thread(){ public void run() { String str_entity =
			 * NetUtils.easyLinkInternet("/RequestLogin"); Log.d("tag",
			 * "success-str_entity: "+str_entity); Message msg=new Message();
			 * msg.obj=str_entity; handler.sendMessage(msg);
			 * 
			 * }; }.start();
			 */

			check_account_and_pwd();

			// dataSubmit2Bmob();

			break;
		case R.id.bt_login_backdoor:
			
			login_from_backdoor();
			
			break;
		default:
			break;
		}

	}

	private void login_from_backdoor() {

		//通过sharedpreferences来获得上一次成功登录时候缓存的号码
		SharedPreferences sharedPreference1 = getActivity().getSharedPreferences("DEFAULT_PHONE", getActivity().MODE_PRIVATE );

		//Log.v("TAG", "LoginFromBackdoor: shredpref--DEFAULT_PHONE是否存在？"+sharedPreference1.toString());
		
		String phone_last_success=sharedPreference1.getString("PHONE", "13530007739");
		
		final String str_loginPhone =phone_last_success;
		

		BmobQuery<MyUserMoreDetails> query = new BmobQuery<MyUserMoreDetails>();
		// 查询playerName叫“比目”的数据
		query.addWhereEqualTo("userPhone", str_loginPhone);
		// 执行查询方法
		query.findObjects(getActivity(), new FindListener<MyUserMoreDetails>() {
			

			private void login_success() {

				Toast.makeText(getActivity(), "尊贵的用户："+str_loginPhone+"，欢迎进入悦动的世界！",
						Toast.LENGTH_LONG).show();
				Intent intent = new Intent(getActivity(), MainActivity.class);

				getActivity().startActivity(intent);
				getActivity().finish();
				
			}

			@Override
			public void onError(int arg0, String arg1) {
				Log.v("TAG0query", "onError:"+arg1);
				//
				Toast.makeText(getActivity(), "由于系统繁忙，查询失败，请稍候重试",
						Toast.LENGTH_LONG).show();
				
			}

			@Override
			public void onSuccess(List<MyUserMoreDetails> object) {
				// 查询成功
				Log.v("TAG0query", "e==null");

				// toast("查询成功：共"+object.size()+"条数据。");

				String userPhone = "";
				String userPassword = "";
				for (MyUserMoreDetails userDataOne : object) {
					// 获得playerName的信息
					userPhone = userDataOne.getUserPhone();
					// 获得数据的objectId信息
					// gameScore.getObjectId();
					// 获得createdAt数据创建时间（注意是：createdAt，不是createAt）
					//userPassword = userDataOne.getUserPassword();

				}
				if (userPhone.equals(str_loginPhone)
						) {
					login_success();
				} else {
					Toast.makeText(getActivity(), "账户或密码不正确，登录失败",
							Toast.LENGTH_LONG).show();
				}
				
			}
		});

	}

	private void check_account_and_pwd() {
		final String str_loginPhone = et_login_phone.getText().toString();
		final String str_loginPassword = et_login_password.getText().toString();
		// |位运算符 ||或
		if (str_loginPhone.equals("") || str_loginPassword.equals("")) {
			Toast.makeText(getActivity(), "账户或密码为空，登录失败", Toast.LENGTH_SHORT)
					.show();
			return;
		}
		/*Toast.makeText(getActivity(), "请稍等...", Toast.LENGTH_SHORT)
		.show();*/
		
		BmobQuery<MyUserMoreDetails> query = new BmobQuery<MyUserMoreDetails>();
		// 查询playerName叫“比目”的数据
		query.addWhereEqualTo("userPhone", str_loginPhone);
		// 执行查询方法
		query.findObjects(getActivity(), new FindListener<MyUserMoreDetails>() {
			

			private void login_success() {
				
				//把登录成功的手机号码缓存到sharedpreferences里面，供default按钮调用
				default_phonenumber_memory();
				
				// TODO 自动生成的方法存根
				Toast.makeText(getActivity(), "尊贵的用户："+str_loginPhone+"，欢迎进入悦动的世界！",
						Toast.LENGTH_LONG).show();
				Intent intent = new Intent(getActivity(), MainActivity.class);

				getActivity().startActivity(intent);
				getActivity().finish();
			}
			/**
			 * 把登录成功的手机号码缓存到sharedpreferences里面，供default按钮调用
			 */
			private void default_phonenumber_memory() {
				// TODO 自动生成的方法存根
				SharedPreferences sharedPreference1 = getActivity().getSharedPreferences("DEFAULT_PHONE", getActivity().MODE_PRIVATE );
				
				sharedPreference1.edit().putString("PHONE", str_loginPhone.trim()).commit();
				
				Log.v("TAG", "sharedPref更改成功："+str_loginPhone.trim());
			}

			@Override
			public void onError(int arg0, String arg1) {
				// TODO 自动生成的方法存根
				Log.v("TAG0query", "else");
				//
				Toast.makeText(getActivity(), "由于系统繁忙，查询失败，请稍候重试",
						Toast.LENGTH_LONG).show();
			}

			@Override
			public void onSuccess(List<MyUserMoreDetails> object) {
				// TODO 自动生成的方法存根
				// 查询成功
				Log.v("TAG0query", "e==null");

				// toast("查询成功：共"+object.size()+"条数据。");

				String userPhone = "";
				String userPassword = "";
				for (MyUserMoreDetails userDataOne : object) {
					// 获得playerName的信息
					userPhone = userDataOne.getUserPhone();
					// 获得数据的objectId信息
					// gameScore.getObjectId();
					// 获得createdAt数据创建时间（注意是：createdAt，不是createAt）
					userPassword = userDataOne.getUserPassword();

				}
				// userPhone.equals(str_loginPhone);
				// userPassword.equals(str_loginPassword);
				//
				if (userPhone.equals(str_loginPhone)
						&& userPassword.equals(str_loginPassword)) {
					login_success();
				} else {
					Toast.makeText(getActivity(), "账户或密码不正确，登录失败",
							Toast.LENGTH_LONG).show();
				}
			}
		});

	}

}
