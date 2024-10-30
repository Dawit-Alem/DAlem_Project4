//import com.dalem.management.Plot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlotTestStudent {
    private Plot plot;

    @BeforeEach
    public void setUp() {
        plot = new Plot(0, 0, 10, 10);
    }

    @Test
    public void testGetX() {
        assertEquals(0, plot.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(0, plot.getY());
    }

    @Test
    public void testGetWidth() {
        assertEquals(10, plot.getWidth());
    }

    @Test
    public void testGetDepth() {
        assertEquals(10, plot.getDepth());
    }

    @Test
    public void testEncompasses() {
        Plot innerPlot = new Plot(1, 1, 5, 5);
        assertTrue(plot.encompasses(innerPlot));

        Plot outerPlot = new Plot(-5, -5, 20, 20);
        assertFalse(plot.encompasses(outerPlot));
    }

    @Test
    public void testOverlaps() {
        Plot overlappingPlot = new Plot(5, 5, 10, 10);
        assertTrue(plot.overlaps(overlappingPlot));

        Plot nonOverlappingPlot = new Plot(11, 11, 2, 2);
        assertFalse(plot.overlaps(nonOverlappingPlot));
    }
}
