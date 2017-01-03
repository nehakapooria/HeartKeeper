package heartkeeper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Constants;

@Test
public class Profile {
	WebDriver dr;
	@BeforeClass
	public void setConnection() {

		System.setProperty("webdriver.chrome.driver", "/home/chandra/Downloads/chromedriver");
		dr = new ChromeDriver();
		dr.get(Constants.APP_URL_SERVER + "/home");
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
		ele1.sendKeys("anil.sharma@gmail.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginPass")));
		WebElement ele2 = dr.findElement(By.id("loginPass"));
		ele2.sendKeys("sam300axn@");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submitLogin")));
		WebElement ele3 = dr.findElement(By.id("submitLogin"));
		ele3.click();
		}

	@Test(description = "Profile",dependsOnMethods={"login"})
	public void profile() throws InterruptedException{
		
		WebDriverWait wait= new WebDriverWait(dr, 60);
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userName")));
		WebElement elem= dr.findElement(By.id("userName"));
		elem.click();
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userAccount")));
		WebElement ele10= dr.findElement(By.id("userAccount"));
		ele10.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("accNavProfile")));
		WebElement ele11= dr.findElement(By.id("accNavProfile"));
		
		WebElement ele=dr.findElement(By.xpath("//*[@id='imageUpload']"));
		ele.sendKeys("/home/chandra/workspace/HeartKeeper/src/main/resources/Neha1.jpg");
	
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("basicInfoFName")));
		WebElement ele12=dr.findElement(By.id("basicInfoFName"));
		ele12.sendKeys("Anil");
	
	
		wait.until(ExpectedConditions.elementToBeClickable(By.id("basicInfoLName")));
		WebElement ele13= dr.findElement(By.id("basicInfoLName"));
		ele13.sendKeys("Sharma");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("basicInfoGender")));
		WebElement ele14=dr.findElement(By.id("basicInfoGender"));
		ele14.click();
		Thread.sleep(4000);
		dr.findElement(By.cssSelector("md-option[value='FEMALE']")).click();
		Thread.sleep(3000);	
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("basicInfoAgeGrp")));
		WebElement ele16=dr.findElement(By.id("basicInfoAgeGrp"));
		Thread.sleep(2000);
		ele16.click();
		Thread.sleep(3000);
		dr.findElement(By.xpath("//*[@id='select_option_21']")).click();
		Thread.sleep(3000);
		
		WebElement ele18=dr.findElement(By.id("basicInfoSubmit"));
		ele18.click();
		Thread.sleep(3000);
		WebElement changepic=dr.findElement(By.id("showChangeMenu"));
		changepic.click();
		Thread.sleep(3000);
		WebElement ele20=dr.findElement(By.id("removeProfile"));
		ele20.click();
		Thread.sleep(2000);
		ele.sendKeys("/home/chandra/workspace/HeartKeeper/src/main/resources/Neha2.jpg");
		Thread.sleep(3000);
		ele18.click();
		}
	@Test(description = "logout",dependsOnMethods={"profile"})
	public void logout() throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(dr, 120);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userName")));
		WebElement ele9 = dr.findElement(By.id("userName"));
		ele9.click();
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userLogout")));
		WebElement ele10 = dr.findElement(By.id("userLogout"));
		ele10.click();
		dr.close();
	}	
}
