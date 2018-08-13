package com.servicenow.utilities;

import org.apache.commons.lang.RandomStringUtils;
/**
 * This class is responsible for generating data for inserting new data in both staff and branches intities
 * @author samihaosama
 *
 */
public class KeysGenerators {

	public static String getRandomNumber() {
		return RandomStringUtils.randomNumeric(5);
	}

	public static String getRandomBranchName() {
		return "B_"+RandomStringUtils.randomAlphabetic(5);

	}

	public static String getRandomCodeName() {
		return "B_"+RandomStringUtils.random(2, getRandomBranchName()).toUpperCase()+RandomStringUtils.random(1, "!@#$%^&*");

	}
	
	public static String getRandomStaffName(){
		return "S_"+RandomStringUtils.randomAlphabetic(5);
	}
	
	public static String getRandomStaffName1(){
		return "S_"+RandomStringUtils.randomAlphabetic(3);
	}
}
