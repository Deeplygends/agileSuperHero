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
import org.junit.platform.engine.support.descriptor.FileSystemSource;
import org.junit.runner.RunWith;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue ="", strict = true)

public class FunctionnalTestRunnerTest {

    public static SuperHero superHero;
    public static SuperHero superHeroMax;
    public static BadGuy badguy;

    public static class US001Test {
        private Nac puppy;
        private String answer;

        @Given("un Nac possédant un {string} et  un {int}")
        public void un_Nac_possédant_un_et_un(String string, Integer int1) throws io.cucumber.java.PendingException {
            puppy = new Nac(string, int1);
        }

        @When("l’utilisateur lui demande de se présenter")
        public void l_utilisateur_lui_demande_de_se_présenter() throws io.cucumber.java.PendingException {
            answer = puppy.presentation();
        }

        @Then("le système renvoie la {string} du Nac")
        public void le_système_renvoie_la_du_Nac(String string) throws io.cucumber.java.PendingException {
            assertEquals(answer, string);
        }
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

    public static class UserStorySuperHero1A {

        @Given("^an instance of a Superhero$")
        public void aSuperheroWithAStrengthOfP1() {
            superHero = SuperHero.getInstance();
            //superHero.printDetailsHero();
        }

        @When("^the SuperHero is working out one time$")
        public void theSuperHeroIsWorkingOut() {
            superHero.workOut();
        }

        @Then("^the SuperHero' strength grow up to \"(.*)\"$")
        public void theSuperHeroStrengthGrowUpToP1(String p1) {
            assertEquals(superHero.getStrength(), Integer.parseInt(p1));
        }

    }
    public static class UserStorySuperHero1B {
        @Given("^a new instance of SuperHero$")
        public void aSuperHeroWithAStrenghtOfP1() {
            superHeroMax = SuperHero.getInstance();
            for(int i = 0; i < 100; i++)
                superHeroMax.workOut();
        }

        @When("^SuperHero works out 100 times$")
        public void superHeroWorksOut() {
            superHeroMax.workOut();
        }

        @Then("^the SuperHero' strength is cap to \"(.*)\"$")
        public void theSuperHeroStrengthIsCapToP1(String p1) {
            assertEquals(superHeroMax.getStrength(), Integer.parseInt(p1));
        }
    }

    public static class UserStory2A{
        @Given("^a fight between a supehero of strength (\\d+) and a BadGuy of strength (\\d+)$")
        public void aFightBetweenASuperheroOfStrengthP1AndABadGuyOfStrengthP2(int p1, int p2) {
            System.out.println(p1);
            superHero = SuperHero.getInstance();
            badguy = new BadGuy(p2);
        }

        @When("^the bad guy wins against the super hero$")
        public void theBadGuyWinsAgainstTheSuperHero() {
            //assertEquals(true, superHero.fightBadGuy(badguy));
            superHero.fightBadGuy(badguy);
        }

        @Then("^the superhero strength decrease to (\\d+)$")
        public void theSuperheroStrengthDecreaseToP3(int p3) {
            assertEquals(superHero.getStrength(), p3);
        }

        @Then("^the bad guy strength grow up to (\\d+)$")
        public void theBadGuyStrengthGrowUpToP4(int p4) {
            assertEquals(badguy.getStrength(), p4);
        }
    }

    public static class UserStory2B{
        @Given("^a fight between a superhero and a Bad Guy of strength (\\d+)$")
        public void aFightBetweenASuperheroOfStrengthP1AndABGOfStrengthP2(int p2) {
            superHero = SuperHero.getInstance();
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

    public static class Us_Mixte {

        private Nac puppy;
        private BadGuy bg;
        private int force_before;
        private int nbrDodo_before;

        @Given("un Nac avec un {int} et un BadGuy avec une {int}")
        public void un_Nac_avec_un_et_un_BadGuy_avec_une(Integer int1, Integer int2) {
            puppy = new Nac("hamtaro", int1);
            bg = new BadGuy(int2);
            this.force_before = bg.getStrength();
            this.nbrDodo_before = puppy.getNbrDodo();
        }

        @When("le Nac gagne")
        public void le_Nac_gagne() {
            assertEquals(puppy.fightBadGuy(bg), true);
        }

        @When("le badguy gagne")
        public void le_badguy_gagne() {
            assertEquals(puppy.fightBadGuy(bg), false);
        }

        @Then("le Nac voit son {int} augmenter et le badguy son {int} diminuer")
        public void le_Nac_voit_son_augmenter_et_le_badguy_son_diminuer(Integer int1, Integer int2) {
            boolean b1 = false;
            if(int1 == 1){
                b1 = true;
            }
            assertEquals(b1, puppy.getNbrDodo() > this.nbrDodo_before);
            if(int2 == 1){
                b1 = true;
            }
            else{
                b1 = false;
            }
            assertEquals(b1, bg.getStrength() > this.force_before);
        }

        @Then("le Nac voit son {int} diminuer et le badguy son {int} augmenter")
        public void le_Nac_voit_son_diminuer_et_le_badguy_son_augmenter(Integer int1, Integer int2) {
            boolean b1 = false;
            if(int1 == 1){
                b1 = true;
            }
            assertEquals(b1, puppy.getNbrDodo() > this.nbrDodo_before);
            if(int2 == 1){
                b1 = true;
            }
            else{
                b1 = false;
            }
            assertEquals(b1, bg.getStrength() >= this.force_before);
        }

    }


}