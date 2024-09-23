
import java.time.Duration;
import java.time.LocalDateTime;


public class Meeting extends Event implements Completable {
    private LocalDateTime endDateTime; //The time the meeting is over
    private String location; //Represents the location of the event.
    private boolean complete;

    public Meeting(String meetingTest, LocalDateTime localDateTime, LocalDateTime now, String locationTest) {
        super.setName(meetingTest);
        super.setDateTime(localDateTime);
        this.endDateTime = now;
        this.location = locationTest;
    }

    @Override
    public void complete() { //sets the complete boolean to true
        this.complete = true;
    }
    @Override
    public boolean isComplete() { //returns the complete boolean
        return complete;
    }
    public LocalDateTime getEndTime() { //returns the endDateTime
        return endDateTime;
    }
    public Duration getDuration() { //returns the duration of the meeting (dateTime - endDateTime)
            return Duration.between(this.getDateTime(), endDateTime);
    }

    public String getLocation() { //returns the location of the meeting
        return location;
    }
    public void setEndTime(LocalDateTime end) {
        this.endDateTime = end;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime end) {
        this.endDateTime = end;
    }
}
