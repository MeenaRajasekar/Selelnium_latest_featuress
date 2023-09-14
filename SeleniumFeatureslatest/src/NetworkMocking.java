import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.fetch.Fetch;

public class NetworkMocking {

	public static void main(String[] args) {
		
		//how to mock network request with selenium on Chrome Devtool integration

		
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devtool=driver.getDevTools();
		devtool.createSession();
		
		devtool.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devtool.addListener(Fetch.requestPaused(), request->
		{
			if(request.getRequest().getUrl().contains("shetty"))
			{
				String mockedUrl=request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				
				devtool.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl), Optional.of(request.getRequest().getMethod()),
						Optional.empty(), Optional.empty(),Optional.empty() ));
			}
			else {
				devtool.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()),
						Optional.empty(), Optional.empty(),Optional.empty() ));
				
			}
				
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("button[data-toggle='modal']")).click();
		
		
		
	}

}
