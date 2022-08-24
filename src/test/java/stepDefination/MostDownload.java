package stepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import setupClass.BaseClass;

public class MostDownload extends BaseClass {
	WebElement popular_Ppts;
	static String errorLog;
	WebElement viewPerPage;
	WebElement selectDropdown;
	WebElement filterByCategory;

	@Given("^user is already on home page$")
	public void user_is_already_on_home_page() throws Throwable {
		driver.get(AppURL);
		log.info("user is already on Home page");
		Thread.sleep(4000);
	}

	@Then("^click on Popular ppts text and check console error$")
	public void click_on_Popular_ppts_text_and_check_console_error() throws Throwable {
		// click on Popular PPTs without login
		try {
			popular_Ppts = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Popular PPTs")));
			popular_Ppts.click();
			checkConsoleError();
			Thread.sleep(2000);
		} catch (WebDriverException e) {

		}
	}

	@Then("^click on the any of one ppt and verify the console error$")
	public void click_on_the_any_of_one_ppt_and_verify_the_console_error() throws Throwable {

		try {
			Thread.sleep(2000);
			WebElement select_ppt = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//img[@title='Change Management Powerpoint Presentation Slides']")));
			js.executeScript("arguments[0].scrollIntoView();", select_ppt);
			select_ppt.click();
			checkConsoleError();
			driver.navigate().back();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on the pagination and check the console errorfor two pages only$")
	public void click_on_the_pagination_and_check_the_console_errorfor_two_pages_only() throws Throwable {

		List<WebElement> sizeofPagination = driver.findElements(By.xpath("//div[3]//div[1]//div[1]//div//a"));

		System.out.println(sizeofPagination.size() + " = size");

		if (sizeofPagination.size() > 0) {
			System.out.println("pagination exists");

			// click on pagination link do
			for (int i = 1; i < sizeofPagination.size();) {
				if (!driver.findElements(By.xpath("//div[3]//div[1]//div[1]//div//a//img[@alt = 'Next']")).isEmpty()) {

					WebElement nextButton = driver
							.findElement(By.xpath("//div[3]//div[1]//div[1]//div//a//img[@alt = 'Next']"));
					nextButton.click();

					Thread.sleep(2000); // print console error checkConsoleError();
				} else

				{
					break;
				}

			}
		} else

		{
			System.out.println("No pagination exists");
		}
	}

	@Then("^click on the view page and check the console error$")
	public void click_on_the_view_page_and_check_the_console_error() throws Throwable {
		try {
			// driver.navigate().back();
			selectDropdown = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")));
			js.executeScript("arguments[0].scrollIntoView();", selectDropdown);
			selectDropdown.click();

			// check console error for the 120 pages
			List<WebElement> viewPerPage120 = driver.findElements(By.xpath("//div[@data-value = '120']"));
			// js.executeScript("arguments[0].scrollIntoView();", viewPerPage);
			viewPerPage120.get(0).click();
			Thread.sleep(2000);
			// print console error
			checkConsoleError();

			selectDropdown = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")));
			js.executeScript("arguments[0].scrollIntoView();", selectDropdown);
			selectDropdown.click();

			// check console error for the 180 pages
			Thread.sleep(2000);
			List<WebElement> viewPerPage180 = driver.findElements(By.xpath("//div[@data-value = '180']"));
			// js.executeScript("arguments[0].scrollIntoView();", viewPerPage);
			viewPerPage180.get(0).click();
			Thread.sleep(2000);
			// print console error
			checkConsoleError();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebDriverManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^click on the Filter By Category and check the console error$")
	public void click_on_the_Filter_By_Category_and_check_the_console_error() throws Throwable {
		try {
			WebElement filterByCategory = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")));
			js.executeScript("arguments[0].scrollIntoView();", filterByCategory);
			filterByCategory.click();
			Thread.sleep(2000);
			// check console error for the 120 pages
			List<WebElement> diagrams = driver.findElements(By.xpath("//div[@class = 'choices__list']//div[2]"));
			// js.executeScript("arguments[0].scrollIntoView();", diagrams);
			diagrams.get(0).click();
			Thread.sleep(2000);
			// print console error
			checkConsoleError();

			filterByCategory = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")));
			// js.executeScript("arguments[0].scrollIntoView();", filterByCategory);
			filterByCategory.click();
			Thread.sleep(2000);

			// check console error for the 180 pages
			List<WebElement> flatDesigns = driver.findElements(By.xpath("//div[@class = 'choices__list']//div[3]"));
			// js.executeScript("arguments[0].scrollIntoView();", flatDesigns);
			flatDesigns.get(0).click();
			Thread.sleep(2000);
			// print console error
			checkConsoleError();

			filterByCategory = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")));
			js.executeScript("arguments[0].scrollIntoView();", filterByCategory);
			filterByCategory.click();
			Thread.sleep(2000);

			List<WebElement> businessSlides = driver.findElements(By.xpath("//div[@class = 'choices__list']//div[4]"));
			// js.executeScript("arguments[0].scrollIntoView();", businessSlides);
			businessSlides.get(0).click();
			Thread.sleep(2000);
			// print console error
			checkConsoleError();

			filterByCategory = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")));
			// js.executeScript("arguments[0].scrollIntoView();", filterByCategory);
			filterByCategory.click();
			Thread.sleep(2000);

			List<WebElement> completeDesk = driver.findElements(By.xpath("//div[@class = 'choices__list']//div[5]"));
			// js.executeScript("arguments[0].scrollIntoView();", completeDesk);
			completeDesk.get(0).click();
			Thread.sleep(2000);

			checkConsoleError();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebDriverManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}