package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Animations.Animation;
import Display.Assets;
import Test_Program.Game;
import Test_Program.Handler;

// Player creates the player.
public class Player extends Creature
{

	private Animation[] Anim_Moves = new Animation[4];
	
	// Player places the player on the canvas.
	public Player(Handler The_Handler, float X, float Y)
	{
		
		super(The_Handler, X, Y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//Bounds.x = 29;
		//Bounds.y = 0;
		Bounds.x = 29;
		Bounds.y = 30;
		//Bounds.width = 13;
		//Bounds.height = 57;
		Bounds.width = 2;
		Bounds.height = 2;
		
		for(int Index = 0; Index < Anim_Moves.length; Index++)	
			Anim_Moves[Index] = new Animation(500, Assets.Player_Moves[Index]);
		
	}

	// Update controls player movement.
	@Override
	public void Update()
	{
		
		for(int Index = 0; Index < Anim_Moves.length; Index++)
			Anim_Moves[Index].Update();
		
		Get_Input();
		Move();
		
		The_Handler.Get_Game_Camera().Center_On_Entity(this);
		
	}
	
	private void Get_Input()
	{
		
		X_Move = 0;
		Y_Move = 0;
		
		
		if(The_Handler.Get_Key_Manager().Up)
			Y_Move = -Speed;
		if(The_Handler.Get_Key_Manager().Right)
			X_Move = Speed;
		if(The_Handler.Get_Key_Manager().Down)
			Y_Move = Speed;
		if(The_Handler.Get_Key_Manager().Left)
			X_Move = -Speed;
		
	}

	// Render redraws the player.
	@Override
	public void Render(Graphics Image)
	{
		
		Image.drawImage(Get_Current_Animation_Frame(),
				(int)(X - The_Handler.Get_Game_Camera().Get_X_Offset()),
				(int)(Y - The_Handler.Get_Game_Camera().Get_Y_Offset()), Width, Height, null);
		
		
		Image.setColor(Color.red);
		Image.fillRect((int)(X + Bounds.x - The_Handler.Get_Game_Camera().Get_X_Offset()),
				(int)(Y + Bounds.y - The_Handler.Get_Game_Camera().Get_Y_Offset()),
				Bounds.width, Bounds.height);
		
	}
	
	private BufferedImage Get_Current_Animation_Frame()
	{
		
		if(X_Move < 0)
			return Anim_Moves[0].Get_Current_Frame();
		else if(X_Move > 0)
			return Anim_Moves[1].Get_Current_Frame();
		else if(Y_Move > 0)
			return Anim_Moves[2].Get_Current_Frame();
		else if(Y_Move < 0)
			return Anim_Moves[3].Get_Current_Frame();
		else
			return Assets.Player_Idle;
		
	}

}
