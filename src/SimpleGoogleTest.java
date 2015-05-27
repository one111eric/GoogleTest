import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SimpleGoogleTest {
//test if we can find UCSF and SFSU in google search first page using search keyword "san francisco"
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Testing if we can find UCSF and SFSU in google search first page using search keyword \"San Francisco\"...");
		WebDriver wd=new FirefoxDriver();
		Thread.sleep(1000);
		wd.manage().window().setPosition(new Point(0,0));
   		wd.manage().window().setSize(new Dimension(1024,768));
   		
		wd.get("https://www.google.com");
		Thread.sleep(4000);
		wd.findElement(By.name("q")).sendKeys("San Francisco");
		wd.findElement(By.name("btnK")).click();
        Thread.sleep(2000);
        Boolean SFSU=false;
        Boolean UCSF=false;
        List<WebElement> firstpageresult=new ArrayList<WebElement>();
        firstpageresult=wd.findElements(By.cssSelector("h3.r"));
        for(WebElement result : firstpageresult)
        {
        	if(result.getText().contains("UC San Francisco"))
        	{
        		UCSF=true;
        	}
        	if(result.getText().contains("San Francisco State University"))
        	{
        		SFSU=true;
        	}
        }
        if(UCSF==true)
        {
        System.out.println("University of California, San Francisco is found in first page search result");
        }
        else{
        	System.out.println("University of California, San Francisco is not found in first page search result");
        }
        if(SFSU==true)
        {
        System.out.println("San Francisco State University is found in first page search result");
        }
        else{
        	System.out.println("San Francisco State University is not found in first page search result");
        }
        wd.close();
        
}
}
