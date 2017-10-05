public class ComplexMatrix extends GenericMatrix<Complex>{

    public static void main(String[]args){
	Complex[][] c1 = { {new Complex(1,1), new Complex(0,0)},
		{new Complex(0,0), new Complex(2,2)} };
	Complex[][] c2 = { {new Complex(1,0), new Complex(2,1)},
		{new Complex(1,1), new Complex(2,2)} };
	ComplexMatrix c = new ComplexMatrix();
	c.printResult(c1, c2, c.addMatrix(c1,c2), '+');;
    }
    
    public ComplexMatrix(){	
    }

    public Complex add(Complex o1, Complex o2){
	return o1.add(o2);
    }

    public Complex multiply(Complex o1, Complex o2){
	return o1.multiply(o2);
    }

    public Complex zero(){
	return new Complex(0,0);
    }
}
