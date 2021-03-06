public class TestMyInteger{

    public static void main(String[] args){
	int zero=0;
	int one=1;
	int ten=10;
	int prime=13;
	MyInteger myzero = new MyInteger(zero);
	MyInteger myone = new MyInteger(one);
	MyInteger myten = new MyInteger(ten);
	MyInteger myprime = new MyInteger(prime);

	int[] primitives={zero,one,ten,prime};
	MyInteger[] wrappers={myzero,myone,myten,myprime};

	for (int i: primitives){
	    System.out.printf("int test %d: isEven - %b, isOdd - %b, isPrime - %b\n", i, MyInteger.isEven(i), MyInteger.isOdd(i), MyInteger.isPrime(i));
	}
	for (MyInteger i: wrappers){
	    System.out.printf("MyInteger instance test %d: isEven - %b, isOdd - %b, isPrime - %b\n", i.getValue(), i.isEven(), i.isOdd(), i.isPrime());
	}
	for (MyInteger i: wrappers){
	    System.out.printf("MyInteger class test %d: isEven - %b, isOdd - %b, isPrime - %b\n", i.getValue(), MyInteger.isEven(i), MyInteger.isOdd(i), MyInteger.isPrime(i));
	}
    }
}
