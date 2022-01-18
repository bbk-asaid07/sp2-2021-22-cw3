package cw3;

/**
 * Food for Hamsters. It has a nutritional value expressed in "food units".
 *
 * @author Carsten Fuhs
 */
public class HamsterFood {

	/**
	 * The nutritional value of this HamsterFood in "food units". Always >= 0.
	 */
	private int units;

	/**
	 * Constructs a new HamsterFood object with a nutritional value given by the
	 * parameter.
	 *
	 * @param units the nutritional value in "food units"; must not be negative (but
	 *              0 is ok)
	 * @throws IllegalArgumentException if units < 0
	 */
	public HamsterFood(int units) {
		if (units < 0) {
			throw new IllegalArgumentException("Expected units >= 0, found: " + units);
		}
		this.units = units;
	}

	/**
	 * Returns the nutritional value of the food in "food units".
	 *
	 * @return the nutritional value of the food in "food units"
	 */
	public int getFoodUnits() {
		return this.units;
	}

	/**
	 * Resets the nutritional value of the food to 0.
	 */
	public void reset() {
		this.units = 0;
	}

	@Override
	public String toString() {
		return "HamsterFood with " + this.units + " food units";
	}
}
