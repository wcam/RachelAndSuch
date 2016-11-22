import java.util.Random;

public class Wheel {
	static int wheelSlots[] = {500,550,600,650,700,750,800,850,900,950}; //instantiates the wheelSlots array
	
	public static int spin(){
		Random rn = new Random();
		int spin = rn.nextInt(30); //returns random number, usually set to 30, set to one now for debug purposes
		if(spin == 0){ //if number is 0 then lose a turn
			return 98;
		}
		else if(spin == 1){ //if number is 1 then bankrupt
			return 99; //usually set to 99 but it's at 98 for debugging
		}
		else
		return wheelSlots[rn.nextInt(10)]; //returns a random value for the wheelSlots array.
	}

}
