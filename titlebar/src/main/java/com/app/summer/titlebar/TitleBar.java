package com.app.summer.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.app.summer.titlebar.Interface.OnClickListenerImgLeft;
import com.app.summer.titlebar.Interface.OnClickListenerRight;


public class TitleBar extends LinearLayout implements View.OnClickListener {

    private int mTitleBg;

    private int mTitleLeftImg;

    private String mTitleText;
    private int mTitleTextColor;
    private int mTitleTextSize;

    private String mTitleRight;
    private int mTitleRightColor;
    private int mTitleRightTextSize;
/*************************************/
    private RelativeLayout mRlBg;
    private TextView mTvTitle;
    private ImageView mImgLeftBack;
    private TextView mTvRight;

    private OnClickListenerImgLeft onClickListenerImgLeft;
    private OnClickListenerRight onClickListenerRight;

    public TitleBar(Context context) {
        super(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);

        mTitleBg = typedArray.getColor(R.styleable.TitleBar_titleBg, 0xFF000000);

        mTitleLeftImg = typedArray.getResourceId(R.styleable.TitleBar_titleLeftImg, R.mipmap.titlebar_back);

        mTitleText = typedArray.getString(R.styleable.TitleBar_titleText);
        mTitleTextColor = typedArray.getColor(R.styleable.TitleBar_titleTextColor, 0xFFFFFFFF);
        mTitleTextSize = typedArray.getInteger(R.styleable.TitleBar_titleTextSize,15);

        mTitleRight = typedArray.getString(R.styleable.TitleBar_titleRight);
        mTitleRightColor = typedArray.getColor(R.styleable.TitleBar_titleRightColor, 0xFFFFFFFF);
        mTitleRightTextSize = typedArray.getInteger(R.styleable.TitleBar_titleRightTextSize,15);

        typedArray.recycle();

        initView();
    }


    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView() {
        View.inflate(getContext(), R.layout.layout_titlebar, this);

        mRlBg = findViewById(R.id.rlBg);
        mImgLeftBack = findViewById(R.id.imgLeftBack);
        mTvTitle = findViewById(R.id.tvTitle);
        mTvRight = findViewById(R.id.tvRight);

        //设置属性
        setAttributes();

        //事件
        mImgLeftBack.setOnClickListener(this);
        mTvRight.setOnClickListener(this);

    }

    private void setAttributes() {
        //TitleBar背景
        mRlBg.setBackgroundColor(mTitleBg);
        //左边图片
        mImgLeftBack.setImageResource(mTitleLeftImg);
        //中间属性
        mTvTitle.setText(mTitleText);
        mTvTitle.setTextColor(mTitleTextColor);
        mTvTitle.setTextSize(mTitleTextSize);
        mTvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX,mTitleTextSize); //px
        mTvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,mTitleTextSize); //SP
        mTvTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP,mTitleTextSize);//DIP
        //右边属性
        mTvRight.setText(mTitleRight);
        mTvRight.setTextColor(mTitleRightColor);
        mTvRight.setTextSize(TypedValue.COMPLEX_UNIT_PX,mTitleRightTextSize);
        mTvRight.setTextSize(TypedValue.COMPLEX_UNIT_SP,mTitleRightTextSize);
        mTvRight.setTextSize(TypedValue.COMPLEX_UNIT_DIP,mTitleRightTextSize);
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.imgLeftBack) {
            if (onClickListenerImgLeft != null) {
                onClickListenerImgLeft.OnClickImgLeftBack();
            }
        }
        if (i == R.id.tvRight) {
            if (onClickListenerRight != null) {
                onClickListenerRight.OnClickRight();
            }
        }
    }

    /**
     * 设置左边图片
     * @param resId
     */
    public void setTitleLeftImg(int resId){
        mTitleLeftImg = resId;
        mImgLeftBack.setImageResource(mTitleLeftImg);
    }

    /**
     * 设置中间文字的大小
     * @param size
     */
    public void setTitleTextSize(int size){
        mTitleTextSize = size;
        mTvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX,mTitleTextSize);
        mTvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,mTitleTextSize);
        mTvTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP,mTitleTextSize);
    }

    /**
     * 设置右边文字的大小
     * @param size
     */
    public void setTitleRightTextSize(int size){
        mTitleRightTextSize = size;
        mTvRight.setTextSize(TypedValue.COMPLEX_UNIT_PX,mTitleRightTextSize);
        mTvRight.setTextSize(TypedValue.COMPLEX_UNIT_SP,mTitleRightTextSize);
        mTvRight.setTextSize(TypedValue.COMPLEX_UNIT_DIP,mTitleRightTextSize);
    }


    public void setonClickListenerImgLeft(OnClickListenerImgLeft onClickListenerTitleBar) {
        this.onClickListenerImgLeft = onClickListenerTitleBar;
    }

    public void setOnClickListenerRight(OnClickListenerRight onClickListenerRight) {
        this.onClickListenerRight = onClickListenerRight;
    }
}
