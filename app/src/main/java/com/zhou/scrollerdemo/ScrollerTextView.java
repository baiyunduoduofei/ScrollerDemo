package com.zhou.scrollerdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Scroller;

/**
 * @author: zhouyunfei
 * @date: 2018/12/14
 * @desc:
 */
public class ScrollerTextView extends android.support.v7.widget.AppCompatTextView {
    private Scroller mScroller;

    public ScrollerTextView(Context context) {
        super(context);
        init(context);
    }

    public ScrollerTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ScrollerTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mScroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }


    /***
     * 从当前位置平滑移动
     * @param destX 目的位置 X
     * @param destY 目的位置 Y
     * @param milliseconds 时间 （毫秒）
     */
    public void smoothScrollTo(int destX, int destY, int milliseconds) {
        int scrollX = mScroller.getCurrX();
        int scrollY = mScroller.getCurrY();
        mScroller.startScroll(scrollX, scrollY, destX - scrollX, destY - scrollY,milliseconds);
        invalidate();
    }


}
