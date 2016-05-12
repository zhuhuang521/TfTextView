package com.zxs.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zxs on 16/5/12.
 * 一个可以使用字体当做ImageView 的Text
 */
public class TfTextView extends TextView{
    private String srcImage;
    public TfTextView(Context context) {
        this(context,null);
    }

    public TfTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TfTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.TfTextView,defStyleAttr,defStyleAttr);
        String tf = a.getString(R.styleable.TfTextView_typeface);
        if(TextUtils.isEmpty(tf)){
            tf = "iconfont6.ttf";
        }
        int srcId = attrs.getAttributeResourceValue(null,"imageSrc",0);
        if(srcId > 0){
            srcImage = getResources().getString(srcId);
        }else{
            srcImage = a.getString(R.styleable.TfTextView_imageSrc);
        }
        a.recycle();
        //初始化字体或者读取默认字体
        AssetManager assetManager = context.getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager,tf);
        this.setTypeface(typeface);
        this.setText(getResources().getString(R.string.text));
    }

}
