package cumcumbertest.us001_superhero_workout;

import com.google.common.eventbus.SubscriberExceptionContext;
import cucumber.api.java.en.*;
import model.SuperHero;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    private static SuperHero superheroNormal;
    private static SuperHero superHeroMax;
    @Given("^a Superhero with a strength of \"(\\d+)\"$")
    public void aSuperheroWithAStrenghthOfP1(int p1) {
        superheroNormal = new SuperHero("Hero", p1);
    }

    @When("^the SuperHero is working out$")
    public void theSuperHeroIsWorkingOut() {
        superheroNormal.workOut();
    }

    @Then("^the SuperHero' strength grow up to (\\d+)$")
    public void theSuperHeroStrengthGrowUpToP1(int p1) {
        assertEquals(superheroNormal.getStrength(),p1);
    }


    @Given("^a SuperHero with a strength of (\\d+)$")
    public void aSuperHeroWithAStrengthOfP1(int p1) {
        superHeroMax = new SuperHero("Hero Max", p1);
    }

    @When("^SuperHero works out$")
    public void superHeroWorksOut() {
        superHeroMax.workOut();
    }

    @Then("^the SuperHero' strength become (\\d+)$")
    public void theSuperHeroStrengthBecomeP1(int p1) {
        assertEquals(superHeroMax.getStrength(), p1);
    }
}