package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screeshot {
	
	public void takeScreenshot(WebDriver driver, String testName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("target//screenshots/" + testName + ".png");
		//System.out.println("Screenshot taken for test: " + testName);
	
	try {

        FileUtils.copyFile(
                source,
                destination
        );

        System.out.println(
            "Screenshot saved: "
            + destination.getAbsolutePath()
        );

    } catch (IOException e) {

        e.printStackTrace();
    }
    }

}
