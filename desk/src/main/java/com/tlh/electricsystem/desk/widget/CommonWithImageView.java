package com.tlh.electricsystem.desk.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.tlh.electricsystem.desk.R;

/**
 * 组合控件-单带图片
 */
public class CommonWithImageView extends LinearLayout {

    private TextView tvName;
    private ImageView tvValue;

    public CommonWithImageView(Context context) {
        super(context);
        initView(context);
    }

    public CommonWithImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CommonWithImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.item_common_with_image,this,true);

        tvName = findViewById(R.id.tv_common_image_name);
        tvValue = findViewById(R.id.iv_common_image);
    }

    public void setName(String name){
        if(tvName != null){
            tvName.setText(name);
        }
    }

    public void setValue(int value){
        if(tvValue != null){
            tvValue.setImageResource(value);
        }
    }
}
