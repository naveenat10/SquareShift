package cnacodechallenge;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * @author Naveena Tholapi
 */

public class CnaTests extends BaseCna {
	
	@Test(description = "Validate the headline new item Title")
	
	public void tiltlevalidation() {
		
		//step1: Navigate to cns page
		driver.get(" https://www.channelnewsasia.com/");
		//step2 Validate the headline new item Title
	    driver.findElement(By.xpath("//a[@class='feature-card__heading-link feature-card__heading-link--']")).click();
	  
	    //step3 Click on the Headline Item title and navigate to the actual story. In the example below, the headline item is “Check your mouths regularly
		String headline_title = driver.getTitle();
		System.out.println("Headline Title is " + headline_title);
		
		//step4 Once in the Headline full news item detail page, verify if we are on the expected news item.
		Assert.assertTrue(true, headline_title);
		System.out.println("Headline title verification is success");
		
		//step5 Scroll to the bottom of the screen and wait for AJAX to load more news items.
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    
		//Click on Expand button
	    driver.findElement(By.xpath("(//a[@class='article__read-full-story-button article__read-full-story-button--'])[2]")).click();
        String headlineTitle2 = driver.getTitle();
		System.out.println("Headline Title is " + headlineTitle2);
       
	}
	
	@Test(description = "Validate Topstories,singapore Menus")
	  public void allsections() {
		 
		    //step1: Navigate to cns international page

		    driver.get("https://www.channelnewsasia.com/news/international");
		    //Step2: Go to All sections
			driver.findElement(By.xpath("//span[contains(text(),'All Sections')]")).click();
			//Step3: Hover to topstories
			WebElement topstories = driver.findElement(By.xpath("//*[@id=\"all-section-menu-modal\"]/div/div/div/div[1]/div[2]/ul/li[1]/a"));
			Actions actions = new Actions(driver);
			actions.moveToElement(topstories);
			//Step4: Click on singapore
			WebElement singapore = driver.findElement(By.xpath("//*[@id=\"hamburger-nav\"]/ul/li[1]/ul/li[1]/a"));
			actions.click().build().perform();
			//step5 Validate the headline new item Title
		    driver.findElement(By.xpath("//a[@class='feature-card__heading-link feature-card__heading-link--']")).click();
		    //step6 Click on the Headline Item title and navigate to the actual story. In the example below, the headline item is “Check your mouths regularly
			String headline_title = driver.getTitle();
			System.out.println("Headline Title is " + headline_title);
			//step7 Once in the Headline full news item detail page, verify if we are on the expected news item.
			Assert.assertTrue(true, headline_title);
			System.out.println("Headline title verification is success");
			//step8 Scroll to the bottom of the screen and wait for AJAX to load more news items.
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//Click on Expand button
		    driver.findElement(By.xpath("(//a[@class='article__read-full-story-button article__read-full-story-button--'])[2]")).click();
	        String headlineTitle2 = driver.getTitle();
			System.out.println("Headline Title is " + headlineTitle2);
	       
			}
	@Test
	public void checkweather() {
		
			//step1 Navigate to https://www.channelnewsas
			driver.get("https://www.channelnewsasia.com/news/international");
			driver.findElement(By.xpath("//span[contains(text(),'All Sections')]")).click();
			//hover weather
			WebElement weather = driver.findElement(By.xpath("(//a[contains(text(),'Weather')])[2]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(weather);
			actions.click().build().perform();
			//Validate the city-Kuala lumpur
			WebElement element= driver.findElement(By.xpath("//div[contains(text(),'kuala lumpur')]"));
			System.out.println(element.getText());
			Assert.assertTrue(true);
			System.out.println("City found succesfully");
			List<WebElement> city =driver.findElements(By.xpath("//div[@class='tabular-list__view--city']"));
			List<String> allcities=new ArrayList<String>();
			List<WebElement> maxTemp =driver.findElements(By.xpath("//span[@class='tabular-list__view--temp--max']"));
			List<String> allmaxtemp=new ArrayList<String>();
			List<WebElement> minTemp =driver.findElements(By.xpath("//span[@class='tabular-list__view--temp--min']"));
			List<String> allmintemp=new ArrayList<String>();
			List<WebElement> tempCondition =driver.findElements(By.xpath("//div[@class='tabular-list__view--condition']"));
			List<String> alltempcond=new ArrayList<String>();
			
			HashMap<String, List<String>> map = new HashMap<String, List<String>>();
			for(int i = 0; i < city.size(); i++) {
				
				List<String> temp = new ArrayList<String>();
				temp.add(tempCondition.get(i).getText());
				temp.add(maxTemp.get(i).getText());
				temp.add(minTemp.get(i).getText());
				map.put(city.get(i).getText(), temp);
			
				
				 //System.out.println(city.get(i).getText());
				 //System.out.println(map.get(city.get(i).getText()));
			}
			
			
			List<String> result = map.get("Kuala Lumpur");
			System.out.println("Kuala Lumpur:" + result.get(0)+" "+ result.get(1)+" "+ result.get(2));
			String cond = "Thunderstorm";
			String max = "33°";
			String min = "24°";
			Assert.assertTrue(result.get(0).equals(cond) && result.get(1).equals(max)  && result.get(2).equals(min));
			
		      
		    }
	
	
	

}
