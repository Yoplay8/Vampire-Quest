package Display;

import Test_Program.Handler;
import Entities.Entity;

public class Game_Camera
{
	
	private Handler The_Handler;
	private float X_Offset, Y_Offset;
	
	
	public Game_Camera(Handler The_Handler, float X_Offset, float Y_Offset)
	{
		
		this.The_Handler = The_Handler;
		this.X_Offset = X_Offset;
		this.Y_Offset = Y_Offset;
		
	}

	public void Check_Blank_Space()
	{
		
		if(X_Offset < 0)
			X_Offset = 0;
		else if(X_Offset > The_Handler.Get_The_World().Get_Width() * Tile.TILE_WIDTH - The_Handler.Get_Width())
			X_Offset = The_Handler.Get_The_World().Get_Width() * Tile.TILE_WIDTH - The_Handler.Get_Width();
		
		
		if(Y_Offset < 0)
			Y_Offset = 0;
		else if(Y_Offset > The_Handler.Get_The_World().Get_Height() * Tile.TILE_HEIGHT - The_Handler.Get_Height())
			Y_Offset = The_Handler.Get_The_World().Get_Height() * Tile.TILE_HEIGHT - The_Handler.Get_Height();
		
	}
	
	public void Center_On_Entity(Entity E)
	{
		
		X_Offset = E.Get_X() - The_Handler.Get_Width() / 2 + E.Get_Width() / 2;
		Y_Offset = E.Get_Y() - The_Handler.Get_Height() / 2 + E.Get_Height() / 2;
		
		Check_Blank_Space();
		
	}

	public float Get_X_Offset()
	{
		
		return X_Offset;
		
	}

	public void Move(float X_Amt, float Y_Amt)
	{
		
		X_Offset += X_Amt;
		Y_Offset += Y_Amt;
		
		Check_Blank_Space();
		
	}
	
	public void Set_X_Offset(float X_Offset)
	{
		
		X_Offset = X_Offset;
		
	}


	public float Get_Y_Offset()
	{
		
		return Y_Offset;
		
	}


	public void Set_Y_Offset(float Y_Offset)
	{
		
		Y_Offset = Y_Offset;
		
	}
	
	
}
