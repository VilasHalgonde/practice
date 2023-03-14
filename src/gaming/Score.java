package gaming;



 class GameEntry {
	String name;
	int score;
	public GameEntry(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	
	}
	@Override
	public String toString() {
		return "GameEntry [name=" + name + ", score=" + score + "]";
	}
}


public class Score {
	GameEntry[] gameentry;
	int maxEntries =10;
	int noEntries;
	Score()
	{
		gameentry = new GameEntry[maxEntries] ;
		noEntries=0;
	}
	@Override
	public String toString() {
		String s = "[";
		for(int i =0; i<noEntries; i++)
		{
			if(i>0)
			{
				s += gameentry[i];
			}
		}
		return s +"]";
	}
	public void addGameEntry(GameEntry e)
	{
		int newScore = e.getScore();
		if(noEntries==maxEntries)
		{
			if(newScore <= gameentry[maxEntries-1].getScore())
			{
				return;
			}
		}
		else
		{
			noEntries++;
			gameentry[noEntries-1]=e;
			for(int i =0; i<noEntries; i++)
			{
				for(int j =i+1; j<noEntries; j++)
				{
					if(gameentry[i].getScore()<gameentry[j].getScore())
					{
						GameEntry temp=gameentry[i];
						gameentry[i]=gameentry[j];
						gameentry[j]=temp;
					}
				}
			}
		}
	}
	public void  remove(int i) 
	{
		
		if(i<0 || i>=noEntries)
		{
			System.out.println("innvalid choice");
			return;
		}
		
		else
		{
			GameEntry temp = gameentry[i];
			for(int j =0; j<noEntries; j++)
			{
				if(temp==gameentry[j])
				{
					noEntries--;
					for(int k=j; k<=noEntries; k++)
					{
						gameentry[k] = gameentry[k+1];
					}
			              
					
					System.out.println("Removed"+temp);
			         break;	
				}
			}
		}
	}
	public void print()
	{
		for(int i =0; i<noEntries; i++)
		{
			System.out.println(gameentry[i]);
		}
	}
	public static void main(String[] args) {
		Score score = new Score();
		 score.toString();
		score.addGameEntry(new GameEntry("ind", 279));
		score.addGameEntry(new GameEntry("ban", 282));
		score.addGameEntry(new GameEntry("afg", 223));
		score.addGameEntry(new GameEntry("eng", 265));
		score.addGameEntry(new GameEntry("nz", 245));
		score.addGameEntry(new GameEntry("pak", 211));
		score.print();
		score.remove(3);
		score.print();
		System.out.println("...........");
	}
}
