public class Complex{
    double a, b;

    public Complex(){
	this(0,0);
    }

    public Complex(double setA){
	this(setA,0);
    }

    public Complex(double setA, double setB){
	a=setA;
	b=setB;
    }

    public Complex add(Complex other){
	return new Complex(getRealPart()+other.getRealPart(),getImaginaryPart()+other.getImaginaryPart());
    }

    public Complex subtract(Complex other){
	return new Complex(getRealPart()-other.getRealPart(),getImaginaryPart()-other.getImaginaryPart());
    }

    public Complex multiply(Complex other){
	return new Complex(getRealPart()*other.getRealPart() - getImaginaryPart()*other.getImaginaryPart(), getRealPart()*other.getImaginaryPart() + getImaginaryPart()*other.getRealPart());
    }

    public Complex divide(Complex other){
	double denom=other.getRealPart()*other.getRealPart()+other.getImaginaryPart()*other.getImaginaryPart();
	return new Complex((getRealPart()*other.getRealPart()+getImaginaryPart()*other.getImaginaryPart())/denom,(getImaginaryPart()*other.getImaginaryPart()-getRealPart()*other.getRealPart())/denom);
    }

    public double getRealPart(){
	return a;
    }

    public double getImaginaryPart(){
	return b;
    }

    public String toString(){
	return "("+a+"+"+b+"i)";
    }
}
