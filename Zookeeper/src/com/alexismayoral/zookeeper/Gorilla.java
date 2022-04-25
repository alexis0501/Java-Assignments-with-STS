package com.alexismayoral.zookeeper;

public class Gorilla extends Mammal {
	
	public Gorilla() {
		super();
	}
	
	public void throwSomething() {
		System.out.println("Gorilla threw something!");
		energyLevel -= 5;
	}
	public void eatBananas() {
		System.out.println("Gorilla ate banana!");
		energyLevel += 10;
	}
	public void climb() {
		System.out.println("Gorilla has climbed!");
		energyLevel -= 10;
	}
}
