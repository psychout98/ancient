import java.util.Scanner;

/*5.4) Design and implement a class called Sphere that contains instance data that represents a spheres
diameter. Define the Sphere constructor to accept and initialize the diameter, and include getter and
setter methods for the diameter. Include methods that calculate and return the volume and surface
area of the sphere (Formulas Volume: 4/3πr3 Surface Area: 4πr2). Include a toString method that
returns one-line description of the sphere. Create a driver class called MultiSphere, whose main
method instantiates and updates several Sphere objects.
 */
public class FiveFour {

	public static void main(String[] args){
		double diameter, volume,SA;
		Scanner scan = new Scanner(System.in);
		diameter = scan.nextDouble();
		volume=((4)*(Math.PI)*(Math.pow((diameter/2),3)))/3;
		SA=4*(Math.PI)*(Math.pow((diameter/2), 2));
		System.out.println("Diameter: "+String.valueOf(diameter)+"\nRadius: "+String.valueOf(diameter/2)+"\nVolume: "+String.valueOf(volume)+"\nSurface Area: "+String.valueOf(SA));
	}
}
