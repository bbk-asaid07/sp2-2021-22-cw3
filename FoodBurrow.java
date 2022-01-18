package cw3;

/**
 * Abstract class to factor out food-related responsibilities of HamsterBurrow
 * objects that locally contain HamsterFood. (Note that not all classes that
 * implement HamsterBurrow must necessarily have HamsterFood, so it makes sense
 * to have a separate interface HamsterBurrow in addition to FoodBurrow.)
 * 
 * @author Ayyub Said
 */
public abstract class FoodBurrow implements HamsterBurrow {

	/** The HamsterFood stored in this FoodBurrow; must not be null */
	private HamsterFood food;

	/**
	 * Constructs a new FoodBurrow for given HamsterFood.
	 *
	 * @param food the HamsterFood to store in this FoodBurrow; must not be null
	 * @throws IllegalArgumentException if food is null
	 */
	public FoodBurrow(HamsterFood food) {
		if (food == null) {
			throw new IllegalArgumentException("Illegal null argument: food");
		}
		this.food = food;
	}

	@Override
	public String toString() {
		return "" + this.food.getFoodUnits();
	}

	@Override
	public int totalFoodUnits() {
		return this.food.getFoodUnits();
	}

	@Override
	public int feedHungryHamster(Hamster h) {
		if (h.getAppetite() <= 0) {
			throw new IllegalArgumentException("Illegal argument: appetite must be greater than 0");
		}
		return h.eat(this.food);
	}
}
