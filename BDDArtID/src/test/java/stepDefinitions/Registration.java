package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Registration {
	
WebDriver driver;
@Given("^you are in registration page \"(.*?)\"$")
public void you_are_in_registration_page(String url) throws Throwable {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Babek Chalabi\\Desktop\\Selenium\\geckodriver.exe");
	   driver = new FirefoxDriver();
	   driver.get(url);
	   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
}

@Given("^Add correct data to registration form$")
public void add_correct_data_to_registration_form(DataTable credencials) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	//List<List<String>> data = credencials.raw();
	List<Map<String, String>> data = credencials.asMaps(String.class, String.class);
	driver.findElement(By.name("firstName")).sendKeys(data.get(0).get("firstName"));
	driver.findElement(By.name("lastName")).sendKeys(data.get(0).get("lastName"));
	driver.findElement(By.name("phone")).sendKeys(data.get(0).get("phone"));
	driver.findElement(By.name("userName")).sendKeys(data.get(0).get("userName"));
	driver.findElement(By.name("address1")).sendKeys(data.get(0).get("address1"));
	driver.findElement(By.name("city")).sendKeys(data.get(0).get("city"));
	driver.findElement(By.name("state")).sendKeys(data.get(0).get("state"));
	driver.findElement(By.name("postalCode")).sendKeys(data.get(0).get("postalCode"));
	driver.findElement(By.name("email")).sendKeys(data.get(0).get("email"));
	
}

@When("^I insert password \"(.*?)\" and confirm passwprd \"(.*?)\"$")
public void i_insert_password_and_confirm_passwprd(String pass, String confirm) throws Throwable {
	driver.findElement(By.name("password")).sendKeys(pass);
	driver.findElement(By.name("confirmPassword")).sendKeys(confirm);
   // throw new PendingException();
}

@When("^I click sumbmit$")
public void i_click_sumbmit() throws Throwable {
	driver.findElement(By.name("register")).click(); 
	//throw new PendingException();
}

@Then("^\"(.*?)\" page should be seen$")
public void page_should_be_seen(String url) throws Throwable {
Assert.assertEquals(url, driver.getCurrentUrl());
	//throw new PendingException();
}


}
