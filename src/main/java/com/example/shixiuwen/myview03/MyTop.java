package com.example.shixiuwen.myview03;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by shixiuwen on 15-11-2.
 */
public class MyTop extends RelativeLayout {

    private View view;
    private Button btnLeft;
    private Button btnRight;
    private TextView tvTitle;

    private void init(Context context) {

        //用了这个步骤，自定义控件不需要再进行排版，可以在自己抽取的layout.xml中排好，然后相对应的子控件独自设置属性
        view = View.inflate(context, R.layout.layout_topbaar, this);
        btnLeft = (Button) view.findViewById(R.id.btn_left);
        btnRight = (Button) view.findViewById(R.id.btn_right);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
    }

    public MyTop(Context context) {
        super(context);
        init(context);
    }


    public MyTop(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

        //简单方式设置文字内容/排版等简单属性（string）这一步也可直接放在下面的方法中执行
        String NAMESPACE = "http://schemas.android.com/apk/res-auto";
        String leftText = attrs.getAttributeValue(NAMESPACE, "leftText");
        String rightText = attrs.getAttributeValue(NAMESPACE, "rightText");
        String titleText = attrs.getAttributeValue(NAMESPACE, "titleText");

        btnLeft.setText(leftText);
        btnRight.setText(rightText);
        tvTitle.setText(titleText);

        //复杂方式设置字体大小，控件背景等复杂属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Mytop);

        float leftDimension = typedArray.getDimension(R.styleable.Mytop_leftTextSize, 0);
        Drawable leftDrawable = typedArray.getDrawable(R.styleable.Mytop_leftBackground);
        btnLeft.setTextSize(leftDimension);
        btnLeft.setBackground(leftDrawable);

        float rightDimension = typedArray.getDimension(R.styleable.Mytop_rightTextSize, 0);
        Drawable rightDrawable = typedArray.getDrawable(R.styleable.Mytop_rightBackground);
        btnRight.setTextSize(rightDimension);
        btnRight.setBackground(rightDrawable);

        float titleDimension = typedArray.getDimension(R.styleable.Mytop_titleTextSize, 0);
        Drawable titleDrawable = typedArray.getDrawable(R.styleable.Mytop_titleBackground);
        tvTitle.setTextSize(titleDimension);
        tvTitle.setBackground(titleDrawable);


        typedArray.recycle();

        btnLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnclickListener.myLeftOnclickListener();
            }
        });

        btnRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnclickListener.myRightOnclickListener();
            }
        });
    }

    private MyOnclickListenerFace myOnclickListener;

    public interface MyOnclickListenerFace {
        public void myLeftOnclickListener();

        public void myRightOnclickListener();
    }

    public void setMyOnclickListener(MyOnclickListenerFace myOnclickListener) {
        this.myOnclickListener = myOnclickListener;
    }

    public MyTop(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

}
