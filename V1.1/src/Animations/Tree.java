package Animations;

import java.awt.Color;
import java.awt.Graphics;

import Test_Program.Handler;
import Display.Assets;
import Display.Tile;
import Entities.Static_Entity;

public class Tree extends Static_Entity
{

	public Tree(Handler The_Handler, float X, float Y)
	{
		
		super(The_Handler, X, Y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		
		//Bounds.x = 10;
		//Bounds.y = Height;
		//Bounds.width = Width;
		//Bounds.height = Height;
		
	}

	@Override
	public void Update()
	{
		
		
		
	}

	@Override
	public void Render(Graphics Image)
	{
		
		Image.drawImage(Assets.Tree_N_Grass, (int)(X - The_Handler.Get_Game_Camera().Get_X_Offset()), (int)(Y - The_Handler.Get_Game_Camera().Get_Y_Offset()), Width, Height, null);
		
	}
	
	

}
