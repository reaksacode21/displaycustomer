package customerdisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Customer {
    int id;
    String lastName;
    String firstName;
    String phone;

    public Customer(int id, String lastName, String firstName, String phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
    }
}

public class CustomerDisplay extends JFrame implements ActionListener {
    private JLabel idLabel, lastNameLabel, firstNameLabel, phoneLabel;
    private JTextField idField, lastNameField, firstNameField, phoneField;
    private JButton prevButton, nextButton;
    private List<Customer> customers;
    private int currentIndex;

    public CustomerDisplay() {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "Ra ", "raksa", "0855900"));
        customers.add(new Customer(2, "mmik", "M", "0128909887"));
        customers.add(new Customer(3, "sjj", "rasy", "098765432"));

        currentIndex = 0;

        // Set up the frame
        JFrame frame = new JFrame("Customer");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));

        // Create labels and text fields
        idLabel = new JLabel("ID:");
        lastNameLabel = new JLabel("Last Name:");
        firstNameLabel = new JLabel("First Name:");
        phoneLabel = new JLabel("Phone:");

        idField = new JTextField();
        lastNameField = new JTextField();
        firstNameField = new JTextField();
        phoneField = new JTextField();

        idField.setEditable(false);
        lastNameField.setEditable(false);
        firstNameField.setEditable(false);
        phoneField.setEditable(false);

        // Create buttons
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");

        prevButton.addActionListener(this);
        nextButton.addActionListener(this);

        // Add components to frame
        frame.add(idLabel);
        frame.add(idField);
        frame.add(lastNameLabel);
        frame.add(lastNameField);
        frame.add(firstNameLabel);
        frame.add(firstNameField);
        frame.add(phoneLabel);
        frame.add(phoneField);
        frame.add(prevButton);
        frame.add(nextButton);

        // Display the first customer
        displayCustomer(currentIndex);

        // Set frame visibility
        frame.setVisible(true);
    }

    private void displayCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            Customer customer = customers.get(index);
            idField.setText(String.valueOf(customer.id));
            lastNameField.setText(customer.lastName);
            firstNameField.setText(customer.firstName);
            phoneField.setText(customer.phone);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevButton) {
            if (currentIndex > 0) {
                currentIndex--;
                displayCustomer(currentIndex);
            }
        } else if (e.getSource() == nextButton) {
            if (currentIndex < customers.size() - 1) {
                currentIndex++;
                displayCustomer(currentIndex);
            }
        }
    }

    public static void main(String[] args) {
        new CustomerDisplay();
    }
}
