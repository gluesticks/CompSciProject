//package Subsystems.UI;


import javax.swing.*;

import java.awt.*;



public class UI_Compiler extends JApplet

{

	public static void main(String [] args)

	{

		//step 1, create a frame

		JFrame frame = new JFrame("FRC Space Invaders");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		//step 2, create a panel, put it in frame

		GameFrame panel = new GameFrame();

		frame.getContentPane().add(panel);



		//step 3, set frame size, make it visible

		frame.setSize(600,600);

		frame.setVisible(true);



	}



}
