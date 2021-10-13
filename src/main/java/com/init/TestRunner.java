package com.init;
import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

public class TestRunner {

	
	static TestNG testng;

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub

		testng=new TestNG();
		List suites=Lists.newArrayList();
		suites.add("Build/Login.xml");
		testng.setTestSuites(suites);
		testng.run();
		
		
	}
}
