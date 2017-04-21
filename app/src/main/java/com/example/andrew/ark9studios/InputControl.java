package com.example.andrew.ark9studios;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.GameTouchHandler;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import java.util.List;

import viewports.LayerViewport;
import viewports.ScreenViewport;

/**
 * Created by Megan on 21/04/2017.
 */

public class InputControl extends OverlayObject {



    /***
     * Create new InputControl
     *
     * @param x
     *            - x coordinate starting position
     * @param y
     *            - y coordinate starting position
     * @param width
     *            - width of InputControl Overlay
     * @param height
     *            - height of InputControl Overlay
     * @param bitmap
     *            - InputControl bitmap
     * @param gameScreen
     *            - gameScreen that InputControl overlay belongs to
     */
    public InputControl(float x, float y, float width, float height,
                        Bitmap bitmap, GameScreen gameScreen) {
        super(x, y, width, height, bitmap, gameScreen);
    }

    /***
     * Create new InputControl
     *
     * @param x
     *            - x coordinate starting position
     * @param y
     *            - y coordinate starting position
     * @param width
     *            - width of InputControl Overlay
     * @param height
     *            - height of InputControl Overlay
     * @param bitmap
     *            - InputControl bitmap
     * @param gameScreen
     *            - gameScreen that InputControl overlay belongs to
     * @param drawSourceRect
     *            - specified rectangle from bitmap to draw
     */
    public InputControl(float x, float y, float width, float height,
                        Bitmap bitmap, GameScreen gameScreen, Rect drawSourceRect) {
        super(x, y, width, height, bitmap, gameScreen, drawSourceRect);
    }

    /***
     * Determine if this control has been activated (touched).
     *
     * @return boolean true if the control has been touched, false otherwise
     */
    public boolean isActivated() {

        // Consider any touch events occurring in this update
        Input input = gameScreen.getmGame().getInput();

        // Check if any of the touch events were on this control
        BoundingBox bound = getBound();
        for (int idx = 0; idx < GameTouchHandler.MAX_NO_TOUCHPOINTS; idx++) {
            if (input.existsTouch(idx)) {
                if (bound.contains(input.getTouchX(idx), input.getTouchY(idx))) {
                    return true;
                }
            }
        }

        return false;
    }

    /***
     * Determine if this control has a touch up action .
     *
     * @return boolean true if the control has a Touch Up, false otherwise
     */
    public boolean hasTouchUp() {
        // Consider any touch events occurring in this update
        Input input = gameScreen.getmGame().getInput();
        // Check if any of the touch events were on this control
        BoundingBox bound = getBound();
        List<GameTouchEvent> touchUpEvents = input
                .touchEventsFor(GameTouchEvent.TOUCH_UP);
        for (GameTouchEvent touchUpEvent : touchUpEvents) {
            if (bound.contains(touchUpEvent.x, touchUpEvent.y)) {
                return true;
            }
        }
        return false;
    }

    /***
     * Draw InputControl
     */
    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface,
                     LayerViewport layerViewport, ScreenViewport screenViewport) {
        // Assumed to be in screen space so just draw the whole thing
        super.draw(elapsedTime, graphics2DInterface, layerViewport, screenViewport);
    }

}
