package Steps;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\innoc\\eclipse-workspace\\castleHill\\src\\test\\resources\\Features\\login.feature", 
glue= {"Steps"},
plugin = {"json:target/cucumber.json"})

public class runner {
}