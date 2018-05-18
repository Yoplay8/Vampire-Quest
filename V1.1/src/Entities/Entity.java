package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import Test_Program.Game;
import Test_Program.Handler;

// Entity is called for any entity in the game.
public abstract class Entity
{
	
	// The coordinates.
	protected Handler The_Handler;
	protected float X, Y;
	protected int Width, Height;
	protected Rectangle Bounds;
	
	
	// Entity Places the entity at the coordinates.
	public Entity(Handler The_Handler, float X, float Y, int Width, int Height)
	{
		
		this.The_Handler = The_Handler;
		this.X = X;
		this.Y = Y;
		
		this.Width = Width;
		this.Height = Height;
		
		Bounds = new Rectangle(0, 0, Width, Height);
		
	}
	
	public Rectangle Get_Collision_Bounds(float X_Offset, float Y_Offset)
	{
		
		return new Rectangle((int)(X + Bounds.x + X_Offset), (int)(Y + Bounds.y + Y_Offset), Bounds.width, Bounds.height);
		
	}
	
	public boolean Check_Entity_Collision(float X_Offset, float Y_Offset)
	{
		
		for(Entity E : The_Handler.Get_The_World().Get_The_Manager().Get_Entities())
		{
			
			//System.out.println(E + " " + this);
			if(E.equals(The_Handler.Get_The_World().Get_The_Manager().Get_The_Player()))
			//if(E.equals(this))
				continue;
			
			if(E.Get_Collision_Bounds(0f, 0f).intersects(Get_Collision_Bounds(X_Offset, Y_Offset)))
				return true;
			
		}	
		
		return false;
		
	}
	
	public float Get_X()
	{
		
		return this.X;
		
	}
	
	public void Set_X(float X)
	{
		
		this.X = X;
		
	}
	
	public float Get_Y()
	{
		
		return this.Y;
		
	}
	
	public void Set_Y(float Y)
	{
		
		this.Y = Y;
		
	}
	
	public float Get_Width()
	{
		
		return this.Width;
		
	}
	
	public void Set_Width(int Width)
	{
		
		this.Width = Width;
		
	}
	
	public float Get_Height()
	{
		
		return this.Height;
		
	}
	
	public void Set_Height(int Height)
	{
		
		this.Height = Height;
		
	}
	
	
	public abstract void Update();
	public abstract void Render(Graphics Image);

}
