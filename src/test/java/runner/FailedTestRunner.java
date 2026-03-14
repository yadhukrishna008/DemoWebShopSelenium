package runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="@target/failed_Scenarios.txt",
		glue= {"stepDefinition"},
		dryRun=false,
		monochrome= true,
		plugin= {
				"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_Scenarios.txt"
		}
)

public class FailedTestRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}

