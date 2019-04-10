package Subsystems.Ship;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.JPanel;
import java.io.*;

/*
 * Ship Class for FRC Space Invaders
 * 
 * @author Joe LaRock
 */


public class Ship extends JPanel
{
	BufferedImage shipImage = null;
	boolean isDead;
	int lives;
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
	
	private void health()
	{
		//detects and shows the health and lives 
	}
	
	private void movement()
	{
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
	
	public static void main(String args[])  //currently using for testing if files will correctly load
	{
		new Ship();
	}
}
