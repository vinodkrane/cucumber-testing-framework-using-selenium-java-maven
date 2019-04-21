package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @description: Page Object class for Entities page
 * @author vinod_rane
 * @version 1.0
 * @since 19/04/2019
*/

public class Entities {
	
	// Initialization: Page factory will initialize every web element with reference
	// to corresponding element on the actual web page based on locators
	
	public Entities(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declare elements on Entities page by @findBy annotation
	@FindBy(xpath = "//span[contains(text(),'Entities')]")
	private WebElement entities_btn;

	@FindBy(xpath = "//span[contains(text(),'Branch')]")
	private WebElement branch_btn;
	
	@FindBy(xpath = "//span[contains(text(),'Staff')]")
	private WebElement staff_btn;
	

	// Utilization: Methods to perform action on the web page
	public void click_Entities_button() {
		entities_btn.click();
	}	

	public void click_branch_button() {
		branch_btn.click();
	}
	
	public void click_staff_button() {
		staff_btn.click();
	}
}
