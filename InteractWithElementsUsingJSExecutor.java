package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithElementsUsingJSExecutor {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//ChromeDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		JavascriptExecutor js=(JavascriptExecutor)driver; //if we create the driver instance with webdriver then typecasting required
		//JavascriptExecutor js=driver; //if we create the driver instance with chromedriver then no typecasting required
		
		//locators are not proper because of webpage change
		//Input box 
		WebElement inputbox=driver.findElement(By.id("name"));
		//inputbox is sent to arguments[0] and setting the attribute by setting value=john
		js.executeScript("arguments[0].setAttribute('value','john')",inputbox); 
		
		//Radio button
		WebElement male_rd=driver.findElement(By.id("radiobutton"));
		//male_rd.click(); //throws intercepted exception
		js.executeScript("arguments[0].click();",male_rd); 
		
		//CheckBox
		WebElement sunday=driver.findElement(By.id("checkbox"));
		//sunday.click(); //throws intercepted exception
		js.executeScript("arguments[0].click();",sunday); 
		
		//button
		WebElement btn=driver.findElement(By.id("button"));
		//btn.click(); //throws intercepted exception
		js.executeScript("arguments[0].click();",btn); 

	}

}
