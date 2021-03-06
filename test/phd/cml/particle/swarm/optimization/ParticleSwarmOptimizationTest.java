package phd.cml.particle.swarm.optimization;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

/**
 * Created by Clemencio Morales Lucas.
 */

public class ParticleSwarmOptimizationTest {

    private static final String SOLUTION_FOUND_MESSAGE = "Solution found at Iteration #";
    private static final String BEST_X_COORDINATE_MESSAGE = "====> Best X:";
    private static final String BEST_Y_COORDINATE_MESSAGE = "====> Best Y:";
    private static final double[] MINIMUM_POSITION_TEST_ARRAY = {5, 1, 3, 5, 9, 7, 8};

    private ParticleSwarmOptimization particleSwarmOptimization;
    private final ByteArrayOutputStream outputStreamContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errorStreamContent = new ByteArrayOutputStream();

    @BeforeMethod
    public void setUp() throws Exception {
        this.particleSwarmOptimization = new ParticleSwarmOptimization();
        System.setOut(new PrintStream(outputStreamContent));
        System.setErr(new PrintStream(errorStreamContent));
    }

    @Test
    public void testExecuteObtainsTheExpectedValuesSolvingFormula() throws Exception {
        this.particleSwarmOptimization.execute(true);
        final String consoleResult = outputStreamContent.toString();
        assertTrue(consoleResult.contains(SOLUTION_FOUND_MESSAGE));
        assertTrue(consoleResult.contains(BEST_X_COORDINATE_MESSAGE));
        assertTrue(consoleResult.contains(BEST_Y_COORDINATE_MESSAGE));
    }

    @Test
    public void testInitializeSwarmAndUpdateFitnessList() throws Exception {
        try {
            this.particleSwarmOptimization.initializeSwarm();
            this.particleSwarmOptimization.updateFitnessList();
        } catch (final Exception e) {
            fail();
        }
    }

    @Test
    public void testGetMinimumPosition() throws Exception {
        assertEquals(ParticleSwarmOptimization.getMinimumPosition(MINIMUM_POSITION_TEST_ARRAY), 1);
    }
}
