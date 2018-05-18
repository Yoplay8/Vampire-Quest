package States;

import java.awt.Graphics;

import Test_Program.Game;
import Test_Program.Handler;
import Test_Program.World;
import Animations.Tree;
import Display.Tile;
import Entities.Player;

// Game_State is used to control the game.
public class Game_State extends State
{
	
	private World The_World;
	
	// Game_State sets the player on the screen.
	public Game_State(Handler The_Handler)
	{
		
		super(The_Handler);

		The_World = new World(The_Handler, "Resources/Textures/World_1.txt");
		The_Handler.Set_The_World(The_World);
		
	}
	
	// Update updates the player per tick.
	@Override
	public void Update()
	{
		
		The_World.Update();
		
	}

	// Render renders the player per tick.
	@Override
	public void Render(Graphics Image)
	{
		
		The_World.Render(Image);
		
	}
	
}
