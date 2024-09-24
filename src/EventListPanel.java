import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EventListPanel extends JPanel {
    List<Event> events = new ArrayList<>();
    JPanel controlPanel = new JPanel();
    JPanel displayPanel = new JPanel();
    JComboBox<String> sortDropDown;

    public EventListPanel() {
        setLayout(new BorderLayout());
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(displayPanel), BorderLayout.CENTER);

        JButton addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(e -> {
            new AddEventModal(this).setVisible(true);
        });
        add(addEventButton, BorderLayout.SOUTH);

        sortDropDown = new JComboBox<>(new String[]{"Sort by Name", "Sort by Date"});
        sortDropDown.addActionListener(e -> EventSorting());
        controlPanel.add(sortDropDown);

        add(controlPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);

    }
    void EventSorting() {
    String selected = (String) sortDropDown.getSelectedItem();
    if (selected.equals("Sort by Name")) {
        Collections.sort(events, Comparator.comparing(Event::getName));
    } else if (selected.equals("Sort by Date")) {
        Collections.sort(events, Comparator.comparing(Event::getDateTime));
    }
    newGUI();
}

    void newGUI() {
      displayPanel.removeAll();
      for (Event event : events) {
          displayPanel.add(new EventPanel(event));
      }
      revalidate();
      repaint();
}

    public void addEvent(Event event) {
        events.add(event);
        displayPanel.add(new EventPanel(event));
        revalidate();
        repaint();
    }
}
