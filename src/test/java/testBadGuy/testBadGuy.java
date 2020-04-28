package testBadGuy;

import model.BadGuy;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class testBadGuy {
    private BadGuy badGuy;

    @BeforeEach
    public void setUp()
    {
        badGuy = new BadGuy();
    }
    @Test
    public void testGetStrength(){
        assertEquals(10, badGuy.getStrength());
    }
}
