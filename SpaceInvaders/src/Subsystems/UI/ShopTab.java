import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class ShopTab extends Rectangle 
{
	
	ImageIcon shop_tab_open = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/ShopTab_Open.PNG");
	ImageIcon shop_tab_closed = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/ShopTab_Closed.PNG");
	ImageIcon picture = shop_tab_closed;

	public ShopTab()
	{
		x = 560;
		y = 250;
		width = 25;
		height = 100;
	}
	
	public void draw(Graphics g, Component c, boolean state)
	{
		g.drawImage(picture.getImage(),x,y,width,height,c);
		if(state)
		{
			picture = shop_tab_open;
			x = 400;
		}
		else
		{
			picture = shop_tab_closed;
			x = 560;
		}
	}
	
	public boolean isPressed(Point mouse_coords)
	{
		return this.contains(mouse_coords);
	}
}
