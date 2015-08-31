package com.example.yngvi.inclassdrawingdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class BoardView extends View {

    Rect m_rect = new Rect();
    Paint m_paint = new Paint();

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m_paint.setColor(Color.BLACK);
        m_paint.setStyle(Paint.Style.STROKE);
        m_paint.setStrokeWidth( 2 );
        m_paint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure( int widthMeasureSpec, int heightMeasureSpec ) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /*
        int width  = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        int height = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        int size = Math.min(width, height);
        setMeasuredDimension(size + getPaddingLeft() + getPaddingRight(),
                size + getPaddingTop() + getPaddingBottom());
        */
    }

    @Override
    protected void onSizeChanged( int xNew, int yNew, int xOld, int yOld ) {
        int   boardWidth = (xNew - getPaddingLeft() - getPaddingRight());
        int   boardHeight = (yNew - getPaddingTop() - getPaddingBottom());
        m_rect.set(0, 0, boardWidth, boardHeight );
        m_rect.offset( getPaddingLeft(), getPaddingTop());
    }

    @Override
    protected void onDraw( Canvas canvas ) {
        canvas.drawRect( m_rect, m_paint );
    }
    }
