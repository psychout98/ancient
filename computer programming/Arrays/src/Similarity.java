
public class Similarity {

	public static void main(String[] args){
		int array1[] = {4,9,8,3,2,4,2,5,1,1},array2[] = {4,3,8,8,1,4,7,2,1,4}, similarity = 0;
		String a1="Array 1: ",a2="Array 2: ";
		for(int i=0;i<10;i++){
			a1=a1+array1[i]+" ";
			a2=a2+array2[i]+" ";
			if(array1[i] == array2[i])
				similarity++;
		}
		System.out.println(a1+"\n"+a2+"\nThere are "+similarity+" numbers in the same spots.");
	}
}
