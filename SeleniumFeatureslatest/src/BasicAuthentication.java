import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
import java.util.function.Predicate;


public class BasicAuthentication {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		ChromeDriver driver = new ChromeDriver();

		//predicate help you to create filter condition for your data
		
	    Predicate<URI>	uripredicate=uri->uri.getHost().contains("httpbin:org");
		((HasAuthentication)driver).register(uripredicate, UsernameAndPassword.of(null, null));
		
		driver.get(null);
		
	}

}
