package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import setupClass.BaseClass;

public class HomePage extends BaseClass {
	static String errorLog;

	@Given("^Go the Home page$")
	public void go_the_Home_page() throws Throwable {
		Thread.sleep(2000);
		driver.get(AppURL);
		log.info("It's opening the website URL");

	}

	@Then("^check console error for Home page$")
	public void check_console_error_for_Home_page() throws Throwable {
		checkConsoleError();
	}

	@Then("^click on Sign in button and check console errors$")
	public void click_on_Sign_in_button_and_check_console_errors() throws Throwable {
		try {
			Thread.sleep(3000);
			WebElement sign_in = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign In']")));
			sign_in.click();
			Thread.sleep(3000);
			checkConsoleError();

		} catch (WebDriverManagerException e) {

		}
	}

	@Then("^click on Sign up button and check console errors$")
	public void click_on_Sign_up_button_and_check_console_errors() throws Throwable {
		try {
			Thread.sleep(3000);
			WebElement sign_up = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign up")));
			sign_up.click();
			Thread.sleep(3000);
			checkConsoleError();

		} catch (WebDriverManagerException e) {

		}
	}

	@Then("^check the console error for the top navigation links$")
	public void check_the_console_error_for_the_top_navigation_links() throws Throwable {

		try {
			Thread.sleep(3000);
			WebElement pricing = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Pricing")));
			pricing.click();
			Thread.sleep(3000);
			checkConsoleError();

			WebElement eBooks = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("eBooks")));
			eBooks.click();
			Thread.sleep(3000);
			checkConsoleError();

			WebElement templateFinder = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("Template Finder")));
			templateFinder.click();
			checkConsoleError();
			Thread.sleep(3000);

			WebElement presentationServices = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("Presentation Services")));
			presentationServices.click();
			checkConsoleError();
			Thread.sleep(3000);

			WebElement researchServices = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("Research Services")));
			researchServices.click();
			Thread.sleep(3000);
			checkConsoleError();

		} catch (NoSuchElementException e) {

		}

	}

}
