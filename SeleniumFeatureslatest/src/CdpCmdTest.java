import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.emulation.Emulation;

public class CdpCmdTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();

		DevTools devtool=driver.getDevTools();
		devtool.createSession();
		
		//this way you direct call cdp cmds without bringing selnium custom cmd into picture
		Map<String, Object> devmetrics=new HashMap<String, Object>();
		devmetrics.put("width", 600);
		devmetrics.put("height", 1000);
		devmetrics.put("deviceScaleFactor", 50);
		devmetrics.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", devmetrics);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/shop");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.linkText("Library")).click();
		
		
		}

}
