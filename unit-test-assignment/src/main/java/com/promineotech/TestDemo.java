package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	//  1. Example Unit Test - Code This
	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	// 3. Create Your Own Method & JUnit Test 
	public boolean divisibleByTheSecondParameter(int a, int b) {
		boolean divisibility;
		if(a % b == 0) {
			divisibility = true;
		} else {
			divisibility = false;
		}
		return divisibility;
	}
	
	// 4. Mocking a Class - TestDemo
	public int randomNumberSquared() {
		 int randomNum = getRandomInt();
		 
		 return randomNum * randomNum;
	}
	
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

}
