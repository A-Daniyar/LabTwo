import java.util.ArrayList; //necessary class???
import java.util.List;

class EventCalendar {
    private final List<Event> events;

    public EventCalendar() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        this.events.add(event);
        this.events.sort(Event::compareTo);//sort by date
    }

    public void removeEvent(Event event) {
        this.events.remove(event);
    }

    public List<Event> getEvents() {
        return events;
    }
}
