import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.network.Network;

public class EmulateNetworkSpeed {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devtool=driver.getDevTools();
		devtool.createSession();
		
		devtool.send(Network.enable(  Optional.empty(),  Optional.empty(),  Optional.empty()));
		devtool.send(Network.emulateNetworkConditions(false, 3000, 5000, 8000, Optional.empty()));//Here key value is 2nd argument(latency)
		
		long startime=System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("button[data-toggle='modal']")).click();
		driver.close();
		long endtime=System.currentTimeMillis();
		
		System.out.println(endtime-startime);
		
		
		
		
		
		
	}

}
