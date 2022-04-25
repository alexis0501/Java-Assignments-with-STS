package com.alexismayoral.zookeeper;

public class Bat extends Mammal{
	
	public Bat() {
		super();	
		this.energyLevel =300;
	}
	
	public void fly() {
		energyLevel -= 50;
		System.out.println("wooooosh");
	}
	public void eatHumans() {
		energyLevel += 25;
		System.out.println("yummm");
	}
	public void attackTown() {
		energyLevel -= 100;
		System.out.println("*intense town on fire noises*");
	}
	public int getEnergyLevel() {
		return energyLevel;
	}
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}
