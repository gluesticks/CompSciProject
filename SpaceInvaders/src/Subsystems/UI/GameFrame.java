import javax.swing.*;
import Subsystems.Projectiles.*;
import Subsystems.Ship.Ship;
import Subsystems.Projectiles.Bullets;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.Point2D;

public class GameFrame extends JPanel implements KeyListener, MouseListener
{

	//list of all objects in game
	static LinkedList<SEnemy> masterList;

	//ship
	Ship ship;
	
	//buttons
	Button next_level_button = new Button("Next Level", 0, 208, 250);
	Button quit_button = new Button("Quit", 38, 208, 250);
	
	//some variables to keep track of game
	int dead, listlength, score = 0, level = 1, max_level = 5;	
	boolean nextLevelPrompted = false, quitPrompted = false;

	GameFrame()
	{

		//add some aliens to game
		masterList = new LinkedList<SEnemy>();
		
		//add aliens for level 1
		Level.level_1();
				
		//add a ship to the game
		ship = new Ship();

		Update ut = new Update(this);
		ut.start();
		
		
		//stupid key listener stuff
		addKeyListener(this);
		addMouseListener(this);
		setFocusable(true);
	}


	public void paintComponent(Graphics g)
	{
		//draw all objects in game
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for( SEnemy go : masterList )
		{
			go.draw(g,this);
			listlength++;
			if(!go.alive)
				dead++;
		}
		ship.draw(g, this);
		Bullets.drawBullets(g, this);
		next_level_button.draw(g, this);
		quit_button.draw(g, this);
		RobotShop.draw(g, this);

		g.setFont(new Font("sansserif", Font.BOLD, 32));
		g.setColor(Color.RED);
		g.drawString("Lives: " + ship.lives, 10, 30);
		g.setColor(Color.BLACK);	
		
		g.setFont(new Font("sansserif", Font.BOLD, 32));
		g.setColor(Color.RED);
		g.drawString("Level: " + level, 450, 30);
		g.setColor(Color.BLACK);
		
		g.setFont(new Font("sansserif", Font.BOLD, 22));
		g.setColor(Color.WHITE);
		g.drawString("Score: " + score, 220, 30);
		g.setColor(Color.BLACK);
		
		if(ship.alive == false)
		{
			quit_button.show();
			g.setFont(new Font("sansserif", Font.BOLD, 32));
			g.setColor(Color.RED);
			g.drawString("GAME OVER!!!!", 150, 300);
			g.setColor(Color.BLACK);
			if(quitPrompted)					
				System.exit(0);
		}
		if(dead == listlength)
		{
			Bullets.delAllBullets();
			if(level==max_level) {
				quit_button.show();
				g.setFont(new Font("sansserif", Font.BOLD, 32));
				g.setColor(Color.RED);
				g.drawString("GAME WON!!!!", 150, 300);
				g.setColor(Color.BLACK);		
				if(quitPrompted)					
					System.exit(0);
			} else if(level < max_level) {
				next_level_button.show();
				if(nextLevelPrompted) {
					RobotShop.close();
					Level.next_level(level);
					level += 1;
					next_level_button.hide();
					nextLevelPrompted = false;
				}
			}
		}
		else
		{
			listlength = 0;
			dead = 0;
		}
	}


	public void update()
	{
		//update all objects in game
		for( SEnemy go : masterList )
		{
			go.update();
			
			if(Bullets.checkBulletIntersection(go, "ship_bullet"))
			{
				go.kill();
				score += go.points;
			}
			if(go.intersects(ship) && !go.attribute.equalsIgnoreCase("ship"))
			{
				ship.damage();
				if(ship.lives==0) {
					ship.kill();
				}
				System.out.println(go.attribute + " killed you");
			}
			if(Bullets.checkBulletIntersection(ship, "alien_bullet"))
			{
				ship.damage();
				if(ship.lives==0) {
					ship.kill();
				}
				System.out.println("Shot by " + go.attribute);
			}
			
		}
		
		Bullets.update();
		ship.update();
		
		repaint();
	}
	
	
	public void keyPressed(KeyEvent k)
	{
		ship.movement(k);
	}

	public void keyReleased(KeyEvent k)
	{
		if( k.getKeyCode() == KeyEvent.VK_LEFT ||  k.getKeyCode() == KeyEvent.VK_RIGHT || k.getKeyCode() == KeyEvent.VK_UP || k.getKeyCode() == KeyEvent.VK_DOWN)
			ship.dx = 0; ship.dy = 0;
		if( k.getKeyChar() == ' ')
			ship.setDefaultPic();
	}

	public void keyTyped(KeyEvent k)
	{
	}

	public void mouseClicked(MouseEvent e) 
	{
		RobotShop.onMousePress(this.getMousePosition());
		nextLevelPrompted = next_level_button.isPressed(this.getMousePosition());
		quitPrompted = quit_button.isPressed(this.getMousePosition());
	}

	public void mouseEntered(MouseEvent e) 
	{	
	}

	public void mouseExited(MouseEvent e) 
	{	
	}

	public void mousePressed(MouseEvent e) 
	{	
	}

	public void mouseReleased(MouseEvent e) 
	{
	}

}