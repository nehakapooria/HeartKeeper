package heartkeeper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Constants;

@Test
public class Signup {
	WebDriver dr;

	@BeforeClass
	public void setConnection() {

		System.setProperty("webdriver.chrome.driver", "/home/chandra/Downloads/chromedriver");
		dr = new ChromeDriver();
		dr.get(Constants.APP_URL_SERVER+ "/home");
		dr.manage().window().maximize();
	}

	@Test(priority=1,description = "Signup with Empty Values")
	public void signupblank() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(dr, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("showSignUp")));
		
		WebElement eleSignup = dr.findElement(By.id("showSignUp"));
		eleSignup.click();
		
		WebElement eleEmail = dr.findElement(By.id("signupEmail"));
		System.out.println("Entering Blank Email");
		eleEmail.sendKeys("");
		
		WebElement elePassword = dr.findElement(By.id("signUpPass"));
		System.out.println("Entering Blank Email");
		elePassword.sendKeys("");
		
		WebElement eleCnfPassword= dr.findElement(By.id("signUpConfirmPass"));
		System.out.println("Entering Blank Email");
		eleCnfPassword.sendKeys("");
		
		WebElement eleBtnsubmit = dr.findElement(By.id("sunmitSignUp"));
		eleBtnsubmit.click();	
		Thread.sleep(3000);
	}

	@Test(priority=2,description = "Signup with an Existing account")
	public void signupexisting() throws InterruptedException {
		
		WebElement eleEmail = dr.findElement(By.id("signupEmail"));
		eleEmail.sendKeys("jassi@gmail.com");
		
		WebElement elePassword = dr.findElement(By.id("signUpPass"));
		elePassword.sendKeys("heart@123");
		Thread.sleep(3000);

		System.out.println("Password Text is :-" + elePassword.getAttribute("value"));
		Thread.sleep(3000);
		

		WebElement eleCnfpassword = dr.findElement(By.id("signUpConfirmPass"));
		eleCnfpassword.sendKeys("heart5648");

		System.out.println("Confirm password Text is :-" + eleCnfpassword.getAttribute("value"));
				
		if(elePassword.getAttribute("value").equals(eleCnfpassword.getAttribute("value")))
		{
			System.out.println("Both field contain same data");
		}
		else
			System.out.println("Both field contain different data");
		
		System.out.println("Changing Value in Confirm Password");
		eleCnfpassword.clear();
		eleCnfpassword.sendKeys("heart@123");
		
		System.out.println("Changed value in Confirm Password");
		
		WebElement eleBtnsubmit = dr.findElement(By.id("sunmitSignUp"));
		eleBtnsubmit.click();
		Thread.sleep(3000);		
	}

	@Test(priority=3,description= "Clear Values in form")
	public void clear() throws InterruptedException
	{
		WebElement eleEmail = dr.findElement(By.id("signupEmail"));
		eleEmail.clear();
		
		WebElement elePassword = dr.findElement(By.id("signUpPass"));
		elePassword.clear();
		
		WebElement eleCnfPassword= dr.findElement(By.id("signUpConfirmPass"));
		eleCnfPassword.clear();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=4,description = "Signup Success")
	public void signuppositive() throws InterruptedException
	{

		WebElement eleEmail = dr.findElement(By.id("signupEmail"));
		eleEmail.sendKeys("nehakapooria89@gmail.com");
		
		WebElement elePassword = dr.findElement(By.id("signUpPass"));
		elePassword.sendKeys("heart@123");
		
		WebElement eleCnfPassword= dr.findElement(By.id("signUpConfirmPass"));
		eleCnfPassword.sendKeys("heart@123");
		
		WebElement eleBtnsubmit = dr.findElement(By.id("sunmitSignUp"));
		eleBtnsubmit.click();	
		
		Thread.sleep(5000);
		dr.close();
	}
}





