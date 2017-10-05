public class MyInteger {
    private int value;

    public MyInteger(int valSet){
	value = valSet;
    }

    public int getValue(){
	return value;
    }

    public boolean isEven(){
	return getValue()%2==0;
    }

    public boolean isOdd(){
	return getValue()%2==1;
    }

    public boolean isPrime(){
	for (int i=2; i<= Math.sqrt(getValue()); i++){
	    if (getValue()%i==0){
		return false;
	    }
	}
	return getValue() >= 2;
    }

    public static boolean isEven(int val){
	return val%2==0;
    }

    public static boolean isOdd(int val){
	return val%2==1;
    }

    public static boolean isPrime(int val){
	for (int i=2; i<= Math.sqrt(val); i++){
	    if (val%i==0){
		return false;
	    }
	}
	return val>=2;
    }
    
    public static boolean isEven(MyInteger val){
	return val.getValue()%2==0;
    }

    public static boolean isOdd(MyInteger val){
	return val.getValue()%2==1;
    }

    public static boolean isPrime(MyInteger val){
	for (int i=2; i<= Math.sqrt(val.getValue()); i++){
	    if (val.getValue()%i==0){
		return false;
	    }
	}
	return val.getValue()>=2;
    }
}
