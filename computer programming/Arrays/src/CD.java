
public class CD {

	String title, artist;
	double cost;
	int tracks;
	
	public CD(String Title, String Artist,double Cost, int Tracks){
		title=Title;
		artist=Artist;
		cost=Cost;
		tracks=Tracks;
	}
	public String toString(){
		return "Title: "+title+"\nArtist: "+artist+"\nCost: "+cost+"\nTracks: "+tracks;
	}
	
}
