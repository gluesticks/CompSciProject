package Subsystems.Projectiles;
import java.awt.Rectangle;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.*;

public class Bullets
{
	
    public static LinkedList<Bullet> bullets = new LinkedList<Bullet>();
    static int[] bounds = { 0, 500 };
    
    public static void addBullet(int x, int y, int dy, String attr) 
    {
    	Bullet bullet = new Bullet(x, y, dy, attr);
    	bullets.add(bullet);
    }
    
    public static void delBullet(Bullet b)
    {
    	bullets.remove(b);
    }
    
    public static void delAllBullets()
    {
    	while(bullets.size()!=0)
    		bullets.remove();
    }
    
    public static boolean checkBulletIntersection(GameObject go, String attr)
    {
    	boolean hit = false;
    	Bullet hit_bullet = null;
    	for(Bullet b: bullets)
    	{
    		if(b.intersects(go) && b.attribute.equalsIgnoreCase(attr))
    		{
    			hit_bullet = b;
    			hit = true;
    		}
    	}
    	delBullet(hit_bullet);
        return hit;
    }
    
    private static void checkOutOfBounds()
    {
    	LinkedList<Bullet> oob_bullets = new LinkedList<Bullet>();
    	for(Bullet b: bullets)
    	{
			if(b.y < bounds[0] || b.y > bounds[1])
				oob_bullets.add(b);
    	}
    	for(Bullet b: oob_bullets)
    		delBullet(b);
    }
    
    public static void drawBullets(Graphics g, Component c) 
    {
    	for(Bullet b: bullets)
    	{
    		b.draw(g, c);
    	}
    }
    
	public static void update() 
	{
		for(Bullet b: bullets)
		{
			b.update();
		}
		checkOutOfBounds();
	}
    
}