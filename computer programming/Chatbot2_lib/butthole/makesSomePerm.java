
public class makesSomePerm {
public makesSomePerm(){}




public boolean arePermutation(int[] ar1, int[]ar2)
{
	int count=0;
for(int i = 0; i<ar1.length; i++){
	for(int j=0; j<ar1.length;j++){
		
		if(ar1[i]==ar2[j])
			count++;
		
		
	}
}	
if(count==ar1.length)
	return true;
else
	return false;


}



}
