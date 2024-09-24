import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EventPanel extends JPanel {
    Event event;
    JButton completeButton;

    public EventPanel(Event event) {
        this.event = event;
        this.setLayout(new GridLayout(2, 2));

        //creates a logic for "Complete" Button.
        completeButton = new JButton("Complete");
        completeButton.setEnabled(event instanceof Completable);
        JLabel completeLabel = (new JLabel("Complete: " + ((Completable)event).isComplete()));
        completeButton.addActionListener(e -> {
            ((Completable)event).complete();
            completeLabel.setText("Complete: " + ((Completable)event).isComplete());
        });

        //creates a labels for names and dates of events
        add(new JLabel("Name: " + event.getName()));
        add(new JLabel("Date: " + event.getDateTime()));
        add(completeLabel);

        //sets the information about duration and location of the event
        if (event instanceof Meeting) {
            Meeting meeting = (Meeting) event;
            add(new JLabel("Duration: " + meeting.getDuration() + " minutes"));
            add(new JLabel("Location: " + meeting.getLocation()));

        }
        add(completeButton); //puts complete button in the calendar
    }
}
