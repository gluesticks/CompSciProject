public class FRCalien_4 extends SEnemy {
	
	int x_target = dice.nextInt(500);
	int y_target = dice.nextInt(250);
	boolean x_reached = false;
	boolean y_reached = false;
	int direction_x = (int) Math.signum(x_target - x);
	int direction_y = (int) Math.signum(y_target - y);
	
	public void update()
	{
		if(!x_reached)
		{
			if(direction_x==1) {
				if(x >= x_target)
					x_reached = true;
				else
					x += dx;
			}
			else if(direction_x==-1) {
				if(x <= x_target)
					x_reached = true;
				else
					x -= dx;				
			}
			else if(direction_x==0)
				x_reached = true;
		}
		if(!y_reached)
		{
			if(direction_y==1) {
				if(y >= y_target)
					y_reached = true;
				else
					y += dx;
			}
			else if(direction_y==-1) {
				if(y <= y_target)
					y_reached = true;
				else
					y -= dx;			
			}
			else if(direction_y==0)
				y_reached = true;
		}
		if(x_reached && y_reached) 
		{
			x_target = dice.nextInt(500);
			y_target = dice.nextInt(250);	
			direction_x = (int) Math.signum(x_target - x);
			direction_y = (int) Math.signum(y_target - y);
			x_reached = false;
			y_reached = false;
		}
		
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
