package Test_Program;

import Display.Game_Camera;
import States.Key_Manager;

public class Handler
{
	
	private Game The_Game;
	private World The_World;
	
	
	public Handler(Game The_Game)
	{
	
		this.The_Game = The_Game;
		
	}

	public Game_Camera Get_Game_Camera()
	{
		
		return The_Game.Get_Game_Camera();
		
	}
	
	public Key_Manager Get_Key_Manager()
	{
		
		return The_Game.Get_Key_Manager();
		
	}
	
	public Mouse_Manager Get_Mouse_Manager()
	{
		
		return The_Game.Get_Mouse_Manager();
		
	}
	
	public int Get_Width()
	{
		
		return The_Game.Get_Width();
		
	}
	
	public int Get_Height()
	{
		
		return The_Game.Get_Height();
		
	}
	
	public Game Get_The_Game()
	{
	
		return The_Game;
	
	}


	public void Set_The_Game(Game The_Game)
	{
		
		this.The_Game = The_Game;
		
	}


	public World Get_The_World()
	{
		
		return The_World;
		
	}


	public void Set_The_World(World The_World)
	{
		
		this.The_World = The_World;
		
	}

}
