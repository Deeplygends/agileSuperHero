import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

class testJUNIT {
    @Test
    public void testTrue()
    {
        assertEquals(1,1);
    }
    @Test
    public void testFalse()
    {
        assertNotEquals(1,0);
    }
}
