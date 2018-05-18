package Test_Program;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UI_Image_Button extends UI_Object
{

	private BufferedImage[] Images;
	private ClickListener Clicker;
	
	
	public UI_Image_Button(float X, float Y, int Width, int Height, BufferedImage[] Images, ClickListener Clicker)
	{
		
		super(X, Y, Width, Height);
		
		this.Images = Images;
		this.Clicker = Clicker;
	
	}

	@Override
	public void Update()
	{

		
		
	}

	@Override
	public void Render(Graphics G)
	{

		if(Hovering)
		{
			
			/*for(int Frames = 1; Frames < Assets.Btn_Start.length; Frames++)
			{
				
				G.drawImage(Images[Frames], (int) X, (int) Y, Width, Height, null);		
				
			}*/

			G.drawImage(Images[4], (int) X, (int) Y, Width, Height, null);
			
		}
		else
			G.drawImage(Images[0], (int) X, (int) Y, Width, Height, null);
		
	}

	@Override
	public void On_Click()
	{

		Clicker.On_Click();
		
	}
	
	

}
