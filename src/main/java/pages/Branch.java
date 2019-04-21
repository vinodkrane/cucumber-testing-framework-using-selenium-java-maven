package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Utility;


/**
 * @description: Page Object class for Branch page
 * @author vinod_rane
 * @version 1.0
 * @since 19/04/2019
*/

public class Branch {
	
	// Initialization: Page factory will initialize every web element with reference
	// to corresponding element on the actual web page based on locators
	
	WebDriver driver;
	
	public Branch(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Declare elements on Branch page by @findBy annotation
	@FindBy(xpath = "//span[contains(text(),'Create a new Branch')]")
	private WebElement create_new_branch_btn;

	@FindBy(name = "name")
	private WebElement name_txt;
	
	@FindBy(name = "code")
	private WebElement code_txt;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	private WebElement save_btn;
	
	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private WebElement cancel_btn;
	
	//Confirm delete operation
	@FindBy(xpath = "//span[contains(text(),'Delete')]")
	private WebElement confirm_delete_btn;
	
	//Number of rows of branch(branch)
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	private List<WebElement> branch_rows_tbl;
	
	//This is dynamically changing xpath
	private String edit_btn_xpath = "//button[@href='#/branch/id']/following-sibling::button/child::span[2]";
	private String delete_btn_xpath = "//button[@href='#/branch/id']/following-sibling::button[2]/child::span[2]";
	private String row_count_xpath = "//table[@class='table table-striped']/tbody/tr";
	
	
	// Utilization: Methods to perform action on the web page
	public void click_create_new_branch_button() {
		create_new_branch_btn.click();
	}	

	public void enter_name(String name) {
		name_txt.sendKeys(name);
	}
	
	public void enter_code(String code) {
		code_txt.sendKeys(code);
	}
	
	public void click_save_button() {
		save_btn.click();
	}
	
	public void click_cancel_button() {
		cancel_btn.click();
	}
	
	public void click_edit_branch_button(String id) {
		Utility.pageRefresh();
		WebElement edit_button = prepareWebElementWithDynamicXpath(edit_btn_xpath, id);
		edit_button.click();
	}
	
	public void click_delete_branch_button(String id) {
		Utility.pageRefresh();
		WebElement delete_button = prepareWebElementWithDynamicXpath(delete_btn_xpath, id);
		delete_button.click();
	}
	
	public void confirm_delete() {
		confirm_delete_btn.click();
	}
	
	public WebElement prepareWebElementWithDynamicXpath(String xpathValue, String id ) {
        return driver.findElement(By.xpath(xpathValue.replace("id", id)));
	}
	
	public int get_branch_count() {
		return driver.findElements(By.xpath(row_count_xpath)).size();
	}
}
