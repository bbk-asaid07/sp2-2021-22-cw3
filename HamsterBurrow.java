package cw3;

/**
 * Interface for a HamsterBurrow, allowing us to feed hungry Hamsters.
 *
 * @author Carsten Fuhs
 */
public interface HamsterBurrow {

	/**
	 * Returns the size of the HamsterBurrow.
	 *
	 * @return how many locations there are in this HamsterBurrow
	 */
	int size();

	/**
	 * Returns how many food units this HamsterBurrow stores in total.
	 *
	 * @return how many food units this HamsterBurrow stores in total
	 */
	int totalFoodUnits();

	/**
	 * Feeds a hungry Hamster using an in-order tree-traversal:
	 *
	 * As long as the Hamster is hungry: - it first goes into the left sub-burrow
	 * (if any) to eat, - then it eats at the current position in the burrow,
	 * consuming all food units there, - and finally it goes into the right
	 * sub-burrow (if any).
	 *
	 * In this sense, the Hamster will eat from left to right through the
	 * HamsterBurrow. It will stop being fed as soon as it is no longer hungry, and
	 * the method will stop traversing the (potentially very large) HamsterBurrow.
	 *
	 * @param h must not be null, must be hungry
	 * @return how many "food units" the Hamster has eaten in total
	 * @throws IllegalArgumentException if h is null or if h.isHungry() evaluates to
	 *                                  false
	 */
	int feedHungryHamster(Hamster h);
}
