package ChromeDevTools.CDP;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.idealized.Network;
import org.openqa.selenium.devtools.v113.fetch.Fetch;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NetworkLogActivity {

	public static void main(String[] args) throws InterruptedException {
	// TODO Auto-generated method stub
		
	
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//log file ->
		//ADDED DEVTOOLS MAVEN DEPENDENCY
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		//driver.executeCdpCommand(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request->

		{

		if(request.getRequest().getUrl().contains("=shetty"))

		{

		String mockedUrl=request.getRequest().getUrl().replace("=shetty", "=Bad Guy");

		System.out.println(mockedUrl);

		devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl),

		Optional.of(request.getRequest().getMethod()), Optional.empty() , Optional.empty(), Optional.empty()));

		}

		else

		{

		devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),

		Optional.of(request.getRequest().getMethod()), Optional.empty() , Optional.empty(), Optional.empty()));

		}

		});

		    driver.get("https://rahulshettyacademy.com/angularAppdemo");

		    driver.manage().window().maximize();

		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

		Thread.sleep(3000);

		System.out.println(driver.findElement(By.cssSelector("p")).getText());}
}
