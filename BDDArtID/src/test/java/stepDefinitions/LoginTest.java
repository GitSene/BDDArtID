package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	
WebDriver driver;
@Given("^I am in newtours home page \"(.*?)\"$")
public void i_am_in_newtours_home_page(String url) throws Throwable {
   System.setProperty("webdriver.gecko.driver", "C:\\Users\\Babek Chalabi\\Desktop\\Selenium\\geckodriver.exe");
   driver = new FirefoxDriver();
   driver.get(url);
   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
}


@When("^I insert user name= \"(.*?)\" and  password= \"(.*?)\"$")
public void i_insert_user_name_and_password(String userName, String password) throws Throwable {
	driver.findElement(By.name("userName")).sendKeys(userName); 
	driver.findElement(By.name("password")).sendKeys(password); 
} 


@When("^I press login button$")
public void i_press_login_button() throws Throwable {
	driver.findElement(By.name("login")).click();
}



@Then("^\"(.*?)\" link should be seen on the top of menue$")
public void link_should_be_seen_on_the_top_of_menue(String signLink) throws Throwable {
	   Assert.assertTrue(driver.findElement(By.linkText(signLink)).isDisplayed());
    
}

}
