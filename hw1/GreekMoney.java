/*
 * Ivan Lin
 * 111020797
 * CSE260
 * Homework 1
 */
public class GreekMoney{

    public static int howManyOboloi(int talents, int minae, int drachmae, int oboloi){
	minae += 60*talents;
	drachmae += 70*minae;
	oboloi+= 6*drachmae;
	return oboloi;
    }
    
}
