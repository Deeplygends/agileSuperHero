package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

/**
 * Décrivez votre classe SuperHero ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class SuperHero implements IFeroce {
    private String identity;
    private int strength;
    private static Logger log = Logger.getLogger("SuperHero");

    private static SuperHero INSTANCE;

    private Collection<BadGuy> badGuys;


    /**
     * Constructeur d'objets de classe SuperHero
     */

    private SuperHero()
    {
        badGuys = new ArrayList<BadGuy>();
        this.identity = "Spiderman";
        this.strength = 40;
    }

    public static SuperHero getInstance(){
        if(INSTANCE == null){
            INSTANCE = new SuperHero();
        }
        return INSTANCE; // Lazy Loading
    }

    public static void resetInstance()
    {
        INSTANCE = null;
    }
    
    public void addBadGuy(BadGuy badGuy){
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
        if(strength > 250)
            this.strength = 250;
        else
            this.strength = strength;
    }

    public void workOut()
    {
        setStrength(this.strength + 15);
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
    public boolean fightBadGuy(BadGuy badguy)
    {
        if(badguy.getStrength() < this.strength)
        {
            setStrength(strength+badguy.getStrength()/2);
            badguy.setStrength(badguy.getStrength()/2);
            return true;
        }
        setStrength(this.strength /= 2);
        badguy.setStrength(badguy.getStrength() + this.strength);
        return false;
    }





}
