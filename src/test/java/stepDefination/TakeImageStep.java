package stepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import setupClass.BaseClass;

public class TakeImageStep extends BaseClass {
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				File srcPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				byte[] newFile = FileUtils.readFileToByteArray(srcPath);
				scenario.attach(newFile, "image/png", "screenshotName");
			} catch (IOException e) {
			}
		}
	}
}