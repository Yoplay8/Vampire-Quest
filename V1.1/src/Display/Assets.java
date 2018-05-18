package Display;

import java.awt.image.BufferedImage;

// Assests cuts out a few images that can be called on to use in the game.
public class Assets
{

	// This is the dimension of the image being cut out.
	private static final int WIDTH = 32, HEIGHT = 32;
	
	// These hold the cut out image.
	public static BufferedImage Grass, Tree_N_Grass, Tree;
	public static BufferedImage[][] Player_Moves = new BufferedImage[4][3];
	public static BufferedImage Player_Idle;
	public static BufferedImage[] Btn_Start = new BufferedImage[9];
	
	// This will change in size as we add more enemies. First num is the number of enemies and 2nd num is the frames for the enemy.
	public static BufferedImage[][] Enemies = new BufferedImage[1][4];
	
	// Gets the large image and cuts 3 sections to get my characters.
	public static void Init()
	{
		
		// My large image
		Sprite_Sheet Sheet_1 = new Sprite_Sheet(Image_Loader.Load_Image("/Textures/Noz.png"));
		
		for(int Moves = 0; Moves < Player_Moves.length; Moves++)
		{
			
			for(int Frames = 0; Frames < Player_Moves[0].length; Frames++)
				Player_Moves[Moves][Frames] = Sheet_1.Crop(WIDTH * Frames, HEIGHT * Moves, WIDTH, HEIGHT);
			
		}
		
		Player_Idle = Sheet_1.Crop(WIDTH * 0, HEIGHT * 4, WIDTH, HEIGHT);

		
		
		Sprite_Sheet Sheet_2 = new Sprite_Sheet(Image_Loader.Load_Image("/Textures/Grass.png"));
		
		Grass = Sheet_2.Crop(WIDTH * 0, HEIGHT * 0, WIDTH, HEIGHT);
		
		
		Sprite_Sheet Sheet_3 = new Sprite_Sheet(Image_Loader.Load_Image("/Textures/Tree_obstacle_w_grass.png"));
		
		Tree_N_Grass = Sheet_3.Crop(WIDTH * 0, HEIGHT * 0, WIDTH, HEIGHT);
		
		Sprite_Sheet Sheet_4 = new Sprite_Sheet(Image_Loader.Load_Image("/Textures/Tree.png"));
		
		Tree = Sheet_4.Crop(WIDTH * 0, HEIGHT * 0, WIDTH, HEIGHT);
		
		Sprite_Sheet Sheet_5 = new Sprite_Sheet(Image_Loader.Load_Image("/Textures/New_Piskel.png"));
		
		for(int Rows = 0, Index = 0; Rows < 3; Rows++)
		{
			
			for(int Columns = 0; Columns < 3; Columns++, Index++)
				Btn_Start[Index] = Sheet_5.Crop(64 * Columns, 64 * Rows, 64, 64);
			
		}
		
		Sprite_Sheet Sheet_6 = new Sprite_Sheet(Image_Loader.Load_Image("/Textures/slime.png"));
		
		for(int Rows = 0, Index = 0; Rows < Enemies.length; Rows++)
		{
			
			for(int Columns = 0; Columns < Enemies[Rows].length; Columns++, Index++)
				Enemies[Rows][Columns] = Sheet_6.Crop(WIDTH * Columns, HEIGHT * Rows, WIDTH, HEIGHT);
			
		}
		
	}
	
}
