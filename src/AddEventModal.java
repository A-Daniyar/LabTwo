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
        setLayout(new GridLayout(0,1));

        JTextField nameField = new JTextField();
        JTextField yearField = new JTextField();
        JTextField monthField = new JTextField();
        JTextField dayField = new JTextField();

        add(new JLabel("Modal Name:"));
        add(nameField);
        add(new JLabel("Year:"));
        add(yearField);
        add(new JLabel("Month:"));
        add(monthField);
        add(new JLabel("Day:"));
        add(dayField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            int year = Integer.parseInt(yearField.getText());
            int month = Integer.parseInt(monthField.getText());
            int day = Integer.parseInt(dayField.getText());
            LocalDateTime eventDate = LocalDateTime.of(year,month,day,0,0);
            Deadline deadline = new Deadline(name, eventDate);
            eventListPanel.addEvent(deadline);
            dispose();
        });
        add(addButton);

    }

}
