package Animations;

import java.awt.image.BufferedImage;

public class Animation
{
	
	private int Speed, Index;
	private long Last_Time, Timer;
	private BufferedImage[] Frames;
	
	
	public Animation(int Speed, BufferedImage[] Frames)
	{
		
		this.Speed = Speed;
		this.Frames = Frames;
		
		Index = 0;
		Timer = 0;
		
		Last_Time = System.currentTimeMillis();
		
	}
	
	public void Update()
	{
		
		Timer += System.currentTimeMillis() - Last_Time;
		Last_Time = System.currentTimeMillis();
		
		
		if(Timer > Speed)
		{
			
			Index++;
			Timer = 0;
			
			
			if(Index == Frames.length)
				Index = 0;
			
		}
		
	}
	
	public BufferedImage Get_Current_Frame()
	{
		
		return Frames[Index];
		
	}

}
