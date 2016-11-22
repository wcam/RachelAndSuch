public class Player {  //this whole class is pretty self explanatory
	int roundBalance = 0;
	int gameBalance = 0;
	int winCount = 0;
	int playerCount = 0;
	String name = "Unassigned";
	
	public void setName(String n){
		this.name = n;
	}	
	public void setWinCount(int wc){
		this.winCount += wc;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPlayerNum(int pc){
		this.playerCount = pc;
	}
	
	public int getPlayerNum(){
		return playerCount;
	}
	
	public void setRoundBalance(int rb){
		this.roundBalance = rb;
	}
	
	public int getRoundBalance(){
		return roundBalance;
	}

	public int getGameBalance(){
		return gameBalance;
	}
	
	public void setGameBalance(int gb){
		this.gameBalance = gb;
	}
	
	public void addGameBalance(int gb){
		this.gameBalance += gb;
	}
	
	public void addRoundBalance(int rb){
		this.roundBalance += rb;
	}
}
