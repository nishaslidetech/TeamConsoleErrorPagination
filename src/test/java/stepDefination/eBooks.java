package stepDefination;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import setupClass.BaseClass;

public class eBooks extends BaseClass {
	WebElement dropDown;
	WebElement selecteBook;

	@Given("^user is the on home page$")
	public void user_is_the_on_home_page() throws Throwable {
		driver.get(AppURL);
		log.info("It's opening the website URL");
		BaseClass.ClearBrowserCache();
	}

	@Then("^click on eBooks text and check console error$")
	public void click_on_eBooks_text_and_check_console_error() throws Throwable {
		WebElement eBooks = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("eBooks")));
		eBooks.click();
		Thread.sleep(3000);
		checkConsoleError();

		// go to the eBooks details page and check the console error

		WebElement selecteBook = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//ul[1]/li[1]/div[1]/i[1]/a[1]/img[1]")));
		selecteBook.click();
		Thread.sleep(3000);
		checkConsoleError();
		driver.navigate().back();
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
			selecteBook = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div//ul[1]/li[1]/div[1]/i[1]/a[1]/img[1]")));
			selecteBook.click();
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
			selecteBook = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div//ul[1]/li[1]/div[1]/i[1]/a[1]/img[1]")));
			selecteBook.click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

			WebElement buyNow = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[5]/ul[1]/li[1]/div[1]/form[1]/div[1]/input[1]")));
			buyNow.click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

		} catch (FileNotFoundException e) {
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
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^click on eBooks on the top navigation bar$")
	public void click_on_eBooks_on_the_top_navigation_bar() throws Throwable {
		Thread.sleep(3000);
		WebElement eBooks = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("eBooks")));
		eBooks.click();
		Thread.sleep(3000);
		checkConsoleError();

		// go to the eBooks details page and check the console error

		WebElement selecteBook = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//ul[1]/li[1]/div[1]/i[1]/a[1]/img[1]")));
		selecteBook.click();
		Thread.sleep(3000);
		checkConsoleError();
		driver.navigate().back();
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
			selecteBook = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div//ul[1]/li[1]/div[1]/i[1]/a[1]/img[1]")));
			selecteBook.click();
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
			selecteBook = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div//ul[1]/li[1]/div[1]/i[1]/a[1]/img[1]")));
			selecteBook.click();
			Thread.sleep(3000);
			checkConsoleError();
			driver.navigate().back();

		} catch (FileNotFoundException e) {
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

		driver.get("https://www.slidegeeks.com/register");

		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_name")));
		Thread.sleep(3000);
		name.sendKeys("Automated Program");
		Thread.sleep(3000);

		// Generate Random Email Address
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);

		String signup_email = generatedString;
		String full_email = "selenium.testing." + generatedString + "@gmail.com";
		System.out.println(full_email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

		WebElement new_email = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_email")));
		Thread.sleep(3000);
		new_email.sendKeys(full_email);
		Thread.sleep(3000);

		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password")));
		Thread.sleep(3000);
		password.sendKeys("Geeks@123");
		Thread.sleep(3000);

		WebElement confirm_passwoed = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password2")));
		Thread.sleep(3000);
		confirm_passwoed.sendKeys("Geeks@123");
		Thread.sleep(3000);

		WebElement captcha = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#captchtext")));
		Thread.sleep(3000);
		captcha.sendKeys("Y3Tt6bfwI");
		Thread.sleep(3000);

		WebElement register_btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pg-register-button-new")));
		Thread.sleep(3000);
		register_btn.click();
		Thread.sleep(5000);

		driver.get("https://www.slidegeeks.com/free-downloads");
		Thread.sleep(6000);

		WebElement Download = driver.findElement(
				By.xpath("/html/body/div[1]/div[3]/div/section[2]/div/div/div[1]/div/div[2]/div[1]/div/div/p/a/span"));

		// WebElement Download = (WebElement)js.executeScript("('a.btn-download')", "");
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", Download);
		Download.click();
		Thread.sleep(3000);

		// Apply Coupon
		driver.get("https://www.slidegeeks.com/subscriptions");
		Thread.sleep(4000);
		WebElement Join_now = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[id='Individual'] form[name='hikashop_product_form_205548_hikashop_category_information_menu_117']")));
		Thread.sleep(3000);
		Join_now.click();
		Thread.sleep(3000);
		WebElement Coupon = driver.findElement(By.cssSelector("#discount-checkbox"));
		Thread.sleep(3000);
		Coupon.click();
		Thread.sleep(3000);
		WebElement Add_Coupon = driver.findElement(By.cssSelector("#hikashop_checkout_coupon_input_1_3"));
		Thread.sleep(3000);
		Add_Coupon.sendKeys("5OFF");
		Thread.sleep(3000);
		WebElement Apply_Coupon = driver
				.findElement(By.cssSelector(".hikabtn.hikabtn-primary.hikabtn_checkout_coupon_add.btn.primary-btn"));
		Thread.sleep(3000);
		Apply_Coupon.click();
		Thread.sleep(3000);
		// Remove Coupon
		WebElement Remove_Coupon = driver
				.findElement(By.cssSelector(".hikabtn.hikabtn-primary.hikabtn_checkout_coupon_add.btn.primary-btn"));
		Thread.sleep(3000);
		Remove_Coupon.click();
		Thread.sleep(3000);

		// Checkout
		WebElement place_order_btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#hikabtn_checkout_next")));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", place_order_btn);
		// js.executeScript("arguments[0].click();", place_order_btn);
		Thread.sleep(2000);
		place_order_btn.click();
		Thread.sleep(5000);

		String stripe_page_title = driver.getTitle();
		Thread.sleep(3000);
		System.out.println("Title of the Page is --> " + stripe_page_title);

		// String page_title="https://checkout.stripe.com/";
		String page_title = "SlideTeam Geeks Inc";

		if (page_title.equalsIgnoreCase(stripe_page_title)) {
			System.out.println(" user is on the Stripe page");
			log.info("USER IS ON THE STRIPE PAGE");
		} else {
			System.out.println("user is on the wrong page");
			log.info("USER IS ON THE WRONG PAGE");
		}

		Thread.sleep(3000);
		WebElement Stripe_back = driver.findElement(By.cssSelector(
				"#root > div > div > div.App-Overview > header > div > div > a > div > div > div.Header-backArrowContainer > svg"));
		Thread.sleep(2000);
		Stripe_back.click();
		Thread.sleep(5000);

		// Delete Account
		
		WebElement Account = driver.findElement(
				By.xpath("/html/body/div[1]/header/div/div/nav/div/div[2]/div[2]/div[2]/div/div[2]/ul/li[1]/a"));
		Thread.sleep(3000);
		Account.click();
		Thread.sleep(3000);
		WebElement Delete_Account = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div/div[2]/div/ul/li[6]/a"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", Delete_Account);
		Thread.sleep(3000);
		Delete_Account.click();
		Thread.sleep(3000);
		WebElement Delete_Account_reason = driver.findElement(By.cssSelector("#only-free-download-product"));
		Thread.sleep(3000);
		Delete_Account_reason.click();
		Thread.sleep(3000);
		WebElement Delete_Profile = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[3]/button[1]"));
		Thread.sleep(3000);
		Delete_Profile.click();
		Thread.sleep(3000);
		WebElement No_Delete = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[3]/button[2]"));
		Thread.sleep(3000);
		No_Delete.click();
		Thread.sleep(7000);
		Thread.sleep(7000);

		String verifyDeleteAccountMessage = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='alert-message login-sucesmsg']")))
				.getText();
		System.out.println("verifyText1 = " + verifyDeleteAccountMessage);
		Assert.assertTrue("Your are not on paypal page",
				verifyDeleteAccountMessage.contentEquals("Your Account has been deleted successfully."));
		Thread.sleep(3000);
	}
}
