package gravitySim;

import java.awt.Color;

public class Planet 
{
	private double mass;
	private Color color;
	private double xPos, yPos;
	private double xVel, yVel;
	private double xAcc, yAcc;
	
	Planet(double xPos, double yPos, double xVel, double yVel, double mass, Color color)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.xVel = xVel;
		this.yVel = yVel;
		this.mass = mass;
		this.color = color;
	}
	
	public void updatePos(double delta)
	{
		this.updateVel(delta);
		this.xPos = this.xPos +this.xVel*delta;
		this.yPos = this.yPos +this.yVel*delta;
	}
	
	private void updateVel(double delta)
	{
		this.xVel = this.xVel +this.xAcc*delta;
		this.yVel = this.yVel +this.yAcc*delta;
	}
	public void resetAcc()
	{
		this.xAcc = 0;
		this.yAcc = 0;
	}
	
	public void setAcc(double xAcc, double yAcc)
	{
		this.xAcc += xAcc;
		this.yAcc += yAcc;
	}
	
	public double getXPos()
	{
		return this.xPos;
	}
	
	public double getYPos()
	{
		return this.yPos;
	}
	
	public double getXVel()
	{
		return this.xVel;
	}
	
	public double getYVel()
	{
		return this.yVel;
	}
	
	public double getXAcc()
	{
		return this.xAcc;
	}
	
	public double getYAcc()
	{
		return this.yAcc;
	}
	
	public double getMass()
	{
		return this.mass;
	}
	
	public Color getColor()
	{
		return this.color;
	}
}
