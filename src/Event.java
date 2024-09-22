import java.util.Date;

public abstract class Event implements Comparable<Event>{
    String name; //name of the event
    Date dateTime; //the time and date the event starts
}

public abstract String getName(); //Abstract method that returns the name

public Date getDateTime(){ // Method that returns the dateTime
    return dateTime;
}

public void setDateTime(Date dateTime){ //Sets the DateTime
    this.dateTime = dateTime;
}

public void setName(String name){ //Sets the name of the Event
    this.name = name;
}

@Override
public int compareTo (Event e){
    return this.dateTime.compareTo(e.dateTime);
}