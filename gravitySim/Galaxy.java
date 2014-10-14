package gravitySim;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Galaxy 
{
	private double deltaT;
	private int xSize, ySize;
	private double gravityC;
	private ArrayList<Planet> solarSystem = new ArrayList<Planet>();
	private ArrayList<ArrayList<Double[]>> solarSystemTrace = new ArrayList<ArrayList<Double[]>>();
	int maxTraceLength = 500;
	
	public Galaxy(int xSize, int ySize, double gravityC, double deltaT)
	{
		this.xSize = xSize;
		this.ySize = ySize;
		this.gravityC = gravityC;
		this.deltaT = deltaT;
	}
	
	public void draw(Graphics g)
	{
		for(int i = 0; i < solarSystem.size(); i++)
		{
			g.setColor(solarSystem.get(i).getColor());
			int radius = (int) Math.pow(solarSystem.get(i).getMass(),0.3);
			
			for(int j = 0; j*2 < radius; j+=2)
			{
				g.drawOval((int)(solarSystem.get(i).getXPos()-radius/2+j) 
						  ,(int)(solarSystem.get(i).getYPos()-radius/2+j) 
						  ,radius-2*j 
						  ,radius-2*j);
			}
			
			// Velocity Vector
			/*
			g.setColor(Color.white);
			g.drawLine((int)solarSystem.get(i).getXPos(), (int)solarSystem.get(i).getYPos(), (int)(solarSystem.get(i).getXPos()+solarSystem.get(i).getXVel()), (int)(solarSystem.get(i).getYPos()+solarSystem.get(i).getYVel()));
			*/
			// Acceleration Vector
			/*
			g.setColor(Color.red);
			g.drawLine((int)solarSystem.get(i).getXPos(), (int)solarSystem.get(i).getYPos(), (int)(solarSystem.get(i).getXPos()+solarSystem.get(i).getXAcc()/2), (int)(solarSystem.get(i).getYPos()+solarSystem.get(i).getYAcc()/2));
			*/
		}
	}

	public void addPlanet(Planet planet)
	{
		this.solarSystem.add(planet);
		this.solarSystemTrace.add(new ArrayList<Double[]>());
	}
	public void updateGalaxy()
	{
		for(int i = 0; i < solarSystem.size(); i++)
		{
			solarSystem.get(i).resetAcc();
			for(int j = 0; j < solarSystem.size(); j++)
			{
				if(i!=j)
				{
					double radius = Math.sqrt(Math.pow(Math.abs(solarSystem.get(j).getXPos()-solarSystem.get(i).getXPos()),2)+Math.pow(Math.abs(solarSystem.get(j).getYPos()-solarSystem.get(i).getYPos()),2));
					double force = solarSystem.get(j).getMass()*solarSystem.get(i).getMass()*gravityC/Math.pow(radius,2);
					double xAcc = force/radius*(solarSystem.get(j).getXPos()-solarSystem.get(i).getXPos())*deltaT/solarSystem.get(i).getMass();
					double yAcc = force/radius*(solarSystem.get(j).getYPos()-solarSystem.get(i).getYPos())*deltaT/solarSystem.get(i).getMass();
					solarSystem.get(i).setAcc(xAcc, yAcc);
				}
			}
		}
		for(int i = 0; i < solarSystem.size(); i++)
		{
			solarSystem.get(i).updatePos(deltaT);
		}
	}
	public void updateTrace()
	{
		for(int i = 0; i < solarSystem.size(); i++)
		{
			solarSystemTrace.get(i).add(new Double[] {solarSystem.get(i).getXPos(),solarSystem.get(i).getYPos()});
			if(solarSystemTrace.get(i).size() > maxTraceLength)
			{
				solarSystemTrace.get(i).remove(0);
				
			}
			System.out.print(i);
		}
	}
	
	public void drawTrace(Graphics g)
	{
		for(int i = 0; i < solarSystem.size(); i++)
		{
			for(int j = 0; j < solarSystemTrace.get(i).size()-1; j++)
			{
				g.setColor(Color.white);
				g.drawLine(solarSystemTrace.get(i).get(j)[0].intValue()
						  ,solarSystemTrace.get(i).get(j)[1].intValue()
						  ,solarSystemTrace.get(i).get(j+1)[0].intValue()
						  ,solarSystemTrace.get(i).get(j+1)[1].intValue());
			}
		}
	}
	
	public int getXSize()
	{
		return this.xSize;
	}
	
	public int getYSize()
	{
		return this.ySize;
	}
}