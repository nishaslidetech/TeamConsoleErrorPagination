package stepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import setupClass.BaseClass;

public class SliPage extends BaseClass {
	WebElement search_field;

	@Given("^user is on the home page now$")
	public void user_is_on_the_home_page_now() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");

	}

	@Then("^Enter data in search field and cehck the console error$")
	public void enter_data_in_search_field_and_cehck_the_console_error() throws Throwable {
		try {
			Thread.sleep(5000);
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.clear();
			search_field.sendKeys("HR");
			Thread.sleep(3000);

			checkConsoleError();

			// click on "hr report" in left navigation

			WebElement hr_Report = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-suggested-term='hr report']")));
			hr_Report.click();
			Thread.sleep(3000);
			checkConsoleError();

			// Clear the search field and enter "Management" on sli listing page
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			search_field.clear();
			search_field.sendKeys("Software");
			Thread.sleep(3000);
			checkConsoleError();
			search_field.clear();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebDriverManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^Go to the sli listing page and check the console error$")
	public void go_to_the_sli_listing_page_and_check_the_console_error() throws Throwable {
		// div[@class = 'container listing-container sli_generic_container']//ul//li[4]
		WebElement selectPpt = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[3]/div[1]/ul[1]/li[1]/div[1]/div[1]/a[1]/img[1]")));
		js.executeScript("arguments[0].click();", selectPpt);
		Thread.sleep(3000);
		checkConsoleError();
		driver.navigate().back();
		Thread.sleep(3000);
	}

	@Then("^click on pagination number and check the console error for two page only for sli$")
	public void click_on_pagination_number_and_check_the_console_error_for_two_page_only_for_sli() throws Throwable {
		List<WebElement> sizeofPagination = driver
				.findElements(By.xpath("//div[3]//div[1]//div[1]//div[3]//ul[1]//li"));

		System.out.println(sizeofPagination.size() + " = size");

		if (sizeofPagination.size() > 0) {
			System.out.println("pagination exists");

			// click on pagination link
			for (int i = 1; i < sizeofPagination.size();) {

				if (!driver.findElements(By.xpath("//div[3]//div[1]//div[1]//div//a//img[@alt = 'Next']")).isEmpty()) {

					WebElement nextButton = driver
							.findElement(By.xpath("//div[3]//div[1]//div[1]//div[3]//ul[1]//li//img[@alt = 'Next']"));
					nextButton.click();

					Thread.sleep(3000);
					checkConsoleError();

				} else

				{
					break;
				}

			}
		} else {
			System.out.println("No pagination exists");
		}
	}

}
