package Subsystems.Ship;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.JPanel;
import java.io.*;

/*
 * Ship Class for FRC Space Invaders
 * 
 * @author Joe LaRock
 */


public class Ship extends JPanel implements KeyListener
{
	Graphics Graphics = null;
	BufferedImage shipImage = null;
	boolean isDead = false;
	int lives;
	int yLoc = 550;
	int xLoc = 225;
	Graphics2D shipGraphics = null;
	boolean hit = false;
	
	Arm armUpgrade = new Arm();
	Intake intakeUpgrade = new Intake();
	Elevator elevatorUpgrade = new Elevator();
	Drivetrain drivetrainUpgrade = new Drivetrain();
	Hybrid hybridUpgrade = new Hybrid();
	
	public Ship()
	{
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
	{
		int location = e.getKeyLocation();
		if (location == KeyEvent.KEY_LOCATION_LEFT)//if user presses left arrow key
		{
				xLoc -= 5;
				if (xLoc < 0)
				{
					xLoc = 0;
				}
				setImage(shipGraphics);
		}
		else if(location == KeyEvent.KEY_LOCATION_RIGHT)//if user presses right arrow key
		{
			xLoc += 5;
			setImage(shipGraphics);
		}
		else if (location == 38)//if user presses up arrow key
		{
			yLoc -= 5;
			setImage(shipGraphics);
		}
		else if (location == 40)//user presses down arrow key
		{
			yLoc += 5;
			setImage(shipGraphics);
		}
		else
		{
			return;
		}
		//registers and acts on any movement given to the Ship object
	}
	
	private void checkUpgrades()
	{
		if (hybridUpgrade.collected == true)
		{
			
			//do something with hybrid to create and be able to detect
		}
		//checks what upgrades the Ship currently has
	}
	
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
		
	}
}
