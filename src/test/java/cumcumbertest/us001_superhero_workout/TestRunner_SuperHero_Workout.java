package cumcumbertest.us001_superhero_workout;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/resources/features", glue="")
public class TestRunner_SuperHero_Workout {

}
