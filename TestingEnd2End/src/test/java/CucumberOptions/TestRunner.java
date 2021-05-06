package CucumberOptions;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//@RunWith() annotation tells about the test runner class to start executing our tests.
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features", // the path is provided till Features package and all the feature files under this will be executed.
		glue="StepDefinitions" ,
				//this is just the package name. as it is expected feature and definition will be under src/test/java
				//for only executing 1 feature give full name : src/test/resources/Features/SignIn.feature
				format = {"pretty", "html:target/Destination"}
		)
public class TestRunner 
{

}
