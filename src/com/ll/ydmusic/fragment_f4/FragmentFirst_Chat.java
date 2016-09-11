package com.ll.ydmusic.fragment_f4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imooc.weixin6_0.R;

public class FragmentFirst_Chat extends Fragment {




	@Override
	public View getView() {
		// TODO 自动生成的方法存根
		return super.getView();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onActivityCreated(savedInstanceState);
	}

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
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO 自动生成的方法存根
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//不能填container，否则会崩
		View v=inflater.inflate(R.layout.fragment_chat, null);
		TextView tv=(TextView) v.findViewById(R.id.id_tv_fragment_chat);
		tv.isFocused();
		// TODO 自动生成的方法存根
		return v;
	}

	@Override
	public void onDestroy() {
		// TODO 自动生成的方法存根
		super.onDestroy();
	}

	@Override
	public void onDestroyOptionsMenu() {
		// TODO 自动生成的方法存根
		super.onDestroyOptionsMenu();
	}

	@Override
	public void onDestroyView() {
		// TODO 自动生成的方法存根
		super.onDestroyView();
	}

	@Override
	public void onDetach() {
		// TODO 自动生成的方法存根
		super.onDetach();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO 自动生成的方法存根
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onPause() {
		// TODO 自动生成的方法存根
		super.onPause();
	}

	@Override
	public void onResume() {
		// TODO 自动生成的方法存根
		super.onResume();
		TextView tv=(TextView) getActivity().findViewById(R.id.id_tv_fragment_chat);
		tv.isFocused();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO 自动生成的方法存根
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onStart() {
		// TODO 自动生成的方法存根
		super.onStart();
	}

	@Override
	public void onStop() {
		// TODO 自动生成的方法存根
		super.onStop();
	}

	@Override
	public void setArguments(Bundle args) {
		// TODO 自动生成的方法存根
		super.setArguments(args);
	}

	@Override
	public void setMenuVisibility(boolean menuVisible) {
		// TODO 自动生成的方法存根
		super.setMenuVisibility(menuVisible);
	}

	@Override
	public void setRetainInstance(boolean retain) {
		// TODO 自动生成的方法存根
		super.setRetainInstance(retain);
	}

	@Override
	public void setTargetFragment(Fragment fragment, int requestCode) {
		// TODO 自动生成的方法存根
		super.setTargetFragment(fragment, requestCode);
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		// TODO 自动生成的方法存根
		super.setUserVisibleHint(isVisibleToUser);
	}

	@Override
	public void startActivity(Intent intent) {
		// TODO 自动生成的方法存根
		super.startActivity(intent);
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		// TODO 自动生成的方法存根
		super.startActivityForResult(intent, requestCode);
	}

	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return super.toString();
	}

}
