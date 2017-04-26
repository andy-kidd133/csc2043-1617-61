package com.example.andrew.ark9studios;

import android.graphics.Bitmap;
/***
 * 
 * Factory that exposes static methods for creating key Game Objects easily
 * 
 */
public class GameObjectFactory {




	/***
	 * Create a new InputControl
	 *
	 * @param x
	 *            - starting x coordinate
	 * @param y
	 *            - starting y coordinate
	 * @param bitmap
	 *            - bitmap to be drawn
	 * @param width
	 *            - InputControl width
	 * @param height
	 *            - InputControl height
	 * @param gameScreen
	 *            - gameScreen belongs to
	 * @return new InputControl instance
	 */
	public static InputControl createInputControl(float x, float y,
												  Bitmap bitmap, float width, float height, GameScreen gameScreen) {
		return new InputControl(x, y, width, height, bitmap, gameScreen);
	}




}
