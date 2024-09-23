import java.time.LocalDateTime;

public abstract class Event implements Comparable<Event> {
    String name; //name of the event
    LocalDateTime dateTime; //the time and date the event starts

    public String getName(){
        return name;
    } //Abstract method that returns the name

    public LocalDateTime getDateTime() { // Method that returns the dateTime
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) { //Sets the DateTime
        this.dateTime = dateTime;
    }

    public void setName(String name) { //Sets the name of the Event
        this.name = name;
    }

    @Override
    public int compareTo(Event e) { // compares the date of this Event to the incoming event and returns
        // a positive int if this event comes later,
        // a negative int if this event comes before, and 0 if the two have the same dateTime.
        return this.dateTime.compareTo(e.getDateTime());
    }
}