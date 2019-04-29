import Subsystems.Projectiles.GameObject;

public class Ship extends GameObject
{

	//ship velocity
	int dx;
	
	//ship lives
	public int lives;
	
	public Ship()
	{
		attribute = "ship";
		lives = 3;
	}
	public void update()
	{
		x+=dx;
	}
	public void damage()
	{
		lives -= 1;
	}

}