import javax.swing.*;
import java.awt.*;

public class EventPanel extends JPanel {
    Event event;
    JButton completeButton;

    public EventPanel(Event event) {
        this.event = event;
        this.setLayout(new GridLayout(2, 1));

        completeButton = new JButton("Complete");
        completeButton.setEnabled(event instanceof Completable);

        add(new JLabel("Name: " + event.getName()));
        add(new JLabel("Date: " + event.getDateTime()));
        if (event instanceof Meeting) {
            Meeting meeting = (Meeting) event;
            add(new Jlabel("Duration: " + meeting.getDuration() + " minutes"));
            add(new Jlabel("Location: " + meeting.getLocation()));

        }
        add(completeButton);
        updateUrgency();
    }

    public void updateUrgency(){
        if (event instanceof Completable && ((Completable) event).isComplete()) {
            completeButton.setText("Complete");
            setBackground(Color.green);
        }
        else {
            setBackground(Color.red);
        }
    }
}
