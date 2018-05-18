package Entities;

import Display.Tile;
import Test_Program.Game;
import Test_Program.Handler;


// Creature creates the creates in the game.
public abstract class Creature extends Entity
{

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 5.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;
	
	// Health of creature.
	protected int Health;
	protected float Speed;
	protected float X_Move, Y_Move;
	
	
	// Creature sets the coordinates and health.
	public Creature(Handler The_Handler, float X, float Y, int Width, int Height)
	{
		
		super(The_Handler, X, Y, Width, Height);
		
		Health = DEFAULT_HEALTH;
		Speed = DEFAULT_SPEED;
		
		X_Move = 0;
		Y_Move = 0;
		
	}
	
	public void Move()
	{
		
		if(!Check_Entity_Collision(X_Move, 0f))
			Move_X();
		
		if(!Check_Entity_Collision(0f, Y_Move))
			Move_Y();
		
	}
	
	public void Move_X()
	{
		
		if(X_Move > 0)
		{
			
			int TX = (int)((X + X_Move + Bounds.x + Bounds.width) / Tile.TILE_WIDTH);
			
			
			if(!Collision_With_Tile(TX, (int)((Y + Bounds.y) / Tile.TILE_HEIGHT)) &&
					!Collision_With_Tile(TX, (int)((Y + Bounds.y + Bounds.height) / Tile.TILE_HEIGHT)))
				X += X_Move;
			else
				X = TX * Tile.TILE_WIDTH - Bounds.x - Bounds.width - 1;
			
		}
		else if(X_Move  < 0)
		{
		
			int TX = (int)((X + X_Move + Bounds.x) / Tile.TILE_WIDTH);
						
						
			if(!Collision_With_Tile(TX, (int)((Y + Bounds.y) / Tile.TILE_HEIGHT)) &&
					!Collision_With_Tile(TX, (int)((Y + Bounds.y + Bounds.height) / Tile.TILE_HEIGHT)))
				X += X_Move;
			else
				X = TX * Tile.TILE_WIDTH + Tile.TILE_WIDTH - Bounds.x;
			
		}
		
	}
	
	public void Move_Y()
	{

		if(Y_Move < 0)
		{
			
			int TY = (int)((Y + Y_Move + Bounds.y) / Tile.TILE_HEIGHT);
			
			
			if(!Collision_With_Tile((int)((X + Bounds.x) / Tile.TILE_WIDTH), TY) &&
					!Collision_With_Tile((int)((X + Bounds.x + Bounds.width) / Tile.TILE_WIDTH), TY))
				Y += Y_Move;
			else
				Y = TY * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - Bounds.y;
			
		}
		else if(Y_Move  > 0)
		{
		
			int TY = (int)((Y + Y_Move + Bounds.y + Bounds.height) / Tile.TILE_HEIGHT);
			
			
			if(!Collision_With_Tile((int)((X + Bounds.x) / Tile.TILE_WIDTH), TY) &&
					!Collision_With_Tile((int)((X + Bounds.x + Bounds.width) / Tile.TILE_WIDTH), TY))
				Y += Y_Move;
			else
				Y = TY * Tile.TILE_HEIGHT - Bounds.y - Bounds.height - 1;
			
		}
		
	}
	
	protected boolean Collision_With_Tile(int X, int Y)
	{

		return The_Handler.Get_The_World().Get_Tile(X, Y).Is_Solid();
		
	}
	
	// Everything below is getters and setters.
	
	public float Get_X_Move()
	{
		
		return X_Move;
	
	}

	public void Set_X_Move(int X_Move)
	{
		
		X_Move = X_Move;
	
	}

	public float Get_Y_Move()
	{
		
		return Y_Move;
	
	}

	public void Set_Y_Move(int Y_Move)
	{
		
		Y_Move = Y_Move;
	
	}

	public void Set_Health(int Health)
	{
		
		this.Health = Health;
		
	}
	
	public int Get_Health()
	{
		
		return this.Health;
		
	}
	
	public void Set_Speed(float Speed)
	{
		
		this.Speed = Speed;
		
	}
	
	public float Get_Speed()
	{
		
		return this.Speed;
		
	}

}
