import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Letters{

    public static void main(String[]args) throws IOException{
	FileReader f = new FileReader(args[0]);

	HashMap<String,Integer> letterCnt = new HashMap<String,Integer>();
	letterCnt.put("A",0);
	letterCnt.put("E",0);
	letterCnt.put("I",0);
	letterCnt.put("O",0);
	letterCnt.put("U",0);
	String c;
	int read;
	while ((int)(read=f.read()) != (int)(-1)){
	    c = ""+(char)read;
	    if (c.equalsIgnoreCase("a")){
		letterCnt.put("A",letterCnt.get("A")+1);
	    }
	    if (c.equalsIgnoreCase("e")){
		letterCnt.put("E",letterCnt.get("E")+1);
	    }
	    if (c.equalsIgnoreCase("i")){
		letterCnt.put("I",letterCnt.get("I")+1);
	    }
	    if (c.equalsIgnoreCase("o")){
		letterCnt.put("O",letterCnt.get("O")+1);
	    }
	    if (c.equalsIgnoreCase("u")){
		letterCnt.put("U",letterCnt.get("U")+1);
	    }
	}
	System.out.println(letterCnt);
    }
}
