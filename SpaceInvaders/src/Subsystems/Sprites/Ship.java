import Subsystems.Projectiles.GameObject;

public class Ship extends GameObject
{

	//ship velocity
	int dx;
	
	public Ship()
	{
		attribute = "ship";
	}
	public void update()
	{
		x+=dx;
	}

}