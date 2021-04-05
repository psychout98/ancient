public class FlightTest {
	public static void Main(String[] args) {
		Flight f[] = { new Flight("American Airlines", 314, "APN", "AOO"),
				new Flight("Canadian Airways", 159, "BWI", "ABR"),
				new Flight("Virgin Airlines", 265, "YXX", "BFL"),
				new Flight("Global Air", 358, "BED", "BKW"),
				new Flight("Nateghi-Asli Ariways", 979, "ABY", "AIA"),
				new Flight("Presidential Airlines", 323, "ATL", "AEX"),
				new Flight("Frank the Doge Arilines", 846, "YBG", "AHN"),
				new Flight("Ewok Airways", 264, "YAA", "CYS"),
				new Flight("McDonalds Airlines/Restaurant", 338, "BJI", "BHB"),
				new Flight("Vestibulum arcu", 327, "CLT", "BET") };
		for (int i = 0; i < 10; i++)
			System.out.println(f[i]);

	}
}
