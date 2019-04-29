import java.util.*;

import javax.swing.ImageIcon;

import Subsystems.Projectiles.Bullet;
import Subsystems.Projectiles.Bullets;
import Subsystems.Projectiles.GameObject;

public class SEnemy extends GameObject
{
	ImageIcon picture = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Enemy_Ship_1.PNG");
	Random dice;
	int cnt = 1;
	int dx;
	int rand = 0;
	int points = 500;
	boolean shot;
	
	public SEnemy()
	{
		dice = new Random();
		x = dice.nextInt(400);
		y = dice.nextInt(250);
		dx = dice.nextInt(6) + 4;
		attribute = "alien";
		shot = false;
		setPicture(picture);
	}

	public void update()
	{		
		if(cnt%2 != 1)
		{
			x += dx;
			if(x > 500)
				cnt++;
		}
		else
		{
			x -= dx;
			if(x < 0)
				cnt++;
		}	
		
		fire_update();
	}
	
	protected void fire_update()
	{
		rand = dice.nextInt(25);
		
		if(alive)
		{
			if(rand == 0 && !shot)
			{
				Bullets.addBullet(x + width/2, y + 10, 10, "alien_bullet");
				shot = true;
			}
			
			if(shot)
			{
				shot = false;
			}
		}
	}
}
