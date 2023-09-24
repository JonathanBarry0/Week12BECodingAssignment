package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoJUnitTest {
	
	private TestDemo testDemo; // declares an instance of the class being tested

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo(); // resets the instance to a new instance of the class BeforeEach test
	}
	
	//  1. Example Unit Test - Code This 
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) { // if there is no exception, verify that the method works
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else { // if there is an exception, throw the exception
			assertThatThrownBy(() -> 
				testDemo.addPositive(a, b))
					.isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive() { // a stream of arguments for addPositive so there doesn't need to be multiple test 
		return Stream.of(
			   arguments(2, 4, 6, false),
			   arguments(0, 0, 0, true),
			   arguments(-2, -4, -6, true)
						);
	}
	
	// 2. Write a New JUnit Test 
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(2, 3)).isEqualTo(5); // verifies that add positive can do 2 + 3 and get 5
	}
	
	// 3. Create Your Own Method & JUnit Test 
	@Test
	void assertThatTheFirstParameterIsDivisibleByTheSecondParameter() {
		assertThat(testDemo.divisibleByTheSecondParameter(10, 2)).isEqualTo(true); // verifies it's true that the first parameter is divisible by the second parameter
		assertThat(testDemo.divisibleByTheSecondParameter(3, 2)).isEqualTo(false); // verifies it's false that the first parameter is divisible by the second parameter
	}
	
	// 4. Mocking a Class - TestDemo
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo); // uses the Mockito "spy(testDemo)" method to mock the testDemo variable
		
		doReturn(5).when(mockDemo).getRandomInt(); // doReturn(5) tells the mock to return '5' when using the ".getRandomInt()" method
		
		int fiveSquared = mockDemo.randomNumberSquared(); // declares s variable to store the result of the ".randomNumberSquared()" method
		
		assertThat(fiveSquared).isEqualTo(25); // verifies that the ".randomNumberSquared()" method outputs 25
	}

}
