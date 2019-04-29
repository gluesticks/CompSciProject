import javax.swing.ImageIcon;

public class FRCalien_2 extends SEnemy
{
	
	ImageIcon picture = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Enemy_Ship_2.PNG");
	int y_target = dice.nextInt(250-y) + y;
	int cnty = 1;
	int points = 1000;
	
	public FRCalien_2()
	{
		super();
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
		
		super.fire_update();
	}

	public void setPrey(Ship ship) {
		// TODO Auto-generated method stub
		
	}

}