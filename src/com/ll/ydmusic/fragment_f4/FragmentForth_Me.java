package com.ll.ydmusic.fragment_f4;

import java.io.File;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.DownloadFileListener;
import cn.bmob.v3.listener.FindListener;

import com.imooc.weixin6_0.R;
import com.ll.ydmusic.a.login_regist.bmob.MyUserMoreDetails;
import com.ll.ydmusic.a.login_regist.mview.MyRoundImageView;
import com.ll.ydmusic.bmob.table.HeadImg;

public class FragmentForth_Me extends Fragment {

	public String userPhone;
	public String userNickName = "时过境迁9124";
	public String userHeadImgName;
	public Bitmap headImg ;
/*	public Bitmap headImg = BitmapFactory.decodeResource(getActivity().getResources(),
			R.drawable.headimg_cartoon2);
*/
	protected BmobFile headImg_bmobfile;
	
	public Handler initViewHandler = new Handler(new Handler.Callback() {

		@Override
		public boolean handleMessage(Message msg) {
			// TODO 自动生成的方法存根

			switch (msg.what) {
			// 更改nickname
			case 0:
				TextView tv_my_nickname = (TextView) getActivity()
						.findViewById(R.id.tv_my_nickname);
				tv_my_nickname.setText(userNickName);
				
				Log.v("TAG", "initViewHandler_handleMessage_case0_成功");
				
				break;

			// 更改headImg
			case 1:

				MyRoundImageView myroundiv_headimg = (com.ll.ydmusic.a.login_regist.mview.MyRoundImageView) getActivity()
						.findViewById(R.id.myroundiv_headimg);

				myroundiv_headimg.setImageBitmap(headImg);
				
				Log.v("TAG", "initViewHandler_handleMessage_case1_成功");
				break;

			default:
				break;
			}

			return false;
		}
	});

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 自动生成的方法存根
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO 自动生成的方法存根
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// 不能填container，否则会崩
		View v = inflater.inflate(R.layout.fragment_me, null);

		getCurrentUserInfo();

		return v;
	}

	/**
	 * 因为每次登陆成功后，sharedPreference里面的内容都已经更新。所以直接从这里获取phone_number
	 */
	private void getCurrentUserInfo() {
		// TODO 自动生成的方法存根
		SharedPreferences sharedPreference1 = getActivity()
				.getSharedPreferences("DEFAULT_PHONE",
						getActivity().MODE_PRIVATE);

		String phone_number = sharedPreference1.getString("PHONE",
				"13530007739");

		BmobQuery<MyUserMoreDetails> query = new BmobQuery<MyUserMoreDetails>();
		// 查询playerName叫“比目”的数据
		query.addWhereEqualTo("userPhone", phone_number);
		// 执行查询方法
		query.findObjects(getActivity(), new FindListener<MyUserMoreDetails>() {

			@Override
			public void onError(int arg0, String arg1) {
				Log.v("TAG", "FragmentMe初始化获取数据onError:" + arg1);

			}

			@Override
			public void onSuccess(List<MyUserMoreDetails> object) {
				// 查询成功
				Log.v("TAG", "FragmentMe初始化获取数据_查询成功");

				// toast("查询成功：共"+object.size()+"条数据。");

				String userPhone = "";
				String userNickName = "";
				String userHeadImgName = "";

				for (MyUserMoreDetails userDataOne : object) {

					userPhone = userDataOne.getUserPhone();

					userNickName = userDataOne.getUserNickName();

					userHeadImgName = userDataOne.getUserHeadImgName();

				}
				(FragmentForth_Me.this).userPhone = userPhone;
				(FragmentForth_Me.this).userNickName = userNickName;
				(FragmentForth_Me.this).userHeadImgName = userHeadImgName;

				//更新FragmentMe里面的NickName
				initViewHandler.sendEmptyMessage(0);
				
				//通过获得的HeadImgName去查询相应头像图片
				(FragmentForth_Me.this).queryHeadImg();
			}

		});

	}

	protected void queryHeadImg() {
		// TODO 自动生成的方法存根
		
		BmobQuery<HeadImg> query = new BmobQuery<HeadImg>();
		// 查询playerName叫“比目”的数据
		query.addWhereEqualTo("NameImg", this.userHeadImgName);
		// 执行查询方法
		query.findObjects(getActivity(), new FindListener<HeadImg>() {

			@Override
			public void onError(int arg0, String arg1) {
				Log.v("TAG", "FragmentMe初始化获取数据_头像图片onError:" + arg1);

			}

			@Override
			public void onSuccess(List<HeadImg> object) {
				// 查询成功
				Log.v("TAG", "FragmentMe初始化获取数据_头像图片_成功");

				BmobFile headImg0 = null;

				for (HeadImg userDataOne : object) {

					 headImg0 = userDataOne.getHeadimg();
					
				}
				
				(FragmentForth_Me.this).headImg_bmobfile=headImg0;
				
				final File downloadDir=new File(Environment.getExternalStorageDirectory()+"/YDMusic/HeadImg/", 
						(FragmentForth_Me.this).userHeadImgName+".jpg");
				
				/*if(){
					
				}*/
				
				
				//通过获得的BmobFile实例，去把真正的file下载下来
				(FragmentForth_Me.this).headImg_bmobfile.download(getActivity(), 
						
						downloadDir,new DownloadFileListener() {
					
					@Override
					public void onSuccess(String arg0) {
						// TODO 自动生成的方法存根
						Log.v("TAG", "FragmentMe初始化获取数据_头像图片__下载下来  成功");
						
						
						Bitmap temp=BitmapFactory.decodeFile(downloadDir.getAbsolutePath());
					
						if(temp!=null){
							headImg=temp;
						}
						
						initViewHandler.sendEmptyMessage(1);
					}
					
					@Override
					public void onFailure(int arg0, String arg1) {
						// TODO 自动生成的方法存根
						Log.v("TAG", "FragmentMe初始化获取数据_头像图片_下载下来  onError:"+arg0+":" + arg1);
					
					}
				});
				
				
				
			}

		});
	}

}