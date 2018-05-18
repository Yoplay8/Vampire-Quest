package Entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import Test_Program.Handler;

public class Entity_Manager
{
	
	private Handler The_Handler;
	private Player The_Player;
	private ArrayList<Entity> Entities;
	
	private Comparator<Entity> Render_Sorter = new Comparator<Entity>(){

		@Override
		public int compare(Entity A, Entity B)
		{
			
			if((A.Get_Y() + A.Get_Height()) < (B.Get_Y() + B.Get_Height()))
				return -1;
			else
				return 1;
			
		}};
	
	
	public Entity_Manager(Handler The_Handler, Player The_Player)
	{

		this.The_Handler = The_Handler;
		this.The_Player = The_Player;
		Entities = new ArrayList<Entity>();
		
		
		Add_Entity(The_Player);
	
	}	
	
	public void Update()
	{

		for(Entity E : Entities)
			E.Update();
		
		Entities.sort(Render_Sorter);
		
	}
	
	public void Render(Graphics Image)
	{
		
		for(Entity E : Entities)
			E.Render(Image);
		
	}
	
	public void Add_Entity(Entity E)
	{
		
		Entities.add(E);
		
	}
	
	public Handler Get_The_Handler()
	{
		
		return The_Handler;
		
	}

	public void Set_The_Handler(Handler The_Handler)
	{
		
		this.The_Handler = The_Handler;
		
	}

	public Player Get_The_Player()
	{
		
		return The_Player;
		
	}

	public void Set_The_Player(Player The_Player)
	{
		
		this.The_Player = The_Player;
		
	}

	public ArrayList<Entity> Get_Entities()
	{
		
		return Entities;
		
	}

	public void Set_Entities(ArrayList<Entity> Entities)
	{
		
		this.Entities = Entities;
		
	}
	
}
