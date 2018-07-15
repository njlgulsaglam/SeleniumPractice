package practice;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumPractice {
WebDriver driver;
String baseUrl;


@BeforeClass
public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.manage().window().fullscreen();
	baseUrl ="https://learn.letskodeit.com/p/practice";
	driver.get(baseUrl);
}

@Test(priority = 0)
public void test1() {
	String actualTitle = driver.getTitle();
	String expectedTitle = "Practice | Let's Kode It" ;
	
	Assert.assertEquals(actualTitle,  expectedTitle);
		System.out.println("Loaded Page Successfully ");
		
	}

/*@Test(priority = 1)
public void test2() {
	
	driver.findElement(By.xpath("//a[@class='btn btn-primary pull-right btn-lg']")).click();
}
*/
@Test(priority = 1)
public void bmwRadioButton() throws InterruptedException {
	WebElement bmwRadioButton = driver.findElement(By.id("bmwradio"));
	bmwRadioButton.click();
	
	Thread.sleep(2000);
	WebElement benzRadioButton = driver.findElement(By.id("benzradio"));
	benzRadioButton.click();
	
	Thread.sleep(2000);
	WebElement hondaRadioButton = driver.findElement(By.id("hondaradio"));
	hondaRadioButton.click();
	
}

@Test(priority = 2)
public void checkBox() throws InterruptedException {
	WebElement bmwCheckBox =driver.findElement(By.id("bmwcheck"));
	bmwCheckBox.click();
	
	Thread.sleep(2000);
	WebElement benzCheckBox = driver.findElement(By.id("benzcheck"));
	benzCheckBox.click();
	
	Thread.sleep(2000);
	WebElement hondaCheckBox =driver.findElement(By.id("hondacheck"));
	hondaCheckBox.click();
	
	
	System.out.println("BMW radioCheckBox is selected ?"+ bmwCheckBox.isSelected());
	System.out.println("Benz benzCheckBox is selected ?"+ benzCheckBox.isSelected());
	System.out.println("Honda hondaCheckBox is selected ?"+ hondaCheckBox.isSelected());
}

@Test(priority=4)
public void alert() throws InterruptedException {
	driver.findElement(By.id("name")).sendKeys("Nejla");
	
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("#alertbtn")).click();
	Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	alert.accept();
}


@Test(priority = 5)
public void LoginLink() throws InterruptedException {
	driver.findElement(By.xpath("//a[@class='navbar-link fedora-navbar-link']")).click();
	driver.findElement(By.cssSelector("#user_email")).sendKeys("njlgulsaglam@gmail.com");
	driver.findElement(By.id("user_password")).sendKeys("12345");
	driver.findElement(By.xpath("//input[@class='btn btn-primary btn-md login-button']")).click();
	
	Thread.sleep(2000);
	String emailorpasswordError = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	assertEquals(emailorpasswordError, "Invalid email or password.");
	
}

@Test(priority=6)
public void forgotPassword() {
	driver.findElement(By.xpath("//a[@class='link-below-button']")).click();
	//driver.findElement(By.xpath("//div[@class='content-box']"))
	
	String actualTitle = driver.getTitle();
	String expectedTitle = "Let's Kode It" ;
	
	Assert.assertEquals(actualTitle,  expectedTitle);
		System.out.println("Loaded Page Successfully ");
		
}





	
	
@AfterClass
public void tearDown() throws InterruptedException {
	Thread.sleep(2000);
	

}



}
