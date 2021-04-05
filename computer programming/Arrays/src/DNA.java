
public class DNA {

	public static void main(String[] args) {
		String DNA[] = {"A","T","G","C","A","T","G","C","A","T","G","C","A","T","G","C","A","T","G","C"},strand="DNA Strand: ";
		int a=0,t=0,g=0,c=0;
		for(int i=0;i<20;i++){
			strand = strand+DNA[i];
			a+=(DNA[i].contains("A")?1:0);
			t+=(DNA[i].contains("T")?1:0);
			g+=(DNA[i].contains("G")?1:0);
			c+=(DNA[i].contains("C")?1:0);
		}
		System.out.println(strand+"\n\nAdenine: "+a+"\nThymine: "+t+"\nGuanine: "+g+"\nCytosine: "+c);
	}

}
