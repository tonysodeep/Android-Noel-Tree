package com.example.androidcustomviewnoeltree.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {
    private Paint mPaintLeaf;
    private Paint mPaintTree;
    private Rect mRectTree;
    private Paint mDecorRed;
    private Paint mDecorYellow;
    private Paint mTextPaint;
    Point point1_draw;
    Point point2_draw;
    Point point3_draw;

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){
        mPaintLeaf = new Paint();
        mPaintLeaf.setStrokeWidth(2);
        mPaintLeaf.setColor(Color.GREEN);
        mPaintLeaf.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaintLeaf.setAntiAlias(true);

        mPaintTree = new Paint();
        mPaintTree.setColor(Color.DKGRAY);
        mPaintTree.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaintTree.setAntiAlias(true);
        mPaintTree.setStrokeWidth(2);

        mDecorRed = new Paint();
        mDecorRed.setStrokeWidth(2);
        mDecorRed.setColor(Color.RED);
        mDecorRed.setStyle(Paint.Style.FILL_AND_STROKE);
        mDecorRed.setAntiAlias(true);

        mDecorYellow = new Paint();
        mDecorYellow.setStrokeWidth(2);
        mDecorYellow.setColor(Color.YELLOW);
        mDecorYellow.setStyle(Paint.Style.FILL_AND_STROKE);
        mDecorYellow.setAntiAlias(true);

        mTextPaint = new Paint();
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setTextSize(40f);

        mRectTree = new Rect();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("Nguyễn Gia Hy",700f,100f,mTextPaint);
        canvas.drawText("Nguyễn Quang Huy",700f,200f,mTextPaint);
        canvas.drawText("Trần Ngọc Phương",700f,300f,mTextPaint);
        drawTriangle(250,600,600,400,false, mPaintLeaf,canvas);
        drawTriangle(250,800,600,400,false, mPaintLeaf,canvas);
        drawTriangle(250,1000,600,400,false, mPaintLeaf,canvas);
        drawTriangle(250,1200,600,400,false, mPaintLeaf,canvas);
        drawTree(canvas);
        canvas.drawCircle(500f,400f,50f,mDecorRed);
        canvas.drawCircle(450f,600f,50f,mDecorYellow);
        canvas.drawCircle(600f,700f,50f,mDecorRed);
        canvas.drawCircle(450f,900f,50f,mDecorYellow);
    }

    private void drawTree(Canvas canvas){
        mRectTree.left = 500;
        mRectTree.top = 1200;
        mRectTree.right = 600;
        mRectTree.bottom = 1400;
        canvas.drawRect(mRectTree,mPaintTree);
    }
    private void drawTriangle(int x, int y, int width, int height, boolean inverted, Paint paint, Canvas canvas){

        point1_draw = new Point(x,y);
        int pointX = x + width/2;
        int pointY = inverted?  y + height : y - height;

        point2_draw = new Point(pointX,pointY);
        point3_draw = new Point(x+width,y);


        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(point1_draw.x,point1_draw.y);
        path.lineTo(point2_draw.x,point2_draw.y);
        path.lineTo(point3_draw.x,point3_draw.y);
        path.close();

        canvas.drawPath(path, paint);
    }
}
