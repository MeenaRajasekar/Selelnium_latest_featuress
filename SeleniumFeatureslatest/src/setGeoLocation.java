import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class setGeoLocation {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devtool=driver.getDevTools();
		devtool.createSession();
		
		Map<String, Object> coordinates=new HashMap<String, Object>();
		coordinates.put("longitude", 52);
		coordinates.put("latitude", 5);
		
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", coordinates);
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Netflix",Keys.ENTER);
		
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		
		String title=driver.findElement(By.xpath("//div[contains(@class,'default-ltr-cache')]/h1")).getText();
		
		System.out.println(title);
		
		
		
		
		

	}

}
