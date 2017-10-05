/*
 * Ivan Lin
 * 111020797
 * CSE260
 * Homework 1
 */

public class Length3SubstringMatch{
    
    /*
     *@return int num of positions where they contain the same length 3 substring
     */
    public static int stringMatch3(String a, String b){
	int matchCount=0;
	int currentMatch=0;
	for (int i=0; i<a.length() && i<b.length(); i++){
	    if (a.charAt(i)==b.charAt(i)){
		currentMatch+=1;
	    }
	    else{
		matchCount+= currentMatch >= 3 ? currentMatch-2 : 0;
		currentMatch=0;
	    }
	}
	matchCount+= currentMatch >= 3 ? currentMatch-2 : 0;
	return matchCount;
    }
}
