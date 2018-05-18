package States;

import java.awt.Graphics;

import Test_Program.Game;
import Test_Program.Handler;

// State is used to create the different states the of the game.
public abstract class State
{
	
	// Holds the state being created.
	private static State Current_State = null;
	
	
	// Set_State creates the state.
	public static void Set_State(State Desired_State)
	{
		
		Current_State = Desired_State;
		
	}
	
	// Get_State gets the state of the calling object.
	public static State Get_State()
	{
		
		return Current_State;
		
	}
	
	// The game state.
	protected Handler The_Handler;
	
	// State sets the state of the game.
	public State(Handler The_Handler)
	{
		
		this.The_Handler = The_Handler;
		
	}
	
	
	public abstract void Update();
	public abstract void Render(Graphics Image);
	

}
