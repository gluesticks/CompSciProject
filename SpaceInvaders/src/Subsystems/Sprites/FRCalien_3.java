public class FRCalien_3 extends SEnemy {
	
	int x_target = dice.nextInt(500-x) + x;
	int cnty = 1;
	
	public void update() 
	{
		if(cnt%2 != 1)
		{
			x += dx;
			if(x > x_target) {
				x_target = dice.nextInt(x);
				if(cnty%2 != 1) {
					y += dx;
					if(y > 250)
						cnty++;
				}
				else {
					y -= dx;
					if(y < 0)
						cnty++;
				}
				cnt++;
			}
		}
		else
		{
			x -= dx;
			if(x < x_target) {
				x_target = dice.nextInt(500-x) + x;
				if(cnty%2 != 1) {
					y += dx;
					if(y > 250)
						cnty++;
				}
				else {
					y -= dx;
					if(y < 0)
						cnty++;
				}
				cnt++;
			}
		}		
		
		rand = dice.nextInt(2);
		
		if(alive)
		{
			if(rand == 0 && !shot)
			{
				bullet.x = x + width/2;
				bullet.y = y + 5;
				shot = true;
			}
			
			if(shot)
			{
				bullet.y += 10;
				if(bullet.y >= 500)
				{
					bullet.y = -5;
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
