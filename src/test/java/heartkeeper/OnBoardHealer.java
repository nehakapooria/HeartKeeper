package heartkeeper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.Constants;

	@Test
	public class OnBoardHealer {
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
			
			@Test(description = "Healer Onboard",dependsOnMethods={"adminlogin"})
			public void onboardhealer() throws InterruptedException {
			
				WebDriverWait wait=new WebDriverWait(dr,120);
				wait.until(ExpectedConditions.elementToBeClickable(By.id("adminNavOnboard")));
				WebElement eleonboardnav=dr.findElement(By.id("adminNavOnboard"));
				eleonboardnav.click();
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicFName")));
				WebElement eleofirstname=dr.findElement(By.id("onbrdBasicFName"));
				eleofirstname.sendKeys("Hersharan");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicLName")));
				WebElement eleolastname=dr.findElement(By.id("onbrdBasicLName"));
				eleolastname.sendKeys("Kaur");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicGender")));
				WebElement eleogender=dr.findElement(By.id("onbrdBasicGender"));
				eleogender.click();
				Thread.sleep(3000);
				dr.findElement(By.xpath("//*[@id='select_option_11']")).click();
				Thread.sleep(3000);
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicLocation")));
				WebElement eleolocation=dr.findElement(By.id("onbrdBasicLocation"));
				eleolocation.sendKeys("New Delhi");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicMobile")));
				WebElement eleophone=dr.findElement(By.id("onbrdBasicMobile"));
				eleophone.sendKeys("9654816446");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicEmail")));
				WebElement eleoemail=dr.findElement(By.id("onbrdBasicEmail"));
				eleoemail.sendKeys("hersharan.kaur@gmail.com");
							
				wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicQuali")));
				WebElement eleoqual=dr.findElement(By.id("onbrdBasicQuali"));
				eleoqual.click();
				Thread.sleep(3000);
				dr.findElement(By.xpath("//*[@id='select_option_13']")).click();
				Thread.sleep(1000);
				dr.findElement(By.xpath("//*[@id='select_option_15']")).click();
				//eleoqual.click();
	
				Thread.sleep(2000);
				Actions action=new Actions(dr);
			     WebElement ele=dr.findElement(By.cssSelector("body > md-backdrop"));
			     action.click(ele).build().perform();    

				wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicSpec")));
				WebElement eleospel=dr.findElement(By.id("onbrdBasicSpec"));
				eleospel.click();
				Thread.sleep(3000);
				dr.findElement(By.xpath("//*[@id='select_option_17']")).click();
				Thread.sleep(1000);
				dr.findElement(By.xpath("//*[@id='select_option_18']")).click();
				Thread.sleep(1000);
				dr.findElement(By.xpath("//*[@id='select_option_19']")).click();
				Thread.sleep(1000);
				
				Thread.sleep(2000);
				
				 Actions actionspec=new Actions(dr);
			     WebElement ele2=dr.findElement(By.cssSelector("body > md-backdrop"));
			     actionspec.click(ele2).build().perform();    
			     
			 	wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicLang")));
				WebElement eleolang=dr.findElement(By.id("onbrdBasicLang"));
				eleolang.click();
				Thread.sleep(3000);
				dr.findElement(By.xpath("//*[@id='select_option_21']")).click();
				Thread.sleep(1000);
				dr.findElement(By.xpath("//*[@id='select_option_22']")).click();
				Thread.sleep(1000);
				dr.findElement(By.xpath("//*[@id='select_option_23']")).click();
				Thread.sleep(1000);
				
				Thread.sleep(2000);
				
				 Actions actionlang=new Actions(dr);
			     WebElement ele3=dr.findElement(By.cssSelector("body > md-backdrop"));
			     actionlang.click(ele3).build().perform();    
			     
			     wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicEmailCharges")));
				 WebElement eleoemailcharge=dr.findElement(By.id("onbrdBasicEmailCharges"));
				 eleoemailcharge.sendKeys("20");
				 
				 wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicCallCharges")));
				 WebElement eleocallcharge=dr.findElement(By.id("onbrdBasicCallCharges"));
				 eleocallcharge.sendKeys("20");
			     
				 wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicChatCharges")));
				 WebElement eleochatcharge=dr.findElement(By.id("onbrdBasicChatCharges"));
				 eleochatcharge.sendKeys("20");
				 
				 wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicPass")));
				 WebElement eleopassword=dr.findElement(By.id("onbrdBasicPass"));
				 eleopassword.sendKeys("sam300axn@");
				 
				 wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicConfirmPass")));
				 WebElement eleocnfpassword=dr.findElement(By.id("onbrdBasicConfirmPass"));
				 eleocnfpassword.sendKeys("sam300axn@");
			     
				 wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicBio")));
				 WebElement eleobio=dr.findElement(By.id("onbrdBasicBio"));
				 eleobio.sendKeys("Possess 10 years of experience in the domain and can handle issues related to love,finance");
			     
				 wait.until(ExpectedConditions.elementToBeClickable(By.id("onbrdBasicOther")));
				 WebElement eleothers=dr.findElement(By.id("onbrdBasicOther"));
				 eleothers.sendKeys("No");
			     
				 wait.until(ExpectedConditions.elementToBeClickable(By.id("submitOnbrdBasic")));
				 WebElement eleosubmit=dr.findElement(By.id("submitOnbrdBasic"));
				 eleosubmit.click();
			}
			
			@Test(description = "Payment Details",dependsOnMethods={"onboardhealer"})
			public void onboardhealerpayment() throws InterruptedException {
				
				WebDriverWait wait=new WebDriverWait(dr,120);
				wait.until(ExpectedConditions.elementToBeClickable(By.id("onBoardACNo")));
				WebElement eleoaccno=dr.findElement(By.id("onBoardACNo"));
				eleoaccno.sendKeys("785467901");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("onBoardBankName")));
				WebElement eleobank=dr.findElement(By.id("onBoardBankName"));
				eleobank.sendKeys("Bank Of UK");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("onBoardACHolder")));
				WebElement eleoaccholder=dr.findElement(By.id("onBoardACHolder"));
				eleoaccholder.sendKeys("Hersharan Kaur");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("onBoardBankCode")));
				WebElement eleobankcode=dr.findElement(By.id("onBoardBankCode"));
				eleobankcode.sendKeys("12456890000");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.id("submitFinance")));
				WebElement eleosubmit=dr.findElement(By.id("submitFinance"));
				eleosubmit.click();
				
				Thread.sleep(2000);
				dr.close();
			}		
			
			
				
}
