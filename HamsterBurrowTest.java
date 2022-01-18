package cw3;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

/**
 * JUnit 5 test cases for the HamsterBurrow hierarchy.
 * 
 * @author Ayyub Said
 */
public class HamsterBurrowTest {
	@Test
	public void Test1_CheckSize() {
		HamsterBurrow test_hb = (new Coursework3Main()).mkBurrow();
		int expected = 9;
		assertEquals(expected, test_hb.size());
	}

	@Test
	public void Test2_CheckFoodItems() {
		HamsterBurrow test_hb = (new Coursework3Main()).mkBurrow();
		int expected = 280;
		assertEquals(expected, test_hb.totalFoodUnits());
	}

	@Test
	public void Test3_CheckReturnNibblersEaten() {
		HamsterBurrow test_hb = (new Coursework3Main()).mkBurrow();
		Hamster test_h1 = new Hamster("Nibbler", 50);
		int expected = 60;
		assertEquals(expected, test_hb.feedHungryHamster(test_h1));
	}

	@Test
	public void Test4_CheckReturnNibblersAppetite() {
		HamsterBurrow test_hb = (new Coursework3Main()).mkBurrow();
		Hamster test_h1 = new Hamster("Nibbler", 50);
		int expected = -10;
		test_hb.feedHungryHamster(test_h1);
		assertEquals(expected, test_h1.getAppetite());
	}

	@Test
	public void Test5_CheckFoodUnitAfterVisit() {
		HamsterBurrow test_hb = (new Coursework3Main()).mkBurrow();
		Hamster test_h1 = new Hamster("Nibbler", 50);
		int expected = 220;
		test_hb.feedHungryHamster(test_h1);
		assertEquals(expected, test_hb.totalFoodUnits());
	}

	@Test
	public void Test6_CheckNullException() {
		HamsterBurrow test_hb = (new Coursework3Main()).mkBurrow();
		Hamster test_h6 = new Hamster(null, 0);

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> test_hb.feedHungryHamster(test_h6));

		assertEquals(IllegalArgumentException.class, thrown.getClass());

	}

	@Test
	public void Test7_CheckHungryEcxeption() {
		HamsterBurrow test_hb = (new Coursework3Main()).mkBurrow();
		Hamster test_h7 = new Hamster(null, 0);

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> test_hb.feedHungryHamster(test_h7));

		assertEquals(IllegalArgumentException.class, thrown.getClass());

	}

	@Test
	public void Test8() {
		// hamster burrow with single deadend and 30 Food Units
		HamsterBurrow test_hb = new DeadEnd(new HamsterFood(30));
		// now the size of the hamster burrow is 1 so expected value should be 1
		int expected = 1;
		assertEquals(expected, test_hb.size());
	}

	@Test
	public void Test9() {
		HamsterBurrow test_hb = new DeadEnd(new HamsterFood(30));
		int expected = 30;
		assertEquals(expected, test_hb.totalFoodUnits());
	}

	@Test
	public void Test10() {
		HamsterBurrow test_hb = new DeadEnd(new HamsterFood(30));
		Hamster test_h10 = new Hamster("Nibbler", 50);
		// expected value should be 30 now because our HamsterBurrow has total 30 food
		// units now
		int expected = 30;
		assertEquals(expected, test_hb.feedHungryHamster(test_h10));
	}

	@Test
	public void Test11() {
		HamsterBurrow test_hb = new DeadEnd(new HamsterFood(30));
		Hamster test_h11 = new Hamster("Nibbler", 50);
		// expected Appetite should be 20 now, because Nibbler has hunger 50, but
		// HamsterBurrow has only 30 food units
		int expected = 20;
		test_hb.feedHungryHamster(test_h11);
		assertEquals(expected, test_h11.getAppetite());
	}

	@Test
	public void Test12() {
		HamsterBurrow test_hb = new DeadEnd(new HamsterFood(30));
		Hamster test_h12 = new Hamster("Nibbler", 50);
		// expected value should be zero because Nibbler should eat all 30 units, as its
		// hunger is 50
		int expected = 0;
		test_hb.feedHungryHamster(test_h12);
		assertEquals(expected, test_hb.totalFoodUnits());
	}

	@Test
	public void Test13() {
		HamsterBurrow test_hb = new DeadEnd(new HamsterFood(30));
		Hamster test_h13 = new Hamster(null, 0);

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> test_hb.feedHungryHamster(test_h13));

		assertEquals(IllegalArgumentException.class, thrown.getClass());
	}

	@Test
	public void Test14() {
		HamsterBurrow test_hb = new DeadEnd(new HamsterFood(30));
		Hamster test_h14 = new Hamster("Nibbler", 0);

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> test_hb.feedHungryHamster(test_h14));

		assertEquals(IllegalArgumentException.class, thrown.getClass());
	}

}
