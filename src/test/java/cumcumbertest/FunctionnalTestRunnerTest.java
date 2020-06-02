package cumcumbertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import model.BadGuy;
import model.Maitre;
import model.Nac;
import model.SuperHero;
import org.junit.Assert;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue ="", strict = true)

public class FunctionnalTestRunnerTest{

    public static SuperHero superHero;
    public static SuperHero superHeroMax;
    public static BadGuy badguy;

public static class US001Test {
    private Nac puppy;
    private String answer;

    @Given("un Nac possédant un {string} et  un {int}")
    public void un_Nac_possédant_un_et_un(String string, Integer int1) throws io.cucumber.java.PendingException {
        puppy = new Nac(string, int1); }

    @When("l’utilisateur lui demande de se présenter")
    public void l_utilisateur_lui_demande_de_se_présenter() throws io.cucumber.java.PendingException {
        answer = puppy.presentation(); }

    @Then("le système renvoie la {string} du Nac")
    public void le_système_renvoie_la_du_Nac(String string) throws io.cucumber.java.PendingException {
        assertEquals(answer, string); }
}


public static class US002Test {
    private Maitre maitre;
    private ArrayList<Nac> myNac = new ArrayList<Nac>();
    private String answer;

    @Given("Un maitre avec un {string} et un {int} et les {string} {string} {int} {int} des animaux qu’il possede")
    public void un_maitre_avec_un_et_un_et_les_des_animaux_qu_il_possede(String nom, Integer age, String arg0, String arg1, int arg2, int arg3) throws io.cucumber.java.PendingException {
        Nac puppy1 = new Nac(arg0, arg2);
        Nac puppy2 = new Nac(arg1, arg3);
        myNac.add(puppy1);
        myNac.add(puppy2);
        maitre = new Maitre(age, nom, myNac);
    }

    @When("l’utilisateur demande de promener le groupe")
    public void lUtilisateurDemandeDePromenerLeGroupe() {
        answer = maitre.promener();
    }

    @Then("le systeme renvoie un {string} confirmant bien la promenade et les animaux qui y participent")
    public void le_systeme_renvoie_un_confirmant_bien_la_promenade_et_les_animaux_qui_y_participent(String message) throws io.cucumber.java.PendingException {
        assertEquals(answer, message);
    }


    @Given("Un maître avec un {string} et un {int} ne possédant pas d’animal")
    public void un_maître_avec_un_et_un_ne_possédant_pas_d_animal(String nom, Integer age) throws io.cucumber.java.PendingException {
        maitre = new Maitre(age, nom);
    }

    @Then("le système renvoie un {string} d erreur")
    public void le_système_renvoie_un_derreur(String message) throws io.cucumber.java.PendingException {
        assertEquals(answer, message);
    }
}

public static class StepDefinitions {

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
}