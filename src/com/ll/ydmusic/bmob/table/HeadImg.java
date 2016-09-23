package com.ll.ydmusic.bmob.table;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class HeadImg extends BmobObject {

	
	//private static final long serialVersionUID = -189910393389598932L;

	private String NameImg;
	private BmobFile headimg;
	
	
	public HeadImg(String nameImg, BmobFile headimg) {
		super();
		NameImg = nameImg;
		this.headimg = headimg;
	}
	
	public String getNameImg() {
		return NameImg;
	}
	public void setNameImg(String nameImg) {
		NameImg = nameImg;
	}
	public BmobFile getHeadimg() {
		return headimg;
	}
	public void setHeadimg(BmobFile headimg) {
		this.headimg = headimg;
	}
	public HeadImg() {
		// TODO 自动生成的构造函数存根
	}

}
