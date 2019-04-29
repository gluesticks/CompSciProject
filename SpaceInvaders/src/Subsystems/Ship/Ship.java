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
<<<<<<< HEAD
	
	ImageIcon ship = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Ship.PNG");
	ImageIcon ship_firing = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Ship_Firing.PNG");
	private static final Graphics Graphics = null;
	public int dx, dy;
	public int lives;
=======
	Graphics Graphics = null;
	BufferedImage shipImage = null;
	boolean isDead = false;
	int lives;
	int yLoc = 550;
	int xLoc = 225;
	Graphics2D shipGraphics = null;
	boolean hit = false;
>>>>>>> 1dcda9ab21321dd134adf7056e4729bb6cebc358
	
	Arm armUpgrade = new Arm();
	Intake intakeUpgrade = new Intake();
	Elevator elevatorUpgrade = new Elevator();
	Drivetrain drivetrainUpgrade = new Drivetrain();
	Hybrid hybridUpgrade = new Hybrid();
	
	public Ship()
	{
<<<<<<< HEAD
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
=======
		try
		{
			shipImage = ImageIO.read(new File("SpaceInvaders/src/Subsystems/Sprites/Ship.png"));
		}
		catch (Exception e)
		{
			System.out.println("Error loading ship image.");
		}
	}
	
	private void setImage(Graphics g)
	{
		super.paintComponent(g);
		super.repaint();
		shipGraphics = (Graphics2D)g;
		shipGraphics.drawImage(shipImage, xLoc, yLoc, null);
	}
	
	private void movement(KeyEvent e)
>>>>>>> 1dcda9ab21321dd134adf7056e4729bb6cebc358
	{
		//registers and acts on any movement given to the Ship object
		int key_code = e.getKeyCode();
		if (key_code == KeyEvent.VK_LEFT)//if user presses left arrow key
		{
<<<<<<< HEAD
			dx = -10;
=======
				xLoc -= 5;
				if (xLoc < 0)
				{
					xLoc = 0;
				}
				setImage(shipGraphics);
>>>>>>> 1dcda9ab21321dd134adf7056e4729bb6cebc358
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
		if (hybridUpgrade.collected == true)
		{
			
			//do something with hybrid to create and be able to detect
		}
		//checks what upgrades the Ship currently has
	}
	
<<<<<<< HEAD
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
=======
	private void hitDetection(boolean isHit)
	{
		//
		
		if (hit == true)
		{
			lives--;
			hit = false;
		}
		else
		{
			
			return;
		}
	}
	
>>>>>>> 1dcda9ab21321dd134adf7056e4729bb6cebc358
	@Override
	public void keyPressed(KeyEvent arg0)
	{
		if (arg0 == null)
		{
			return;
		}
		else
		{
			movement(arg0);
		}
		// TODO Auto-generated method stub
	}

	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	private void update()
	{
		//keyPressed(KeyEvent arg0)
	}
	
	private void reset()
	{
		isDead = false;
		//lives;
		yLoc = 550;
		xLoc = 225;
		hit = false;
	}
	
	public static void main(String[] args)
	{
		new Ship();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}*/
}
