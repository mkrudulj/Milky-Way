package gravitySim;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Universe extends Applet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Galaxy milkyWay = new Galaxy(800,800,100000,0.001);
	
	public void initWindow()
	{
		 this.setSize(milkyWay.getXSize(),milkyWay.getYSize());
		 this.setVisible(true);
		 this.setBackground(Color.black);
	}
	
	
	public void init()
	{
		initWindow();
		milkyWay.addPlanet(new Planet(400,400,0,17.91,100000,Color.yellow));
		milkyWay.addPlanet(new Planet(500,400,0,310,1000,Color.magenta));
		milkyWay.addPlanet(new Planet(350,400,0,-410,100,Color.cyan));
		milkyWay.addPlanet(new Planet(600,400,0,-210,10000,Color.blue));
		milkyWay.addPlanet(new Planet(620,400,0,10,100,Color.red));
		milkyWay.addPlanet(new Planet(50,400,0,-160,100,Color.green));
		milkyWay.addPlanet(new Planet(55,400,0,-200,10,Color.orange));
		milkyWay.addPlanet(new Planet(400,500,300,0,100,Color.orange));
		
	}
	public void paint(Graphics g)
	{
		repaint();
		milkyWay.updateGalaxy();
		//milkyWay.updateTrace();
		//milkyWay.drawTrace(g);
		milkyWay.draw(g);
	}
}
