package testBadGuy;

import model.BadGuy;

import static org.junit.Assert.*;

import model.SuperHero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class testBadGuy {
    private BadGuy badGuy;
    private SuperHero superhero;
    @BeforeEach
    public void setUp()
    {

        badGuy = new BadGuy();
        superhero = SuperHero.getInstance();
    }
    @Test
    public void testGetStrength(){
        assertEquals(10, badGuy.getStrength());
    }
    @Test
    public void testGetSuperHero()
    {
        assertEquals(superhero, badGuy.getSuperHero());
    }
    @Test
    public void testSetSuperHero() {
        badGuy.setSuperHero(superhero);
        assertEquals(superhero, badGuy.getSuperHero());
    }
}
