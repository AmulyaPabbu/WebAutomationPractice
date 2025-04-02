package day25;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertWithInputBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		
		Alert alertWindow=driver.switchTo().alert();
		System.out.println(alertWindow.getText());
		
		alertWindow.sendKeys("Welcome");
		
		alertWindow.dismiss();
		//validation
		String exp_text="You entered: Welcome";
		String act_text=driver.findElement(By.xpath("//p[@id='result']")).getText();
		if(act_text.equals(exp_text))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}

		
	}

}
