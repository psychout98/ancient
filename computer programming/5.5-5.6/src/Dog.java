//pd.7 Noah Heath 4/22/14
public class Dog {
	private String Name;
	private int Age;

	public Dog(int age, String name) {
		Age = age;
		Name = name;
	}

	public String getName() {
		return Name;
	}

	public int getAge() {
		return Age;
	}

	public int personAge() {
		return Age / 7;
	}
	
	public void setName(String newName){
		Name=newName;
	}
	
	public void setAge(int newAge){
		Age = newAge;
	}

	public String toString() {
		return "Name: " + Name + "\nAge: " + Age + "\nPerson Age: "
				+ personAge();
	}
}
