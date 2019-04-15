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
	private static final Graphics Graphics = null;
	BufferedImage shipImage = null;
	boolean isDead;
	int lives;
	int yLoc = 550;
	int xLoc = 225;
	Graphics2D shipGraphics = null;
	KeyEvent keyboard = null;
	
	Object[] upgrades = {new Arm(), new Intake(), new Elevator(), new Drivetrain()};
	
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
	
	private void health()
	{
		//detects and shows the health and lives 
	}
	
	private void movement(KeyEvent e)
	{
		int location = e.getKeyLocation();
		if (location == KeyEvent.KEY_LOCATION_LEFT)//if user presses left arrow key
		{
				xLoc -= 5;
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
		//checks what upgrades the Ship currently has
	}
	
	private void hitDetection()
	{
		//checks if the Ship object has been hit
		
		//then looks to see if death happens
	}

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
		
	}
}
