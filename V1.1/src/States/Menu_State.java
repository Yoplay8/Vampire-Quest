package States;

import java.awt.Color;
import java.awt.Graphics;

import Display.Assets;
import Test_Program.ClickListener;
import Test_Program.Game;
import Test_Program.Handler;
import Test_Program.UI_Image_Button;
import Test_Program.UI_Manager;

// Menu_State is used to control the menu.
public class Menu_State extends State
{
	
	private UI_Manager The_UI_Manager;
	
	
	// Menu_State sets the menu.
	public Menu_State(Handler The_Handler)
	{
		
		super(The_Handler);
		
		The_UI_Manager = new UI_Manager(The_Handler);
		The_Handler.Get_Mouse_Manager().Set_UI_Manager(The_UI_Manager);
		
		The_UI_Manager.Add_Object(new UI_Image_Button(200, 200, 128, 64, Assets.Btn_Start, new ClickListener(){

			@Override
			public void On_Click()
			{
				
				The_Handler.Get_Mouse_Manager().Set_UI_Manager(null);
				State.Set_State(The_Handler.Get_The_Game().Game);
				
			}}));
		
	}
	
	// Update
	@Override
	public void Update()
	{
	
		The_UI_Manager.Update();
		
	}
	
	@Override
	public void Render(Graphics Image)
	{
		
		The_UI_Manager.Render(Image);
		
	}

}
