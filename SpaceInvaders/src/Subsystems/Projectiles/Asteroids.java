package Subsystems.Projectiles;

public class Asteroids
{
    public void move(int x, int y)
    {
        x += Math.rand();
        y += Math.rand();
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