package Test_Program;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UI_Manager
{

	private Handler The_Handler;
	private ArrayList<UI_Object> Objects;
	
	
	public UI_Manager(Handler The_Handler)
	{
		
		this.The_Handler = The_Handler;
		
		Objects = new ArrayList<UI_Object>();
		
	}
	
	public void Update()
	{
		
		for(UI_Object O : Objects)
			O.Update();
		
	}
	
	public void Render(Graphics G)
	{
		
		for(UI_Object O : Objects)
			O.Render(G);
		
	}
	
	public void On_Mouse_Move(MouseEvent E)
	{
		
		for(UI_Object O : Objects)
			O.On_Mouse_Move(E);
		
	}
	
	public void On_Mouse_Release(MouseEvent E)
	{

		for(UI_Object O : Objects)
			O.On_Mouse_Release(E);
		
	}
	
	public void Add_Object(UI_Object O)
	{
		
		Objects.add(O);
		
	}
	
	public void Remove_Object(UI_Object O)
	{
		
		Objects.remove(O);
		
	}

	public Handler Get_The_Handler()
	{
		
		return The_Handler;
	
	}

	public void Set_The_Handler(Handler The_Handler)
	{
		
		this.The_Handler = The_Handler;
	
	}

	public ArrayList<UI_Object> Get_Objects()
	{
		
		return Objects;
	
	}

	public void Set_Objects(ArrayList<UI_Object> Objects)
	{
		
		this.Objects = Objects;
	
	}
	
}
