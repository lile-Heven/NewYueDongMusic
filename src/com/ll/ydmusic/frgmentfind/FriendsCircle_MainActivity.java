package com.ll.ydmusic.frgmentfind;

import java.util.ArrayList;

import com.imooc.weixin6_0.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class FriendsCircle_MainActivity extends Activity {

	private ListView lv;
	private ScrollView sv;
	private LinearLayout ll_inside_sv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friendsactivity_main);
		//newһ��displaysize�Ա��ʼ��DisplaySize.width_gridview_singlecolumn
		new DisplaySize(this);
		
//		sv=(ScrollView)findViewById(R.id.sv);
		ll_inside_sv=(LinearLayout)findViewById(R.id.ll_inside_sv);
//		lv=(ListView)findViewById(R.id.lv);
		
//		BaseAdapter adapter = init_adapter();
		
//		lv.setAdapter(adapter);
		//lv.setsc
		set_data_sv(init_data());
		setonTouchListenerForEditRL();
	}
	/**
	 * 给edittext的父控件relativelayout设置触摸监听，以便让它关闭软键盘
	 */
	private void setonTouchListenerForEditRL() {
		RelativeLayout rl_main_for_edit = (RelativeLayout)this.findViewById(R.id.rl_main_for_edit);
				
				rl_main_for_edit.setOnTouchListener(new OnTouchListener() {
					
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						RelativeLayout rl_main_for_edit = (RelativeLayout)(FriendsCircle_MainActivity.this).findViewById(R.id.rl_main_for_edit);
						rl_main_for_edit.setVisibility(View.GONE);
						
						//为了让软键盘自动消息，尝试把et的焦点移走
						EditText edit_main=(EditText)(FriendsCircle_MainActivity.this).findViewById(R.id.edit_main);
						edit_main.setText("");
						//edit_main.clearFocus();
						
						/*InputMethodManager inputManager =  
					               (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);  
					         //    inputManager.showSoftInput(edit, 0);
							inputManager.hideSoftInputFromWindow(edit_main.getWindowToken(), 1);
							*/
							
							InputMethodManager imm = (InputMethodManager) getApplication().getSystemService(Context.INPUT_METHOD_SERVICE);
					        if (imm != null) {
					            imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
					        }
						return false;
					}
				});
	}

	private void set_data_sv(ArrayList<LinearLayout> arrayList) {
		
		// TODO �Զ���ɵķ������
		for (int i = 0; i < arrayList.size(); i++) {
			ll_inside_sv.addView(arrayList.get(i));
		}
	}

	private BaseAdapter init_adapter() {
		// TODO �Զ���ɵķ������
		ArrayList<LinearLayout> arrayList = init_data();
		
		ListViewAdapter adapter = new ListViewAdapter(this,arrayList);
		
		return adapter;
		
	}

	private ArrayList<LinearLayout> init_data() {
		ArrayList<LinearLayout> arrayList=new ArrayList<LinearLayout>();
		
		
		// TODO �Զ���ɵķ������
		Bitmap head1 = BitmapFactory.decodeResource(getResources(), R.drawable.fragmentfind_ic_launcher);
		String name1="朱正宇";
		
		
		String str_content1="今天要开发一个新的广告sdk，有一点难哦。不过正是因为难，所有才算作挑战，于是更有意思咯？";
		ArrayList<Bitmap> bmp_content1=new ArrayList<Bitmap>();
	    bmp_content1.add(BitmapFactory.decodeResource(getResources(), R.drawable.fragmentfind_singledog));
		
		String time1="3小时前";
		
		
		
				
		ArrayList<String> comments1 = new ArrayList<String>();
		comments1.add("时过境迁9124：说的蛮有道理的。加油哦！");
		comments1.add("小王：哼哼！");
		comments1.add("海神：小子不错。有前途");
		MyCustomScrollView_FriendsCircle myLinearLayoutCanClone=new MyCustomScrollView_FriendsCircle(
				this, head1, name1, str_content1, bmp_content1, time1 ,comments1);
		
		
		arrayList.add(myLinearLayoutCanClone);
		
		
		//------------------------------------------
		
		Bitmap head2 = BitmapFactory.decodeResource(getResources(), R.drawable.fragmentfind_ic_launcher222);
		String name2="朱正宇";
		
		
		String str_content2="啦啦啦，一天又过去啦。";
		ArrayList<Bitmap> bmp_content2=new ArrayList<Bitmap>();
	    bmp_content2.add(BitmapFactory.decodeResource(getResources(), R.drawable.fragmentfind_bg_login_regist_well4));
	    bmp_content2.add(BitmapFactory.decodeResource(getResources(), R.drawable.fragmentfind_headimg_cartoon2));
	    bmp_content2.add(BitmapFactory.decodeResource(getResources(), R.drawable.fragmentfind_ic_launcher222));
	    bmp_content2.add(BitmapFactory.decodeResource(getResources(), R.drawable.fragmentfind_bg_login_regist_well4));
	    bmp_content2.add(BitmapFactory.decodeResource(getResources(), R.drawable.fragmentfind_headimg_cartoon2));
	    bmp_content2.add(BitmapFactory.decodeResource(getResources(), R.drawable.fragmentfind_headimg_cartoon2));
	    bmp_content2.add(BitmapFactory.decodeResource(getResources(), R.drawable.fragmentfind_headimg_cartoon2));
	   
	    
		String time2="7小时前";
		
		ArrayList<String> comments2 = new ArrayList<String>();
		
		comments2.add("王思聪：大哥您就是太低调了");
		comments2.add("王石：等你很久了。说好一起去滑翔的呀！");
		
		MyCustomScrollView_FriendsCircle myLinearLayoutCanClone2=new MyCustomScrollView_FriendsCircle(
				this, head2, name2, str_content2, bmp_content2, time2,comments2);
		
		arrayList.add(myLinearLayoutCanClone2);
		//arrayList.add(myLinearLayoutCanClone);
		
		return arrayList;
	}
	
	/**
	 * �½�ImageView+clone������е�仯�������ǲ���
	 * @return
	 */

	/*	private ArrayList<LinearLayout> init_data3() {
		

        ArrayList<LinearLayout> arrayList=new ArrayList<LinearLayout>();
		
		
		
		
		
		// TODO �Զ���ɵķ������
		
        MyLinearLayoutCanClone lineLayout = new MyLinearLayoutCanClone(this);  
		
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);  
        lineLayout.setLayoutParams(params);  
        
        lineLayout.setOrientation(LinearLayout.VERTICAL);      
        lineLayout.setGravity(Gravity.TOP );  
        
        
        
        //TextView 
        TextView showText = new TextView(this);  
        showText.setTextColor(Color.GREEN);  
        showText.setTextSize(30);  
        showText.setId(10001);//���� id  
        showText.setText("�����ڳ�������ӵĵ�һ���ı�");  
        showText.setBackgroundColor(Color.GRAY);  
        // set �ı���С  
        LinearLayout.LayoutParams paramstv = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,  
                LayoutParams.WRAP_CONTENT);  
        //set ���ܾ���  
        paramstv.setMargins(10, 10, 10, 10);  
       
        showText.setLayoutParams(params);  
          
        //����ı���������  
        lineLayout.addView(showText );  
		
        
		ImageView img=new ImageView(this);
		LinearLayout.LayoutParams paramsiv = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,  
                LayoutParams.WRAP_CONTENT);  
		
		img.setLayoutParams(paramsiv);
		img.setBackgroundResource(R.drawable.item_imageicon);
		//img.setTag("IMG");
		
		//��ӵ�������  
        lineLayout.addView(img);  
		
        
        
        arrayList.add(lineLayout);//���һ��linearlayout���
        
        
        
        //��¡----------------------------------
        MyLinearLayoutCanClone lineLayout2 = lineLayout.clone();
        
        
        
        lineLayout2.removeView(img);//�Ƴ�         ���Ƴ����޸ģ������
        
        ImageView img2=new ImageView(this);
		LinearLayout.LayoutParams paramsiv2 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,  
                LayoutParams.WRAP_CONTENT);  
		
		img2.setLayoutParams(paramsiv2);
		img2.setBackgroundResource(R.drawable.headimg_cartoon2);
		
        
        lineLayout2.addView(img2 ); //���
        
        arrayList.add(lineLayout2);//���һ��linearlayout���
        
        
        //��¡----------------------------------
        MyLinearLayoutCanClone lineLayout3 = lineLayout.clone();
        
        lineLayout3.removeView(img);//�Ƴ�         ���Ƴ����޸ģ������
        
        ImageView img3=new ImageView(this);
		LinearLayout.LayoutParams paramsiv3 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,  
                LayoutParams.WRAP_CONTENT);  
		
		img3.setLayoutParams(paramsiv3);
		img3.setBackgroundResource(R.drawable.bg_login_regist_well4);
		
        
        lineLayout3.addView(img3 ); //���
        
        arrayList.add(lineLayout3);//���һ��linearlayout���
        
       // arrayList.add(lineLayout);//���һ��linearlayout���
        
        Log.v("TAG", ""+lineLayout.hashCode());
        Log.v("TAG", ""+lineLayout2.hashCode());
        Log.v("TAG", ""+lineLayout3.hashCode());
        
        Log.v("TAG", "-------------");
        
        Log.v("TAG", ""+arrayList.get(0).hashCode());
        Log.v("TAG", ""+arrayList.get(1).hashCode());
        Log.v("TAG", ""+arrayList.get(2).hashCode());
        
        
        
        
        
		return arrayList;
        
        
	}*/
	
	/**
	 * ����ǳ��������д�������listviewֻ��ʾ���һ�ǰ���ǿհף�
	 * @return
	 */
/*private ArrayList<LinearLayout> init_data2() {
		

        ArrayList<LinearLayout> arrayList=new ArrayList<LinearLayout>();
		
		
		
		
		
		// TODO �Զ���ɵķ������
		
        MyLinearLayoutCanClone lineLayout = new MyLinearLayoutCanClone(this);  
		
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);  
        lineLayout.setLayoutParams(params);  
        
        lineLayout.setOrientation(LinearLayout.VERTICAL);      
        lineLayout.setGravity(Gravity.TOP );  
        
        
        
        //TextView 
        TextView showText = new TextView(this);  
        showText.setTextColor(Color.GREEN);  
        showText.setTextSize(30);  
        showText.setId(10001);//���� id  
        showText.setText("�����ڳ�������ӵĵ�һ���ı�");  
        showText.setBackgroundColor(Color.GRAY);  
        // set �ı���С  
        LinearLayout.LayoutParams paramstv = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,  
                LayoutParams.WRAP_CONTENT);  
        //set ���ܾ���  
        paramstv.setMargins(10, 10, 10, 10);  
       
        showText.setLayoutParams(params);  
          
        //����ı���������  
        lineLayout.addView(showText );  
		
		ImageView img=new ImageView(this);
		LinearLayout.LayoutParams paramsiv = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,  
                LayoutParams.WRAP_CONTENT);  
		
		img.setLayoutParams(paramsiv);
		img.setBackgroundResource(R.drawable.item_imageicon);
		img.setTag("IMG");
		
		//��ӵ�������  
        lineLayout.addView(img);  
		
        
        arrayList.add(lineLayout);//���һ��linearlayout���
        
        
        //��¡
        MyLinearLayoutCanClone lineLayout2 = lineLayout.clone();
        
        
        
        lineLayout2.removeView(img);//�Ƴ�         ���Ƴ����޸ģ������
        
        img.setBackgroundResource(R.drawable.headimg_cartoon2);//�޸�
        
        lineLayout2.addView(img ); //���
        
        arrayList.add(lineLayout2);//���һ��linearlayout���
        
        
        //��¡
        MyLinearLayoutCanClone lineLayout3 = lineLayout2.clone();
        
        lineLayout3.removeView(img);//�Ƴ�         ���Ƴ����޸ģ������
        
        img.setBackgroundResource(R.drawable.item_imageicon);//�޸�
        
        lineLayout3.addView(img ); //���
        
        arrayList.add(lineLayout3);//���һ��linearlayout���
        
       // arrayList.add(lineLayout);//���һ��linearlayout���
        
        Log.v("TAG", ""+lineLayout.hashCode());
        Log.v("TAG", ""+lineLayout2.hashCode());
        Log.v("TAG", ""+lineLayout3.hashCode());
        
        Log.v("TAG", "-------------");
        
        Log.v("TAG", ""+arrayList.get(0).hashCode());
        Log.v("TAG", ""+arrayList.get(1).hashCode());
        Log.v("TAG", ""+arrayList.get(2).hashCode());
        
        
        
        
        
		return arrayList;
        
        
	}*/
/*private ArrayList<LinearLayout> init_data() {
	

    ArrayList<LinearLayout> arrayList=new ArrayList<LinearLayout>();
	
	
	
	
	
	// TODO �Զ���ɵķ������
	
    MyLinearLayoutCanClone lineLayout = new MyLinearLayoutCanClone(this);  
	
	LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);  
    lineLayout.setLayoutParams(params);  
    
    lineLayout.setOrientation(LinearLayout.VERTICAL);      
    lineLayout.setGravity(Gravity.TOP );  
    
    
    
    //TextView 
    TextView showText = new TextView(this);  
    showText.setTextColor(Color.GREEN);  
    showText.setTextSize(30);  
    showText.setId(10001);//���� id  
    showText.setText("�����ڳ�������ӵĵ�һ���ı�");  
    showText.setBackgroundColor(Color.GRAY);  
    // set �ı���С  
    LinearLayout.LayoutParams paramstv = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,  
            LayoutParams.WRAP_CONTENT);  
    //set ���ܾ���  
    paramstv.setMargins(10, 10, 10, 10);  
   
    showText.setLayoutParams(params);  
      
    //����ı���������  
    lineLayout.addView(showText );  
	
	ImageView img=new ImageView(this);
	LinearLayout.LayoutParams paramsiv = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,  
            LayoutParams.WRAP_CONTENT);  
	
	img.setLayoutParams(paramsiv);
	img.setBackgroundResource(R.drawable.item_imageicon);
	img.setTag("IMG");
	
	//��ӵ�������  
    lineLayout.addView(img);  
	
    
    arrayList.add(lineLayout);//���һ��linearlayout���
    
    
    //------------------------------------------
    
// TODO �Զ���ɵķ������
	
    MyLinearLayoutCanClone lineLayout2 = new MyLinearLayoutCanClone(this);  
	
	LayoutParams params2 = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);  
    lineLayout2.setLayoutParams(params2);  
    
    lineLayout2.setOrientation(LinearLayout.VERTICAL);      
    lineLayout2.setGravity(Gravity.TOP );  
    
    
    
    //TextView 
    TextView showText2 = new TextView(this);  
    showText2.setTextColor(Color.GREEN);  
    showText2.setTextSize(30);  
    showText2.setId(10001);//���� id  
    showText2.setText("�����ڳ�������ӵĵ�һ���ı�");  
    showText2.setBackgroundColor(Color.GRAY);  
    // set �ı���С  
    LinearLayout.LayoutParams paramstv2 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,  
            LayoutParams.WRAP_CONTENT);  
    //set ���ܾ���  
    paramstv.setMargins(10, 10, 10, 10);  
   
    showText2.setLayoutParams(paramstv2);  
      
    //����ı���������  
    lineLayout2.addView(showText2 );  
	
	ImageView img2=new ImageView(this);
	LinearLayout.LayoutParams paramsiv2 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,  
            LayoutParams.WRAP_CONTENT);  
	
	img2.setLayoutParams(paramsiv2);
	img2.setBackgroundResource(R.drawable.headimg_cartoon2);
	img2.setTag("IMG");
	
	//��ӵ�������  
    lineLayout2.addView(img2);  
	
    
    arrayList.add(lineLayout2);//���һ��linearlayout���
    
    
    
    
    
    
    
    
    Log.v("TAG", ""+lineLayout.hashCode());
    Log.v("TAG", ""+lineLayout2.hashCode());
    Log.v("TAG", ""+lineLayout3.hashCode());
    
    Log.v("TAG", "-------------");
    
    Log.v("TAG", ""+arrayList.get(0).hashCode());
    Log.v("TAG", ""+arrayList.get(1).hashCode());
    Log.v("TAG", ""+arrayList.get(2).hashCode());
    
    
    
    
    
	return arrayList;
    
    
}*/
}
