package cw3;

/**
 * This class models a Hamster with a name and a certain appetite.
 *
 * @author Carsten Fuhs
 */
public class Hamster {

	/** The Hamster's name. Non-null. */
	private String name;

	/**
	 * The Hamster's current appetite level, expressed in "food units". Positive
	 * values indicate hunger, zero or negative values indicate repletion.
	 */
	private int appetite;

	/**
	 * Constructs a new Hamster with a name and a given appetite level in "food
	 * units".
	 *
	 * @param name     the Hamster's name, must not be the null reference
	 * @param appetite the appetite level in "food units". Positive values indicate
	 *                 hunger, zero or negative values indicate repletion.
	 * @throws IllegalArgumentException if name is the null reference
	 */
	public Hamster(String name, int appetite) {
		this.name = name;
		this.appetite = appetite;
	}

	/**
	 * Returns whether this Hamster is hungry.
	 *
	 * @return whether this Hamster is hungry
	 */
	public boolean isHungry() {
		return this.appetite > 0;
	}

	/**
	 * Consumes all food units in food, adjusts the appetite level of this Hamster
	 * accordingly, and resets food.
	 *
	 * @param food the food for the Hamster to eat; must not be null
	 * @return how many food units were consumed by the method call
	 * @throws IllegalArgumentException if food is the null reference
	 */
	public int eat(HamsterFood food) {
		if (food == null) {
			throw new IllegalArgumentException("Illegal null argument: food");
		}
		int foodUnits = food.getFoodUnits();
		this.appetite -= foodUnits;
		food.reset();
		return foodUnits;
	}

	/**
	 * Returns this Hamster's name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns this Hamster's current appetite level.
	 *
	 * @return the appetite
	 */
	public int getAppetite() {
		return this.appetite;
	}

	@Override
	public String toString() {
		return "Hamster " + this.name + " with appetite " + this.appetite;
	}
}
