package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @description: This class acts as an interlink between cucumber feature files and step definition classes 
 * @author vinod_rane
 * @version 1.0
 * @since 28/12/2018
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "../Gurukul/src/main/java/gurukul/feature/featureFile.feature",
		glue= {"stepDefination"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome=true
		)
public class TestRunnerPostComment {
}