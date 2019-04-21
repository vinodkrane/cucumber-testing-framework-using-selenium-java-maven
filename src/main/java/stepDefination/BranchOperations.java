package stepDefination;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Branch;
import pages.Entities;
import pages.Login;
import utility.DataHelper;
import utility.DriverFactory;
import utility.Utility;


public class BranchOperations {
	
	public WebDriver driver;
	Login login;
	Entities entities;
	Branch branch;
	public List<HashMap<String, String>> datamap;
	String id;
	
	static Logger logger = Logger.getLogger(BranchOperations.class.getName());


	/**
	* @description: setUp() method to set up initial state for all test methods and tearDown() method perform cleanup after execution.
	* @param None
	* @return None
	* @author vinod_rane
	* @version 1.0
	*/
	
	@Before
	public void setUp() {
		Reporter.assignAuthor("Vinod Rane");
		datamap = DataHelper.data(System.getProperty("user.dir") + "../Gurukul/resources/data.xlsx", "Sheet1");
		logger.info("Instantiating chrome driver");
		driver = DriverFactory.get_driver_instance();
		login = new Login(driver);
		entities = new Entities(driver);
		branch = new Branch(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyConfigurator.configure("../Gurukul/config/log4j.properties");
		//List<HashMap<String, String>> datamap;
	}
	
	
	@After
	public void tearDown() {
	    Reporter.loadXMLConfig(new File(Utility.getProperty("reportConfigPath")));
	    Reporter.setSystemInfo("User Name", Utility.getProperty("uname"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.141.59");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	    driver.close();
	}

	
	@Given("^user navigates to the gurukula application$")
	public void user_is_on_the_gurukula_application_home_page() throws Throwable {
		driver.get(Utility.getProperty("url"));
	}

	@When("^he log-in to the application$")
	public void he_logged_in_successfully() throws Throwable {
		Reporter.addStepLog("Login to the application");
		login.click_login_link();
		Reporter.addStepLog("Enter User Name:");
		login.enter_username(Utility.getProperty("uname"));
		Reporter.addStepLog("Enter Password:");
		login.enter_password(Utility.getProperty("pwd"));
		Reporter.addStepLog("Click Authenticate button:");
		login.authenticate();

	}

	@Then("^he add the branch to the application \"([^\"]*)\"$")
	public void he_add_the_branch_to_the_application(String arg1) throws Throwable {
		
		Reporter.addStepLog("Add the branch");
		//Getting name and code from data.xlsx
		int index = Integer.parseInt(arg1);
	    String name = datamap.get(index).get("b_name");
	    String code = datamap.get(index).get("b_code");	    
		entities.click_Entities_button();
		entities.click_branch_button();
		branch.click_create_new_branch_button();
		branch.enter_name(name);
		branch.enter_code(code);
		branch.click_save_button();
	}
	
	@Then("^he can edit the branch details \"([^\"]*)\"$")
	public void he_can_edit_the_branch_details(String arg1) throws Throwable {
		Reporter.addStepLog("Edit the branch");
		int index = Integer.parseInt(arg1);
	    id = datamap.get(index).get("editDeleteById");
		branch.click_edit_branch_button(id);
		branch.click_cancel_button();
		
	}

	@Then("^he can delete the branch")
	public void he_can_delete_the_branch() throws Throwable {
		Reporter.addStepLog("Delete the branch");
		branch.click_delete_branch_button(id);
		branch.confirm_delete();
		login.click_on_account_button();
		login.click_on_logout();
	}
}
