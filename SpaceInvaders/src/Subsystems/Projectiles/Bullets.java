package Subsystems.Projectiles;
import java.awt.Rectangle;
import java.awt.geom.*;
public class Bullets
{
    public int getBulletPos()
    {
        //call class to get sprite pos
        return bulletPos;
    }
    public Rectangle(int x, int y, int width, int height)
    {
        //x = <get shipXPos>
        //y = <get shipYPos>
        width = 10;
        height = 15;
    }
    public void move(int x, int y, int screenX, int screenY)
    {
        while(x < screenX && y < screenY)
        {
            x += 3;
            y += 3;
        }
        if( x > screenX || x < screenX || y > screenY || y < screenY)
        {
            //despawn bullet
        }
    }
    public boolean hitDetection(boolean hit)
    {
        return hit;
    }
    public void damage(int damage, int healthStat)
    {
        //if hitDetection returns true
            //healthStat -= 5
        
    }
    public boolean boundaryCheck(int bulletX, int bulletY, int screenX, int screenY, boolean inBounds)
    {
        //if bulletX <= screenX and bulletY <= screenY
            //set inBounds = true
        //elif bulletX > screenX or bulletY > screenY
            //set inBounds = false
            return inBounds;
    }
    public boolean bulletFire(boolean bulletFire)
    {
        //at some random point in time the enemy will fire a bullet
        //if (set amount of time) passes
            //wait set random interval of time to fire bullet
        return bulletFire;
    }
}