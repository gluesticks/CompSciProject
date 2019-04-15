import javax.swing.*;

import Subsystems.Projectiles.Bullet;

import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class GameFrame extends JPanel implements KeyListener
{

	//images
	ImageIcon shippic, FRCalien, FRCalien_2, FRCalien_3, FRCalien_4;

	//list of all objects in game
	LinkedList<SEnemy> masterList;

	//ship
	Ship ship;
	Bullet bullet;
	
	int dead, listlength;
	
	GameFrame()
	{
		
		shippic = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Ship.PNG");
		FRCalien = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Enemy_Ship_1.PNG");
		FRCalien_2 = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Enemy_Ship_2.PNG");
		FRCalien_3 = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Enemy_Ship_3.PNG");
		FRCalien_4 = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Enemy_Ship_4.PNG");

		//add some aliens to game
		masterList = new LinkedList<SEnemy>();
		for(int i=0; i<3; i++)
		{
			SEnemy a = new SEnemy();
			a.setPicture(FRCalien);
			masterList.add(a);
		}
		
		FRCalien ca = new FRCalien();
		ca.setPicture(FRCalien);
		masterList.add(ca);
				
		//add a ship to the game
		ship = new Ship();
		ship.setPicture(shippic);
		ship.x = 200;
		ship.y = 400;
	
		FRCalien_2 p1 = new FRCalien_2();
		p1.setPicture(FRCalien_2);
		p1.setPrey(ship);
		masterList.add(p1);
		
		FRCalien_3 p2 = new FRCalien_3();
		p2.setPicture(FRCalien_3);
		masterList.add(p2);
		
		FRCalien_4 p3 = new FRCalien_4();
		p3.setPicture(FRCalien_4);
		masterList.add(p3);
		
		bullet = new Bullet();

		Update ut = new Update(this);
		ut.start();
		
		
		//stupid key listener stuff
		addKeyListener(this);
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
			go.bullet.draw(g, this);
			if(!go.alive)
				dead++;
		}
		ship.draw(g, this);
		bullet.draw(g, this);
		if(ship.alive == false)
		{
			g.setFont(new Font("sansserif", Font.BOLD, 32));
			g.drawString("GAME OVER!!!!", 150, 300);
		}
		if(dead == listlength)
		{
			g.setFont(new Font("sansserif", Font.BOLD, 32));
			g.drawString("GAME WON!!!!", 150, 300);
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
			if(bullet.intersects(go))
			{
				go.kill();
			}
			
			if(go.intersects(ship) && !go.attribute.equalsIgnoreCase("ship"))
			{
				ship.kill();
				System.out.println(go.attribute + " killed you");
			}
			if(go.bullet.intersects(ship))
			{
				ship.kill();
				System.out.println("Shot by " + go.attribute);
			}
			
		}
		
		//check for bullet shot aliens
		
		bullet.update();
		ship.update();
		
		repaint();
	}

	public void keyPressed(KeyEvent k)
	{
		char c = k.getKeyChar();
		
		if( k.getKeyCode() == KeyEvent.VK_RIGHT )
			ship.dx = 5;
		if( k.getKeyCode() == KeyEvent.VK_LEFT )
			ship.dx = -5;
		if(c == ' ')
		{
			bullet.x = ship.x;
			bullet.y = ship.y - 30;
		}
	}

	public void keyReleased(KeyEvent k)
	{
		if( k.getKeyCode() == KeyEvent.VK_LEFT ||  k.getKeyCode() == KeyEvent.VK_RIGHT )
			ship.dx = 0;
	}

	public void keyTyped(KeyEvent k)
	{
	}

}