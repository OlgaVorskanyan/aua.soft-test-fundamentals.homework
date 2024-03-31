package aua.stf;


import java.util.ArrayList;
import java.util.List;
public class EventManager {

    private List<String> events;

    public EventManager() {
        this.events = new ArrayList<>();
    }

    public void addEvent(String event) {
        if (event != null && !event.isEmpty()) {
            events.add(event);
        } else {
            throw new IllegalArgumentException("Event name cannot be null or empty");
        }
    }

    public void removeEvent(String event) {
            if (events.contains(event)) {
                events.remove(event);
            } else {
                throw new IllegalArgumentException("Event does not exist");
            }
    }

    public String viewEvents() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Events:\n");
        if (!events.isEmpty()) {
            for (String event : events) {
                stringBuilder.append(event).append("\n");
            }
        } else {
            stringBuilder.append("No events available\n");
        }
        return stringBuilder.toString();
    }

    public boolean checkEventExistence(String event) { //already has a condition
            return events.contains(event);
    }
}
