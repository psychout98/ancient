public class DNAanalyzer {

	public static void main(String[] args) {
		String Test[] = { "A", "T", "T", "A", "G", "A", "C", "A", "T", "G",
				"G", "A", "G", "T", "T", "A", "C", "C", "A", "T" }, Target[] = {
				"A", "T", "A", "A", "G", "A", "C", "A", "A", "C", "G", "A",
				"G", "A", "T", "A", "C", "C", "A", "T" }, strand1 = "Test Strand:   ", strand2 = "Target Strand: ", complement = "Complement:    ",target="GGA";
		int similarity = 0;
		boolean found = false;
		for (int i = 0; i < 20; i++) {
			strand1 = strand1 + Test[i];
			strand2 = strand2 + Target[i];
			complement = complement + Complement(Test[i]);
			similarity += (Test[i].contains(Target[i]) ? 1 : 0);
			found=((strand1.contains(target))?true:false);
		}
		double similar = similarity * 5;
		System.out.println(strand1 + "\n" + strand2 + "\nThe strands are "
				+ similar + "% similar.\n\n" + strand1 + "\n" + complement
				+ "\n\nBonus:\n" + strand1 + "\nTarget: " + target + "\n"
				+ (found ? "Sequence found." : "Sequence not found."));
	}

	public static String Complement(String DNA) {
		return (DNA.contains("A") ? "T" : "") + (DNA.contains("T") ? "A" : "")
				+ (DNA.contains("G") ? "C" : "")
				+ (DNA.contains("C") ? "G" : "");
	}
}
