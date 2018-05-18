package Display;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Animations.Grass_Tile;
import Animations.Rock_Tile;

public class Tile
{
	
	public static Tile[] Tiles = new Tile[256];
	
	public static Tile Grass = new Grass_Tile(0);
	public static Tile Tree = new Rock_Tile(1);
	
	
	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
	
	protected BufferedImage Texture;
	protected final int Id;
	
	
	public Tile(BufferedImage Texture, int Id)
	{
	
		this.Texture = Texture;
		this.Id = Id;
		
		Tiles[Id] = this;
		
	}
	
	public void Update()
	{
		
		
	}
	
	public void Render(Graphics Image, int X, int Y)
	{
		
		Image.drawImage(Texture, X, Y, TILE_WIDTH, TILE_HEIGHT, null);
			
	}
	
	public boolean Is_Solid()
	{
		
		return false;
		
	}

	public int Get_Id()
	{
		
		return this.Id;
		
	}
	
}
