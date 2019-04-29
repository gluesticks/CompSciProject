//Owen Hill 
package Subsystems.Projectiles;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.JPanel;
import java.io.*;

public class Asteroids extends JPanel
{
	Graphics Graphics = null;
	BufferedImage asteroidImage1 = null;
	BufferedImage asteroidImage2 = null;
	BufferedImage asteroidImage3 = null;
	Graphics2D asteroidGraphics = null;
	int x;
	int y;
	public void Astroid1() 
	{
		try 
		{
			asteroidImage1 = ImageIO.read(new File("SpaceInvaders/src/Subsystems/Sprites/Asteroid_1.png"));
		}
		catch (Exception e)
		{
			System.out.println("Error loading asteroid image.");
		}
	}
	
	private void setImage(Graphics g) 
	{
		asteroidGraphics = (Graphics2D)g;
		asteroidGraphics.drawImage(asteroidImage1, x, y, null);
	}
    public void move(int x, int y)
    {
        x += Math.random();
        y += Math.random();
    }
    public boolean hitDetection(boolean hit)
    {
        return hit;
    }
    public boolean boundaryCheck(int x, int y, boolean inBounds)
    {
        //screenX = <insert screen width>
        //screenY = <insert scrren height>
        return inBounds;
    }
}