package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import javax.lang.model.element.Name;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality Control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(false);
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals("\n", job6.toString().substring(job6.toString().length()-1));
        String myString = String.valueOf(job6.toString().charAt(0));
        assertEquals("\n", myString);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: 1\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality Control\n" +
                "Core Competency: Persistence\n", job7.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job8 = new Job("Product tester", new Employer(""), new Location(""), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: " +job8.getId()+"\nName: Product tester\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Quality Control\nCore Competency: Persistence\n" , job8.toString());
    }

}
