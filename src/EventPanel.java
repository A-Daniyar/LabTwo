import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EventPanel extends JPanel {
    Event event;
    JButton completeButton;

    public EventPanel(Event event) {
        this.event = event;
        this.setLayout(new GridLayout(2, 1));

        completeButton = new JButton("Complete");
        completeButton.setEnabled(event instanceof Completable);
        JLabel completeLable = (new JLabel("Complete: " + ((Completable)event).isComplete()));
        completeButton.addActionListener(e -> {
            ((Completable)event).complete();
            completeLable.setText("Complete: " + ((Completable)event).isComplete());
        });

        add(new JLabel("Name: " + event.getName()));
        add(new JLabel("Date: " + event.getDateTime()));
        add(completeLable);

        if (event instanceof Meeting) {
            Meeting meeting = (Meeting) event;
            add(new JLabel("Duration: " + meeting.getDuration() + " minutes"));
            add(new JLabel("Location: " + meeting.getLocation()));

        }
        add(completeButton);
      //  updateUrgency();
    }

  /*  public void updateUrgency(){
        if (event instanceof Completable && ((Completable) event).isComplete()) {
            completeButton.setText("Complete");
            setBackground(Color.green);
        }
        else {
            setBackground(Color.red);
        }
    }*/
}
