package States;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Key_Manager is used to control the player.
public class Key_Manager implements KeyListener
{

	// Holds the keys that are valid in game.
	private boolean[] Keys;
	public boolean Up, Right, Down, Left;
	
	
	// Key_Manager creates all the possible keys that can be used in game.
	public Key_Manager()
	{
		
		Keys = new boolean[256];
		
	}
	
	// Update updates what keys can be pressed.
	public void Update()
	{
		
		Up = Keys[KeyEvent.VK_W];
		Right = Keys[KeyEvent.VK_D];
		Down = Keys[KeyEvent.VK_S];
		Left = Keys[KeyEvent.VK_A];
		
	}
	
	// keyPressed tells the game what keys are being pressed.
	@Override
	public void keyPressed(KeyEvent arg0)
	{
		
		Keys[arg0.getKeyCode()] = true;
		//System.out.println("Toast and Butter");
		
	}
	
	// keyReleased tells the game what keys have been released.
	@Override
	public void keyReleased(KeyEvent arg0)
	{
		
		Keys[arg0.getKeyCode()] = false;
		
	}

	// keyTyped we don't need but is part of the implemented interface.
	@Override
	public void keyTyped(KeyEvent arg0)
	{
		
		
	}

}
