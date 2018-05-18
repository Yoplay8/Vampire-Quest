package Test_Program;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UI_Object
{
	
	protected float X, Y;
	protected int Width, Height;
	protected Rectangle Bounds;
	protected boolean Hovering = false;
	
	
	public UI_Object(float X, float Y, int Width, int Height)
	{
		
		this.X = X;
		this.Y = Y;
		this.Width = Width;
		this.Height = Height;
		
		Bounds = new Rectangle((int) X, (int) Y, Width, Height);
		
	}

	public abstract void Update();
	public abstract void Render(Graphics G);
	public abstract void On_Click();

	public void On_Mouse_Move(MouseEvent E)
	{
		
		if(Bounds.contains(E.getX(), E.getY()))
			Hovering = true;
		else
			Hovering = false;
		
	}
	
	public void On_Mouse_Release(MouseEvent E)
	{
		
		if(Hovering)
			On_Click();
		
	}
	
	public float Get_X()
	{
		
		return X;
	
	}


	public void Set_X(float X)
	{
		
		this.X = X;
	
	}


	public float Get_Y()
	{
		
		return Y;
		
	}


	public void Set_Y(float Y)
	{
		
		this.Y = Y;
		
	}


	public int Get_Width()
	{
		
		return Width;
		
	}


	public void Set_Width(int Width)
	{
		
		this.Width = Width;
		
	}


	public int Get_Height()
	{
		
		return Height;
		
	}


	public void Set_Height(int Height)
	{
		
		this.Height = Height;
		
	}


	public boolean Is_Hovering()
	{
		
		return Hovering;
		
	}


	public void Set_Hovering(boolean Hovering)
	{
		
		this.Hovering = Hovering;
		
	}
	
	

}
