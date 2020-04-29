package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Décrivez votre classe SuperHero ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class SuperHero
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String identity = "Spiderman";
    private int strength =  35;
    private static Logger log = Logger.getLogger("SuperHero");

    private Collection<BadGuy> badGuys;


    /**
     * Constructeur d'objets de classe SuperHero
     */
    public SuperHero()
    {
        badGuys = new ArrayList<BadGuy>();
    }

    /*public void addBadGuy(BadGuy badGuy)
    {
        badGuys.add(badGuy);
    }*/

    public void setBadGuy(BadGuy badGuy){
        badGuys.add(badGuy);
    }


    public String getIdentity()
    {
        return this.identity;
    }

    public void setIdentity(String identity)
    {
        this.identity = identity;
    }

    public int getStrength()
    {
        return this.strength;
    }

    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    public int workOut(int addStrength)
    {
        this.strength += addStrength;
        printDetailsHero();
        return this.strength;
    }

    private void printDetailsHero()
    {
        //Print details about the hero after the work out
        log.info("name : "+identity);
        log.info("force : " + strength);
    }
    /**
     * The hero fight every bad guy. If he have been defeat one time, the method return false.
     * If he beats all his badGuy
     */
    public boolean fightAllBadGuys()
    {
        return badGuys.stream().allMatch(x -> x.getStrength() <= this.strength);
    }

    @Override
    public boolean equals(Object o)
    {
        /**
         * si l'objet passé en parametre est null ou n'est pas un objet SuperHero alors ils ne
         * peuvent pas être égaux
        **/
        if(o == null || !(o instanceof SuperHero)) return false;
        /**
         * Si la référence (l'adresse mémoire est la même) ils sont forcément égaux
         */
        if(o == this) return true;
        /**
         * Sinon on transforme o en objet SuperHero et on compare les champs idendity et strength
         */
        SuperHero superhero = (SuperHero)o;
        return superhero.getStrength() == this.strength && superhero.getIdentity() == this.identity;
    }


}
