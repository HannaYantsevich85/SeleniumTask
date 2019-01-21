package com.epam.atm.demo1v2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriver {

	ChromeDriver driver;
	ChromeOptions options;

	@BeforeClass(description = ("Start browser"))

	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/hanna_yantsevich/eclipse-workspace/ATM/WebDriver/chromedriver");
	}

	@Test
	public void loginDependancy() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://gmail.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement emailInput = driver.findElement(By.cssSelector("input#identifierId.whsOnd.zHQkBf"));

		// emailInput = driver.findElement(By.id("profileIdentifier"));
		emailInput.sendKeys("a.tsihomirova@gmail.com");

		WebElement NextButton = driver.findElement(By.id("identifierNext"));
		NextButton.click();

		WebElement passwordPage = driver.findElement(By.id("yDmH0d"));
		Assert.assertTrue(passwordPage.isDisplayed(), "Email adress is correct");

		Thread.sleep(1000);
		WebElement passwordInput = driver.findElement(By.xpath("//div[@class='Xb9hP']/input[@type='password']"));
		passwordInput.sendKeys("$ghbjhbntns$1985gmail");

		WebElement passwordButton = driver.findElement(By.id("passwordNext"));
		passwordButton.click();

		/*
		 * WebElement loginPage = driver.findElement(By.xpath("//body[@class='aAX']"));
		 * Assert.assertTrue(loginPage.isDisplayed(), "You are not logged in");
		 */

		Thread.sleep(5000);
		WebElement composebutton = driver.findElement(By.xpath("//div[contains(text(),'Compose')]"));
		composebutton.click();

		WebElement recipientInput = driver.findElement(By.xpath("//textarea[@name='to']"));
		recipientInput.sendKeys("h.yantsevich@gmail.com");

		WebElement subjectInput = driver.findElement(By.xpath("//input[@name='subjectbox']"));
		subjectInput.sendKeys("Test");

		WebElement bodyInput = driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf']"));
		bodyInput.sendKeys("Hello, World!");

		WebElement saveAndCloseButton = driver.findElement(By.xpath("//td[@class='Hm']/img[@class='Ha']"));
		saveAndCloseButton.click();

		WebElement draftsButton = driver.findElement(By.xpath("//a[contains(text(), 'Drafts')]"));
		draftsButton.click();

		Thread.sleep(5000);
		WebElement draftButton1 = driver.findElement(By.id(":171"));
		Assert.assertTrue(draftButton1.isDisplayed(), "Draft disappeared");
		draftButton1.click();

		Thread.sleep(5000);
		// WebElement recipientResult = driver.findElement(By.xpath("//div[@class='oL
		// aDm az9']/span[@email='\"h.yantsevich@gmail.com']"));
		// Assert.assertTrue(recipientResult.isDisplayed(), "Recipient is invalid!");

		WebElement subjectResult = driver.findElement(By.xpath("//div[text()='Test']"));
		Assert.assertTrue(subjectResult.isDisplayed(), "Subject is invalid!");

		WebElement bodyResult = driver.findElement(By.xpath("//div[text()='Hello, World!']"));
		Assert.assertTrue(bodyResult.isDisplayed(), "Email content is invalid!");

		Thread.sleep(1000);

		WebElement sendButton = driver.findElement(By.xpath("//div[text()='Send']"));
		sendButton.click();

		WebElement draftsButton1 = driver.findElement(By.xpath("//a[contains(text(), 'Drafts')]"));
		draftsButton1.click();

		WebElement draftsText = driver.findElement(By.xpath("//tr[@class='TD']/td[@class='TC']"));
		Assert.assertTrue(draftsText.isDisplayed(), "Draft is not sent");

		WebElement sentButton = driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/u/0/#sent']"));
		sentButton.click();

		Thread.sleep(1000);
		WebElement imageButton = driver.findElement(By.xpath(
				"//a[@href='https://accounts.google.com/SignOutOptions?hl=en-GB&continue=https://mail.google.com/mail&service=mail']"));
		imageButton.click();

		Thread.sleep(1000);
		WebElement logOutButton = driver.findElement(By.xpath("//a[@class='gb_Aa gb_xg gb_Eg gb_ef gb_Tb']"));
		logOutButton.click();

		driver.quit();
		System.out.println("Browser is closed");

	}

}
