package com.example.andrew.ark9studios.GameGraphics;

import android.graphics.Bitmap;
import android.graphics.Rect;

/***
 * 
 * Represents a sheet that is made up of multiple images. This class will keep
 * track of the position currently (x,y) coord in the spriteSheet and will be
 * used for animation purposes and picking out specific images from a sheet of
 * images.
 * 
 */
public class SpriteSheet {

	/***
	 * Width of each Sprite in the Sheet (optional)
	 */
	private int spriteWidth;

	/***
	 * Height of each Sprite in the Sheet (optional)
	 */
	private int spriteHeight;

	/***
	 * Current X position with the SpriteSheet
	 */
	private int x;

	/***
	 * Current Y position with the SpriteSheet
	 */
	private int y;

	/***
	 * Bitmap that consists of multiple images
	 */
	private Bitmap bitmap;

	/***
	 * Create a SpriteSheet that has a consistent spriteWidth and spriteHeight
	 * (Used for perfectly uniform spritesheets)
	 * 
	 * @param bitmap
	 *            - bitmap that consists of sheet of images
	 * @param spriteWidth
	 *            - width of each image in the spritesheet
	 * @param spriteHeight
	 *            - height of each image in the spritesheet
	 */
	public SpriteSheet(Bitmap bitmap, int spriteWidth, int spriteHeight) {
		this.bitmap = bitmap;
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
	}

	/***
	 * Create a SpriteSheet with the bitmap that makes up the sheet of images
	 * 
	 * @param bitmap
	 *            - bitmap that consists of sheet of images
	 */
	public SpriteSheet(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	/***
	 * Accessor for x coordinate
	 * 
	 * @return the x coordinate currently at in the image sheet
	 */
	public int getX() {
		return x;
	}

	/***
	 * Mutator for X coordinate
	 * 
	 * @param x
	 *            - set x coordinate to look at in the image sheet
	 */
	public void setX(int x) {
		this.x = x;
	}

	/***
	 * Accessor for y coordinate
	 * 
	 * @return the y coordinate currently at in the image sheet
	 */
	public int getY() {
		return y;
	}

	/***
	 * Mutator for Y coordinate
	 * 
	 * @param y
	 *            - set y coordinate to look at in the image sheet
	 */
	public void setY(int y) {
		this.y = y;
	}

	/***
	 * Return the width of each sprite (0 if undefined).
	 * 
	 * @return will return width of each image, of 0 if undefined
	 */
	public int getSpriteWidth() {
		return spriteWidth;
	}

	/***
	 * Return the height of each sprite (0 if undefined).
	 * 
	 * @return will return height of each image, of 0 if undefined
	 */
	public int getSpriteHeight() {
		return spriteHeight;
	}

	/***
	 * Return the bitmap that makes up the image sheet
	 * 
	 * @return bitmap that is made up of multiple images
	 */
	public Bitmap getBitmap() {
		return bitmap;
	}

	/***
	 * Slice a Rectangle for a uniform spritesheet for with the internal (x,y)
	 * coordinate held in variables x and y, as well as using the defined
	 * spriteWidth and spriteHeight to calculate the Source Rect accordingly.
	 * 
	 * @return rectangle calculated based on the internal defined (x,y) position
	 *         and the sprite width and sprite height properties.
	 */
	public Rect bitmapDrawSourceRect() {
		// Define the source rectangle
		int startSpriteX = x * spriteWidth;
		int startSpriteY = y * spriteHeight;
		return new Rect(startSpriteX, startSpriteY, startSpriteX + spriteWidth,
				startSpriteY + spriteHeight);
	}

	/***
	 * Slice a Rectangle for a uniform spritesheet for a given (x,y) coordinate
	 * and using the defined spriteWidth and spriteHeight to calculate the
	 * Source Rect accordingly
	 * 
	 * @param x
	 *            - x coordinate of image in spritesheet want to slice
	 * @param y
	 *            - y coordinate of image in spritesheet want to slice
	 * @return rectangle calculated based on the parameter defined (x,y)
	 *         position and the sprite width and sprite height properties.
	 */
	public Rect bitmapDrawSourceRectAt(int x, int y) {
		// Define the source rectangle
		int startSpriteX = x * spriteWidth;
		int startSpriteY = y * spriteHeight;
		return new Rect(startSpriteX, startSpriteY, startSpriteX + spriteWidth,
				startSpriteY + spriteHeight);
	}

	/***
	 * Return a Rectangle with of a parameter defined width and height, from a
	 * defined (x,y) coordinate
	 * 
	 * TODO Time Permitting: Probably shouldn't be in this class and should be
	 * in GraphicsHelper.
	 * 
	 * @param x
	 *            - x coordinate to start slice from
	 * @param y
	 *            - y coordinate to slice from
	 * @param width
	 *            - width of slice to calculate
	 * @param height
	 *            - height of slice to calculate
	 * @return rectangle of dimensions [x, y, x + width, y + height]
	 */
	public Rect bitmapDrawSourceRectAt(int x, int y, int width, int height) {
		// Define the source rectangle
		return new Rect(x, y, x + width, y + height);
	}

	/***
	 * Return a Rectangle with of a parameter defined left, top, right and
	 * bottom
	 * 
	 * TODO Time Permitting: Probably shouldn't be in this class and should be
	 * in GraphicsHelper.
	 * 
	 * @param left
	 *            - x coordinate to start slice from
	 * @param top
	 *            - y coordinate to slice from
	 * @param right
	 *            - width of slice to calculate
	 * @param bottom
	 *            - height of slice to calculate
	 * @return rectangle of dimensions [left, top, right, bottom]
	 */
	public Rect bitmapDrawSourceRect(int left, int top, int right, int bottom) {
		return new Rect(left, top, right, bottom);
	}

}
