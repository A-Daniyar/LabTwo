import javax.swing.*;

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

    static void addDefaultEvents(EventPanel events){
        events.addEvent(new Deadline("Deadline test", new (System.currentTimeMillis()+86400000)));
        events.addEvent(new Meeting("Meeting test", new LocalDateTime))
    }
}
