package SeleniumWebdriverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;

public class SampleSeleniumTestUsingTestNG {
	
	WebDriver driver= new FirefoxDriver();

  @BeforeTest
  public void beforeTest() {
	  driver.get("http://automationpractice.com/index.php");
	  driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
	  driver.quit();
  }
  
  @Test
  public void webdriverTest() {
	  WebElement searchKeyword = driver.findElement(By.id("search_query_top"));
	  searchKeyword.clear();
	  searchKeyword.sendKeys("T-shirt"); 
	  
	  WebElement searchBtn = driver.findElement(By.xpath("//*[@id='searchbox']/button"));
	  searchBtn.click();
	  
	  WebElement verifySearch = driver.findElement(By.xpath("//*[@id='center_column']/h1/span[2]"));
	  String actual = verifySearch.getText();
	  String expected = "1 result has been found.";
	  Assert.assertEquals(actual, expected);
	  
	  Select sortByPrice = new Select(driver.findElement(By.id("selectProductSort")));
	  sortByPrice.selectByValue("price:asc");
  }
}
