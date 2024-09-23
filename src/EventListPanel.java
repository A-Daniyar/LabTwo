import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EventListPanel extends JPanel {
    List<Event> events = new ArrayList<>();
    JPanel controlPanel = new JPanel();
    JPanel displayPanel = new JPanel();

    public EventListPanel() {
        setLayout(new BorderLayout());
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(displayPanel), BorderLayout.CENTER);

        JButton addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(e -> {
            new AddEventModal(this).setVisible(true);
        });
        add(addEventButton, BorderLayout.SOUTH);
    }

   // dateComboBox = new JComboBox(SORT_OPTIONS);

    public void addEvent(Event event) {
        events.add(event);
        displayPanel.add(new EventPanel(event));
        revalidate();
        repaint();
    }
}
