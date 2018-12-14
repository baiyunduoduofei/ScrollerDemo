package com.zhou.scrollerdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ScrollerTextView mScrollerTextView;
    private int mScreenWidth;
    private int mScreenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        mScreenWidth = dm.widthPixels;
        mScreenHeight = dm.heightPixels;
        setContentView(R.layout.activity_main);
        mScrollerTextView = findViewById(R.id.scroll_text);
        mScrollerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //随机生成位置，为了防止View滑出界面，限定范围为距离屏幕100像素内。另外，需要注意Scroller滑动的是内容
                mScrollerTextView.smoothScrollTo(-(new Random().nextInt(mScreenWidth - 200) + 100),
                        -(new Random().nextInt(mScreenHeight - 200) + 100),
                        new Random().nextInt(5000) + 1000);
            }
        });
    }
}
