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
public class LoginViaFacebook {
	WebDriver dr;

	@BeforeClass
	public void setConnection() {

		System.setProperty("webdriver.chrome.driver", "/home/chandra/Downloads/chromedriver");
		dr = new ChromeDriver();
		dr.get(Constants.APP_URL_SERVER + "/home");
		dr.manage().window().maximize();
	}
	
	@Test(description = "login via facebook id")
	public void loginfb() throws InterruptedException{
		WebDriverWait wait= new WebDriverWait(dr,120);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("showLogin")));
		WebElement elefblogin= dr.findElement(By.id("showLogin"));
		elefblogin.click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("fbLogin")));
		WebElement elefbtn=dr.findElement(By.id("fbLogin"));
		elefbtn.click();
		
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
                 WebElement elefbemail=dr.findElement(By.id("email"));
     			elefbemail.sendKeys("kapooria.neha@gmail.com");
     			Thread.sleep(1000);
     			WebElement elefbpass=dr.findElement(By.id("pass"));
     			elefbpass.sendKeys("rsnr2689");
     			WebElement elefbbtn=dr.findElement(By.id("loginbutton"));
     			elefbbtn.click();
     			Thread.sleep(3000);
             }
            
         }
        dr.switchTo().window(parentWindowName);
        System.out.println(dr.getTitle());
        System.out.println("-------------------------------------------------------");
		}
	
	@Test(description = "logout",dependsOnMethods={"loginfb"})
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
