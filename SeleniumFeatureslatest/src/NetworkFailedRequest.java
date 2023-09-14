import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.fetch.Fetch;
import org.openqa.selenium.devtools.v111.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v111.network.model.ErrorReason;

public class NetworkFailedRequest {

	public static void main(String[] args) {
		
		//how to fail the selective network calls for some kind of validations
		
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devtool=driver.getDevTools();
		devtool.createSession();
		
		Optional<List<RequestPattern>> patterns=Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())) );
		
		devtool.send(Fetch.enable(patterns, Optional.empty()));
		
		devtool.addListener(Fetch.requestPaused(), request->
		
		{		
			devtool.send(Fetch.failRequest(request.getRequestId(),ErrorReason.FAILED));
				
		});

	
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("button[data-toggle='modal']")).click();
	
	
	
	}

}
