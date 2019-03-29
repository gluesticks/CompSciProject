package Subsystems.Projectiles;
import java.awt.Image;
import javax.swing.*;
/**
 * Ball - Jake Bryant
 */
public class Ball 
{
    public void hitDetection()
    {
        //define hitbox size
        //if Ball is touching enemy sprite, call damage class
            //despawn Sprite
        //else keep looking
    }
    public void damage(int damage, int healthStat)
    {
        //damage = (some set amount)
        //healthStat -= damage
    } 
    public void boundaryCheck(int ballX, int ballY)
    {
        //if ballX <= screenX and ballY <= screenY
            //keep Ball sprite
        //elif ballX > screenX or ballY > screenY
            //despawn Ball sprite
            //set fire_ball to true
    } 
    public void fire_ball(boolean fire)
    {
        //if ball is not on screen
            //set fire = true
        //elif Ball object is on screen
            //set fire = false
    }
}

