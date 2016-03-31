package com.guru99.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

public class AssertAndSoftAssert {
	
  @Test
  // Method using simple Assert
  public void test1() {
	  System.out.println("Test1 started");
	  Assert.assertEquals("same", "same");
	  System.out.println("Test1->Part1 started");
	  Assert.assertEquals("same", "different");
	  System.out.println("Test1->Part2 started");
  }
  
  @Test
//Method using simple SoftAssert
  public void test2() {
	  SoftAssert sAssert = new SoftAssert();
	  sAssert.assertEquals("same", "same");
	  System.out.println("Test2 started");
	  System.out.println("Test2->Part1 started");
	  sAssert.assertEquals("same", "different");
	  System.out.println("Test2->Part2 started");
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is after test");
  }

}
