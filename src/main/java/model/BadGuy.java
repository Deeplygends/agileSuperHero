package model;


/**
 * Décrivez votre classe BadGuy ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class BadGuy
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int strength = 10;
    private SuperHero nemesis;
    /**
     * Constructeur d'objets de classe BadGuy
     */
    public BadGuy()
    {
        // initialisation des variables d'instance
        nemesis = new SuperHero();
    }

    public void setSuperHero(SuperHero nemesis)
    {
        this.nemesis = nemesis;
    }
    public SuperHero getSuperHero()
    {
        return this.nemesis;
    }
    public int getStrength()
    {
        return this.strength;
    }
}

