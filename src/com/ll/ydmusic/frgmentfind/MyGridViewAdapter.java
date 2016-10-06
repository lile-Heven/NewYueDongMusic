package com.ll.ydmusic.frgmentfind;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;

public class MyGridViewAdapter extends BaseAdapter {

	Context context;
	ArrayList<Bitmap> data;
	
	public MyGridViewAdapter(Context context, ArrayList<Bitmap> data) {
		super();
		this.context = context;
		this.data = data;
	}

	public MyGridViewAdapter() {
		// TODO �Զ���ɵĹ��캯����
	}

	@Override
	public int getCount() {
		// TODO �Զ���ɵķ������
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO �Զ���ɵķ������
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO �Զ���ɵķ������
		return position;
	}

	@SuppressWarnings("deprecation")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO �Զ���ɵķ������
		ImageView iv=new ImageView(context);
		iv.setImageBitmap(data.get(position));

		//Drawable drawable = new BitmapDrawable(data.get(position));
		
		//iv.setBackground(drawable);
		
		int size = (DisplaySize.width_gridview_singlecoloumn*3-20)/3;//���ǵ��м��10dp
		
		LayoutParams params=new LayoutParams(size, size);
		params.gravity=Gravity.CENTER;
		
		iv.setLayoutParams(params);
		iv.setScaleType(ScaleType.CENTER_CROP);
		
		return iv;
	}

}
