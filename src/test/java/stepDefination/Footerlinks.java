package stepDefination;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import setupClass.BaseClass;

public class Footerlinks extends BaseClass {

	@Given("^user is on team Home Page$")

	public void user_is_on_team_Home_Page() throws Throwable {

		driver.get(AppURL);
		log.info("It's opening the website URL");
		Thread.sleep(5000);
	}

	@Then("^check the console errors for the footer navigation links$")
	public void check_the_console_errors_for_the_footer_navigation_links() throws Throwable {

		try {
			WebElement aboutUs = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'About Us')]")));
			js.executeScript("arguments[0].scrollIntoView();", aboutUs);
			aboutUs.click();
			checkConsoleError();
			Thread.sleep(3000);

			WebElement contactUs = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title=' Contact Us']")));
			js.executeScript("arguments[0].scrollIntoView();", contactUs);
			contactUs.click();
			Thread.sleep(3000);
			checkConsoleError();

			WebElement resumeServices = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("Resume Services")));
			js.executeScript("arguments[0].scrollIntoView();", resumeServices);
			resumeServices.click();
			Thread.sleep(3000);
			checkConsoleError();

			WebElement couponCode = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Coupon Code")));
			js.executeScript("arguments[0].scrollIntoView();", couponCode);
			couponCode.click();
			Thread.sleep(3000);
			checkConsoleError();

			WebElement customDesignServies = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("Custom Design Services")));
			js.executeScript("arguments[0].scrollIntoView();", customDesignServies);
			customDesignServies.click();
			checkConsoleError();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^Check the console error for newly added section$")
	public void check_the_console_error_for_newly_added_section() throws Throwable {
		try {
			WebElement newlyAdded = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Newly Added")));
			js.executeScript("arguments[0].scrollIntoView();", newlyAdded);
			newlyAdded.click();
			Thread.sleep(3000);
			checkConsoleError();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^click on the pagination and check the console error for the two pages only\\.$")
	public void click_on_the_pagination_and_check_the_console_error_for_the_two_pages_only() throws Throwable {
		List<WebElement> sizeofPagination = driver.findElements(By.xpath("//div[3]//div[1]//div[1]//div//a"));

		System.out.println(sizeofPagination.size() + " = size");

		if (sizeofPagination.size() > 0) {
			System.out.println("pagination exists");

			// click on pagination link
			do

				if (!driver.findElements(By.xpath("//div[3]//div[1]//div[1]//div//a//img[@alt = 'Next']")).isEmpty()) {

					WebElement nextButton = driver
							.findElement(By.xpath("//div[3]//div[1]//div[1]//div//a//img[@alt = 'Next']"));
					nextButton.click();

					Thread.sleep(3000);
					// print console error
					checkConsoleError();

				} else

				{
					break;
				}
			while (true);
		} else {
			System.out.println("No pagination exists");
		}

	}

}
