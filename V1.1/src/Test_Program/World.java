package Test_Program;

import java.awt.Graphics;

import Animations.Tree;
import Display.Assets;
import Display.Tile;
import Entities.Entity_Manager;
import Entities.Player;

public class World
{

	private Handler The_Handler;
	private int Width, Height;
	private int Spawn_X, Spawn_Y;
	private int[][] Tiles;
	private Entity_Manager The_Manager;
	
	
	public World(Handler The_Handler, String Path)
	{
		
		this.The_Handler = The_Handler;
		
		The_Manager = new Entity_Manager(The_Handler, new Player(The_Handler, Tile.TILE_WIDTH * 0, Tile.TILE_HEIGHT * 0));		
		The_Manager.Add_Entity(new Tree(The_Handler, Tile.TILE_WIDTH * 1, Tile.TILE_HEIGHT * 2));

		
		Load_World(Path);
		
		The_Manager.Get_The_Player().Set_X(Spawn_X);
		The_Manager.Get_The_Player().Set_Y(Spawn_Y);
		
	}

	public void Update()
	{
		
		The_Manager.Update();
		
	}
	
	public void Render(Graphics Image)
	{
		
		int X_Start = (int)Math.max(0, The_Handler.Get_Game_Camera().Get_X_Offset() / Tile.TILE_WIDTH),
			X_End = (int)Math.min(Width, (The_Handler.Get_Game_Camera().Get_X_Offset() + The_Handler.Get_Width()) / Tile.TILE_WIDTH + 1);
		int Y_Start = (int)Math.max(0, The_Handler.Get_Game_Camera().Get_Y_Offset() / Tile.TILE_HEIGHT),
			Y_End = (int)Math.min(Height, (The_Handler.Get_Game_Camera().Get_Y_Offset() + The_Handler.Get_Height()) / Tile.TILE_HEIGHT + 1);
		
		
		for(int Height = Y_Start; Height < Y_End; Height++)
		{
		
			for(int Width = X_Start; Width < X_End; Width++)
			{
				
				Get_Tile(Width, Height).Render(Image,
						(int)(Width * Tile.TILE_WIDTH - The_Handler.Get_Game_Camera().Get_X_Offset()),
						(int)(Height * Tile.TILE_HEIGHT - The_Handler.Get_Game_Camera().Get_Y_Offset()));
				
			}
			
		}
		
		
		The_Manager.Render(Image);
		
	}
	
	public Tile Get_Tile(int X, int Y)
	{
		
		if((X < 0) || (Y < 0) || (X >= Width) || (Y >= Height))
			return Tile.Grass;
		
		
		Tile T = Tile.Tiles[Tiles[X][Y]];
		
		
		if(T == null)
			return Tile.Tree;
		
		
		return T;
		
	}
	
	private void Load_World(String Path)
	{
		
		String File = Utils.Load_File_As_String(Path);
		String[] Tokens = File.split("\\s+");
		
		Width = Utils.Parse_Int(Tokens[0]);
		Height = Utils.Parse_Int(Tokens[1]);
		Spawn_X = Utils.Parse_Int(Tokens[2]);
		Spawn_Y = Utils.Parse_Int(Tokens[3]);
		
		Tiles = new int[Width][Height];
		
		
		for(int Y = 0; Y < Height; Y++)
		{
			
			for(int X = 0; X < Width; X++)
				Tiles[X][Y] = Utils.Parse_Int(Tokens[(X + Y * Width) + 4]);
			
		}
		
	}
	
	public int Get_Width()
	{
		
		return Width;
		
	}
	
	public int Get_Height()
	{
		
		return Height;
		
	}
	
	public Entity_Manager Get_The_Manager()
	{
		
		return this.The_Manager;
	
	}
	
}
