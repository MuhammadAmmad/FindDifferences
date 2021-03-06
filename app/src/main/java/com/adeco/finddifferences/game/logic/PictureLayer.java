package com.adeco.finddifferences.game.logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;

import com.adeco.finddifferences.game.interfaces.DifferenceFoundHandler;
import com.adeco.finddifferences.game.interfaces.Drawable;
import com.adeco.finddifferences.game.interfaces.Touchable;
import com.adeco.finddifferences.game.logic.points.DifferencePoint;
import com.adeco.finddifferences.game.states.GameStateHandler;
import com.adeco.finddifferences.game.states.StateController;
import com.adeco.finddifferences.game.statistics.StatisticHandler;


public class PictureLayer implements Drawable, Touchable, GameStateHandler {
    private TouchManager touchManager;

    public PictureLayer(int width, Bitmap img1, Bitmap img2, DifferencePoint[] diffs, StatisticHandler[] statisticHandlers, DifferenceFoundHandler[] differenceFoundHandlers) {
        int new_width = (width-img1.getWidth())/2;
        Paint paint = new Paint();
        TouchHandler top = new HalfPicture(new Point(new_width, 0), img1, paint);
        TouchHandler bottom = new HalfPicture(new Point(new_width, img1.getHeight()), img2, paint);
        touchManager = new TouchManager(diffs, top, bottom, statisticHandlers, differenceFoundHandlers);
    }

    @Override
    public void draw(Canvas canvas) {
        touchManager.draw(canvas);
    }

    @Override
    public void onTouch(MotionEvent event) {
        if (interactable) {
            touchManager.onTouch(event);
        }
    }

    private boolean interactable = true;

    @Override
    public void onGameStateChanged(StateController.GameState state) {
        interactable = state == StateController.GameState.InProgress;
    }

}
