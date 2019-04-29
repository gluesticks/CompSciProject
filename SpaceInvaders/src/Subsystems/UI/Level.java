
public class Level {
	
	public static void next_level(int level) 
	{
		if(level==1) {
			level_2();
		} else if(level==2) {
			level_3();
		} else if(level==3) {
			level_4();
		} else if(level==4) {
			level_5();
		}
	}

	public static void level_1() 
	{
		addAlien1(3);
	}
	
	public static void level_2()
	{
		addAlien1(2);		
		addAlien2(2);

	}
	
	public static void level_3()
	{
		addAlien1(3);
		addAlien2(2);
		addAlien3(1);
	}	
	
	public static void level_4()
	{
		addAlien2(5);
	}
	
	public static void level_5()
	{
		addAlien1(2);
		addAlien2(1);
		addAlien4(3);
	}
	
	
	
	private static void addAlien1(int count)
	{
		for(int i=0; i<count; i++)
		{
			SEnemy a = new SEnemy();
			GameFrame.masterList.add(a);	
		}
	}
	private static void addAlien2(int count)
	{
		for(int i=0; i<count; i++)
		{
			FRCalien_2 a = new FRCalien_2();
			GameFrame.masterList.add(a);
		}
	}
	private static void addAlien3(int count)
	{
		for(int i=0; i<count; i++)
		{
			FRCalien_3 a = new FRCalien_3();
			GameFrame.masterList.add(a);
		}
	}
	private static void addAlien4(int count)
	{
		for(int i=0; i<count; i++)
		{
			FRCalien_4 a = new FRCalien_4();
			GameFrame.masterList.add(a);
		}
	}
}
