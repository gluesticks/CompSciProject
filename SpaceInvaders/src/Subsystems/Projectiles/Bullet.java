package Subsystems.Projectiles;
import Subsystems.Projectiles.GameObject;
import java.awt.*;
import javax.swing.*;


public class Bullet extends GameObject
{
	
	ImageIcon picture = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Ball.PNG");
	int dy;
	
	public Bullet(int x, int y, int dy, String attr)
	{
		width = 10;
		height = 10;
		this.x = x;
		this.y = y;
		this.dy = dy;
		attribute = attr;
		setPicture(picture);
	}
	
	public void update()
	{
		y += dy;
	}
	
	public void draw(Graphics g, Component c)
	{
		g.drawImage(picture.getImage(),x,y,width,height,c);
	}

}