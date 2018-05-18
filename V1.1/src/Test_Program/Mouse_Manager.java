package Test_Program;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse_Manager implements MouseListener, MouseMotionListener
{

	private boolean Left_Pressed, Right_Pressed;
	private int Mouse_X, Mouse_Y;
	private UI_Manager The_UI_Manager;
	
	
	public Mouse_Manager()
	{
		
		
	}
	
	public void Set_UI_Manager(UI_Manager The_UI_Manager)
	{
		
		this.The_UI_Manager = The_UI_Manager;
		
	}
	
	public boolean Is_Right_Pressed()
	{
		
		return Right_Pressed;
		
	}
	
	public boolean Is_Left_Pressed()
	{
		
		return Left_Pressed;
		
	}
	
	public int Get_Mouse_X()
	{
		
		return Mouse_X;
		
	}
	
	public int Get_Mouse_Y()
	{
		
		return Mouse_Y;
		
	}
	
	@Override
	public void mouseDragged(MouseEvent E)
	{
		
		
		
	}

	@Override
	public void mouseMoved(MouseEvent E)
	{
		
		Mouse_X = E.getX();
		Mouse_Y = E.getY();
		
		
		if(The_UI_Manager != null)
			The_UI_Manager.On_Mouse_Move(E);
		
	}

	@Override
	public void mouseClicked(MouseEvent E)
	{
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent E)
	{
		
		
		
	}

	@Override
	public void mouseExited(MouseEvent E)
	{
		
		
		
	}

	@Override
	public void mousePressed(MouseEvent E)
	{
		
		if(E.getButton() == MouseEvent.BUTTON1)
			Left_Pressed = true;
		else if(E.getButton() == MouseEvent.BUTTON3)
			Right_Pressed = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent E)
	{
		
		if(E.getButton() == MouseEvent.BUTTON1)
			Left_Pressed = false;
		else if(E.getButton() == MouseEvent.BUTTON3)
			Right_Pressed = false;
		
		
		if(The_UI_Manager != null)
			The_UI_Manager.On_Mouse_Release(E);
		
	}

}
