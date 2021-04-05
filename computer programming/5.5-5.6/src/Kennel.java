//pd.7 Noah Heath 4/22/14
public class Kennel {
	public static void main(String[] args){
		Dog dog1=new Dog(77,"Rufus");
		Dog dog2=new Dog(1324,"Flurn");
		Dog dog3=new Dog(12,"Mom");
		System.out.println(dog1+"\n"+dog2+"\n"+dog3);
		dog1.setAge(84);
		dog1.setName("Charlie");
		System.out.println(dog1);
	}
}
