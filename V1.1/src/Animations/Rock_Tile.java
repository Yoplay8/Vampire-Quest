package Animations;

import java.awt.image.BufferedImage;

import Display.Assets;
import Display.Tile;

public class Rock_Tile extends Tile
{

	public Rock_Tile(int Id)
	{
		
		super(Assets.Tree_N_Grass, Id);
		
	}
	
	@Override
	public boolean Is_Solid()
	{
		
		return true;
		
	}
	
}
