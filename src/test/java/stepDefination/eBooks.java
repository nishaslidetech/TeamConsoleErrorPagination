package stepDefination;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.ErrorHandler.UnknownServerException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import setupClass.BaseClass;

public class eBooks extends BaseClass {
	WebElement dropDown;
	List<WebElement> selecteBook;

	@Given("^user is the on home page$")
	public void user_is_the_on_home_page() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");
		BaseClass.ClearBrowserCache();
		Thread.sleep(5000);
	}

	@Then("^click on eBooks text and check console error$")
	public void click_on_eBooks_text_and_check_console_error() throws Throwable {
		try {
			WebElement eBooks = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("eBooks")));
			eBooks.click();
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error

			selecteBook = driver.findElements(By.xpath("//div[@class = 'book-collection-inner']//img"));
			selecteBook.get(1).click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();
		} catch (WebDriverManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^select option from sort By and check the console error$")
	public void select_option_from_sort_By_and_check_the_console_error() throws Throwable {

		try {
			Thread.sleep(3000);
			dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk0-combobox")));
			dropDown.click();
			Thread.sleep(3000);
			checkConsoleError();

			WebElement newAndPopular = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='dk0-1']")));
			newAndPopular.click();
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error
			selecteBook = driver.findElements(By.xpath("//div[@class = 'book-collection-inner']//img"));
			selecteBook.get(1).click();
			Thread.sleep(3000);

			checkConsoleError();
			driver.navigate().back();

			Thread.sleep(3000);
			dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk0-combobox")));
			dropDown.click();
			Thread.sleep(3000);

			WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='dk0-2']")));
			name.click();
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error
			selecteBook = driver.findElements(By.xpath("//div[@class = 'book-collection-inner']//img"));
			selecteBook.get(1).click();
			Thread.sleep(3000);

			checkConsoleError();
			driver.navigate().back();

			List<WebElement> buyNow = driver
					.findElements(By.xpath("//div[@class = 'book-count']//input[@name = 'Buy']"));
			buyNow.get(0).click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

		} catch (WebDriverException e) {
		}

	}

	@Given("^Go to the home page$")
	public void go_to_the_home_page() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");

	}

	@Then("^Enter paid valid credentials$")
	public void enter_paid_valid_credentials() throws Throwable {
		try {
			Thread.sleep(3000);
			WebElement sign_in = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign In']")));
			sign_in.click();
		} catch (NoSuchElementException e) {

		}
		try {

			Thread.sleep(3000);
			WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
			email.sendKeys("nisha.dhiman@slidetech.in");

			WebElement password_field = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")));
			password_field.sendKeys("123456");
			WebElement login_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Login']")));
			login_btn.click();
			Thread.sleep(2000);

			if (!driver.findElements(By.xpath("//div[@class='login-attempt-popup']")).isEmpty()) {
				WebElement approve = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirm-approve']")));
				approve.click();
			}
		} catch (WebDriverManagerException e) {

		}
	}

	@Then("^click on eBooks on the top navigation bar$")
	public void click_on_eBooks_on_the_top_navigation_bar() throws Throwable {
		try {
			Thread.sleep(3000);

			/*
			 * Actions action = new Actions(driver); action.moveByOffset(0,
			 * 83).click().perform(); Thread.sleep(3000);
			 */

			if (!driver.findElements(By.xpath("//div[@class='checkout_custom']//center")).isEmpty()) {
				WebElement closePopup = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='livechatclosepopup']")));
				closePopup.click();
				Thread.sleep(2000);
			}
			WebElement eBooks = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("eBooks")));
			eBooks.click();
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error

			selecteBook = driver.findElements(By.xpath("//div[@class = 'book-collection-inner']//img"));
			selecteBook.get(1).click();
			Thread.sleep(3000);

			checkConsoleError();
			driver.navigate().back();
		} catch (UnknownServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebDriverManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^Select option from sort By and check the console error$")
	public void Select_option_from_sort_By_and_check_the_console_error() throws Throwable {
		try {
			Thread.sleep(3000);
			dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk0-combobox")));
			dropDown.click();
			Thread.sleep(3000);
			checkConsoleError();

			WebElement newAndPopular = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='dk0-1']")));
			newAndPopular.click();
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error
			selecteBook = driver.findElements(By.xpath("//div[@class = 'book-collection-inner']//img"));
			selecteBook.get(1).click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

			Thread.sleep(3000);
			dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dk0-combobox")));
			dropDown.click();
			Thread.sleep(3000);

			WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='dk0-2']")));
			name.click();
			Thread.sleep(3000);
			checkConsoleError();

			// go to the eBooks details page and check the console error
			selecteBook = driver.findElements(By.xpath("//div[@class = 'book-collection-inner']//img"));
			selecteBook.get(1).click();
			Thread.sleep(3000);
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

		} catch (WebDriverException e) {
		}

	}

	@Then("^Logout from the application and verify the page$")
	public void logout_from_the_application_and_verify_the_page() throws Throwable {
		// sign out from the application
		try {
			Thread.sleep(2000);
			WebElement sign_Out = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Out")));
			sign_Out.click();
		} catch (NoSuchElementException e) {

		}

		// verify the message after signout
		String verifySignOutMessage = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@class='base']"))).getText();

		Assert.assertTrue("user is not logout from the application",
				verifySignOutMessage.contains("YOU ARE NOW LOGGED OUT"));

	}
}
