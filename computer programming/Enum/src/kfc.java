public class kfc {
	enum Menu {
		Chicken, Sandwich, Classic, Side, Dessert
	}

	enum Chicken {
		Original, BonelessOriginal, ExtraCrispy, Grilled, Tenders, HotWings, Bites, GoCups
	}

	enum Sandwiches {
		Doublicious, ChickenLittles
	}

	enum Classics {
		FamousBowl, PotPie
	}

	enum Sides {
		MashedPotatoes, ColeSlaw, MacCheese, Wedges, GreenBeans, Biscuits, KernelCorn, CobCorn
	}

	enum Desserts {
		ChocolateChipCake, ChocolateChipCookie
	}

	public static void main(String[] args) {
		Chicken chicken1, chicken2, chicken3;
		Sides side1, side2, side3, side4, side5;
		Desserts dessert1, dessert2, dessert3;
		Sandwiches sandwich1, sandwich2;
		Menu chicken, sandwich, classic, side, dessert;
		chicken = Menu.Chicken;
		sandwich = Menu.Sandwich;
		classic = Menu.Classic;
		side = Menu.Side;
		dessert = Menu.Dessert;
		Classics classic1;
		chicken1 = Chicken.Original;
		chicken2 = Chicken.ExtraCrispy;
		chicken3 = Chicken.HotWings;
		side1 = Sides.Wedges;
		side2 = Sides.MacCheese;
		side3 = Sides.KernelCorn;
		side4 = Sides.GreenBeans;
		side5 = Sides.Biscuits;
		dessert1 = Desserts.ChocolateChipCookie;
		dessert2 = dessert1;
		dessert3 = Desserts.ChocolateChipCake;
		sandwich1 = Sandwiches.Doublicious;
		sandwich2 = Sandwiches.ChickenLittles;
		classic1 = Classics.PotPie;
		System.out.println("Order 1 value: " + chicken1 + " " + chicken + ", "
				+ side1 + " " + side + ", " + dessert1 + " " + dessert);
		System.out.println("Order 1 ordinal: " + chicken1.ordinal() + " "
				+ chicken + " " + chicken + ", " + side1.ordinal() + " " + side
				+ ", " + dessert1.ordinal() + " " + dessert);
		System.out.println("Order 1 name: " + chicken1.name() + " " + chicken
				+ ", " + side1.name() + " " + side + ", " + dessert1.name()
				+ " " + dessert);
		System.out.println();
		System.out.println("Order 2 value: " + sandwich1 + " " + sandwich
				+ ", " + sandwich2 + " " + sandwich + ", " + side2 + " " + side
				+ ", " + dessert2 + " " + dessert);
		System.out.println("Order 2 ordinal: " + sandwich1.ordinal() + " "
				+ sandwich + ", " + sandwich2.ordinal() + " " + sandwich + ", "
				+ side2.ordinal() + " " + side + ", " + dessert2.ordinal()
				+ " " + dessert);
		System.out.println("Order 2 name: " + sandwich1.name() + " " + sandwich
				+ ", " + sandwich2.name() + " " + sandwich + ", "
				+ side2.name() + " " + side + ", " + dessert2.name() + " "
				+ dessert);
		System.out.println();
		System.out.println("Order 3 value: " + chicken2 + " " + chicken + ", "
				+ chicken3 + " " + chicken + ", " + side3 + " " + side + ", "
				+ side4 + " " + side + ", " + side5 + " " + side + ", "
				+ dessert3 + " " + dessert + ", " + classic1 + " " + classic);
		System.out.println("Order 3 ordinal: " + chicken2.ordinal() + " "
				+ chicken + ", " + chicken3.ordinal() + " " + chicken + ", "
				+ side3.ordinal() + " " + side + ", " + side4.ordinal() + " "
				+ side + ", " + side5.ordinal() + " " + side + ", "
				+ dessert3.ordinal() + " " + dessert + ", "
				+ classic1.ordinal() + " " + classic);
		System.out.println("Order 3 name: " + chicken2.name() + " " + chicken
				+ ", " + chicken3.name() + " " + chicken + ", " + side3.name()
				+ " " + side + ", " + side4.name() + " " + side + ", "
				+ side5.name() + " " + side + ", " + dessert3.name() + " "
				+ dessert + ", " + classic1.name() + " " + classic);

	}
}
