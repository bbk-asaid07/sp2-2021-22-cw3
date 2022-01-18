package cw3;

/**
 * A Junction is a HamsterBurrow that stores food and that branches into two
 * further HamsterBurrows.
 *
 * @author Ayyub Said
 */
public class Junction extends FoodBurrow {

	/** The left HamsterBurrow. Non-null. */
	private HamsterBurrow leftBurrow;

	/** The right HamsterBurrow. Non-null. */
	private HamsterBurrow rightBurrow;

	/**
	 * Constructs a new Junction which stores HamsterFood and branches into two
	 * further burrows.
	 * 
	 * @param food        the HamsterFood to store in this DeadEnd; must not be null
	 * @param leftBurrow  the left burrow into which this Junction branches; must
	 *                    not be null
	 * @param rightBurrow the right burrow into which this Junction branches; must
	 *                    not be null
	 */
	public Junction(HamsterFood food, HamsterBurrow leftBurrow, HamsterBurrow rightBurrow) {
		super(food);
		if (leftBurrow == null) {
			throw new IllegalArgumentException("Illegal null argument: leftBurrow");
		}
		if (rightBurrow == null) {
			throw new IllegalArgumentException("Illegal null argument: rightBurrow");
		}
		this.leftBurrow = leftBurrow;
		this.rightBurrow = rightBurrow;
	}

	@Override
	public String toString() {
		return "Y(" + super.toString() + ", " + this.leftBurrow + ", " + this.rightBurrow + ")";
	}

	@Override
	public int size() {
		return this.leftBurrow.size() + 1 + this.rightBurrow.size();
	}

	@Override
	public int totalFoodUnits() {
		return this.leftBurrow.totalFoodUnits() + super.totalFoodUnits() + this.rightBurrow.totalFoodUnits();
	}

	@Override
	public int feedHungryHamster(Hamster h) {
		int eaten;
		if (h.getAppetite() <= 0) {
			throw new IllegalArgumentException("Illegal argument: appetite must be greater than 0");
		}
		if (h.isHungry()) {
			if (this.leftBurrow.totalFoodUnits() > 0)
				eaten = this.leftBurrow.feedHungryHamster(h);
			else if (this.totalFoodUnits() > this.rightBurrow.totalFoodUnits())
				return super.feedHungryHamster(h);
			else if (this.rightBurrow.totalFoodUnits() > 0)
				eaten = this.rightBurrow.feedHungryHamster(h);
			else {
				eaten = 0;
				return 0;
			}

		} else {
			eaten = 0;
		}
		// loop to check if the appetite is zero or less now
		while (h.getAppetite() > 0) {
			int temp = feedHungryHamster(h);
			// if the return is zero it means the current node and its children has zero
			// values now
			if (temp == 0) {
				break;
			} else {
				eaten += temp;
			}
		}
		return eaten;
	}
}
