package Color; 

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {

    @Test
    public void testConvertToRGB_ValidColor() {
        Color color = new Color("blue"); 
        String result = color.convertToRGB();
        assertEquals("0,0,255", result, "Boja 'blue' nije pravilno konvertirana u RGB!");
    }

    @Test
    public void testConvertToRGB_InvalidColor() {
        Color color = new Color("unknownColor");
        String result = color.convertToRGB(); 
        assertNull(result, "Metoda nije vratila 'null' za nepoznatu boju!");
    }

    @Test
    public void testSetColor_ValidInput() {
        Color color = new Color("red");
        color.setColor("green"); 
        assertEquals("green", color.getColor(), "Metoda setColor nije ispravno postavila boju!");
    }

    @Test
    public void testSetColor_InvalidInput() {
        Color color = new Color("red");
        color.setColor("invalidColor"); 
        assertNotEquals("invalidColor", color.getColor(), "Metoda setColor prihvatila nevažeću boju!");
    }

    @Test
    public void testIsPrimaryColor() {
        Color color = new Color("red");
        assertTrue(color.isPrimaryColor(), "'red' je primarna boja, ali metoda kaže da nije!");

        color.setColor("purple");
        assertFalse(color.isPrimaryColor(), "'purple' nije primarna boja, ali metoda kaže da jest!");
    }

    @Test
    public void testDefaultColor() {
        Color color = new Color();
        assertEquals("black", color.getColor(), "Zadana boja nije ispravno postavljena na 'black'!");
    }
}
