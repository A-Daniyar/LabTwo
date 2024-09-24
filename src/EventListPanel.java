import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EventListPanel extends JPanel {
    List<Event> events = new ArrayList<>(); //a list of the events to be listed.
    JPanel controlPanel = new JPanel(); //holds the controls for the event display.
    JPanel displayPanel = new JPanel(); // a panel to hold the EventPanels corresponding to the events.
    JComboBox<String> sortDropDown;

    public EventListPanel() { //

        //sets how Layout will be displayed.
        setLayout(new BorderLayout());
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(displayPanel), BorderLayout.CENTER);

        //creates a button for adding events.
        JButton addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(e -> {
            new AddEventModal(this).setVisible(true);
        });
        add(addEventButton, BorderLayout.SOUTH);

        //creates a JComboBox for sorting by name and date.
        sortDropDown = new JComboBox<>(new String[]{"Sort by Name", "Sort by Date"});
        sortDropDown.addActionListener(e -> EventSorting());
        controlPanel.add(sortDropDown);

        //adjusts the position of control and display panels.
        add(controlPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);

    }
    void EventSorting() { //logical part of sorting JComboBox
    String selected = (String) sortDropDown.getSelectedItem();
    if (selected.equals("Sort by Name")) {
        Collections.sort(events, Comparator.comparing(Event::getName));
    } else if (selected.equals("Sort by Date")) {
        Collections.sort(events, Comparator.comparing(Event::getDateTime));
    }
    newGUI(); //calls the Display-refresh panel
}

    void newGUI() {  //refreshing the calendar GUI by removing all and putting sorted events back
      displayPanel.removeAll();
      for (Event event : events) {
          displayPanel.add(new EventPanel(event));
      }
      revalidate();
      repaint();
}

    public void addEvent(Event event) { //calls the new event panel
        events.add(event);
        displayPanel.add(new EventPanel(event));
        revalidate();
        repaint();
    }
}
