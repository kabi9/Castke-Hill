package Steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {

	ChromeDriver driver;

	@Given("User on the Sauce Demo Login Page")
	public void User_on_the_Sauce_Demo_Login_Page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\innoc\\Desktop\\chromedriver_win32");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins");
		driver = new ChromeDriver(co);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@When("User enters valid username and password")
	public void User_enters_valid_username_and_password() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

	}

	@And("User click the Login Button")
	public void User_click_the_Login_Button() {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("User redirected to the Sauce Demo Main Page")
	public void User_redirected_to_the_Sauce_Demo_Main_Page() {
		driver.getTitle();
	}

	@And("User verify the App Logo exists ")
	public void User_verify_the_App_Logo_exists() {
		boolean logo = driver.findElement(By.className("app_logo")).isDisplayed();
		Assert.assertEquals(logo, true);
	}

//	***************************************************************************************************

	@When("User enters invalid username and password")
	public void User_enters_invalid_username_and_password() {
		driver.findElement(By.id("user-name")).sendKeys("standard_userr");
		driver.findElement(By.id("password")).sendKeys("secret_saucee");

	}

	@And("User click Login Button")
	public void User_click_Login_Button() {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("Error message is displayed - Invalid Credentials")
	public void Error_message_is_displayed_Invalid_Credentials() {

		boolean error = driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).isDisplayed();
		Assert.assertEquals(error, true);
	}

}
