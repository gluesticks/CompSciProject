package Subsystems.Projectiles;
import Subsystems.Projectiles.GameObject;
import java.awt.*;
import javax.swing.*;


public class Bullet extends GameObject
{
	Color col;
	public Bullet()
	{
		width = 10;
		height = 10;
		
		x = 0;
		y = 0;
		
		attribute = "bullet";
		//col = Color.RED;
	}
	
	public void update()
	{
		y -= 10;
	}
	
	public void makeColor()
	{
		col = Color.GREEN;
	}
	public void draw(Graphics g, Component c)
	{
		g.drawImage(picture.getImage(),x,y,width,height,c);
	//	g.setColor(col);
	//	g.fillOval(x, y, width, height);
	}
}