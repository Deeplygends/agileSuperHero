package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        return this.strength;
    }
    /**
     * Return true if superhero beat the badGuy
     * else false
     */
    public boolean fightBadGuy()
    {
        return badGuys.stream().allMatch(x -> x.getStrength() <= this.strength);
    }
}
