package com.example.tasklist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView {
    public interface ScrollToBottomListener {
        void onScrollToBottom(CustomScrollView scrollView, int p);
    }

    private ScrollToBottomListener scrollToBottomListener;
    private int scrollBottomMargin = 0;

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defs) {
        super(context, attrs, defs);
    }

    public void setScrollToBottomListener(ScrollToBottomListener listener) {
        this.scrollToBottomListener = listener;
    }

    public void setScrollBottomMargin(int value) {
        this.scrollBottomMargin = value;
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        scrollToBottomListener.onScrollToBottom(this, y);
    }  
}
