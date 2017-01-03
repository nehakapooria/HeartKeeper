package heartkeeper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.Constants;

@Test
public class HealerLogin {
	public WebDriver dr;
	
	@BeforeClass
	public void setConnection() {

		System.setProperty("webdriver.chrome.driver", "/home/chandra/Downloads/chromedriver");
		dr = new ChromeDriver();
		dr.get(Constants.APP_URL_SERVER + "/healer-login");
		dr.manage().window().maximize();
	}

	@Test(description = "Healers Login")
	public void healerlogin() throws InterruptedException {
		
		WebDriverWait wait= new WebDriverWait(dr,120);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("healerLoginEmail")));
		WebElement elehealerid= dr.findElement(By.id("healerLoginEmail"));
		elehealerid.sendKeys("kapooria.neha@gmail.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("healerLoginPass")));
		WebElement elehealerpassword=dr.findElement(By.id("healerLoginPass"));
		elehealerpassword.sendKeys("sam300axn@");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submitHealerLogin")));
		WebElement elehealersubmit=dr.findElement(By.id("submitHealerLogin"));
		elehealersubmit.click();
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("healerName")));
		WebElement elehealername=dr.findElement(By.id("healerName"));
		
		dr.close();

	
	}

}
