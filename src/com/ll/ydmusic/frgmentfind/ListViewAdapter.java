package com.ll.ydmusic.frgmentfind;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ListViewAdapter extends BaseAdapter {
	
	private Context context;
	private List data;

	public ListViewAdapter(Context context, List data) {
		super();
		this.context = context;
		this.data = data;
	}

	@Override
	public int getCount() {
		// TODO �Զ���ɵķ������
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO �Զ���ɵķ������
		return (View)data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO �Զ���ɵķ������
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO �Զ���ɵķ������
		
		convertView=((View) data.get(position));
		
		
		Log.v("TAG", "convertView:"+convertView.hashCode());
		return convertView;
	}

}
