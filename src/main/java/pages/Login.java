package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Utility;

/**
 * @description: Page Object class for Login page
 * @author vinod_rane
 * @version 1.0
 * @since 19/04/2019
*/

public class Login {

	// Initialization: Page factory will initialize every web element with reference
	// to corresponding element on the actual web page based on locators
	public Login(WebDriver driver) {
		/**
		   * Constructor
		 */	
		PageFactory.initElements(driver, this);
	}

	// Declare elements on Login page by @findBy annotation
	@FindBy(linkText = "login")
	private WebElement login_lnkbtn;

	@FindBy(id = "username")
	private WebElement username_txt;

	@FindBy(id = "password")
	private WebElement password_txt;

	@FindBy(css = ".btn.btn-primary.ng-scope")
	private WebElement authenticate_btn;
	
	@FindBy(xpath = "//span[contains(text(),'Account')]")
	private WebElement account_btn;
	
	@FindBy(xpath = "//span[contains(text(),'Log out')]")
	private WebElement log_out_btn;
	
	@FindBy(xpath = "//div[contains(text(),'You are logged in as user \"admin\".')]")
	private List<WebElement> login_success;

	// Utilization: Methods to perform action on the web page
	public void click_login_link() {
		login_lnkbtn.click();
	}	

	/**
	   * Enter text in username textbox.
	   * @param: uname Username
	   * Parameters:uname, must not be null
	 */	
	public void enter_username(String uname) {
		username_txt.sendKeys(uname);
	}
	
	/**
	   * Enter text in password textbox.
	   * @param: pwd Password
	   * Parameters:pwd, must not be null
	 */	
	public void enter_password(String pwd) {
		password_txt.sendKeys(pwd);
	}
	
	/**
	   * Click on authenticate button. This function also validates the login success.
	   * @param: None
	 */	
	public void authenticate() {
		authenticate_btn.click();
		validate_login();
	}
	
	public void click_on_account_button() {
		Utility.pageRefresh();
		account_btn.click();
	}
	
	public void click_on_logout() {
		log_out_btn.click();
	}
	
	//Login assertion
	public void validate_login() {
		if(login_success.size()==1) {
			System.out.println("Login successful");
		}else {
			System.out.println("Login failed");
		}
	}
}
