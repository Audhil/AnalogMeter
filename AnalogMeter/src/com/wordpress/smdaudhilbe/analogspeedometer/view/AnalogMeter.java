package com.wordpress.smdaudhilbe.analogspeedometer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class AnalogMeter extends View {

	private Paint paint;
	private RectF rectF;
	private int radius;
	float sweepAngle;
	
	public AnalogMeter(Context context) {
		super(context);
	}

	public AnalogMeter(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint = new Paint(Paint.FILTER_BITMAP_FLAG | Paint.DITHER_FLAG | Paint.ANTI_ALIAS_FLAG);		
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		
		if(getHeight() > getWidth()){
			radius = getWidth() / 4;
		}
		else{
			radius = getHeight() / 4;
		}
		
		rectF = new RectF();
		rectF.set(getWidth() / 2 - radius, getHeight() / 2 - radius, getWidth() / 2 + radius, getHeight() / 2 + radius);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		paint.setColor(Color.parseColor("#8033b5e5"));
		paint.setStyle(Paint.Style.FILL);
		canvas.drawArc(rectF, 225, sweepAngle, true, paint);
		
		paint.setColor(Color.parseColor("#33b5e5"));
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(5);		
		canvas.drawArc(rectF, 225, sweepAngle, true, paint);
	}

	public void setSweepAngle(int percent) {
		sweepAngle = percent * 0.9f;
	}
}