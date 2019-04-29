
public class FRCalien extends SEnemy {

	double t;

	public void update()
	{
		x = 100+ (int) (100 * Math.sin(t));
		y = 100+ (int) (100 *Math.cos(t));
		t += .2;
		
		super.fire_update();
	}

	
}
