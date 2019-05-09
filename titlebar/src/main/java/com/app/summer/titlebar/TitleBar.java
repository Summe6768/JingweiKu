package com.app.summer.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.summer.titlebar.Interface.OnClickListenerImgLeftBack;

/**
 * @author: Summer
 * @date: 2019/5/8
 */
public class TitleBar extends LinearLayout implements View.OnClickListener {

    private String mTitleText;
    private int mTitleBg;

    private RelativeLayout mRlBg;
    private TextView mTvTitle;
    private ImageView mImgLeftBack;

    private OnClickListenerImgLeftBack onClickListenerImgLeftBack;

    public TitleBar(Context context) {
        super(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);

        mTitleText = typedArray.getString(R.styleable.TitleBar_titleText);
        mTitleBg = typedArray.getColor(R.styleable.TitleBar_titleBg,0xffff0000);

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

        mRlBg.setBackgroundColor(mTitleBg);
        mTvTitle.setText(mTitleText);

        mImgLeftBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.imgLeftBack) {
            if (onClickListenerImgLeftBack != null){
                onClickListenerImgLeftBack.OnClickImgLeftBack();
            }
        }
    }


    public void setOnClickListenerImgLeftBack(OnClickListenerImgLeftBack onClickListenerImgLeftBack) {
        this.onClickListenerImgLeftBack = onClickListenerImgLeftBack;
    }
}
