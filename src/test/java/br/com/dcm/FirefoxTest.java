package br.com.dcm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.dcm.web.selenium.SeleniumUtil;
import junit.framework.TestCase;

@RunWith(JUnit4.class)
public class FirefoxTest extends TestCase {

	@Test
	public void start() {
//		System.setProperty("webdriver.gecko.driver", "/home/danilomendes/driver/geckodriver");
//
//		ProfilesIni profile = new ProfilesIni();
//		FirefoxProfile ffprofile = profile.getProfile("DEV_ROBO");
//
//		FirefoxOptions options = new FirefoxOptions();
//		options.setProfile(ffprofile);
//
//		WebDriver driver = new FirefoxDriver(options);
//		driver.navigate().to("https://www.google.com");
		
		SeleniumUtil.startDriverFirefox("DEV_ROBO");
		
		SeleniumUtil.openURL("https://www.cadesp.fazenda.sp.gov.br/(S(aljupn5501cd5jefroucepm3))/Pages/Cadastro/Consultas/ConsultaPublica/ConsultaPublica.aspx");

	}
}
