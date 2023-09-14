import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogCapture {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		
		driver.findElement(By.linkText("Cart")).click();
		
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries entry=driver.manage().logs().get(LogType.BROWSER);//Get LogEntry Object
		List<LogEntry>logs=entry.getAll();//With LogEntry Object using getAll method which returns all logs in list
		
		//iterating through list and print each log msg
		for(LogEntry e:logs) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
