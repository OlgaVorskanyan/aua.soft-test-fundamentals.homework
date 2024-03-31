package aua.stf;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventManagerTest {

    private EventManager eventManager;

    @Before
    public void setUp() {
        eventManager = new EventManager();
    }

    @Test
    public void testAddEvent() {
        eventManager.addEvent("Capstone Meeting");
        assertTrue(eventManager.checkEventExistence("Capstone Meeting"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEventEmpty() {
        eventManager.addEvent("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEventNull() {
        eventManager.addEvent(null);
    }

    @Test
    public void testRemoveEvent() {
        eventManager.addEvent("Retro");
        eventManager.removeEvent("Retro");
        assertFalse(eventManager.checkEventExistence("Retro"));
    }
@Test(expected = IllegalArgumentException.class)
    public void testRemoveEventNonExisting() {
        eventManager.addEvent("Retro");
        eventManager.removeEvent("Stand up");
    }

    @Test
    public void testViewEvents() {
        eventManager.addEvent("Stand up");
        eventManager.addEvent("1-1 Meeting");

        String expected = "Events:\nStand up\n1-1 Meeting\n";
        assertEquals(expected, eventManager.viewEvents());
    }

    @Test
    public void testViewEventsEmpty() {
        String expected = "Events:\nNo events available\n";
        assertEquals(expected, eventManager.viewEvents());
    }
    @Test
    public void testCheckEventExistence() {
        eventManager.addEvent("Sync up");
        assertTrue(eventManager.checkEventExistence("Sync up"));
        assertFalse(eventManager.checkEventExistence("NonExistentEvent"));
    }


    @Test
    public void testAddMultipleEvents() {
        eventManager.addEvent("Dentist Appointment");
        eventManager.addEvent("Vet");
        eventManager.addEvent("Dogs meet up");

        assertTrue(eventManager.checkEventExistence("Dentist Appointment"));
        assertTrue(eventManager.checkEventExistence("Vet"));
        assertTrue(eventManager.checkEventExistence("Dogs meet up"));
    }




}
