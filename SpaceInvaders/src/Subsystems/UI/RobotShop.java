import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

public class RobotShop
{
	
	static ImageIcon shop = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Shop.PNG");
	static ShopTab shoptab = new ShopTab();
	static boolean state = false;
	
	public static void draw(Graphics g, Component c)
	{
		shoptab.draw(g, c, state);
		if(state)
		{
			g.drawImage(shop.getImage(),425,155,180,300,c);
		}
	}
	
	public static void onMousePress(Point mouse_coords)
	{
		boolean pressed = shoptab.isPressed(mouse_coords);
		if(pressed)
		{
			state = !state;
		}
	}
	
	public static void open()
	{
		state = true;
	}
	
	public static void close()
	{
		state = false;
	}
	
}