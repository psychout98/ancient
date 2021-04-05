
public class CDCollection {
	CD collection[] = new CD[100];
	int count;
	double totalcost;
	
	public CDCollection(){
		count=0;
		totalcost=0;
	}
	
	public void addCD(String title, String artist, double cost, int tracks){
		collection[count] = new CD(title,artist,cost,tracks);
		count++;
		totalcost+=cost;
	}
	
	public String toString(){
		String list="";
		for(int i=0;i<count;i++)
			list+=collection[i].toString()+"\n\n";
		double averagecost = totalcost/count;
		return "Collection :\n\nNumber of CDs: "+count+"\nTotal Cost: "+totalcost+"\nAverage cost: "+averagecost+"\n\nCD List:\n\n"+list;
	}
	
	public void increaseSize(){
		CD newCollection[]= new CD[collection.length*2];
		for(int i=0;i<count;i++)
			newCollection[i]=collection[i];
	}
}
