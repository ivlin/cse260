public class TestComplex {

    public static void main(String[]args){
	Complex a = new Complex(1,1);
	Complex b = new Complex(2,-2);
	System.out.printf("%s+%s=%s\n",a.toString(),b.toString(),a.add(b).toString());
	System.out.printf("%s-%s=%s\n",a.toString(),b.toString(),a.subtract(b).toString());
	System.out.printf("%s*%s=%s\n",a.toString(),b.toString(),a.multiply(b).toString());
	System.out.printf("%s/%s=%s\n",a.toString(),b.toString(),a.divide(b).toString());
    }

}
Th
