import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		DevTools devtool=driver.getDevTools();
		
		devtool.createSession();
		
		//send command to CDP methods->CDP methods will invoke and get access to CDP tools
		devtool.send(Emulation.setDeviceMetricsOverride(600, 1000, 55, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/shop");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.linkText("Library")).click();
		
		}

}
