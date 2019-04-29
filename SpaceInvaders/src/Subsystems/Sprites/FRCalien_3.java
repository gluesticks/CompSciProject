import javax.swing.ImageIcon;

public class FRCalien_3 extends SEnemy {
	
	ImageIcon picture = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Enemy_Ship_3.PNG");
	int x_target = dice.nextInt(500-x) + x;
	int cnty = 1;
	int points = 1500;
	
	public FRCalien_3()
	{
		super();
		setPicture(picture);
	}
	
	public void update() 
	{
		if(cnt%2 != 1)
		{
			x += dx;
			if(x > x_target) {
				x_target = dice.nextInt(Math.abs(x));
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
		
		super.fire_update();
	}

}
