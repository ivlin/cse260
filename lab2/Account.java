public class Account{
    private int id;
    private double balance,annualInterestRate;
    private Date dateCreated;

    public Account(){
	this(0,1000);
    }

    public Account(int newId, double newBalance){
	id=newId;
	balance=newBalance;
	annualInterestRate=4.5;
	dateCreated=new Date();
    }

    public int getId(){
	return id;
    }

    public double getBalance(){
	return balance;
    }

    public double getInterestRate(){
	return interestRate;
    }

    public Date getDateCreate(){
	return dateCreated;
    }

    public double getMonthlyInterestRate(){
	return getInterestRate()/12;
    }

    public void withdraw(double amt){
	if (amt>getBalance()){
	    System.out.println("not enough money");
	}
	else{
	    balance-=amt;
	}
    }

    public void deposit(double amt){
	balance+=amt;
    }
}
