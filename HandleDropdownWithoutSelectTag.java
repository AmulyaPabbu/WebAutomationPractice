package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdownWithoutSelectTag {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();	
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		//clicking on dropdown
		driver.findElement(By.xpath("//button[contains(@class, 'multiselect')]")).click();
		
		List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class, 'multiselect')]//label"));
		
		//Find total number of options
		System.out.println(options.size());
		
		//Print options in console window
		/*	for(int i=0; i<options.size(); i++)
			{
				System.out.println(options.get(i).getText());
			}
			*/
		
		//Select options from dropdown
	/*	for(int i=0; i<options.size(); i++)
		{
			String option=options.get(i).getText();
			if(option.equals("Java") || option.equals("Python"))
			{
				options.get(i).click();
			}
		}
		*/
		
		for(WebElement option:options)
		{
			String text=option.getText();
			if(text.equals("Java") || text.equals("Python"))
			{
				option.click();
			}
		}

	}

}
