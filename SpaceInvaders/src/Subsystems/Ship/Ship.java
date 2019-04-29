package Subsystems.Ship;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Component;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.ImageIcon;

import Subsystems.Projectiles.Bullets;
import Subsystems.Projectiles.GameObject;

import java.io.*;

/*
 * Ship Class for FRC Space Invaders
 * 
 * @author Joe LaRock
 */


public class Ship extends GameObject
{
	
	ImageIcon ship = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Ship.PNG");
	ImageIcon ship_firing = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Ship_Firing.PNG");
	private static final Graphics Graphics = null;
	public int dx, dy;
	public int lives;
	
	Object[] upgrades = {new Arm(), new Intake(), new Elevator(), new Drivetrain()};
	
	public Ship()
	{
		x = 260;
		y = 430;
		width = 50;
		height = 50;
		alive = true;
		attribute = "ship";
		lives = 3;
		setPicture(ship);
	}
	
	//private void health()
	//{
	//	//detects and shows the health and lives 
	//}
	
	public void movement(KeyEvent e)
	{
		//registers and acts on any movement given to the Ship object
		int key_code = e.getKeyCode();
		if (key_code == KeyEvent.VK_LEFT)//if user presses left arrow key
		{
			dx = -10;
		}
		else if(key_code == KeyEvent.VK_RIGHT)//if user presses right arrow key
		{
			dx = 10;
		}
		else if (key_code == KeyEvent.VK_UP)//if user presses up arrow key
		{
			dy = -5;
		}
		else if (key_code == KeyEvent.VK_DOWN)//user presses down arrow key
		{
			dy = 5;
		}
		else if(e.getKeyChar() == ' ')
		{
			Bullets.addBullet(x + width/2, y - 10, -30, "ship_bullet");
			setPicture(ship_firing);
		} 
		else
		{
			return;
		}
	}
	
	private void checkUpgrades()
	{
		//checks what upgrades the Ship currently has
	}
	
	public void update()
	{
		x += dx;
		y += dy;
	}
	
	public void damage()
	{
		lives -= 1;
	}
	
	public void setDefaultPic()
	{
		setPicture(ship);
	}
	
	/*
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}*/
}
