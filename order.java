package walcart.order_Process;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class order {
	

		@Test
		public void myFirstTest() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			// create a chromeDriver object named driver.
			WebDriver driver = new ChromeDriver();
			SoftAssert softAssert=new SoftAssert();

			// go to google web page
			driver.get("https://www.walcart.com/");
			softAssert.assertEquals(driver.getCurrentUrl(), "https://www.walcart.com/","current url dose not match");
			// Maximize the browser window
			driver.manage().window().maximize();

			// wait for 5 seconds
			Thread.sleep(5000);
			
			//clicking login button
			driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
			
			//logins process start
			driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("01303117693");
			driver.findElement(By.xpath("//button[@class='action primary mobile-login-button']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Ullas199520");
			driver.findElement(By.xpath("//button[@class='action primary mobile-login-code-button']")).click();
			Thread.sleep(3000);
			//logins process end
			
			//search product start
			driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Monitor");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@title='Search']//span[contains(text(),'Search')]")).click();
			softAssert.assertEquals(driver.getCurrentUrl(), "https://www.walcart.com/catalogsearch/result/?q=Monitor","search url dose not match");
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(@title,'Walton Monitor 21.45 Inch LED WD215V04')]")).click();
			String actualProductName = driver.findElement(By.xpath("//strong[normalize-space()='Walton Monitor WD215V04']")).getText();
			softAssert.assertEquals(actualProductName, "Walton Monitor WD215V04","product name dose not match");
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//select[@id='attribute93']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id=\"attribute93\"]/option[2]")).click();
			Thread.sleep(3000);
			//search product end
			
			//increase qty and add to cart start
			driver.findElement(By.xpath("//span[@class='mbi mbi-plus']")).click();
			Thread.sleep(1000);
			String actualQty = driver.findElement(By.xpath("//*[@id=\"qty\"]")).getText();
			softAssert.assertEquals(actualQty, "2","product dose not increase");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div/div[2]/div[2]/div[1]/a")).click();
			Thread.sleep(3000);
			String actualSubTotal = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr[2]/td[4]/span/span/span")).getText();
			softAssert.assertEquals(actualSubTotal, "BDT 22,398","product price not correct");
			
			driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div[2]/div/div/div[2]/div[1]/ul/li/button")).click();
			Thread.sleep(3000);
			//increase qty and add to cart end
			
			//shipping data strat
			driver.findElement(By.xpath("//*[@id=\"checkout-step-shipping\"]/div[2]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[1]/div/input")).sendKeys("01922661277");           
			Thread.sleep(1000);                                                                                                        //phone number
			driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[2]/div/input")).clear();                           //clear previous text
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[2]/div/input")).sendKeys("kk");                    //add new text
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[3]/div/input")).clear();                           //clear previous text
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[3]/div/input")).sendKeys("bd");                    //add new text
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/fieldset/div/div[1]/div/input")).sendKeys("3/1 3/2");  //address 1
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/fieldset/div/div[2]/div/input")).sendKeys("20 bdm");   //address 2
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/fieldset/div/div[3]/div/input")).sendKeys("30 akm");   //address 3
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[7]/div/input")).sendKeys("Dhaka");                 // district
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[8]/div/input")).sendKeys("1200");                  //post code
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"shipping-new-address-form\"]/div[9]/div/input")).sendKeys("none");                  //work
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".action.primary.action-save-address")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".button.action.continue.primary")).click();
			Thread.sleep(3000);
			//shipping data end
			
			
//			close the browser all active window
			driver.quit();
			softAssert.assertAll();

}
		}
