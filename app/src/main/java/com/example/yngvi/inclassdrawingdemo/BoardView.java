package com.example.yngvi.inclassdrawingdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class BoardView extends View {

    private int m_cellWidth;
    private int m_cellHeight;

    private Rect m_rect = new Rect();
    private Paint m_paint = new Paint();

    private RectF m_circle = new RectF();
    private Paint m_paintCircle = new Paint();

    private final int NUM_CELLS = 6;

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m_paint.setColor(Color.BLACK);
        m_paint.setStyle(Paint.Style.STROKE);
        m_paint.setStrokeWidth(2);
        m_paint.setAntiAlias(true);

        m_paintCircle.setColor(Color.RED);
        m_paintCircle.setStyle(Paint.Style.FILL_AND_STROKE);
        m_paintCircle.setAntiAlias(true);

    }

    @Override
    protected void onMeasure( int widthMeasureSpec, int heightMeasureSpec ) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width  = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        int height = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        int size = Math.min(width, height);
        setMeasuredDimension(size + getPaddingLeft() + getPaddingRight(),
                size + getPaddingTop() + getPaddingBottom());
    }

    @Override
    protected void onSizeChanged( int xNew, int yNew, int xOld, int yOld ) {
        int   boardWidth = (xNew - getPaddingLeft() - getPaddingRight());
        int   boardHeight = (yNew - getPaddingTop() - getPaddingBottom());
        m_cellWidth = boardWidth / NUM_CELLS;
        m_cellHeight = boardHeight / NUM_CELLS;
        //m_rect.set(0, 0, boardWidth, boardHeight );
        //m_rect.offset( getPaddingLeft(), getPaddingTop());
    }

    @Override
    protected void onDraw( Canvas canvas ) {
        canvas.drawRect(m_rect, m_paint);

        for ( int row = 0; row < NUM_CELLS; ++row ) {
            for ( int col = 0; col < NUM_CELLS; ++col ) {
                int x = col * m_cellWidth;
                int y = row * m_cellHeight;
                m_rect.set( x, y, x + m_cellWidth, y + m_cellHeight );
                m_rect.offset( getPaddingLeft(), getPaddingTop() );
                canvas.drawRect( m_rect, m_paint );
            }
        }

        m_circle.set( 0, 0, m_cellWidth, m_cellHeight );
        m_circle.offset( getPaddingLeft(), getPaddingTop() );
        m_circle.inset( m_cellWidth * 0.1f, m_cellHeight * 0.1f );
        canvas.drawOval( m_circle, m_paintCircle );
    }

}
