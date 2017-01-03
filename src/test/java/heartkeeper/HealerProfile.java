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
public class HealerProfile {

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
			
			//wait.until(ExpectedConditions.elementToBeClickable(By.id("healerName")));
			//WebElement elehealername=dr.findElement(By.id("healerName"));
		}
		
		@Test(description = "Healers Profile",dependsOnMethods={"healerlogin"})
		public void profile() throws InterruptedException{
			
			WebDriverWait wait= new WebDriverWait(dr, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("healerNavProfile")));
			WebElement elehealerprofile= dr.findElement(By.id("healerNavProfile"));
			elehealerprofile.click();
			Thread.sleep(4000);
		}
		
		@Test(description= "Edit Healers Profile",dependsOnMethods={"profile"})
		public void editprofile()throws InterruptedException{
		
		WebDriverWait wait=new WebDriverWait(dr,120);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("editHealerBasic")));
		WebElement eleeditprofilepen=dr.findElement(By.id("editHealerBasic"));
		eleeditprofilepen.click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadHealerPic")));
//		WebElement eleupdatehealerpic=dr.findElement(By.xpath("//*[@id='uploadHealerPic']"));
//		eleupdatehealerpic.sendKeys("/home/chandra/workspace/HeartKeeper/src/main/resources/Neha1.jpg");
//		Thread.sleep(4000);
//		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("healerBasicFName")));
		WebElement elehealerfirstname=dr.findElement(By.id("healerBasicFName"));
		elehealerfirstname.clear();
		elehealerfirstname.sendKeys("Neha");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("healerBasicLName")));
		WebElement elehealerlastname=dr.findElement(By.id("healerBasicFName"));
		elehealerlastname.clear();
		elehealerlastname.sendKeys("Kapooria");
		
		
		
		
		dr.close();
		
		}
		
		
		
		
}
