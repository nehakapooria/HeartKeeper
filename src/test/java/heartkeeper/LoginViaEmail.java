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
public class LoginViaEmail {
	WebDriver dr;
	
	@BeforeClass
	public void setConnection() {

		System.setProperty("webdriver.chrome.driver", "/home/chandra/Downloads/chromedriver");
		dr = new ChromeDriver();
		dr.get(Constants.APP_URL_SERVER+"/home/");
		dr.manage().window().maximize();
	}
	
	@Test(description = "login via email id")
	public void login() throws InterruptedException {
	
		WebDriverWait wait=new WebDriverWait(dr, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("showLogin")));
	
		WebElement ele = dr.findElement(By.id("showLogin"));
		System.out.println(ele);
		ele.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginEmail")));
		WebElement ele1 = dr.findElement(By.id("loginEmail"));
		ele1.sendKeys("heartkeeper.web@gmail.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginPass")));
		WebElement ele2 = dr.findElement(By.id("loginPass"));
		ele2.sendKeys("sam300axn@");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submitLogin")));
		WebElement ele3 = dr.findElement(By.id("submitLogin"));
		ele3.click();
		}

	@Test(description = "logout",dependsOnMethods={"login"})
	public void logout() throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(dr, 120);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userName")));
		WebElement ele9 = dr.findElement(By.id("userName"));
		ele9.click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userLogout")));
		WebElement ele10 = dr.findElement(By.id("userLogout"));
		ele10.click();
		Thread.sleep(3000);
		dr.close();
	}	
	}
	




