package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class NegativeTests {

	public void loginTest() {
		System.out.println("Starting login Page");

//		create driver

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// sleep for 3 seconds

		sleep(3000);

//		maximize the browser window
		driver.manage().window().maximize();
//		open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);

		System.out.println("Page is Opened");

		// sleep for 2 seconds

		sleep(2000);

//		enter user name

		WebElement username = driver.findElement(By.id("username"));

		username.sendKeys("tomsmith");

		sleep(2000);
//		enter password

		WebElement password = driver.findElement(By.name("password"));

		sleep(2000);

		password.sendKeys("SuperSecretPassword!");
//		click login button

		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();

		sleep(2000);
//		
//		verification
//		
//		new url page

		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual is url not same as expeted");
		sleep(2000);

//		logout button viewable 

		WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logOutButton.isDisplayed(), "Log Out button is not visible");

		// successful login message

//		
//		WebElement successsMessage = driver.findElement(By.cssSelector("#flash"));

//		WebElement successsMessage = driver.findElement(By.className("success"));
//		"//div[@id='flash']"
//		
		WebElement successsMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		String epectedMessage = "You logged into a secure area!";
		String actualMessage = successsMessage.getText();
		
//		Assert.assertEquals(actualMessage, epectedMessage, "Actual message is not same as expected");
		
		Assert.assertTrue(actualMessage.contains(epectedMessage), "Actual does not contain message is not same as expected.\nActual Message : " + actualMessage + "\nExpected Message :" + epectedMessage);
		
		//
//		Close Browser
		driver.quit();

	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
