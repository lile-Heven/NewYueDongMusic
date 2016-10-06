package com.ll.ydmusic.frgmentfind;

import java.util.ArrayList;

import com.imooc.weixin6_0.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyCustomScrollView_FriendsCircle extends LinearLayout implements OnClickListener{

	//各个视图的id表：0x7f0966**
	//iv_head : 0x7f096601
	//tv_content : 0x7f096602
	//iv_content : 0x7f096603
	//tv_cancel : 0x7f096604
	//iv_comment_bottom : 0x7f096609
	
	
	public LinearLayout linearLayout1;
	public LinearLayout linearLayout2;
	public ImageView iv_head;
	public TextView tv_content;
	public TextView tv_name;
	public TextView tv_time;
	private GridView gridView;
	private ImageView iv_content;
	private LinearLayout linearLayout_bottom;
	private LinearLayout linearLayout_Content;
	private ImageView iv_comment_bottom;
	private TextView tv_cancel;
	private PopupWindow pw_comment;
	private LinearLayout ll_CommentsZone;
	

	public MyCustomScrollView_FriendsCircle(
			Context context ,
			Bitmap img_head ,
			String name , 
			String str_content ,
			ArrayList<Bitmap> bmp_content2 ,
			String time
			,ArrayList<String> comments) {
		super(context);

		
		init_ThisParams();      
		
        
        
        
        
		onCreate( context ,
				img_head ,
				 name , 
				 str_content ,
				 bmp_content2 ,
				 time ,comments);
		
		
	}
	private void onCreate(Context context, Bitmap head, String name, 
			String str_content, ArrayList<Bitmap> bmp_content2, 
			String time ,ArrayList<String> comments) {
		
		onCreate_LinearLayout_Content(context); 
         //为了避免用户不是上传的单图，倒置方法不执行，然后iv_content.setOnClickListener抛出空指针异常。在此先初始化
		iv_content=new ImageView(context);
		
        onCreate_LinearLayout1(context);  
        onCreate_LinearLayout2(context);  
		
		// TODO 自动生成的方法存根
		onCreate_Head(context,head);
		onCreate_Name(context,name);
		onCreate_Str_Content(context,str_content);
		onCreate_Bmp_Content(context,bmp_content2);

		onCreate_Time(context,time);
		onCreate_Cancel(context);
        onCreate_Comment_Icon(context);
        
        onCreate_LinearLayout_Bottom(context);
        //待iv_comment被添加进ll后，给comment图片附加PopupWindow
      	init_PopupWindow_Comment(context);
      	
      	//添加评论区域。可能有可能无
        onCreate_LinearLayout_CommentZone(context,comments);
        
		onCreate_DividerLine(context);
		
		
		//设置点击监听
		setOnClickListener();
	}
	/**
	 * 评论区域
	 * @param comments 
	 * @param context 
	 */
	private void onCreate_LinearLayout_CommentZone(Context context, ArrayList<String> comments) {
		// TODO 自动生成的方法存根
		if(comments.size()<=0){
			//此条动态没有评论数据
			return ;
		}else{
			ll_CommentsZone = new LinearLayout(context);  
			
	        LayoutParams params_child2 = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
	        //params_child2.gravity=Gravity.RIGHT;
	        params_child2.setMargins(0, 0, 20, 20);
	        ll_CommentsZone.setLayoutParams(params_child2);  
	        
	        ll_CommentsZone.setOrientation(LinearLayout.VERTICAL);
	        
	        ll_CommentsZone.setBackgroundResource(R.drawable.fragmentfind_friendscc_comment_list_normal);
	        
			for (String string : comments) {
				TextView comment_one=new TextView(context);
				
				comment_one.setTextColor(getResources().getColor(R.color.Black_Font_Content));  
				comment_one.setTextSize(12);  
				comment_one.setId(5010);//设置 id  
				
				comment_one.setText(string);  
				//comment_one.setBackgroundColor(getResources().getColor(R.color.White));  
				
				//comment_one.setTextColor(getResources().getColor(R.color.Gray_Font));
		        // set 文本大小  
				
		        LinearLayout.LayoutParams paramstv = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,  
		                LayoutParams.WRAP_CONTENT);  
		        
		        //set 四周距离  
		        paramstv.setMargins(2, 2, 2, 2);  
		        
		        comment_one.setLayoutParams(paramstv);  
				
		        ll_CommentsZone.addView(comment_one);
			}
			
			linearLayout2.addView(ll_CommentsZone);
		}
	}
	private void setOnClickListener() {
		// TODO 自动生成的方法存根
		//tv_name.setOnClickListener(this);
		iv_head.setOnClickListener(this);
		tv_content.setOnClickListener(this);
		iv_content.setOnClickListener(this);
		tv_cancel.setOnClickListener(this);
		iv_comment_bottom.setOnClickListener(this);
		//Button bt=(Button)this.findViewById(R.id.bt_edit_send);
		//bt.setOnClickListener(this);
		
	}
	private void onCreate_Cancel(Context context) {
		// TODO 自动生成的方法存根
		tv_cancel = new TextView(context);  
		tv_cancel.setId(0x7f096604);//设置 id  
		// set 文本大小  
        LinearLayout.LayoutParams paramstv = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,  
                LayoutParams.WRAP_CONTENT);  
        //set 四周距离  
        paramstv.setMargins(5, 5, 5, 5);  
       
        tv_cancel.setLayoutParams(paramstv);  
        
        
		tv_cancel.setTextSize(12); 
		tv_cancel.setText("删除");  
		tv_cancel.setTextColor(getResources().getColor(R.color.Blue_Font_Cancel));  
		tv_cancel.setBackgroundColor(getResources().getColor(R.color.White));  
        
		
        
	}
	private void onCreate_DividerLine(Context context) {
		// TODO 自动生成的方法存根
		View dividerLine=new View(context);
		
		LinearLayout.LayoutParams paramsiv = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,  
				1);  
		
		dividerLine.setLayoutParams(paramsiv);
		dividerLine.setBackgroundResource(R.color.Gray_DividerLine);
		//bottomLine.setBackgroundColor(R.color.Gray_BackGround);
		
		//Log.v("TAG", "width of dividerLine : "+dividerLine.getWidth()+"  height : "+ dividerLine.getHeight());
		//Log.v("TAG", "paramsiv of dividerLine : "+paramsiv.width+"  height : "+ paramsiv.height);
		
		this.addView(dividerLine);
	}
	private void onCreate_LinearLayout_Content(Context context) {
		// TODO 自动生成的方法存根
		linearLayout_Content = new LinearLayout(context);  
        LayoutParams params_child1 = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
        params_child1.weight=6;
        linearLayout_Content.setLayoutParams(params_child1);  
        
        linearLayout_Content.setOrientation(LinearLayout.HORIZONTAL);
        

        this.addView(linearLayout_Content);
	}
	/**
	 * 初始化this这个LinearLayout的参数params
	 */
	private void init_ThisParams() {
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
        
		this.setLayoutParams(params);  
        
        this.setOrientation(LinearLayout.VERTICAL);
	}

	/**
	 * 创建第二个LinearLayout，并初始化 ，以便ll1跟ll2把主布局切分成左右两边
	 * @param context
	 */
	private void onCreate_LinearLayout2(Context context) {
		linearLayout2 = new LinearLayout(context);  
		
        LayoutParams params_child2 = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
        params_child2.weight=1;
        linearLayout2.setLayoutParams(params_child2);  
        
        linearLayout2.setOrientation(LinearLayout.VERTICAL);
        

        linearLayout_Content.addView(linearLayout2);
        

	}
	
	/**
	 * 创建第一个LinearLayout，并初始化  ，以便ll1跟ll2把主布局切分成左右两边
	 * @param context
	 * @return
	 */
	private void onCreate_LinearLayout1(Context context) {
		linearLayout1 = new LinearLayout(context);  
        LayoutParams params_child1 = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
        params_child1.weight=6;
        linearLayout1.setLayoutParams(params_child1);  
        
        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        

        linearLayout_Content.addView(linearLayout1);
        
	}
	
	
	
	
	private void onCreate_LinearLayout_Bottom(Context context) {
		// TODO 自动生成的方法存根
		linearLayout_bottom = new LinearLayout(context);  
		
        LayoutParams params_child2 = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);  
        //params_child2.gravity=Gravity.RIGHT;
        linearLayout_bottom.setLayoutParams(params_child2);  
        
        linearLayout_bottom.setOrientation(LinearLayout.HORIZONTAL);
        
       // Log.v("TAG", "linearLayout_bottom hashCode : "+linearLayout_bottom.hashCode());
      //  Log.v("TAG", "tv_time hashCode : "+tv_time.hashCode());
      //添加时间tv到主布局  
        linearLayout_bottom.addView(tv_time ); 
        
        
        
        linearLayout_bottom.addView(tv_cancel); 
        
        /*View space=new View(context);
        
        LinearLayout.LayoutParams params_space = new LinearLayout.LayoutParams(400,  
				50);  
        
        space.setLayoutParams(params_space);
        //添加到布局  
        linearLayout_bottom.addView(space);*/
        
        
        
      //  Log.v("TAG", "linearLayout_bottom hashCode : "+linearLayout_bottom.hashCode());
		
		linearLayout_bottom.addView(iv_comment_bottom);
        
        
        linearLayout2.addView(linearLayout_bottom);
	}
	/**
	 * @param context
	 */
	private void onCreate_Comment_Icon(Context context) {
		iv_comment_bottom = new ImageView(context);
		iv_comment_bottom.setId(0x7f096609);
		/*LinearLayout.LayoutParams paramsiv = new LinearLayout.LayoutParams(50,  
                50);  */
		LinearLayout.LayoutParams paramsiv = new LinearLayout.LayoutParams(50,  
				50);  
		//paramsiv.gravity=Gravity.END;
		 //set 四周距离  
		paramsiv.setMargins(580, 10, 0, 20);
        
		iv_comment_bottom.setLayoutParams(paramsiv);
		
		
		//img.setBackgroundResource(R.drawable.item_imageicon);
		iv_comment_bottom.setImageResource(R.drawable.fragmentfind_icon_popup_comment2);
		
		/*Matrix matrix=new Matrix();
		matrix*/
		
		//img.setTag("IMG");
		//------------------------------------
		
	}

	private void init_PopupWindow_Comment(Context context) {
		
		View view = LayoutInflater.from(context).inflate(R.layout.friendsactivity_layout_popupwindow_comment, null);
		
		// TODO 自动生成的方法存根
		 pw_comment=new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
		
		pw_comment.setOutsideTouchable(true);
		pw_comment.setFocusable(true);
		
		
		
		pw_comment.update();
		
		(pw_comment.getContentView().findViewById(R.id.ll1_popup)).setOnClickListener(this);
		(pw_comment.getContentView().findViewById(R.id.ll2_popup)).setOnClickListener(this);
		
		
		//pw_comment.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.bg_login_regist_well4));
		pw_comment.setBackgroundDrawable(new BitmapDrawable());  
		//pw_comment.showAsDropDown(this, 0, 0);
		
	}
	/**
	 * @param context
	 * @param head
	 */
	private void onCreate_Head(Context context, Bitmap head ) {
		// TODO 自动生成的方法存根
		 iv_head=new ImageView(context);
		/*LinearLayout.LayoutParams paramsiv = new LinearLayout.LayoutParams(50,  
                50);  */
		LinearLayout.LayoutParams paramsiv = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,  
				LayoutParams.MATCH_PARENT);  
		paramsiv.gravity=Gravity.CENTER;
		 //set 四周距离  
		paramsiv.setMargins(3, 3, 3, 3); 
        
		iv_head.setLayoutParams(paramsiv);
		
		
		//img.setBackgroundResource(R.drawable.item_imageicon);
		iv_head.setImageBitmap(head);
		
		/*Matrix matrix=new Matrix();
		matrix*/
		iv_head.setId(0x7f096601);
		//img.setTag("IMG");
		Log.v("TAG", "iv_head id : "+ iv_head.getId());
		//添加到主布局  
        linearLayout1.addView(iv_head);
		
        
        
	}

	private void onCreate_Name(Context context, String name) {
		// TODO 自动生成的方法存根
		tv_name = new TextView(context);  
		tv_name.setTextColor(getResources().getColor(R.color.Blue_Font_Name));  
		tv_name.setTextSize(16);  
		//tv_name.setId(5001);//设置 id  
		tv_name.setText(name);  
		tv_name.setBackgroundColor(getResources().getColor(R.color.White));  
        // set 文本大小  
        LinearLayout.LayoutParams paramstv = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,  
                LayoutParams.WRAP_CONTENT);  
        //set 四周距离  
        paramstv.setMargins(5, 5, 5, 5);  
       
        tv_name.setLayoutParams(paramstv);  
          
        tv_name.getId();
        
        Log.v("TAG", "tv_name id : "+ tv_name.getId());
        
        //添加文本到主布局  
        linearLayout2.addView(tv_name ); 
	}

	
	

	private void onCreate_Str_Content(Context context, String str_content) {
		// TODO 自动生成的方法存根
		tv_content = new TextView(context);  
		LinearLayout.LayoutParams paramstv = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,  
                LayoutParams.WRAP_CONTENT);  
        //set 四周距离  
        paramstv.setMargins(5, 5, 5, 5);  
        tv_content.setLayoutParams(paramstv);  

        
        tv_content.setTextColor(getResources().getColor(R.color.Black_Font_Content));  
        tv_content.setTextSize(16);  
        tv_content.setId(5002);//设置 id  
        tv_content.setText(str_content);  
        tv_content.setBackgroundColor(getResources().getColor(R.color.White));  
        // set 文本大小  
        
        tv_content.setId(0x7f096602);
          
        //添加文本到主布局  
        linearLayout2.addView(tv_content );  
	}

	private void onCreate_Bmp_Content(Context context, ArrayList<Bitmap> bmp_content2) {
		// TODO 自动生成的方法存根
		if(bmp_content2==null){
			return;
		}
		
		int length=bmp_content2.size();
		
		if(length==0){
			//return ;
		}else if(length==1){
			onCreate_content_SingleImageView(context,bmp_content2);
		}else{
			onCreate_content_GirdView(context,bmp_content2);
		}
		
		
	}
	
	private void onCreate_content_SingleImageView(Context context, ArrayList<Bitmap> bmp_content2) {
			
			
			iv_content=new ImageView(context);
			// TODO 自动生成的方法存根
		 	
		 	int[] size=obtain_SizeOfIv(bmp_content2);
		 	
			LinearLayout.LayoutParams paramsiv = new LinearLayout.LayoutParams(size[0],  
					size[1]);  
/*			LinearLayout.LayoutParams paramsiv = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,  
					LayoutParams.WRAP_CONTENT);  
*/		
			paramsiv.gravity=Gravity.START;
			 //set 四周距离  
			paramsiv.setMargins(5, 5, 5, 5); 
	        
			iv_content.setLayoutParams(paramsiv);
			
			iv_content.setImageBitmap(bmp_content2.get(0));
			
			iv_content.setScaleType(ScaleType.FIT_XY);
			
			iv_content.setId(0x7f096603);
			/*Matrix matrix=new Matrix();
			matrix*/
			
			//img.setTag("IMG");
			
			//添加到主布局  
	        linearLayout2.addView(iv_content);
	}

	private int[] obtain_SizeOfIv(ArrayList<Bitmap> bmp_content2) {
		//size[0]意味着width  ， size[1]意味着height
		int[] size=new int[2];
		
		Bitmap bmp=bmp_content2.get(0);
		
		int width=bmp.getWidth();
		int height=bmp.getHeight();
		
		boolean isWidthMax=width>height;
		
		if(isWidthMax){
			size[0]=DisplaySize.width_0_618_OfDisplay;
			
			size[1]=DisplaySize.width_0_618_OfDisplay*height/width;
			
			
		}else{
			size[1]=DisplaySize.width_0_618_OfDisplay;
			
			size[0]=DisplaySize.width_0_618_OfDisplay*width/height;
			
		}
		
		//Log.v("TAG", "size.length : "+size.length);
		
		
		return size;
	}

	private void onCreate_content_GirdView(Context context, ArrayList<Bitmap> bmp_content2) {
		//提醒：这里gridview也是可以滚动，嵌套到scrollview里面后，scrollview的滚动失效了
		
		
		
		// TODO 自动生成的方法存根
		gridView=new GridView(context);
		Log.v("TAG","width_gridview_singlecoloumn in GridView: " +DisplaySize.width_gridview_singlecoloumn);
		LayoutParams params_child1 = new LayoutParams(DisplaySize.width_gridview_singlecoloumn*3,
				DisplaySize.width_gridview_singlecoloumn*3);  

		gridView.setLayoutParams(params_child1);  
		
		gridView.setNumColumns(3);
		
		gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
		
		gridView.setHorizontalSpacing(10);
		gridView.setVerticalSpacing(10);
		
		/*List<? extends Map<String, ?>> data=init_data_gridview();
		//to: The views that should display column in the "from" parameter. These should all be TextViews
		SimpleAdapter adapter=new SimpleAdapter(context, data, resource, from, to);*/
		
		
		
		MyGridViewAdapter adapter=new MyGridViewAdapter(context,bmp_content2);
		
		
		gridView.setAdapter(adapter);
		
		
		
		//添加到主布局  
        linearLayout2.addView(gridView);
		
	}

	

	private void onCreate_Time(Context context, String time) {
		// TODO 自动生成的方法存根
				tv_time = new TextView(context);  
				tv_time.setTextColor(getResources().getColor(R.color.Black));  
				tv_time.setTextSize(12);  
				tv_time.setId(5003);//设置 id  
				tv_time.setText(time);  
				tv_time.setBackgroundColor(getResources().getColor(R.color.White));  
				tv_time.setTextColor(getResources().getColor(R.color.Gray_Font));
		        // set 文本大小  
		        LinearLayout.LayoutParams paramstv = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,  
		                LayoutParams.WRAP_CONTENT);  
		        //set 四周距离  
		        paramstv.setMargins(5, 5, 5, 5);  
		       
		        tv_time.setLayoutParams(paramstv);  
		          
		        
		
	}

	public MyCustomScrollView_FriendsCircle(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO 自动生成的构造函数存根
	}

	public MyCustomScrollView_FriendsCircle(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO 自动生成的构造函数存根
	}
	
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		
		/*if(v.getId()==tv_name.getId()){
			System.out.println("点击监听设置成功。。。啦啦啦");
		}*/
		
		
		//各个视图的id表：0x7f0966**
		//iv_head : 0x7f096601
		//tv_content : 0x7f096602
		//iv_content : 0x7f096603
		//tv_cancel : 0x7f096604
		//iv_comment_bottom : 0x7f096609
		
		switch (v.getId()) {
			
		case 0x7f096601:
			System.out.println("点击了头像。。。啦啦啦");
			break;
		case 0x7f096602:

			System.out.println("点击了文本内容。。。啦啦啦");
			break;
		case 0x7f096603:

			System.out.println("点击了单图内容。。。啦啦啦");
			break;
		case 0x7f096604:

			System.out.println("点击了删除。。。啦啦啦");
			break;
			
		case R.id.ll1_popup:
			if (pw_comment != null){   
				pw_comment.dismiss();  
        	} 
			
			System.out.println("测试成功ll1。。。啦啦啦");
			break;
		case R.id.ll2_popup:
			
			if(pw_comment!= null){   
				pw_comment.dismiss();  
        	} 
			
	             
			System.out.println("测试成功ll2。。。啦啦啦"+"inputMethodManager : ");


			RelativeLayout rl_main_for_edit = (RelativeLayout)((Activity)this.getContext()).findViewById(R.id.rl_main_for_edit);
			rl_main_for_edit.setVisibility(View.VISIBLE);

		//	LinearLayout ll_bottom_main_for_edit = (LinearLayout)((Activity)this.getContext()).findViewById(R.id.ll_bottom_main_for_edit);
		//	ll_bottom_main_for_edit.setVisibility(View.VISIBLE);
			
			EditText edit_main = (EditText)((Activity)this.getContext()).findViewById(R.id.edit_main);
			 
			edit_main.setFocusable(true);
			edit_main.setFocusableInTouchMode(true);
			edit_main.requestFocus();
			edit_main.requestFocusFromTouch();
			//edit.setfo
			InputMethodManager inputManager =  
	               (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);  
	         //    inputManager.showSoftInput(edit, 0);
			inputManager.toggleSoftInput(0, 1);
//			inputManager.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
			break;
			
		case 0x7f096609:
			
			pw_comment.showAsDropDown(iv_comment_bottom, 
					-375, -iv_comment_bottom.getMeasuredHeight()-5);
			
			//Log.v("TAG", ""+v1.toString());
			//.setOnClickListener(MyLinearLayoutCanClone.this);
			
			//Log.v("TAG",	"pw_comment.getContentView().getMeasuredWidth() : "+pw_comment.getContentView().getMeasuredWidth() );
			System.out.println("点击了评论。。。啦啦啦");
			break;
		case R.id.bt_edit_send:
			
			
			break;
				
		default:
			break;
		}
		
	}

	/*public MyLinearLayoutCanClone clone() {
		MyLinearLayoutCanClone o = null;
		try {
			o = (MyLinearLayoutCanClone) super.clone();// Object 中的clone()识别出你要复制的是哪一个对象。
		} catch (CloneNotSupportedException e) {
			System.out.println(e.toString());
		}
		
		return o;
	}*/

}
