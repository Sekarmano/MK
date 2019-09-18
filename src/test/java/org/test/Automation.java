package org.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Automation extends Base {
	public static void main(String[] args) throws IOException {
		getBrowser();
		launchBrowser("http://demo.automationtesting.in/Register.html");
		WebElement fname = findElementByXpath("//input[@placeholder='First Name']");
		type(fname, getData(1, 0));
		WebElement lname = findElementByXpath("//input[@placeholder='Last Name']");
		type(lname, getData(1, 1));
		WebElement address = findElementByXpath("//textarea[@rows='3']");
		type(address, getData(1, 2));
	    WebElement mail = findElementByXpath("//input[@type='email']");
	    type(mail, getData(1, 3));
	    
	    WebElement tel = findElementByXpath("//input[@type='tel']");
	    type(tel, getData(1, 4));
	    WebElement gender = findElementByXpath("(//input[@type='radio'])[1]");
	    gender.click();
	    WebElement hob = findElementByXpath("//input[@id='checkbox1']");
	    hob.click();
		
	}
	

}
