package day31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessTesting {

	public static void main(String[] args) throws InterruptedException {
		
	/*	//Approach1 Headless mode
		ChromeOptions options= new ChromeOptions();
		options.setHeadless(true);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
	*/
		
		//Approach2 WDM 5.1+
	    ChromeOptions options= new ChromeOptions();
		options.setHeadless(true);
		WebDriver driver= WebDriverManager.chromedriver().capabilities(options).create();
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//Provide username - Admin.
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		//Provide password - admin123.
		driver.findElement(By.name("password")).sendKeys("admin");
		
		//Click on submit button.
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

		Thread.sleep(2000);
		
		//6)Verify the title of dashboard page.
		//Title validation
		String act_title=driver.getTitle();
		String exp_title="OrangeHRM";
		
		if(act_title.equals(exp_title))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Failed");		
		}
		
		
		
		driver.close();
	}

}
