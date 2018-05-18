package Display;

import java.awt.Canvas;
import java.awt.Dimension;


import javax.swing.JFrame;

// Display deals with creating the JFrame and canvas.
public class Display
{
	
	// The things we need to draw on.
	private JFrame Frame;
	private Canvas Draw_Board;
	
	// Used for JFrame
	private String Title;
	private int Width, Height;
	

	
	// Display creates the JFrame.
	public Display(String Title, int Width, int Height)
	{
	
		this.Title = Title;
		this.Width = Width;
		this.Height = Height;
	
		Create_Display();
		
	}
	
	// Create_Display deals with more settings on the JFrame and adds the canvas to the JFrame.
	private void Create_Display()
	{
		Frame = new JFrame(Title);
		Frame.setSize(Width, Height);
		Frame.setIconImage(Image_Loader.Load_Image("/Textures/Taskbar.png"));
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setResizable(false);
		Frame.setLocationRelativeTo(null);
		Frame.setVisible(true);
		
		
		Draw_Board = new Canvas();
		
		Draw_Board.setPreferredSize(new Dimension(Width, Height));
		Draw_Board.setMaximumSize(new Dimension(Width, Height));
		Draw_Board.setMinimumSize(new Dimension(Width, Height));
		Draw_Board.setFocusable(false);
		
		
		Frame.add(Draw_Board);
		Frame.pack();
		
	}
	
	// Get_Canvas returns the canvas
	public Canvas Get_Canvas()
	{
		
		return this.Draw_Board;
		
	}
	
	// Get_Frame returns the frame.
	public JFrame Get_Frame()
	{
		
		return this.Frame;
		
	}
		
}
