import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequest {

	public static void main(String[] args) {
		
		//block the unwanted Network request calls to speed up the execution with Selenium
		
		
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devtool=driver.getDevTools();
		devtool.createSession();
		
		devtool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtool.send(Network.setBlockedURLs(ImmutableList.of("*jpg","*css") ));
		
		long starttime=System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("a[role*='button']")).click();	
		driver.findElement(By.linkText("Selenium")).click();
		
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		long endtime=System.currentTimeMillis();
		System.out.println(endtime-starttime+"ms");
		
		
	}

}
