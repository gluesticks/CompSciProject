import java.util.*;

import javax.swing.ImageIcon;

import Subsystems.Projectiles.Bullet;
import Subsystems.Projectiles.GameObject;

public class SEnemy extends GameObject
{
	Random dice;
	int cnt = 1;
	int dx;
	int bullet_dy = 3;
	int rand = 0;
	boolean shot;
	ImageIcon ballpic;
	
	Bullet bullet;
	
	public SEnemy()
	{
		dice = new Random();
		x = dice.nextInt(400);
		y = dice.nextInt(250);
		dx = dice.nextInt(6) + 4;
		attribute = "alien";
		ballpic = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Ball.PNG");
		bullet = new Bullet();
		bullet.setPicture(ballpic);
		bullet.y = -10;
		shot = false;
		
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
		
		rand = dice.nextInt(2);
		
		if(alive)
		{
			if(rand == 0 && !shot)
			{
				bullet.x = x + width/2;
				bullet.y = y + bullet_dy;
				shot = true;
			}
			
			if(shot)
			{
				bullet.y += bullet_dy;
				if(bullet.y >= 500)
				{
					bullet.y = -bullet_dy;
					shot = false;
				}
			}
		}
		else
		{
			bullet.y = -15;
		}
		
	}
}