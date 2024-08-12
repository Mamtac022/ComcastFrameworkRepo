package practice.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class HotStarTest 
{
	public static void main(String[] args) throws Exception 
	{
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hotstar.com/in/home?ref=%2Fin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement element = driver.findElement(By.xpath("//p[@class='_1zc788KtPN0EmaoSx7RUA_ ON_IMAGE_ALT _3XVb7IxsFvh7Oy1CvpaF6R ']"));
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshot\\"+"SS2.png");
		Files.copy(src, dest);
		
		File s1 = ts.getScreenshotAs(OutputType.FILE);
		File d1= new File(".\\Screenshot\\"+"SS1.png");
		Files.copy(s1, d1);
	/*	

		
		List<WebElement> element1 =driver.findElements(By.linkText("a"));
		/*for(int i =0; i<element1.size()-1; i++)
		{
			WebElement links= element1.get(i);
			String url = links.getAttribute("href");
		}
		
		for(WebElement a :element1) {
		    
		}
		
		
	*/
		 List<WebElement> list =driver.findElements(By.tagName("a"));
		 for(WebElement element1: list) {
			 System.out.println(element1.getText()+" "+element1.getAttribute("href"));	
			 
		 }
		 
		
	     
		
		
		
		
		
		
		
		
	}
	}

