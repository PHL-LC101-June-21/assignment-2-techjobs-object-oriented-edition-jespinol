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

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job6 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String toStringOut = job6.toString();
        assertEquals(toStringOut.charAt(0), '\n');
        assertEquals(toStringOut.charAt(toStringOut.length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job7 = new Job("a", new Employer("b"),
                new Location("c"), new PositionType("d"),
                new CoreCompetency("e"));
        String toStringOut = job7.toString();
        String desired = "\n" +"ID: " + job7.getId() + "\n" +
                "Name: a" + "\n" +
                "Employer: b" + "\n" +
                "Location: c" + "\n" +
                "Position Type: d" + "\n" +
                "Core Competency: e";
        assertEquals(toStringOut, desired);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job8 = new Job("a", new Employer("b"),
                new Location("c"), new PositionType(""),
                new CoreCompetency(""));
        String toStringOut = job8.toString();
        String desired = "\n" + "ID: " + job8.getId() + "\n" +
                "Name: a" + "\n" +
                "Employer: b" + "\n" +
                "Location: c" + "\n" +
                "Position Type: Data not available" + "\n" +
                "Core Competency: Data not available";
        assertEquals(toStringOut, desired);
    }

    @Test
    public void testJobOnlyContainsIDFieldPrintsSpecialMessage(){
        Job jobEmpty = new Job();
        Job jobComplete = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertEquals(jobEmpty.toString(), "OOPS! This job does not seem to exist.");
        assertTrue(jobComplete.toString() != "OOPS! This job does not seem to exist.");
    }

}
