import javax.swing.*;

public class Update extends Thread
{

	GameFrame panel;

	public Update(GameFrame p)
	{
		panel = p;
	}

	public void run()
	{
		while(true)
		{
			panel.update();

			//wait awhile
			try{Thread.sleep(50);}
			catch(Exception e){}
		}
	}


}