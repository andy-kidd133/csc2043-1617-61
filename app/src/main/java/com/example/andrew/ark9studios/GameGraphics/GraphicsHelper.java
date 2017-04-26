package com.example.andrew.ark9studios.GameGraphics;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.BoundingBox;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameObjects;

import viewports.LayerViewport;
import viewports.ScreenViewport;

/***
 * Graphics Helper that contains useful static methods to handle detecting
 * whether a gameObject has entered a viewport, or calculating aspect ratios for
 * viewports
 * 
 */
public final class GraphicsHelper {

	/**
	 * Determine the source bitmap Rect defined by a SpriteSheet and destination
	 * screen Rect if the specified game object bound falls within the layer's
	 * viewport.
	 * 
	 * 
	 * @param gameObject
	 *            Game object instance to be considered
	 * @param layerViewport
	 *            Layer viewport region to check the entity against
	 * @param screenViewport
	 *            Screen viewport region that will be used to draw the
	 * @param sourceRect
	 *            Output Rect holding the region of the bitmap to draw
	 * @param screenRect
	 *            Output Rect holding the region of the screen to draw to
	 * @param spriteSheet
	 *            spriteSheet properties to be considered when calculating
	 *            sourceRect
	 * @return boolean true if the entity is visible, false otherwise
	 */
	public static final boolean getSourceAndScreenRect(GameObjects gameObject,
													   LayerViewport layerViewport, ScreenViewport screenViewport,
													   Rect sourceRect, Rect screenRect, SpriteSheet spriteSheet) {

		if (spriteSheet == null) {
			return false;
		}

		// Get the bounding box for the specified sprite
		BoundingBox spriteBound = gameObject.getBound();

		// retrieve properties from spriteSheet
		int spriteXIndex = spriteSheet.getX();
		int spriteYIndex = spriteSheet.getY();
		int spriteHeight = spriteSheet.getSpriteHeight();
		int spriteWidth = spriteSheet.getSpriteWidth();

		// Determine if the sprite falls within the layer viewport
		if (spriteBound.x - spriteBound.halfWidth < layerViewport.x
				+ layerViewport.halfWidth
				&& spriteBound.x + spriteBound.halfWidth > layerViewport.x
						- layerViewport.halfWidth
				&& spriteBound.y - spriteBound.halfHeight < layerViewport.y
						+ layerViewport.halfHeight
				&& spriteBound.y + spriteBound.halfHeight > layerViewport.y
						- layerViewport.halfHeight) {

			// Use SpriteSheet properties to calculate SourceRect
			int startSpriteX = spriteXIndex * spriteWidth;
			int startSpriteY = spriteYIndex * spriteHeight;
			sourceRect.set(startSpriteX, startSpriteY, startSpriteX
					+ spriteWidth, startSpriteY + spriteHeight);

			// Determine the x- and y-aspect rations between the layer and
			// screen viewports
			float screenXScale = (float) screenViewport.width
					/ (2 * layerViewport.halfWidth);
			float screenYScale = (float) screenViewport.height
					/ (2 * layerViewport.halfHeight);

			// Determine the screen rectangle
			float screenX = screenViewport.left
					+ screenXScale
					* ((spriteBound.x - spriteBound.halfWidth) - (layerViewport.x - layerViewport.halfWidth));
			float screenY = screenViewport.top
					+ screenYScale
					* ((layerViewport.y + layerViewport.halfHeight) - (spriteBound.y + spriteBound.halfHeight));

			screenRect
					.set((int) screenX, (int) screenY,
							(int) (screenX + (spriteBound.halfWidth * 2)
									* screenXScale),
							(int) (screenY + (spriteBound.halfHeight * 2)
									* screenYScale));

			return true;
		}

		// Not visible
		return false;
	}

	/**
	 * Determine the full source bitmap Rect and destination screen Rect if the
	 * specified game object bound falls within the layer's viewport.
	 * 
	 * The return rects are not clipped against the screen viewport.
	 * 
	 * @param gameObject
	 *            Game object instance to be considered
	 * @param layerViewport
	 *            Layer viewport region to check the entity against
	 * @param screenViewport
	 *            Screen viewport region that will be used to draw the
	 * @param sourceRect
	 *            Output Rect holding the region of the bitmap to draw
	 * @param screenRect
	 *            Output Rect holding the region of the screen to draw to
	 * @return boolean true if the entity is visible, false otherwise
	 */
	public static final boolean getSourceAndScreenRect(GameObjects gameObject,
													   LayerViewport layerViewport, ScreenViewport screenViewport,
													   Rect sourceRect, Rect screenRect) {

		// Get the bounding box for the specified sprite
		BoundingBox spriteBound = gameObject.getBound();

		// Determine if the sprite falls within the layer viewport
		if (spriteBound.x - spriteBound.halfWidth < layerViewport.x
				+ layerViewport.halfWidth
				&& spriteBound.x + spriteBound.halfWidth > layerViewport.x
						- layerViewport.halfWidth
				&& spriteBound.y - spriteBound.halfHeight < layerViewport.y
						+ layerViewport.halfHeight
				&& spriteBound.y + spriteBound.halfHeight > layerViewport.y
						- layerViewport.halfHeight) {

			// Define the source rectangle
			Bitmap spriteBitmap = gameObject.getBitmap();
			sourceRect.set(0, 0, spriteBitmap.getWidth(),
					spriteBitmap.getHeight());

			// Determine the x- and y-aspect rations between the layer and
			// screen viewports
			float screenXScale = (float) screenViewport.width
					/ (2 * layerViewport.halfWidth);
			float screenYScale = (float) screenViewport.height
					/ (2 * layerViewport.halfHeight);

			// Determine the screen rectangle
			float screenX = screenViewport.left
					+ screenXScale
					* ((spriteBound.x - spriteBound.halfWidth) - (layerViewport.x - layerViewport.halfWidth));
			float screenY = screenViewport.top
					+ screenYScale
					* ((layerViewport.y + layerViewport.halfHeight) - (spriteBound.y + spriteBound.halfHeight));

			screenRect
					.set((int) screenX, (int) screenY,
							(int) (screenX + (spriteBound.halfWidth * 2)
									* screenXScale),
							(int) (screenY + (spriteBound.halfHeight * 2)
									* screenYScale));

			return true;
		}

		// Not visible
		return false;
	}

	/**
	 * Determine the destination screen Rect with a defined sourceRect if the
	 * specified game object bound falls within the layer's viewport.
	 * 
	 * 
	 * @param gameObject
	 *            Game object instance to be considered
	 * @param layerViewport
	 *            Layer viewport region to check the entity against
	 * @param screenViewport
	 *            Screen viewport region that will be used to draw the
	 * @param sourceRect
	 *            Output Rect holding the region of the bitmap to draw
	 *            (pre-defined)
	 * @param screenRect
	 *            Output Rect holding the region of the screen to draw to
	 * @return boolean true if the entity is visible, false otherwise
	 */
	public static final boolean getScreenRect(GameObjects gameObject,
											  LayerViewport layerViewport, ScreenViewport screenViewport,
											  Rect sourceRect, Rect screenRect) {

		// if source rect not defined, then calculate source and screen Rect
		if (sourceRect == null) {
			return getSourceAndScreenRect(gameObject, layerViewport,
					screenViewport, sourceRect, screenRect);
		}

		// Get the bounding box for the specified sprite
		BoundingBox spriteBound = gameObject.getBound();

		// Determine if the sprite falls within the layer viewport
		if (spriteBound.x - spriteBound.halfWidth < layerViewport.x
				+ layerViewport.halfWidth
				&& spriteBound.x + spriteBound.halfWidth > layerViewport.x
						- layerViewport.halfWidth
				&& spriteBound.y - spriteBound.halfHeight < layerViewport.y
						+ layerViewport.halfHeight
				&& spriteBound.y + spriteBound.halfHeight > layerViewport.y
						- layerViewport.halfHeight) {

			// Define the source rectangle
			sourceRect.set(sourceRect);

			// Determine the x- and y-aspect rations between the layer and
			// screen viewports
			float screenXScale = (float) screenViewport.width
					/ (2 * layerViewport.halfWidth);
			float screenYScale = (float) screenViewport.height
					/ (2 * layerViewport.halfHeight);

			// Determine the screen rectangle
			float screenX = screenViewport.left
					+ screenXScale
					* ((spriteBound.x - spriteBound.halfWidth) - (layerViewport.x - layerViewport.halfWidth));
			float screenY = screenViewport.top
					+ screenYScale
					* ((layerViewport.y + layerViewport.halfHeight) - (spriteBound.y + spriteBound.halfHeight));

			screenRect
					.set((int) screenX, (int) screenY,
							(int) (screenX + (spriteBound.halfWidth * 2)
									* screenXScale),
							(int) (screenY + (spriteBound.halfHeight * 2)
									* screenYScale));

			return true;
		}

		// Not visible
		return false;
	}

	/**
	 * Determine a source bitmap Rect and destination screen Rect if the
	 * specified game object bound falls within the layer's viewport.
	 * 
	 * The returned Rects are clipped against the layer and screen viewport
	 * 
	 * @param gameObject
	 *            Game object instance to be considered
	 * @param layerViewport
	 *            Layer viewport region to check the entity against
	 * @param screenViewport
	 *            Screen viewport region that will be used to draw the
	 * @param sourceRect
	 *            Output Rect holding the region of the bitmap to draw
	 * @param screenRect
	 *            Output Rect holding the region of the screen to draw to
	 * @return boolean true if the entity is visible, false otherwise
	 * @return
	 */
	public static final boolean getClippedSourceAndScreenRect(
			GameObjects gameObject, LayerViewport layerViewport,
			ScreenViewport screenViewport, Rect sourceRect, Rect screenRect) {

		// Get the bounding box for the specified sprite
		BoundingBox spriteBound = gameObject.getBound();

		// Determine if the sprite falls within the layer viewport
		if (spriteBound.x - spriteBound.halfWidth < layerViewport.x
				+ layerViewport.halfWidth
				&& spriteBound.x + spriteBound.halfWidth > layerViewport.x
						- layerViewport.halfWidth
				&& spriteBound.y - spriteBound.halfHeight < layerViewport.y
						+ layerViewport.halfHeight
				&& spriteBound.y + spriteBound.halfHeight > layerViewport.y
						- layerViewport.halfHeight) {

			// Work out what region of the sprite is visible within the layer
			// viewport,
			float sourceX = Math.max(0.0f,
					(layerViewport.x - layerViewport.halfWidth)
							- (spriteBound.x - spriteBound.halfWidth));
			float sourceY = Math.max(0.0f,
					(spriteBound.y + spriteBound.halfHeight)
							- (layerViewport.y + layerViewport.halfHeight));

			float sourceWidth = ((spriteBound.halfWidth * 2 - sourceX) - Math
					.max(0.0f, (spriteBound.x + spriteBound.halfWidth)
							- (layerViewport.x + layerViewport.halfWidth)));
			float sourceHeight = ((spriteBound.halfHeight * 2 - sourceY) - Math
					.max(0.0f, (layerViewport.y - layerViewport.halfHeight)
							- (spriteBound.y - spriteBound.halfHeight)));

			// Determining the scale factor for mapping the bitmap onto this
			// Rect and set the sourceRect value.

			Bitmap spriteBitmap = gameObject.getBitmap();

			float sourceScaleWidth = (float) spriteBitmap.getWidth()
					/ (2 * spriteBound.halfWidth);
			float sourceScaleHeight = (float) spriteBitmap.getHeight()
					/ (2 * spriteBound.halfHeight);

			sourceRect.set((int) (sourceX * sourceScaleWidth),
					(int) (sourceY * sourceScaleHeight),
					(int) ((sourceX + sourceWidth) * sourceScaleWidth),
					(int) ((sourceY + sourceHeight) * sourceScaleHeight));

			// Determine =which region of the screen viewport (relative to the
			// canvas) we will be drawing to.

			// Determine the x- and y-aspect rations between the layer and
			// screen viewports
			float screenXScale = (float) screenViewport.width
					/ (2 * layerViewport.halfWidth);
			float screenYScale = (float) screenViewport.height
					/ (2 * layerViewport.halfHeight);

			float screenX = screenViewport.left
					+ screenXScale
					* Math.max(
							0.0f,
							((spriteBound.x - spriteBound.halfWidth) - (layerViewport.x - layerViewport.halfWidth)));
			float screenY = screenViewport.top
					+ screenYScale
					* Math.max(
							0.0f,
							((layerViewport.y + layerViewport.halfHeight) - (spriteBound.y + spriteBound.halfHeight)));

			// Set the region to the canvas to which we will draw
			screenRect.set((int) screenX, (int) screenY,
					(int) (screenX + sourceWidth * screenXScale),
					(int) (screenY + sourceHeight * screenYScale));

			return true;
		}

		// Not visible
		return false;
	}

	/**
	 * Create a 3:2 aspect ratio screen viewport
	 * 
	 * @param game
	 *            Game view for which the screenport will be defined
	 * @param screenViewport
	 *            Screen viewport to be defined
	 */
	public static void create3To2AspectRatioScreenViewport(Game game,
			ScreenViewport screenViewport) {

		// Create the screen viewport, size it to provide a 3:2 aspect
		float aspectRatio = (float) game.getScreenWidth()
				/ (float) game.getScreenHeight();

		if (aspectRatio > 1.5f) { // 16:10/16:9
			int viewWidth = (int) (game.getScreenHeight() * 1.5f);
			int viewOffset = (game.getScreenWidth() - viewWidth) / 2;
			screenViewport.set(viewOffset, 0, viewOffset + viewWidth,
					game.getScreenHeight());
		} else { // 4:3
			int viewHeight = (int) (game.getScreenWidth() / 1.5f);
			int viewOffset = (game.getScreenHeight() - viewHeight) / 2;
			screenViewport.set(0, viewOffset, game.getScreenWidth(), viewOffset
					+ viewHeight);
		}
	}

	/***
	 * Scale the ScreenViewport to fill the horizontal so that no gaps are left
	 * on rendering to canvas
	 * 
	 * @param game
	 *            - Game view for which the screenport will be defined
	 * @param screenViewport
	 *            - screenViewport to scale horizontally if needed
	 */
	public static void stretchScreenViewportToFillHorizontal(Game game,
			ScreenViewport screenViewport) {
		int leftOffset = screenViewport.left - 0;
		int rightOffSet = game.getScreenWidth() - screenViewport.right;
		screenViewport.set(screenViewport.left - leftOffset,
				screenViewport.top, screenViewport.right + rightOffSet,
				screenViewport.bottom);
	}
}