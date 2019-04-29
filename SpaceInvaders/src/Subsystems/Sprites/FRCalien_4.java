import javax.swing.ImageIcon;

public class FRCalien_4 extends SEnemy {
	
	ImageIcon picture = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Enemy_Ship_4.PNG");
	int x_target = dice.nextInt(500);
	int y_target = dice.nextInt(250);
	boolean x_reached = false;
	boolean y_reached = false;
	int direction_x = (int) Math.signum(x_target - x);
	int direction_y = (int) Math.signum(y_target - y);
	int points = 2000;
	
	public FRCalien_4()
	{
		super();
		setPicture(picture);
	}
	
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
		
		super.fire_update();
	}
	
}
