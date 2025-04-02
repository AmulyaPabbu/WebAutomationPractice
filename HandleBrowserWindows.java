package day26;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		
		//capture ids for browser windows
		//In set collection we cannot retrieve individual items
		Set<String> windowIds=driver.getWindowHandles(); //stored 2 window ids
		
		//Approach1
/*		//converting set to list so that we can retrieve individual items using index concept
		List<String> windowIdsList=new ArrayList(windowIds);
		String parentWindowId=windowIdsList.get(0);  //parent window id
		String childWindowId=windowIdsList.get(1);  //child window id
		
		//switchTo child window
		driver.switchTo().window(childWindowId);
		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
		
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		*/
		
		//Approach2
	/*	for(String winId:windowIds)
		{
			String title=driver.switchTo().window(winId).getTitle();
			
			if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
			{
				driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
			}
			
		}
		*/
		
		//closing specific browser windows based on our choice
		//1-x 2-y 3-z 4-a 5-b
		for(String winId:windowIds)
		{
			String title=driver.switchTo().window(winId).getTitle();
			
			if(title.equals("OrangeHRM") || title.equals("OrangeHRM HR Software | OrangeHRM"))
			{
				driver.close();
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
