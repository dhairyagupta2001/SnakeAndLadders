package main;

import java.util.Random;

public class Dice {
	private Random random;
	private int numberOfDice;

	public Dice(int numberOfDice) {
		this.random = new Random();
		this.numberOfDice = numberOfDice;
	}

	public int Roll() {
		return (random.nextInt(6) + 1) * numberOfDice;
	}
}
