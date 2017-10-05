/* Ivan Lin
 * 111020797
 * CSE260
 * Homework #2
 */

public class CarRepairShop{	

    private MyList carList, ticketList;
  
    public CarRepairShop(){
	carList = new MyList();
	ticketList = new MyList();
    }
    
    /** Adds a new car to the database with the provided VIN, make (e.g., Ford, Honda, Hyundai, etc.) and year of
     * manufacture. If a car with the given VIN already exists in the database, the method returns −1 and makes
     *	no changes to the database. Otherwise, the method returns the number of cars in the database after adding
     *	this new car.*/
    public int addNewCar(String vin, String make, int year) {
	for (int i=0; i<carList.size(); i++){
	    if (((Car)carList.get(i)).getVin().equals(vin)){
		return -1;
	    }
	}
	carList.push(new Car(vin,make,year));
	return carList.size();
    }

    /**Adds a new repair ticket to the database for the car with the provided VIN, repair cost and repair 
     *description. If no car with the given VIN exists in the database, the method returns −1 and makes no 
     *changes to the database. Otherwise, the method returns the repair ticket number. The first ticket 
     *added to the database has ticket number 1, the second has ticket number 2, etc. Ticket numbers always 
     *increase. For example, suppose 4 tickets were added and then two were deleted. The next ticket added 
     *would be assigned ticket number 5.*/
    public int addRepairTicket(String vin, double cost, String description) {
	Ticket t;
	for (int i=0; i<carList.size(); i++){
	    if (((Car)carList.get(i)).getVin().equals(vin)){
		t = new Ticket(ticketList.size(), vin, cost, description);
		ticketList.push(t);
		return t.getNumber();
	    }
	}
	return -1;
    }
    
    /** Returns the cost of the repair associated with the provided repair ticket number. 
     *If no repair ticket with the given number exists in the database, the method returns −1.0. 
     *Under no circumstances may the method make changes to the database*/
    public double getRepairCost(int ticketNum) {
	Ticket t = (Ticket)(ticketList.get(ticketNum));
	if (t != null && t.getStatus() != Ticket.VOID){
	    return t.getCost();
	}
	return -1.0;
    }

    /**Returns the total of all repair costs for the car with the provided VIN. If no car with 
     *the given VIN exists in the database, the method returns −1.0. Under no circumstances may 
     *the method make changes to the database.*/
    public double getTotalRepairCosts(String vin) {
	boolean carExists = false;
	for (int i=0; i<carList.size(); i++){
	    carExists = carExists || ((Car)(carList.get(i))).getVin().equals(vin);
	}
	if (carExists){
	    Ticket t;
	    double cost=0;
	    for (int i=0; i<ticketList.size(); i++){
		t = (Ticket)(ticketList.get(i));
		if (t.getVin().equals(vin) && t.getStatus()!=Ticket.VOID){
		    cost += t.getCost();
		}
	    }
	    return cost;
	}
	return -1.0;
    }

    /**Returns the make of car that had the greatest total number of repairs. Note that the method 
     *does not return the sum of the costs. Rather, it counts how many times each make of car was 
     *repaired and returns the make of the car having the greatest count. If there are no cars in 
     *the database, the method returns null. Under no circumstances may the method make changes to 
     *the database.
     **/
    public String getWorstCarMake() {
	MyList repairVinList = new MyList();
	for (int t=0; t<ticketList.size(); t++){
	    repairVinList.push(((Ticket)(ticketList.get(t))).getVin());
	}
	MyList makeList = new MyList();
	MyList countList = new MyList();
	boolean firstRepair;
	for (int v=0; v<repairVinList.size(); v++){
	    for (int c=0; c<carList.size(); c++){
		Car car = (Car)(carList.get(c));
		if (car.getVin().equals((String)repairVinList.get(v))){
		    firstRepair = true;
		    for (int m=0; m<makeList.size(); m++){
			if (car.getMake().equals((String)(makeList.get(m)))){
			    firstRepair = false;
			    countList.set((int)countList.get(m)+1, m);
			}
		    }
		    if (firstRepair){
			makeList.push(car.getMake());
			countList.push(1);
		    }
		}
	    }
	}
	int maxInd = 0;
	for (int i=0; i<countList.size(); i++){
	    if ((int)countList.get(i)>(int)countList.get(maxInd)){
		maxInd = i;
	    }
	}
	return makeList.size()>0 ? (String)makeList.get(maxInd) : null;
    }

    /** Updates the cost for the repair with the given ticket number to newCost and then returns true. 
     *	If no repair ticket with the given number exists in the database, the method returns false 
     *	and makes no changes to the database.
     */
    public boolean updateRepairCost(int ticketNum, double newCost) {
	Ticket t = ((Ticket)(ticketList.get(ticketNum)));
	if (t != null){
	    t.setCost(newCost);
	}
	return t!=null;
    }

    /**Deletes the repair with the given ticket number from the database and then returns true. 
     * If no repair ticket with the given number exists in the database, the method returns 
     * false and makes no changes to the database. */
    public boolean deleteRepair(int ticketNum) {
	Ticket t = ((Ticket)(ticketList.get(ticketNum)));
	if (t!=null){
	    t.deactivate();
	}
	return t!=null;
    }

    /**
     * Deletes all repairs for the car with the given VIN from the database and then returns true. If no car with
     * the given VIN exists in the database, the method returns false and makes no changes to the database.
     */
    public boolean deleteAllRepairsForCar(String VIN) {
	int deletedTicketCount=0;
	Ticket t;
	for (int i=0; i<ticketList.size(); i++){
	    t = (Ticket)(ticketList.get(i));
	    if (t!=null && t.getVin().equals(VIN)){
		t.deactivate();
		deletedTicketCount++;
	    }
	}
	return deletedTicketCount>0;
    }

    /**
     * Deletes the car and all repairs for the car with the given VIN from the database and then returns true. 
     * If no car with the given VIN exists in the database, the method returns false and makes no changes to 
     * the database.
     */
    public boolean deleteCarAndRepairs(String VIN) {
	Car c;
	Ticket t;
	boolean exists = false;
	for (int i=carList.size()-1; i>=0; i--){
	    c = (Car)(carList.get(i));
	    if (c.getVin().equals(VIN)){
		exists = true;
		carList.remove(i);
	    }
	}
	for (int i=0; i<ticketList.size(); i++){
	    t=(Ticket)ticketList.get(i);
	    if (t.getVin().equals(VIN)){
		t.deactivate();
	    }
	}
	return true;
    }


    private class Car{
	private String vin, make;
	private int year;

	public Car(String vin, String make, int year){
	    this.vin=vin;
	    this.make=make;
	    this.year = year;
	}

	public String getVin(){
	    return vin;
	}

	public String getMake(){
	    return make;
	}

	public int getYear(){
	    return year;
	}
    }

    private class Ticket{

	public static final int ACTIVE = 0;
	public static final int VOID = 1;

	private int status, number;
	private double cost;
	private String vin, description;
	
	public Ticket(int number, String vin, double cost, String description){
	    this.number = number;
	    this.vin = vin;
	    this.cost = cost;
	    this.description = description;
	    this.status = Ticket.ACTIVE;
	}

	public String getVin(){
	    return vin;
	}

	public int getStatus(){
	    return status;
	}

	public double getCost(){
	    return cost;
	}

	public String getDescription(){
	    return description;
	}

	public int getNumber(){
	    return number;
	}

	public void setCost(double newCost){
	    cost = newCost;
	}

	public void deactivate(){
	    this.status = Ticket.VOID;
	}
    }
}
