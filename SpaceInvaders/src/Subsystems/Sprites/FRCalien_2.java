public class FRCalien_2 extends SEnemy
{
	
	int y_target = dice.nextInt(250-y) + y;
	int cnty = 1;
	
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
		
		if(cnty%2 != 1)
		{
			y += dx;
			if(y > y_target)
			{
				y_target = dice.nextInt(y);
				cnty++;
			}
		}
		else
		{
			y -= dx;
			if(y < y_target)
			{
				y_target = dice.nextInt(250-y) + y;
				cnty++;
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

	public void setPrey(Ship ship) {
		// TODO Auto-generated method stub
		
	}

}