import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.network.model.Request;
import org.openqa.selenium.devtools.v111.network.model.Response;
import org.openqa.selenium.devtools.v85.network.Network;

public class NetworkLogActivity {

	public static void main(String[] args) {
		
		//Extract Network response and status code with Selenium CDP Listeners
		
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devtool=driver.getDevTools();
		devtool.createSession();
		
		//Enabled the Network so that ChromeDev Tools pull the traffic and send it to client(Selenium)
		devtool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devtool.addListener(Network.requestWillBeSent(), request->
	       {
				org.openqa.selenium.devtools.v85.network.model.Request req=request.getRequest();
				//System.out.println(req.getUrl());
		      
	       });
		
		//Whenever the event responseReceived() is fired am adding a listener addListener() so that way this event emits response object am catching the object
		  //and from that object am getting the stauts and URL
		devtool.addListener(Network.responseReceived(), response->
		{	
			org.openqa.selenium.devtools.v85.network.model.Response res=response.getResponse();
			//System.out.println(res.getUrl());
			//System.out.println(res.getStatus());
			if(res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getUrl()+"this URL is failed with status code"+res.getStatus());
			}
		
		} );
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("button[data-toggle='modal']")).click();
		
		
		

	}

}


