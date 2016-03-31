package com.guru99.pageObjects;
	
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	public static WebDriver driver = null;
	public static WebElement element = null;
	public static String element_location = null;
	public static Alert alert = null;
	
	public BasePage(WebDriver driver){
		BasePage.driver = driver;
	}
}