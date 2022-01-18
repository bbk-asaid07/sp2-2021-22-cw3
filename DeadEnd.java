package cw3;

/**
 * A DeadEnd is a HamsterBurrow which stores HamsterFood and does not branch
 * into any further HamsterBurrows.
 *
 * @author Carsten Fuhs
 */
public class DeadEnd extends FoodBurrow {

	/**
	 * Constructs a new DeadEnd which stores HamsterFood.
	 * 
	 * @param food the HamsterFood to store in this DeadEnd; must not be null
	 */
	public DeadEnd(HamsterFood food) {
		super(food);
	}

	@Override
	public String toString() {
		return ".(" + super.toString() + ")";
	}

	@Override
	public int size() {
		return 1;
	}

}
