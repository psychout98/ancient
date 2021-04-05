
public class AudioDecrypt {
	
	String Notes[] = { "E ", "F ", "G ", "A1", "B1", "C1", "D1", "E1", "F1",
			"A2", "RS" };
	
	AudioDecrypt(){
		//collect audio file
		String num = "1";
		System.out.println(read(Notelist(num/*Audio file*/)));
		//Decryption(read(Notelist(Audio file)));
	}
	
	public static void main(String[] args){
	AudioDecrypt decrypt = new AudioDecrypt();	
	}
	
	public String Notelist(String num/*Audio file*/){
		String noteList = "";
		//for(Audio file length)
		noteList+=""+getNote(num/*note (retrieved from audio file*/);
		return noteList;
	}
	
	public String getNote(String num/*note*/){
		String Note = "";
				if(/*note = value of note "E"*/num == "0")
		Note = "E ";
				if(/*note = value of note "F"*/num == "1")
		Note = "F ";
				if(/*note = value of note "G"*/num == "2")
		Note = "G ";
				if(/*note = value of note "A1"*/num == "3")
		Note = "A1";
				if(/*note = value of note "B1"*/num == "4")
		Note = "B1";
				if(/*note = value of note "C1"*/num == "5")
		Note = "C1";
				if(/*note = value of note "D1"*/num == "6")
		Note = "D1";
				if(/*note = value of note "E1"*/num == "7")
		Note = "E1";
				if(/*note = value of note "F1"*/num == "8")
		Note = "F1";
				if(/*note = value of note "A2"*/num == "9")
		Note = "A2";
				if(/*note = value of note "REST"*/num == ".")
		Note = "RS";
		return Note;
	}
	
	public String read(String noteList){
		String encryptedMessage = "";
		for(int i=0; i<noteList.length(); i+=2){
			for(int j=0;j<10;j++)
			if(noteList.substring(i, i+2).contains(Notes[j]))
				encryptedMessage += j;
			if(noteList.substring(i, i+2).contains("RS"))
				encryptedMessage += ".";
		}
		return encryptedMessage;
		
	}
	
	
}
