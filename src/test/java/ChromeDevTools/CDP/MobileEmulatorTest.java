package ChromeDevTools.CDP;

import java.util.HashMap;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class MobileEmulatorTest {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		
		devTools.createSession();
		
		//https://rahulshettyacademy.com/angularAppdemo/
		//Send commands to CDP Methods-> CDP methods will invoke and get access to chrome dev tools
		//https://chromedevtools.github.io/devtools-protocol/tot/Browser/
		
		// Send Command to CDP Method -> then CDP will invoke and get access to chrome Dev Tools

		HashMap deviceMetrics = new HashMap()

		        {{

		            put("width", 600);

		            put("height", 1000);

		            put("mobile", true);

		            put("deviceScaleFactor", 50);

		        }};

		        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("/html/body/app-root/nav/button/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
		
	}

}
