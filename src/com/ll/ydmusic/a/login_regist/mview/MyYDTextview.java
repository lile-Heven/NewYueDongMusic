package com.ll.ydmusic.a.login_regist.mview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.imooc.weixin6_0.R;

public class MyYDTextview extends View {
	
	private boolean Flag_forever = true;

	private boolean Flag_atfirst = true;
	private int mTime = 0;
	private String mText = "无";
	private int randomAlpha = 255;
	/*
	 * private int mTextSize = (int) TypedValue.applyDimension(
	 * TypedValue.COMPLEX_UNIT_SP, 24, getResources().getDisplayMetrics());
	 */
	private int mTextSize;
	private boolean mColor_Random = false;

	private Rect mTextBound;
	private Paint mTextPaint = null;

	private int mColor;

	private int distance = 800;

	private int mDeadTime = 400;

	private Thread thread = new Thread(new Runnable() {

		@Override
		public void run() {
			Log.v("TAG", "run!");
			// 改为true则无限循环
			// while (mTime < 200) {
			while (mTime < mDeadTime) {
				mTime++;

				if (mTime == 20) {
					Flag_atfirst = false;
				}

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

				// MyYDTextview.this.onDraw();
				postInvalidate();
			}

		}
	});

	public MyYDTextview(Context context) {
		// super(context);
		this(context, null);
		// TODO 自动生成的构造函数存根
		Log.v("TAG", "Context context!");
	}

	public MyYDTextview(Context context, AttributeSet attrs) {
		// super(context, attrs);
		this(context, attrs, 0);

		// TODO 自动生成的构造函数存根
		Log.v("TAG", "Context context, AttributeSet attrs!");

	}

	public MyYDTextview(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.MyYDTextview);

		int n = a.getIndexCount();

		for (int i = 0; i < n; i++) {
			int attr = a.getIndex(i);
			switch (attr) {
			case R.styleable.MyYDTextview_text_ran:
				mText = a.getString(attr);
				break;
			case R.styleable.MyYDTextview_text_color:
				mColor = a.getColor(attr, 0xFF45C01A);
				break;
			case R.styleable.MyYDTextview_text_size_ran:
				// mColor = a.getColor(attr, 0xFF45C01A);
				mTextSize = (int) a.getDimension(attr, TypedValue
						.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12,
								getResources().getDisplayMetrics()));
				break;
			case R.styleable.MyYDTextview_text_color_random:
				mColor_Random = a.getBoolean(attr, false);
				break;
			/*
			 * case R.styleable.ChangeColorIconWithText_color: mColor =
			 * a.getColor(attr, 0xFF45C01A); break; case
			 * R.styleable.ChangeColorIconWithText_text: mText =
			 * a.getString(attr); break; case
			 * R.styleable.ChangeColorIconWithText_text_size: mTextSize = (int)
			 * a.getDimension(attr, TypedValue
			 * .applyDimension(TypedValue.COMPLEX_UNIT_SP, 12,
			 * getResources().getDisplayMetrics())); break;
			 */
			}

		}

		a.recycle();

		// 获取text内容结果的尺寸
		mTextBound = new Rect();

		mTextPaint = new Paint();
		mTextPaint.setTextSize(mTextSize);
		mTextPaint.setColor(0Xff555555);
		// 把测量text的结果放到mTextBound里面
		mTextPaint.getTextBounds(mText, 0, mText.length(), mTextBound);

		// Thread ranThread =
		thread.start();

	}

	public void setVisibleGone() {
		this.setVisibility(View.GONE);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		// TODO 自动生成的方法存根
		super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO 自动生成的方法存根
		// super.onDraw(canvas);

		/*
		 * canvas.drawBitmap(mIconBitmap, null, mIconRect, null);
		 * 
		 * int alpha = (int) Math.ceil(255 * mAlpha);
		 * 
		 * // 内存去准备mBitmap , setAlpha , 纯色 ，xfermode ， 图标
		 * setupTargetBitmap(alpha); // 1、绘制原文本 ； 2、绘制变色的文本
		 * drawSourceText(canvas, alpha); drawTargetText(canvas, alpha);
		 * 
		 * canvas.drawBitmap(mBitmap, 0, 0, null);
		 */
		// Paint p=new Paint();

		mTextPaint.setAntiAlias(true);

		//Log.v("TAG", randomAlpha + "");

		mTextPaint.setTextSize(mTextSize);

		// int x = getMeasuredWidth() / 2 - mTextBound.width() / 2;
		// int y = mIconRect.bottom + mTextBound.height();
		if (mColor_Random) {

			mTextPaint.setARGB((int) (Math.random() * 256),
					(int) (Math.random() * 256), (int) (Math.random() * 256),
					(int) (Math.random() * 256));
		} else {
			mTextPaint.setColor(mColor);

			mTextPaint.setAlpha(randomAlpha = (int) (Math.random() * 256));
		}

		if (Flag_atfirst) {
			canvas.drawText(mText, getMeasuredWidth() / 2 - mTextBound.width()
					/ 2, mTextBound.height(), mTextPaint);
		} else {
			if (mTime == mDeadTime) 
			{
				canvas.drawText(mText,
						getMeasuredWidth() / 2 - mTextBound.width() / 2,
						getMeasuredHeight() / 2+mTextBound.height()/2, mTextPaint);

			}else
			{
				// int ranDistance=(int) (Math.random()*distance);
				canvas.drawText(
						mText,
						getMeasuredWidth()
								/ 2
								- mTextBound.width()
								/ 2
								+ (int) ((Math.random() - Math.random()) * distance),
						mTextBound.height()
								+ (int) ((Math.random() - Math.random()) * distance),
						mTextPaint);
				
			}
			
		}

	}

}
