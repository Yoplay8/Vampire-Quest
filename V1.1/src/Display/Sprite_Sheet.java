package Display;

import java.awt.image.BufferedImage;

// Sprite_Sheet I think is the canvas we call on to place our images.
public class Sprite_Sheet
{
	
	// The canvas.
	private BufferedImage Sheet;
	
	
	// Sets the canvas.
	public Sprite_Sheet(BufferedImage Sheet)
	{
		
		this.Sheet = Sheet;
		
	}

	// Puts the image on the canvas??? or crops the image to be used on canvas.
	public BufferedImage Crop(int X, int Y, int Width, int Height)
	{
		
		return Sheet.getSubimage(X, Y, Width, Height);
		
	}
	
}
