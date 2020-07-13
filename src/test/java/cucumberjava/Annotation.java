package cucumberjava; 

import java.util.Collections;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;


public class Annotation { 
   WebDriver driver = null;    
   
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver =  new ChromeDriver(options); 
        driver.get("https://mail.google.com/");        
	}
	
	@When("^enter username \"(.*?)\" and password \"(.*?)\"$")
	public void when_entered_username_password(String username, String password){
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).
			sendKeys(username);
		driver.findElement(By.id("identifierNext")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).
			sendKeys(password);
				//sendKeys("Abcdef123456");		
	}
	
	@Then("^login and send a msg \"(.*?)\"$")
	public void login_and_send_message(String emailIds) {
		driver.findElement(By.id("passwordNext")).click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}	
		
		System.out.println(emailIds);
		
		for(String emailId : emailIds.split(",")) {
		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
		System.out.println("##############################");
		System.out.println(emailId);
		//Enter the sender mail id
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(emailId);
		//Enter subject to the mail
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Selenium script");
		driver.findElement(By.xpath("//*[text() = 'Send']")).click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.findElement(By.xpath("//a[contains(text(),'Sent')]")).click();
		//tr/td[@id=':5m']//div//span[contains(text(),'Selenium script')]
		driver.close();
	}
}
