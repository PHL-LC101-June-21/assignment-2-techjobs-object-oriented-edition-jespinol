package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void emptyTest() {
        assertEquals(10,10,0.001);
    }

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertTrue(job1.getId() != job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(job3 instanceof Job);
        assertEquals(job3.getName(), "Product tester");
        assertTrue(job3.getEmployer() instanceof Employer);
        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertTrue(job3.getLocation() instanceof Location);
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertEquals(job3.getPositionType().getValue(), "Quality control");
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertFalse(job4.equals(job5));
    }

}
