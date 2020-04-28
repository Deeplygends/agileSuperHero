package testBadGuy;

import model.BadGuy;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class testBadGuy {
    private BadGuy badGuy;

    @Before
    public void setUp()
    {
        badGuy = new BadGuy();
    }
    @Test
    public void testGetStrength(){
        assertEquals(10, badGuy.getStrength());
    }
}
