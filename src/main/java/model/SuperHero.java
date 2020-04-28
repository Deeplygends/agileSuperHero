package model;

import java.util.Collection;

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

    private Collection<BadGuy> badGuy;


    /**
     * Constructeur d'objets de classe SuperHero
     */
    public SuperHero()
    {
        // initialisation des variables d'instance
    }


    public void setBadGuy(BadGuy badGuy){

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
        return true;
    }
}
