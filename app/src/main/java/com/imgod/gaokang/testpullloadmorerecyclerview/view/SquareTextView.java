package com.imgod.gaokang.testpullloadmorerecyclerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * 项目名称：TestPullLoadMoreRecyclerView
 * 包名称：com.imgod.gaokang.testpullloadmorerecyclerview.view
 * 类描述：
 * 创建人：gaokang
 * 创建时间：2016-06-28 14:26
 * 修改人：gaokang
 * 修改时间：2016-06-28 14:26
 * 修改备注：
 */
public class SquareTextView extends TextView{

    public SquareTextView(Context context) {
        super(context);
    }

    public SquareTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
