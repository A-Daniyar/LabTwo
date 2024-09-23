import javax.swing.*;
import java.time.LocalDateTime;

public class EventPlanner {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        EventListPanel eventListPanel = new EventListPanel();
        frame.add(eventListPanel);
        addDefaultEvents(eventListPanel);
        frame.setVisible(true);
    }

    static void addDefaultEvents(EventListPanel events){
        events.addEvent(new Deadline("Deadline test", LocalDateTime.now()));
        events.addEvent(new Meeting("Meeting test", LocalDateTime.now().minusHours(2),LocalDateTime.now(),"Location Test"));
    }
}
