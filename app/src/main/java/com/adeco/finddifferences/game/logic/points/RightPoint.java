package com.adeco.finddifferences.game.logic.points;

import android.graphics.Bitmap;
import android.graphics.Paint;

import com.adeco.finddifferences.game.Consts;
import com.adeco.finddifferences.utils.Graphics;


public class RightPoint extends BitmapPoint {
	private Bitmap bitmap;
    private int width;
    private int height;
    private Paint paint;

    public RightPoint(DifferencePoint dif) {
        super(dif.getX(), dif.getY(), dif.getRadius(), Graphics.difImg, Consts.difPaint);
    }

}
