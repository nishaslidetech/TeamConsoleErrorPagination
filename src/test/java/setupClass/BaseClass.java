package setupClass;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static String AppURL;
	public static Properties property = new Properties(System.getProperties());
	public static String browser;
	public static Logger log;
	public static WebDriverWait wait;
	static String errorLog;
	public static JavascriptExecutor js;

	@BeforeClass
	public static void before_Class() throws Exception {
		log = Logger.getLogger(BeforeClass.class.getName());
		property.load(new FileReader("config//config.properties"));
		AppURL = property.getProperty("App_url");

		System.out.println("Bname=====" + AppURL);

		if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
			browser = System.getenv("browser");
			System.out.println("env browser = " + browser);

		} else {
			browser = property.getProperty("browser");
			System.out.println("config browser = " + browser);
		}

		property.setProperty("browser", browser);

		System.out.println("setProperty browser = " + browser);

		if ((property.getProperty("browser").equals("chrome"))) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 50);
			js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
		}
		// if (browser.equalsIgnoreCase("firefox"))

		// if (browser.equalsIgnoreCase("chrome"))
		else if ((property.getProperty("browser").equals("firefox"))) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 50);
			js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
		} else if ((property.getProperty("browser").equals("edge"))) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 50);
			js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
		}

		else {

			System.out.println("platform does not provide");
		}

	}

	public static void ClearBrowserCache() throws Throwable {

		driver.manage().deleteAllCookies();
		Thread.sleep(4000); // wait 4 seconds to clear cookies.
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	public static WebElement elementToBeClickable(By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement precenceOfElement(By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void checkConsoleError() throws InterruptedException, IOException {

		String path = System.getProperty("user.dir");
		// System.out.println("path = " + path);
		BufferedWriter printlog = new BufferedWriter(new FileWriter(path + "\\console error.txt"));
		// PrintStream printlog = new PrintStream(path + "\\console error.txt");
		// check console error
		List<LogEntry> logs = driver.manage().logs().get("browser").getAll();

		for (LogEntry entry : logs) {

			errorLog = entry.getMessage().toString();

			System.out.println(driver.getCurrentUrl() + "   ---------------" + new Date(entry.getTimestamp())
					+ "-------- " + entry.getLevel() + "--- " + entry.getMessage());

			printlog.append(new Date(entry.getTimestamp()) + "---" + driver.getCurrentUrl() + "---" + entry.getLevel()
					+ "---" + entry.getMessage() + "---" + System.getProperty("line.separator"));
		}

		printlog.append(System.getProperty("line.separator"));
		printlog.append(System.getProperty("line.separator"));
		printlog.close();
		Thread.sleep(2000);

	}
	public static void Chat_window_handle() throws InterruptedException {
		try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if (iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				Thread.sleep(1000);
				WebElement chat1 = driver.findElement(By.cssSelector("#title .icon-minimize"));
				Thread.sleep(1000);
				chat1.click();
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				Thread.sleep(1000);
				driver.switchTo().parentFrame();
				Thread.sleep(3000);
			} else {

				System.out.println("chat window does not open");
			}
		} catch (NoSuchElementException NCP) {

		}
	}
	@AfterClass
	public static void after_Class() throws InterruptedException {
		Thread.sleep(2000);

		if (driver != null) {
			// driver.quit(); // ->> don't want to close the browser
			Thread.sleep(2000);
		}

	}

}
