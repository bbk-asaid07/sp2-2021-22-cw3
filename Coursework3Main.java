package cw3;

/**
 * Driver class for Coursework Assignment 3 in the Software and Programming II
 * module at BBK in 2021/2.
 *
 * @author Carsten Fuhs
 */
public class Coursework3Main {

	/**
	 * Builds an example HamsterBurrow.
	 *
	 * @return an example HamsterBurrow.
	 */
	public static HamsterBurrow mkBurrow() {
		return new Junction(new HamsterFood(30),
				new Junction(new HamsterFood(20), new DeadEnd(new HamsterFood(40)), new DeadEnd(new HamsterFood(50))),
				new Junction(new HamsterFood(10), new DeadEnd(new HamsterFood(10)), new Junction(new HamsterFood(20),
						new DeadEnd(new HamsterFood(30)), new DeadEnd(new HamsterFood(70)))));
	}

	/**
	 * Prints information about a HamsterBurrow and a Hamster.
	 *
	 * @param hb the HamsterBurrow to print information about, must not be null
	 * @param h  the Hamster to print
	 */
	private static void printBurrowAndHamster(HamsterBurrow hb, Hamster h) {
		System.out.println(hb);
		System.out.println("Food units available: " + hb.totalFoodUnits());
		System.out.println(h);
	}

	/**
	 * Feeds a Hamster in a HamsterBurrow. Prints information about the
	 * HamsterBurrow and the Hamster before and after the feeding.
	 *
	 * @param hb the HamsterBurrow to use for feeding, must not be null
	 * @param h  the Hamster to be fed, must not be null, must be hungry
	 */
	private static void feedAndPrint(HamsterBurrow hb, Hamster h) {
		System.out.println("===============");
		printBurrowAndHamster(hb, h);
		hb.feedHungryHamster(h);
		printBurrowAndHamster(hb, h);
	}

	/**
	 * Main method to be run from the command line.
	 *
	 * @param args ignored
	 */
	public static void main(String[] args) {
		HamsterBurrow hb = mkBurrow();
		System.out.println("Hamster Burrow of size: " + hb.size());

		Hamster h1 = new Hamster("Nibbler", 50);
		Hamster h2 = new Hamster("Chewie", 90);
		Hamster h3 = new Hamster("Tribble", 5);

		feedAndPrint(hb, h1);
		feedAndPrint(hb, h2);
		feedAndPrint(hb, h3);
	}

	/*
	 * 
	 * Hamster Burrow of size: 9 =============== Y(30, Y(20, .(40), .(50)), Y(10,
	 * .(10), Y(20, .(30), .(70)))) Food units available: 280 Hamster Nibbler with
	 * appetite 50 Y(30, Y(0, .(0), .(50)), Y(10, .(10), Y(20, .(30), .(70)))) Food
	 * units available: 220 Hamster Nibbler with appetite -10 =============== Y(30,
	 * Y(0, .(0), .(50)), Y(10, .(10), Y(20, .(30), .(70)))) Food units available:
	 * 220 Hamster Chewie with appetite 90 Y(0, Y(0, .(0), .(0)), Y(10, .(0), Y(20,
	 * .(30), .(70)))) Food units available: 130 Hamster Chewie with appetite 0
	 * =============== Y(0, Y(0, .(0), .(0)), Y(10, .(0), Y(20, .(30), .(70)))) Food
	 * units available: 130 Hamster Tribble with appetite 5 Y(0, Y(0, .(0), .(0)),
	 * Y(0, .(0), Y(20, .(30), .(70)))) Food units available: 120 Hamster Tribble
	 * with appetite -5
	 * 
	 */

}
