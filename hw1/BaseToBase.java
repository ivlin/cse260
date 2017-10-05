/*
 * Ivan Lin
 * 111020797
 * CSE260
 * Homework 1
 */

public class BaseToBase{

    public static String base2base(String n, int b1, int b2){
	int base10=0;
	char ch;
	for (int i=0; i<n.length(); i++){
	    base10*=b1; 
	    ch = n.charAt(i);
	    if (ch>='0' && ch<='9'){
		base10+= ch-'0';
	    }
	    else if (ch>='A' && ch<='Z'){
		base10+= ch-'A';
	    }
	    else{
		System.out.println("Invalid input");
	    }
	}
	String out="";
	int cur;
	while (base10 > 0){
	    cur = base10%b2;
	    base10 = base10/b2;
	    out = (cur <= 9 ? cur : 'A' + (char)(cur - 10)) + out;
	}
	return out;
    }
}
