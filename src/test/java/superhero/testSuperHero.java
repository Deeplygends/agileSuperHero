package superhero;

import model.BadGuy;
import model.SuperHero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.Assert.*;
import org.junit.After;

import java.util.logging.Logger;


class testSuperHero
{
    private BadGuy badGuy1;
    private BadGuy badGuy2;
    private static Logger log =java.util.logging.Logger.getLogger("SuperHeroTest");
    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
        log.info("Before statement");
        SuperHero.resetInstance();
        badGuy1 = new BadGuy();
        badGuy2 = new BadGuy(1000);
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }
    @Test
    public void testEquals()
    {
        SuperHero superHer1 = SuperHero.getInstance();
        SuperHero superHer2 = SuperHero.getInstance();

        assertTrue(!superHer1.equals(null));
        assertEquals(superHer1, superHer1);
        assertEquals(superHer1, SuperHero.getInstance());

        //test of the singleton
        assertEquals(superHer1, superHer2);

        assertTrue(superHer1.getIdentity().equals("Spiderman"));

    }
    @Test
    public void testWorkOut()
    {
        SuperHero superHer1 = SuperHero.getInstance();
        var strength = superHer1.getStrength();
        log.info("Test WorkOut Start");
        assertEquals(strength + 15, superHer1.workOut());
    }

    @Test
    public void testFightBadGuy()
    {
        SuperHero superHer1 = SuperHero.getInstance();
        log.info("Test FightBadGuy");
        assertEquals(true, superHer1.fightAllBadGuys());
    }

    @Test
    public void testSetIndentity()
    {
        SuperHero superHer1 = SuperHero.getInstance();
        superHer1.setIdentity("Moi");
        assertEquals("Moi", superHer1.getIdentity());
    }
    @Test
    public void testGetIndentity()
    {
        SuperHero superHer1 = SuperHero.getInstance();
        assertEquals("Spiderman", superHer1.getIdentity());
    }
    @Test
    public void testGetStrength()
    {
        SuperHero superHer1 = SuperHero.getInstance();
        assertEquals(40, superHer1.getStrength());
    }
    @Test
    public void testSetStrength()
    {
        SuperHero superHer1 = SuperHero.getInstance();
        superHer1.setStrength(50);
        assertEquals(50, superHer1.getStrength());
    }
    @Test
    public void testAddBadGuy()
    {
        SuperHero superHer1 = SuperHero.getInstance();
        BadGuy bg = new BadGuy(100);
        superHer1.addBadGuy(bg);
        assertFalse(superHer1.fightAllBadGuys());
    }
}




