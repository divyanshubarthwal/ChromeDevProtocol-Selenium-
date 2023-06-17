package ChromeDevTools.CDP;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SetGeoLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		
		
		
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		
		Map<String,Object> coordinates=new HashMap<String,Object>();
		coordinates.put("latitude",40);
		coordinates.put("longitude",3);
		coordinates.put("accuracy",1);
		
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		//driver.get("http://google.com");
		//driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		//driver.findElement(By.xpath("//a[@href=\"https://www.netflix.com/\"]/h3[@class=\"LC20lb MBeuO DKV0Md\"]")).click();
		
		//String title=driver.findElement(By.xpath("//h1[@class=\"default-ltr-cache-19f4kxn ejqbulh8\"]")).getText();
		//System.out.println(title);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

		driver.get("https://my-location.org/");

		System.out.println(driver.findElement(By.id("address")).getText());



	}

}
