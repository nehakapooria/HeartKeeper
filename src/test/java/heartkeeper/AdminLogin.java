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
public class AdminLogin {
	public WebDriver dr;
		
		@BeforeClass
		public void setConnection() {

			System.setProperty("webdriver.chrome.driver", "/home/chandra/Downloads/chromedriver");
			dr = new ChromeDriver();
			dr.get(Constants.APP_URL_SERVER + "/admin-login");
			dr.manage().window().maximize();
		}
		
		@Test(description = "admin login via email id")
		public void adminlogin() throws InterruptedException {
		
			WebDriverWait wait=new WebDriverWait(dr, 120);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("adminLoginEmail")));
			WebElement eleadminuserid = dr.findElement(By.id("adminLoginEmail"));
			eleadminuserid.sendKeys("heartkeeper.web@gmail.com");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("adminLoginPass")));
			WebElement eleadminpass = dr.findElement(By.id("adminLoginPass"));
			eleadminpass.sendKeys("heartkeeper16");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("submitAdminLogin")));
			WebElement eleadminsubmit = dr.findElement(By.id("submitAdminLogin"));
			eleadminsubmit.click();
			}
		
		@Test(description = "admin logout",dependsOnMethods={"adminlogin"})
		public void adminlogout() throws InterruptedException {
			System.out.println("Hii");	
			WebDriverWait wait=new WebDriverWait(dr, 60);
			
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("AdminName")));
			WebElement eleadminame = dr.findElement(By.id("AdminName"));
			eleadminame.click();
			Thread.sleep(3000);
			
			//wait.until(ExpectedConditions.elementToBeClickable(By.id("adminLogout")));
			WebElement eleadminlogout = dr.findElement(By.id("adminLogout"));
			eleadminlogout.click();
			dr.close();
		}	
		
		
		}	
		

