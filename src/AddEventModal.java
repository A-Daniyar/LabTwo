import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDateTime;

public class AddEventModal extends JDialog {
    EventListPanel eventListPanel;

    public AddEventModal(EventListPanel eventListPanel) {
        this.eventListPanel = eventListPanel;
        setTitle("Add Event");
        setSize(400,200);
        setLayout(new GridLayout(1,2));

        JTextField nameField = new JTextField();
        JTextField dateField = new JTextField();

        add(new JLabel("Modal Name:"));
        add(nameField);
        add(new JLabel("Event Date:"));
        add(dateField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            LocalDateTime eventDate = new LocalDateTime();
            Deadline deadline = new Deadline();
            eventListPanel.addEvent(deadline);
            dispose();
        });
        add(addButton);

    }

}
