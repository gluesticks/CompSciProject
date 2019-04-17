
public class FRCalien extends SEnemy {

	double t;

	public void update()
	{
		x = 100+ (int) (100 * Math.sin(t));
		y = 100+ (int) (100 *Math.cos(t));
		t += .2;
		
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
