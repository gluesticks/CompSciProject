package Subsystems.Projectiles;

public class Asteroids
{
    public void move(int x, int y)
    {
        x += Math.rint(10);
        y += Math.rint(10);
    }
    public boolean hitDetection(boolean hit)
    {
        return hit;
    }
    public boolean boundaryCheck(int x, int y, boolean inBounds)
    {
        //screenX = <insert screen width>
        //screenY = <insert scrren height>
        return inBounds;
    }
}