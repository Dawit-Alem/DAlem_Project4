
//import com.dalem.management.ManagementCompany;
//import com.dalem.management.Property;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManagementCompanyTestStudent {
    private ManagementCompany managementCompany;

    @BeforeEach
    public void setUp() {
        managementCompany = new ManagementCompany("Test Management", "12345", 10.0);
    }

    @Test
    public void testAddProperty() {
        Property property = new Property("Property 1", "City 1", 1200.0, "Owner 1");
        int result = managementCompany.addProperty(property);
        assertEquals(0, result);
        assertEquals(1, managementCompany.getPropertiesCount());
    }

    @Test
    public void testAddPropertyExceedingLimit() {
        for (int i = 0; i < 5; i++) {
            managementCompany.addProperty(new Property("Property " + i, "City " + i, 1000.0 + i * 100, "Owner " + i));
        }
        int result = managementCompany.addProperty(new Property("Property 6", "City 6", 1600.0, "Owner 6"));
        assertEquals(-1, result); // Expecting -1 because of the maximum property limit
    }

    @Test
    public void testGetTotalRent() {
        managementCompany.addProperty(new Property("Property 1", "City 1", 1200.0, "Owner 1"));
        managementCompany.addProperty(new Property("Property 2", "City 2", 1500.0, "Owner 2"));
        assertEquals(2700.0, managementCompany.getTotalRent());
    }

    @Test
    public void testGetHighestRentProperty() {
        managementCompany.addProperty(new Property("Property 1", "City 1", 1200.0, "Owner 1"));
        managementCompany.addProperty(new Property("Property 2", "City 2", 1500.0, "Owner 2"));
        Property highestRentProperty = managementCompany.getHighestRentProperty();
        assertEquals("Property 2", highestRentProperty.getPropertyName());
    }

    @Test
    public void testRemoveLastProperty() {
        managementCompany.addProperty(new Property("Property 1", "City 1", 1200.0, "Owner 1"));
        managementCompany.removeLastProperty();
        assertEquals(0, managementCompany.getPropertiesCount());
    }
}
