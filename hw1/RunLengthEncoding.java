/*
 * Ivan Lin
 * 111020797
 * CSE260
 * Homework 1
 */
public class RunLengthEncoding{
    
    public static String encode(String message, char delimiter){
	String str="";
	int charCount=0;
	char curChar=message.charAt(0);
	for (int i=0; i<=message.length(); i++){
	    if (i<message.length() && message.charAt(i)==curChar){
	        charCount++;
	    }
	    else{
		if (charCount > 3){
		    str+=delimiter;
		    str+=curChar;
		    str+=charCount;
		}
		else{
		    for (int c=0; c<charCount; c++){
			str+=curChar;
		    }
		}
		charCount=1;
		if (i < message.length()){
		    curChar = message.charAt(i);
		}
	    }
	}
	return str;
    }
}
