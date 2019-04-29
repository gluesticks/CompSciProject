import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Button extends Rectangle 
{
	
	ImageIcon picture = new ImageIcon("SpaceInvaders/src/Subsystems/Sprites/Button.PNG");
	String text;
	public int offset;
	boolean show = false;
	
	public Button(String text, int offset, int x, int y)
	{
		this.text = text;
		this.offset = offset;
		this.x = x;
		this.y = y;
		width = 150;
		height = 45;
	}
	
	public void draw(Graphics g, Component c)
	{
		if(show)
		{
			g.drawImage(picture.getImage(),x,y,width,height,c);
			g.setFont(new Font("sansserif", Font.BOLD, 25));
			g.setColor(Color.RED);
			g.drawString(text, x + 12 + offset, y + 30);
			g.setColor(Color.BLACK);
		}
	}
	
	public boolean isPressed(Point mouse_coords)
	{
		return this.contains(mouse_coords);
	}
	
	public void show()
	{
		show = true;
	}
	
	public void hide()
	{
		show = false;
	}
	
}
