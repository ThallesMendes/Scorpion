package br.com.dcm.web.selenium;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
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

public class Selenium {

	private WebDriver driver;

	public Selenium() {

	}

	/**
	 * @param youProfile is required if has captcha in you web page by example
	 *                   "DEV_ROBO"
	 */
	public void startDriverFirefox(String youProfile) {
		System.setProperty("webdriver.gecko.driver", "/home/danilomendes/driver/geckodriver");

		if (youProfile != null && !youProfile.trim().isEmpty()) {
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile.getProfile(youProfile);

			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(ffprofile);

			driver = new FirefoxDriver(options);
		} else {
			driver = new FirefoxDriver();
		}
	}

	public void startDriverGoogle() {
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
	public void startDriverGoogle(String pathUserChrome, boolean useOptions, boolean browserOcult) {

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

	public void setValueSelectById(String attribute, Object object) {
		if (attribute == null || object == null || object.toString() == null) {
			return;
		}

		System.out.println("Select attribute: " + attribute + "\nobject: " + object.toString());
		Select dropdown = new Select(driver.findElement(By.id(attribute)));
		dropdown.selectByValue(object.toString());
	}

	public void setValueSelectByName(String attribute, Object object) {
		if (attribute == null || object == null || object.toString() == null) {
			return;
		}

		System.out.println("Select attribute: " + attribute + "\nobject: " + object.toString());
		Select dropdown = new Select(driver.findElement(By.name(attribute)));
		dropdown.selectByValue(object.toString());
	}

	public WebElement getElementById(String id) {
		return driver.findElement(By.id(id));
	}

	public WebElement getElementByName(String name) {
		return driver.findElement(By.name(name));
	}

	public WebElement getElementByXPath(String xpathExpression) {
		return driver.findElement(By.xpath(xpathExpression));
	}

	public WebElement getElementByTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));
	}
	
	public List<WebElement> getElementsByTagName(String tagName) {
		return driver.findElements(By.tagName(tagName));
	}

	public WebElement getElementByXpath(String tag, String attribute, String value) {
		if (tag == null || attribute == null) {
			return null;
		}

		WebElement element = driver.findElement(By.xpath("//" + tag + "[@" + attribute + "='" + value + "']"));
		System.out.println("tag: " + tag + "\nattribute: " + attribute + "\nvalue: " + value);
		return element;
	}

	public void openURL(String url) {
		driver.get(url);
	}

	/**
	 * @param attribute
	 * @param object
	 */
	public void setValueByName(String attribute, Object object) {
		setValueByName(attribute, object, false);
	}

	/**
	 * @param attribute
	 * @param object
	 * @param keyTab
	 */
	public void setValueByName(String attribute, Object object, boolean keyTab) {
		if (attribute == null || object == null || object.toString() == null) {
			return;
		}

		WebElement element = driver.findElement(By.name(attribute));
		System.out.println("attribute: " + attribute + "\nobject: " + object.toString());
		element.clear();
		element.sendKeys(object.toString() + (keyTab ? Keys.TAB : ""));

	}
	
	public void setValueByName(String attribute, Object object, Keys key) {
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

	public void keyTabByName(String attribute) {
		if (attribute == null) {
			return;
		}

		WebElement element = driver.findElement(By.name(attribute));
		System.out.println("attribute: " + attribute);
//		element.clear();
		element.sendKeys(Keys.TAB);

	}

	public void submitByName(String value) {
		if (value == null) {
			return;
		}

		WebElement searchBox = driver.findElement(By.name(value));
		searchBox.submit();
	}

	/**
	 * @param attribute
	 * @param object
	 */
	public void setValueById(String attribute, Object object) {
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
	public void setValueByXpath(String tag, String attribute, String value, Object object) {
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
	public void setClickByXpath(String tag, String attribute, String value) {
		if (tag == null || attribute == null || value == null) {
			return;
		}

		WebElement element = driver.findElement(By.xpath("//" + tag + "[@" + attribute + "='" + value + "']"));
		System.out.println("tag: " + tag + "\nattribute: " + attribute + "\nvalue: " + value);
		element.click();
	}

	public void setClickByName(String attribute) {
		if (attribute == null || attribute.isEmpty()) {
			return;
		}

		WebElement element = driver.findElement(By.name(attribute));
		System.out.println("attribute: " + attribute);
		element.click();
	}

	public void setClickById(String attribute) {
		if (attribute == null || attribute.isEmpty()) {
			return;
		}

		System.out.println("attribute: " + attribute);
		WebElement element = driver.findElement(By.id(attribute));
		element.click();
	}

	public void setClickByClassName(String attribute) {
		if (attribute == null || attribute.isEmpty()) {
			return;
		}

		WebElement element = driver.findElement(By.className(attribute));
		System.out.println("attribute: " + attribute);
		element.click();
	}

	public void setClickByCssSeletor(String seletor) {
		if (seletor == null || !seletor.isEmpty()) {
			return;
		}

		WebElement element = driver.findElement(By.cssSelector(seletor));
		System.out.println("attribute: " + seletor);
		element.click();
	}

	public boolean elementIsEmpyty(String attribute) {
		WebElement element = driver.findElement(By.name(attribute));
		System.out.println("attribute: " + attribute);
		return (element.getText() != null ? element.getText().trim().isEmpty() : false);
	}

	public String getValueSubElementByIdElement(String id, String tag, String attribute, String value) {
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
	public void implicitlyWaitForSeconds(int seconds) {
		// set implicit wait
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/**
	 * @param seconds
	 * @see wait for seconds
	 */
	public void implicitlyWaitForMilliSeconds(int milliseconds) {
		// set implicit wait
		driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
	}

	public void executeScript(String script) {
		if (driver instanceof JavascriptExecutor) {
			JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
			jsDriver.executeScript(script);
			implicitlyWaitForMilliSeconds(500);
		} else {
			throw new IllegalStateException("Esse driver não suporta javascript");
		}
	}

	public String getValueByScript(String script) {
		if (driver instanceof JavascriptExecutor) {
			JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
			return (String) jsDriver.executeScript("return " + script);
			// implicitlyWaitForMilliSeconds(500);
		} else {
			throw new IllegalStateException("Esse driver não suporta javascript");
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void setCaptchaById(String attribute) throws AWTException {
		setCaptchaById(attribute, 20000);
	}

	public void setCaptchaById(String attribute, int miliSeconds) throws AWTException {
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

	public void setCaptchaByName(String attribute) throws AWTException {
		setCaptchaByName(attribute, 20000);
	}

	public void setCaptchaByName(String attribute, int miliSeconds) throws AWTException {
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

	public String getTitle() {
		return driver.getTitle();
	}

	public String getHtml() {
		return driver.getPageSource();
	}

	public String getTextById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element.getAttribute("value");
	}

	public void clickRightButtonMouseById(String id) {

		WebElement element = driver.findElement(By.id(id));

		Actions action = new Actions(driver);

		action.contextClick(element).build().perform();
	}

	public void doubleClickById(String id) {

		WebElement element = driver.findElement(By.id(id));

		Actions action = new Actions(driver);

		action.doubleClick(element).build().perform();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void exit() {
		driver.close();
	}
}