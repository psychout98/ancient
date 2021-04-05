
public class DNAcomp {


	public static void main(String[] args) {
		String DNA[] = {"A","T","G","C","A","T","G","C","A","T","G","C","A","T","G","C","A","T","G","C"},strand="DNA Strand: ",strand2="Complement: ";
		for(int i=0;i<20;i++){
			strand = strand+DNA[i];
			strand2 = strand2+complement(DNA[i]);
		}
		System.out.println(strand+"\n"+strand2);
	}
	public static String complement(String DNA){
		return (DNA.contains("A")?"T":"")+(DNA.contains("T")?"A":"")+(DNA.contains("G")?"C":"")+(DNA.contains("C")?"G":"");
	}

}
