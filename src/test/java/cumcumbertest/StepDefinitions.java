package cumcumbertest;

import cucumber.api.java.en.*;
import model.BadGuy;
import model.SuperHero;

import static org.junit.Assert.assertEquals;


import org.junit.Assert;

public class StepDefinitions {
    public static SuperHero superHero;
    public static SuperHero superHeroMax;
    public static BadGuy badguy;
    @Given("^a Superhero with a strength of \"(.*)\"$")
    public void aSuperheroWithAStrengthOfP1(String p1) {
        superHero = new SuperHero("Hero", Integer.parseInt(p1));
    }

    @When("^the SuperHero is working out$")
    public void theSuperHeroIsWorkingOut() {
        superHero.workOut();
    }

    @Then("^the SuperHero' strength grow up to \"(.*)\"$")
    public void theSuperHeroStrengthGrowUpToP1(String p1) {
        assertEquals(superHero.getStrength(), Integer.parseInt(p1));
    }


    @Given("^a SuperHero with a strenght of \"(.*)\"$")
    public void aSuperHeroWithAStrenghtOfP1(String p1) {
        superHeroMax = new SuperHero("Hero Max", Integer.parseInt(p1));
    }

    @When("^SuperHero works out$")
    public void superHeroWorksOut() {
        superHeroMax.workOut();
    }

    @Then("^the SuperHero' strength is cap to \"(.*)\"$")
    public void theSuperHeroStrengthIsCapToP1(String p1) {
        assertEquals(superHeroMax.getStrength(), Integer.parseInt(p1));
    }
    @Given("^a fight between a supehero of strength (\\d+) and a BadGuy of strength (\\d+)$")
    public void aFightBetweenASuperheroOfStrengthP1AndABadGuyOfStrengthP2(int p1, int p2) {
        System.out.println(p1);
        superHero = new SuperHero("Batman", p1);
        badguy = new BadGuy(p2);
    }

    @When("^the bad guy wins against the super hero$")
    public void theBadGuyWinsAgainstTheSuperHero() {
        Assert.assertFalse(superHero.fightBadGuy(badguy));
    }

    @Then("^the superhero strength decrease to (\\d+)$")
    public void theSuperheroStrengthDecreaseToP3(int p3) {
        assertEquals(superHero.getStrength(), p3);
    }

    @Then("^the bad guy strength grow up to (\\d+)$")
    public void theBadGuyStrengthGrowUpToP4(int p4) {
        assertEquals(badguy.getStrength(), p4);
    }


    @Given("^a fight between a supehero of strength (\\d+) and a Bad Guy of strength (\\d+)$")
    public void aFightBetweenASuperheroOfStrengthP1AndABGOfStrengthP2(int p1, int p2) {
        superHero = new SuperHero("SpiderMan", p1);
        badguy = new BadGuy(p2);
    }

    @When("^the super hero wins against the bad guy$")
    public void theSuperHeroWinsAgainstTheBadGuy() {
        Assert.assertTrue(superHero.fightBadGuy(badguy));
    }

    @Then("^the SuperHero strength grows up to (\\d+)$")
    public void theSuperheroStrengthGrowsUpToP3(int p3) {
        assertEquals(superHero.getStrength(), p3);
    }

    @Then("^the bad guy strength decrease to (\\d+)$")
    public void theBadGuyStrengthDecreaseToP4(int p4) {
        assertEquals(badguy.getStrength(), p4);
    }
}