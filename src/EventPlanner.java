import javax.swing.*;
import java.time.LocalDateTime;

public class EventPlanner {

    public static void main(String[] args) {
        //main method of GUI that creates a JFrame and adds an EventListPanel
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        EventListPanel eventListPanel = new EventListPanel();
        frame.add(eventListPanel);
        addDefaultEvents(eventListPanel);
        frame.setVisible(true);
    }

    static void addDefaultEvents(EventListPanel events){
        //adds some default events to the EventPanel
        events.addEvent(new Deadline("Deadline test",
                LocalDateTime.now()));
        events.addEvent(new Meeting("Meeting test",
                LocalDateTime.now().minusHours(2),LocalDateTime.now(),"Location Test"));
    }
}
