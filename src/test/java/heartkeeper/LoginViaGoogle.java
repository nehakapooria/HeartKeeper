package heartkeeper;

import java.util.Iterator;
import java.util.Set;

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
public class LoginViaGoogle {
	WebDriver dr;

	@BeforeClass
	public void setConnection() {

		System.setProperty("webdriver.chrome.driver", "/home/chandra/Downloads/chromedriver");
		dr = new ChromeDriver();
		dr.get(Constants.APP_URL_SERVER + "/home");
		dr.manage().window().maximize();
	}
	
	@Test(description = "login via google id")
	public void logingoogle() throws InterruptedException{
		WebDriverWait wait= new WebDriverWait(dr,120);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("showLogin")));
		WebElement eleglogin= dr.findElement(By.id("showLogin"));
		eleglogin.click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("gpLogin")));
		WebElement elegbtn=dr.findElement(By.id("gpLogin"));
		elegbtn.click();
		
		 String parentWindowName = dr.getWindowHandle();
         Thread.sleep(1000);
         Set<String> windowSets = dr.getWindowHandles();
         Thread.sleep(1000);
         Iterator<String> windowIterator = windowSets.iterator();
         Thread.sleep(1000);
         while (windowIterator.hasNext())
         {
             String childWindowName = windowIterator.next();
             Thread.sleep(1000);
             if (!parentWindowName.equalsIgnoreCase(childWindowName)) 
             {
                 Thread.sleep(1000);
                 dr.switchTo().window(childWindowName);
                 Thread.sleep(1000);
                 System.out.println(dr.getTitle());
                 Thread.sleep(2000);
                 WebElement elefbemail=dr.findElement(By.id("Email"));
     			elefbemail.sendKeys("kapooria.neha@gmail.com");
     			Thread.sleep(1000);
     			WebElement elegnextbtn=dr.findElement(By.id("next"));
     			elegnextbtn.click();
     			Thread.sleep(1000);
     			WebElement elegpass=dr.findElement(By.id("Passwd"));
     			elegpass.sendKeys("rsnr2689");
     			WebElement elegobtn=dr.findElement(By.id("signIn"));
     			elegobtn.click();
     			Thread.sleep(3000);
     			WebElement elegaccess=dr.findElement(By.id("submit_approve_access"));
     			elegaccess.click();
     			//wait.until(ExpectedConditions.elementToBeClickable(By.id("userName")));
     			Thread.sleep(3000);
     			
             }
         }
         dr.switchTo().window(parentWindowName);
         System.out.println(dr.getTitle());
         System.out.println("-------------------------------------------------------");
 		}
	
	@Test(description = "logout",dependsOnMethods={"logingoogle"})
	public void logout() throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(dr, 120);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userName")));
		WebElement ele9 = dr.findElement(By.id("userName"));
		ele9.click();
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userLogout")));
		WebElement ele10 = dr.findElement(By.id("userLogout"));
		ele10.click();
		Thread.sleep(2000);
		dr.close();
	}
	
	
}
