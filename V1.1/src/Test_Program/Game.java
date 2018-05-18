package Test_Program;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Display.Assets;
import Display.Display;
import Display.Game_Camera;
import States.Game_State;
import States.Key_Manager;
import States.Menu_State;
import States.State;

// Game deals with how the game functions such as rendering, updating, and stopping.
public class Game implements Runnable
{

	// Used to display game on.
	private Display Game_Display;
	
	// For Display
	private String Title;
	private int Width, Height;
	
	// Used to run the game.
	private Thread Game_Thread;
	private boolean Running = false;
	
	// Used to put images on screen.
	private BufferStrategy Buffer;
	private Graphics Image;
	
	// Used to make different menus.
	public State Game;
	public State Menu;
	
	// Used for users controls.
	private Key_Manager Key;
	private Mouse_Manager Mouse;
	
	private Game_Camera Camera;
	
	private Handler The_Handler;
	
	
	// Game sets the variables for display.
	public Game(String Title, int Width, int Height)
	{
	
		this.Title = Title;
		this.Width = Width;
		this.Height = Height;
		
		Key = new Key_Manager();
		Mouse = new Mouse_Manager();

	}
	
	// Init sets up the displays and menus.
	private void Init()
	{
		
		Game_Display = new Display(Title, Width, Height);
		Game_Display.Get_Frame().addKeyListener(Key);
		Game_Display.Get_Frame().addMouseListener(Mouse);
		Game_Display.Get_Frame().addMouseMotionListener(Mouse);
		Game_Display.Get_Canvas().addMouseListener(Mouse);
		Game_Display.Get_Canvas().addMouseMotionListener(Mouse);
		
		Assets.Init();
		
		The_Handler = new Handler(this);
		Camera = new Game_Camera(The_Handler, 0, 0);
		
		Game = new Game_State(The_Handler);
		Menu = new Menu_State(The_Handler);
		
		
		State.Set_State(Menu);
		
	}
	
	// Update updates the game after each tick.
	private void Update()
	{
		
		Key.Update();
		
		// If game has no state.
		if(State.Get_State() != null)
			State.Get_State().Update();
			
	}
	
	// Render deals with updates and rendering screen to display the game correctly.
	private void Render()
	{
		
		Buffer = Game_Display.Get_Canvas().getBufferStrategy();
		
		
		// If display doesn't have an image to buffer???
		if(Buffer == null)
		{
		
			Game_Display.Get_Canvas().createBufferStrategy(3);
		
			
			return;
			
		}
		
		
		Image = Buffer.getDrawGraphics();
		
		
		Image.clearRect(0, 0, Width, Height);
		
		
		// If game doesn't have a state.
		if(State.Get_State() != null)
			State.Get_State().Render(Image);
		
		
		Buffer.show();
		Image.dispose();
		
	}
	
	// Run regulates the FPS of the game and display an FPS counter.
	public void run()
	{
		
		// All used to mathematically make the FPS work some how.
		int FPS = 60;
		double Time_Per_Tick = 1000000000 / FPS;
		double Delta = 0;
		long Now;
		long Last_Time = System.nanoTime();
		long Timer = 0;
		int Ticks = 0;
		
		
		Init();
		
		
		// While game is running.
		while(Running)
		{
			
			Now = System.nanoTime();
			Delta += (Now - Last_Time) / Time_Per_Tick;
			Timer += Now - Last_Time;
			
			Last_Time = Now;
			
			
			// Updates the game?
			if(Delta >= 1)
			{
				
				Update();
				Render();
				
				
				Ticks++;
				Delta--;
			
			}
			
			// Used to determine when FPS counter is updated on screen.
			if(Timer >= 1000000000)
			{
				
				System.out.println("FPS " + Ticks);
				Ticks = 0;
				Timer = 0;
				
			}
			
		}
		
		Stop();
		
	}
	
	// Get_Key_Manager returns the key used for users controls.
	public Key_Manager Get_Key_Manager()
	{
		
		return Key;
		
	}
	
	public Mouse_Manager Get_Mouse_Manager()
	{
		
		return Mouse;
		
	}
	
	public Game_Camera Get_Game_Camera()
	{
		
		return Camera;
		
	}
	
	public int Get_Width()
	{
		
		return Width;
		
	}
	
	public int Get_Height()
	{
		
		return Height;
		
	}
	
	// Start starts the game.
	public synchronized void Start()
	{
		
		// Start game if not running.
		if(!Running)
		{
			
			Running = true;
			
			Game_Thread = new Thread(this);
			
			Game_Thread.start();
			
		}
		
	}
	
	// Stop game if running.
	public synchronized void Stop()
	{
		
		// If game is running.
		if(Running)
		{
			
			// Stops the game smoothly?
			try
			{
				
				Running = false;
				
				Game_Thread.join();
				
			}
			catch (InterruptedException e)
			{
	
				e.printStackTrace();
				
			}
		
		}
		
	}
	
}
