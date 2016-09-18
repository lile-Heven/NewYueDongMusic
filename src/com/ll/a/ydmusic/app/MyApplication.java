package com.ll.a.ydmusic.app;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import android.app.Application;
import android.content.res.Configuration;

public class MyApplication extends Application {

	public MyApplication() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void onCreate() {
		// TODO 自动生成的方法存根
		super.onCreate();
		 //只有主进程运行的时候才需要初始化
        if (getApplicationInfo().packageName.equals(getMyProcessName())){
            //im初始化
           // BmobIM.init(this);
            //注册消息接收器
          //  BmobIM.registerDefaultMessageHandler(new DemoMessageHandler());
        }
        
        
        
        //调用setOnConnectStatusChangeListener方法即可监听到当前长链接的连接状态
        /*BmobIM.getInstance().setOnConnectStatusChangeListener(
        		new ConnectStatusChangeListener() {
            @Override
            public void onChange(ConnectionStatus status) {
                Logger.i("" + status.getMsg());
            }
        });*/
        
	}
	
	 /**
     * 获取当前运行的进程名
     * @return
     */
    public static String getMyProcessName() {
        try {
            File file = new File("/proc/" + android.os.Process.myPid() + "/" + "cmdline");
            BufferedReader mBufferedReader = new BufferedReader(new FileReader(file));
            String processName = mBufferedReader.readLine().trim();
            mBufferedReader.close();
            return processName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	@Override
	public void onTerminate() {
		// TODO 自动生成的方法存根
		super.onTerminate();
		//调用disConnect方法，客户端会断开与服务器之间的连接，
		//再次聊天需要重新调用connect方法完成与服务器之间的连接。
	//	BmobIM.getInstance().disConnect();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO 自动生成的方法存根
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onLowMemory() {
		// TODO 自动生成的方法存根
		super.onLowMemory();
	}
	
}
