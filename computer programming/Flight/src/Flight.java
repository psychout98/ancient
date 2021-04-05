public class Flight {
	public String Name, Destination, Origin;
	public int Number;

	public Flight(String name, int number, String origin, String destination) {
		Name = name;
		Number = number;
		Origin = origin;
		Destination = destination;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int newNumber) {
		Number = newNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String newName) {
		Name = newName;
	}
	
	public String getDestination(){
		return Destination;
	}
	
	public void setDestination(String newDestination){
		Destination=newDestination;
	}
	
	public String getOrigin(){
		return Origin;
	}
	
	public void setOrigin(String newOrigin){
		Origin = newOrigin;
	}
	
	public String toString(){
		return "Flight Name: "+Name+"\nFlight Number: "+Number+"\nOrgign: "+Origin+"\nDestination: "+Destination;
	}

}
