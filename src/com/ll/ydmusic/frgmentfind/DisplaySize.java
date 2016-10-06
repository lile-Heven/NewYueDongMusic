package com.ll.ydmusic.frgmentfind;

import android.content.Context;
import android.util.Log;

public class DisplaySize {

	public static  int width_gridview_singlecoloumn=120;
	
	public static int width_0_618_OfDisplay=360;
	public DisplaySize(Context context) {
		// TODO �Զ���ɵĹ��캯����
		
		Log.v("TAG","width_gridview_singlecoloumn before init: " +width_gridview_singlecoloumn);
		width_gridview_singlecoloumn =context.getResources().getDisplayMetrics().widthPixels/5;
		Log.v("TAG","width_gridview_singlecoloumn after init: " +width_gridview_singlecoloumn);
		
		
		Log.v("TAG","width_0_618_OfDisplay before init: " +width_0_618_OfDisplay);
		width_0_618_OfDisplay =(int) (context.getResources().getDisplayMetrics().widthPixels*0.618);
		Log.v("TAG","width_0_618_OfDisplay after init: " +width_0_618_OfDisplay);
		
	}

}
