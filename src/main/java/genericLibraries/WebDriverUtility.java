package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all reusable methods to perform web driver actions
 * 
 * @author Srikanth
 * 
 *
 */
public class WebDriverUtility {
	WebDriver driver;

	public WebDriver launchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("invalid browser info");

		}
		driver.manage().window().maximize();
		return driver;
	}

	/**
	 * This method is used to navigate to the application
	 * 
	 * @param url
	 */
	public void navigateToApp(String url) {
		driver.get(url);
	}

	/**
	 * this method is an implicity wait statement
	 * 
	 * @param time
	 */
	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 * this method is used to wait untill element is visible
	 * 
	 * @param time
	 * @param element
	 * @return
	 * 
	 */
	public WebElement explicityWait(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method is used to wait untill element is enabled
	 * 
	 * @param element
	 * @param time
	 * @return
	 */
	public WebElement explicityWait(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * this method is used untill title of the webpage appeares
	 * 
	 * @param title
	 * @param time
	 * @return
	 */

	public Boolean explicityWait(String title, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.titleContains(title));
		/**
		 * this method is used to mouse hover to an element
		 * 
		 * @param element
		 */
	}

	public void mouseHoverToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * this method is used to double click on element
	 * 
	 * @param element
	 */
	public void doubleClickonElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * this menthod is used to rightclick on an element
	 * 
	 * @param element
	 */
	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * this method is used to drag and drop an element
	 * 
	 * @param element
	 * @param target
	 */
	public void dragAndDropElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * this method is used to select an element from drop and down on index
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * this method is used to select an element from drop down based on value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * this method is used to seect an element from drop down on text
	 * 
	 * @param element
	 * @param text
	 */
	public void handleDropdownSelect(String visible, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(visible);
	}

	public void handleDropdownDeSelect(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * this method is used to select an element from drop down based on value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropdownDeSelect(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * this method is used to seect an element from drop down on text
	 * 
	 * @param element
	 * @param text
	 */
	public void handleDropdownDeSelect(String visible, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(visible);
	}

	/**
	 * this method is used to switch to frame on index
	 * 
	 * @param index
	 */
	public void switchToframe(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * this method is used to switch to frame on id or name
	 * 
	 * @param idOrName
	 */
	public void switchToframe(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	/**
	 * this method is used to switch to frame on frameelement
	 * 
	 * @param frameElement
	 */
	public void switchToframe(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * this method is used to switch back from frame
	 */
	public void switchBackFromframe() {
		driver.switchTo().defaultContent();
	}

	/**
	 * this method is used to capture window screenshot
	 * 
	 * @param driver
	 * @param className
	 * @param jutil
	 */
	public void takescreenshot(WebDriver driver, String className, JavaUtility jutil) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/" + className + "_" + jutil.getCurrentTime() + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method is used to scroll till element
	 * 
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView(true)", element);
	}

	/**
	 * this method is used to handle alert
	 * 
	 * @param status
	 */

	public void handleAlert(String status) {
		Alert alert = driver.switchTo().alert();
		if (status.equalsIgnoreCase("ok"))
			alert.accept();
		else
			alert.dismiss();
	}

	/**
	 * this method is used to switch to child browser
	 */
	public void switchTochildBrowser() {
		Set<String> set = driver.getWindowHandles();
		for (String windowID : set) {
			driver.switchTo().window(windowID);
		}
	}

	/**
	 * this method is used to switch to parent browser address
	 * 
	 * @return
	 */
	public String getparentWindowID() {
		return driver.getWindowHandle();
	}

	/**
	 * this method is used to switch to specified window
	 * 
	 * @param windowID
	 */
	public void switchToWindow(String windowID) {
		driver.switchTo().window(windowID);
	}

	/**
	 * this method is used to close current window
	 */
	public void closecurrentWindow() {
		driver.close();
	}

	/**
	 * this method is used to close all the windows
	 */
	public void closeAllWindows() {
		driver.quit();
	}
}