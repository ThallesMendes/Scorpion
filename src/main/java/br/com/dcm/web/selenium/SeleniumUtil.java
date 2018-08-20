package br.com.dcm.web.selenium;

import java.awt.AWTException;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import br.com.dcm.awt.RobotUtil;

public class SeleniumUtil {

	public static final String config = System.getProperty("user.dir") + File.separator + "config";

	private static WebDriver driver;

	public static void setValueSelectById(String attribute, Object object) {
		if (attribute == null || object == null || object.toString() == null) {
			return;
		}

		System.out.println("Select attribute: " + attribute + "\nobject: " + object.toString());
		Select dropdown = new Select(driver.findElement(By.id(attribute)));
		dropdown.selectByValue(object.toString());
	}

	public static void setValueSelectByName(String attribute, Object object) {
		if (attribute == null || object == null || object.toString() == null) {
			return;
		}

		System.out.println("Select attribute: " + attribute + "\nobject: " + object.toString());
		Select dropdown = new Select(driver.findElement(By.name(attribute)));
		dropdown.selectByValue(object.toString());
	}

	public static WebElement getElementById(String id) {
		return driver.findElement(By.id(id));
	}

	public static WebElement getElementByName(String name) {
		return driver.findElement(By.name(name));
	}

	public static WebElement getElementByXPath(String xpathExpression) {
		return driver.findElement(By.xpath(xpathExpression));
	}

	public static WebElement getElementByTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));
	}
	
	public static List<WebElement> getElementsByTagName(String tagName) {
		return driver.findElements(By.tagName(tagName));
	}

	public static WebElement getElementByXpath(String tag, String attribute, String value) {
		if (tag == null || attribute == null) {
			return null;
		}

		WebElement element = driver.findElement(By.xpath("//" + tag + "[@" + attribute + "='" + value + "']"));
		System.out.println("tag: " + tag + "\nattribute: " + attribute + "\nvalue: " + value);
		return element;
	}

	public static void openURL(String url) {
		driver.get(url);
	}

	/**
	 * @param attribute
	 * @param object
	 */
	public static void setValueByName(String attribute, Object object) {
		setValueByName(attribute, object, false);
	}

	/**
	 * @param attribute
	 * @param object
	 * @param keyTab
	 */
	public static void setValueByName(String attribute, Object object, boolean keyTab) {
		if (attribute == null || object == null || object.toString() == null) {
			return;
		}

		WebElement element = driver.findElement(By.name(attribute));
		System.out.println("attribute: " + attribute + "\nobject: " + object.toString());
		element.clear();
		element.sendKeys(object.toString() + (keyTab ? Keys.TAB : ""));
	}
	
	public static void setValueByName(String attribute, Object object, Keys key) {
		if (attribute == null || object == null || object.toString() == null) {
			return;
		}

		WebElement element = driver.findElement(By.name(attribute));
		System.out.println("attribute: " + attribute + "\nobject: " + object.toString());
//		element.clear();
		element.sendKeys(object.toString());
		if (key != null) {
			element.sendKeys(key);
		}
	}

	public static void submitByName(String value) {
		if (value == null) {
			return;
		}

		System.out.println("value: " + value);

		WebElement searchBox = driver.findElement(By.name(value));
		searchBox.submit();
	}

	/**
	 * @param attribute
	 * @param object
	 */
	public static void setValueById(String attribute, Object object) {
		if (attribute == null || object == null || object.toString() == null) {
			return;
		}

		WebElement element = driver.findElement(By.id(attribute));
		System.out.println("attribute: " + attribute + "\nobject: " + object.toString());
		element.clear();
		element.sendKeys(object.toString());
	}

	/**
	 * @param tag
	 * @param attribute
	 * @param value
	 * @param object
	 */
	public static void setValueByXpath(String tag, String attribute, String value, Object object) {
		if (tag == null || attribute == null || object == null || object.toString() == null) {
			return;
		}

		WebElement element = driver.findElement(By.xpath("//" + tag + "[@" + attribute + "='" + value + "']"));
		System.out.println(
				"tag: " + tag + "\nattribute: " + attribute + "\nvalue: " + value + "\nobject: " + object.toString());
		element.clear();
		element.sendKeys(object.toString());
	}

	/**
	 * @param tag
	 * @param attribute
	 * @param value
	 */
	public static void setClickByXpath(String tag, String attribute, String value) {
		if (tag == null || attribute == null || value == null) {
			return;
		}

		WebElement element = driver.findElement(By.xpath("//" + tag + "[@" + attribute + "='" + value + "']"));
		System.out.println("tag: " + tag + "\nattribute: " + attribute + "\nvalue: " + value);
		element.click();
	}

	public static void setClickByName(String attribute) {
		if (attribute == null || attribute.isEmpty()) {
			return;
		}

		WebElement element = driver.findElement(By.name(attribute));
		System.out.println("attribute: " + attribute);
		element.click();
	}

	public static void setClickById(String attribute) {
		if (attribute == null || attribute.isEmpty()) {
			return;
		}

		System.out.println("attribute: " + attribute);
		WebElement element = driver.findElement(By.id(attribute));
		element.click();
	}

	public static void setClickByClassName(String attribute) {
		if (attribute == null || attribute.isEmpty()) {
			return;
		}

		WebElement element = driver.findElement(By.className(attribute));
		System.out.println("attribute: " + attribute);
		element.click();
	}

	public static void setClickByCssSeletor(String seletor) {
		if (seletor == null || !seletor.isEmpty()) {
			return;
		}

		WebElement element = driver.findElement(By.cssSelector(seletor));
		System.out.println("attribute: " + seletor);
		element.click();
	}

	/**
	 * @param youProfile is required if has captcha in you web page by example
	 *                   "DEV_ROBO"
	 */
	public static void startDriverFirefox(String youProfile) {
		System.setProperty("webdriver.gecko.driver", "/home/danilomendes/driver/geckodriver");

		if (youProfile != null && !youProfile.trim().isEmpty()) {
//			ProfilesIni profile = new ProfilesIni();
//			FirefoxProfile myprofile = profile.getProfile(youProfile);
//			driver = new FirefoxDriver(myprofile);

			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile.getProfile(youProfile);

			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(ffprofile);

			driver = new FirefoxDriver(options);
		} else {
			driver = new FirefoxDriver();
		}
	}

	public static void startDriverGoogle() {
		startDriverGoogle(null, false, false);
	}

	/**
	 * @param pathChromeDrive by example D:\\chromedriver.exe
	 * @param pathUserChrome  by example C:\\Users\\Danilo
	 *                        Mendes\\AppData\\Local\\Google\\Chrome\\User Data
	 *                        (Windows) or
	 *                        /home/danilomendes/.config/google-chrome/Default
	 *                        (Linux)
	 */
	public static void startDriverGoogle(String pathUserChrome, boolean useOptions, boolean browserOcult) {

		System.setProperty("webdriver.chrome.driver", "/home/danilomendes/driver/chromedriver");

		if (useOptions) {
			ChromeOptions options = new ChromeOptions();
//			options.addExtensions(new File("/home/danilomendes/driver/anticaptcha-plugin.crx"));

			if (pathUserChrome != null && !pathUserChrome.isEmpty()) {
				options.addArguments("user-data-dir=" + pathUserChrome);
			}
			options.addArguments("--single-process");
			options.addArguments("--start-maximized");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-gpu");
			options.addArguments("chromedriver --whitelisted-ips='*'");
			options.addArguments("disable-infobars");
			if (browserOcult) {
				options.addArguments("--headless");
			}

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities.chrome());
		} else {
			driver = new ChromeDriver();
		}

	}

	public static boolean elementIsEmpyty(String attribute) {
		WebElement element = driver.findElement(By.name(attribute));
		System.out.println("attribute: " + attribute);
		return (element.getText() != null ? element.getText().trim().isEmpty() : false);
	}

	public static String getValueSubElementByIdElement(String id, String tag, String attribute, String value) {
		WebElement div = driver.findElement(By.id(id));

		List<WebElement> imgs = div.findElements(By.xpath("//" + tag + "[@" + attribute + "='" + value + "']"));

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < imgs.size(); i++) {
			sb.append(imgs.get(i).getAttribute("src").toString().replaceAll("http://wwwv.site/images/capchs/", "")
					.replaceAll(".png", ""));
		}
		return sb.toString();
	}

	/**
	 * @param seconds
	 * @see wait for seconds
	 */
	public static void implicitlyWaitForSeconds(int seconds) {
		// set implicit wait
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/**
	 * @param seconds
	 * @see wait for seconds
	 */
	public static void implicitlyWaitForMilliSeconds(int milliseconds) {
		// set implicit wait
		driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
	}

	public static void executeScript(String script) {
		if (driver instanceof JavascriptExecutor) {
			JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
			jsDriver.executeScript(script);
			implicitlyWaitForMilliSeconds(500);
		} else {
			throw new IllegalStateException("Esse driver não suporta javascript");
		}
	}
	
	public static String getValueByScript(String script) {
		if (driver instanceof JavascriptExecutor) {
			JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
			return (String) jsDriver.executeScript("return " + script);
			// implicitlyWaitForMilliSeconds(500);
		} else {
			throw new IllegalStateException("Esse driver não suporta javascript");
		}
	}

	public static void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public static void setCaptchaById(String attribute) throws AWTException {
		setCaptchaById(attribute, 20000);
	}

	public static void setCaptchaById(String attribute, int miliSeconds) throws AWTException {
		if (attribute == null) {
			return;
		}

		WebElement element = driver.findElement(By.id(attribute));
		System.out.println("attribute: " + attribute);
		element.clear();
		element.sendKeys("");

		RobotUtil robotUtil = new RobotUtil();
		robotUtil.sleep(1000);
		robotUtil.ctrlShiftVk_3();
		robotUtil.sleep(500);
		robotUtil.ctrlShiftVk_6();
		// wait for 20 seconds
		robotUtil.sleep(miliSeconds);
	}

	public static void setCaptchaByName(String attribute) throws AWTException {
		setCaptchaByName(attribute, 20000);
	}

	public static void setCaptchaByName(String attribute, int miliSeconds) throws AWTException {
		if (attribute == null) {
			return;
		}

		WebElement element = driver.findElement(By.name(attribute));
		System.out.println("attribute: " + attribute);
		element.clear();
		element.sendKeys("");

		RobotUtil robotUtil = new RobotUtil();
		robotUtil.sleep(1000);
		robotUtil.ctrlShiftVk_3();
		robotUtil.sleep(500);
		robotUtil.ctrlShiftVk_6();
		// wait for 20 seconds
		robotUtil.sleep(miliSeconds);
	}

	public static String getTitle() {
		return driver.getTitle();
	}

	public static String getHtml() {
		return driver.getPageSource();
	}

	public static void keyEnterByName(Keys key, String name) {
		if (name == null) {
			return;
		}

		WebElement element = driver.findElement(By.name(name));
		System.out.println("name: " + name);
		element.sendKeys(key);
	}
	
	public static void clickRightButtonMouseById(String id) {
		
		WebElement element = driver.findElement(By.id(id));
		
		Actions action= new Actions(driver);
		
		action.contextClick(element).build().perform();
	}
	
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public static void exit() {
		driver.close();
	}
}