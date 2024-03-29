package com.epam.atm.demo1v2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverBonusTask {

	@BeforeClass(description = "Start browser")
	public void StartBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/hanna_yantsevich/eclipse-workspace/ATM/WebDriver/chromedriver");
	}

	@Test
	public void YouTube() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://youtube.com//");

		WebElement fieldInput = driver.findElement(By.id("search"));
		fieldInput.click();
		fieldInput.sendKeys("Banana Song");

		WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
		searchButton.click();

		Thread.sleep(3000);
		WebElement videoDespicableMe = driver.findElement(By.xpath("//a[@href='/watch?v=sFukyIIM1XI']"));
		Assert.assertTrue(videoDespicableMe.isDisplayed(), "It is less than 50Bil Times");
		videoDespicableMe.click();

		WebElement pageText = driver.findElement(By.id("youtube-paths"));
		Assert.assertTrue(pageText.isDisplayed(), "It is NOT YouTube page!");

	}
}