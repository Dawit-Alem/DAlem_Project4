//import com.dalem.management.Property;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PropertyTestStudent {
    private Property property;

    @BeforeEach
    public void setUp() {
        property = new Property("Test Property", "Test City", 1500.0, "Test Owner");
    }

    @Test
    public void testGetPropertyName() {
        assertEquals("Test Property", property.getPropertyName());
    }

    @Test
    public void testGetCity() {
        assertEquals("Test City", property.getCity());
    }

    @Test
    public void testGetRentAmount() {
        assertEquals(1500.0, property.getRentAmount());
    }

    @Test
    public void testGetOwner() {
        assertEquals("Test Owner", property.getOwner());
    }

    @Test
    public void testToString() {
        String expected = "Test Property,Test City,Test Owner,1500.00";
        assertEquals(expected, property.toString());
    }
}
