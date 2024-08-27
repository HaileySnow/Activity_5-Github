import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.awt.event.KeyAdapter;

 

public class MenuCal {

    private static JFrame firstFrame;

 

    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (Exception e) {

            e.printStackTrace();

        }

 

        firstFrame = new JFrame("Simple Calculator");

        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the initial frame to full screen

        firstFrame.getContentPane().setBackground(new Color(255, 182, 193)); // Set background color to baby pink

 

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        Font menuFont = new Font("SansSerif", Font.BOLD, 50); // Adjusted font size for menu items

        menu.setFont(menuFont);

 

        JMenuItem additionItem = createMenuItem("Addition of Numbers", "Add", "Sum");

        JMenuItem subtractionItem = createMenuItem("Subtraction of Numbers", "Subtract", "Difference");

        JMenuItem multiplicationItem = createMenuItem("Multiplication of Numbers", "Multiply", "Product");

        JMenuItem divisionItem = createMenuItem("Division of Numbers", "Divide", "Quotient");

        JMenuItem exitItem = new JMenuItem("Exit");

 

        menu.add(additionItem);

        menu.add(subtractionItem);

        menu.add(multiplicationItem);

        menu.add(divisionItem);

        menu.addSeparator();

        menu.add(exitItem);

        menuBar.add(menu);

        firstFrame.setJMenuBar(menuBar);

 

        additionItem.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openCalculator("Addition of Numbers", "Add", "Sum");

            }

        });

 

        subtractionItem.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openCalculator("Subtraction of Numbers", "Subtract", "Difference");

            }

        });

 

        multiplicationItem.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openCalculator("Multiplication of Numbers", "Multiply", "Product");

            }

        });

 

        divisionItem.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                openCalculator("Division of Numbers", "Divide", "Quotient");

            }

        });

 

        exitItem.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }

        });

 

        firstFrame.setVisible(true);

    }

 

    private static JMenuItem createMenuItem(String title, String operation, String label) {

        JMenuItem menuItem = new JMenuItem(title);

        menuItem.setFont(new Font("SansSerif", Font.BOLD, 50)); // Adjusted font size for menu items

        menuItem.setPreferredSize(new Dimension(800, 100)); // Adjusted size for menu items

        menuItem.setBackground(new Color(255, 182, 193));

        menuItem.setActionCommand(operation + ":" + label);

        return menuItem;

    }

 

    private static void openCalculator(String title, String operation, String label) {

        JFrame calculatorFrame = new JFrame(title);

        calculatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        calculatorFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the calculator frame to full screen

        centerFrame(calculatorFrame);

 

        JPanel calculatorPanel = new JPanel();

        calculatorPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("<<" + title + ">>");

        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 70)); // Larger font for title

        JLabel label1 = createLabel("Enter 1st Number:");

        JTextField num1 = createTextField(10);

        JLabel label2 = createLabel("Enter 2nd Number:");

        JTextField num2 = createTextField(10);

        JButton calculateButton = createLargeButton(operation); // Create a large button

        JLabel resultLabel = createLabel(label + ":");

        JTextField resultField = createTextField(10);

        resultField.setEditable(false);

 

        // Adjusted spacing and alignment

        gbc.insets = new Insets(20, 20, 20, 20);

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2;

        gbc.anchor = GridBagConstraints.CENTER;

        calculatorPanel.add(titleLabel, gbc);

 

        gbc.gridx = 0;

        gbc.gridy = 1;

        gbc.gridwidth = 1;

        gbc.anchor = GridBagConstraints.EAST;

        calculatorPanel.add(label1, gbc);

        gbc.gridx = 1;

        gbc.anchor = GridBagConstraints.WEST;

        calculatorPanel.add(num1, gbc);

 

        gbc.gridx = 0;

        gbc.gridy = 2;

        gbc.anchor = GridBagConstraints.EAST;

        calculatorPanel.add(label2, gbc);

        gbc.gridx = 1;

        gbc.anchor = GridBagConstraints.WEST;

        calculatorPanel.add(num2, gbc);

 

        gbc.gridx = 0;

        gbc.gridy = 3;

        gbc.gridwidth = 2;

        gbc.anchor = GridBagConstraints.CENTER;

        calculatorPanel.add(calculateButton, gbc);

 

        gbc.gridx = 0;

        gbc.gridy = 4;

        gbc.gridwidth = 1;

        gbc.anchor = GridBagConstraints.EAST;

        calculatorPanel.add(resultLabel, gbc);

        gbc.gridx = 1;

        gbc.anchor = GridBagConstraints.WEST;

        calculatorPanel.add(resultField, gbc);

 

        // Move the button a bit to the right

        gbc.gridx = 2;

        gbc.gridy = 3;

        gbc.gridwidth = 1;

        gbc.anchor = GridBagConstraints.WEST; // Adjusted alignment

        calculatorPanel.add(Box.createRigidArea(new Dimension(100, 0))); // Empty space to push the button right

 

        calculateButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                String[] parts = e.getActionCommand().split(":");

                String operation = parts[0];

                try {

                    double value1 = Double.parseDouble(num1.getText());

                    double value2 = Double.parseDouble(num2.getText());

                    double result = 0;

 

                    if (operation.equals("Add")) {

                        result = value1 + value2;

                    } else if (operation.equals("Subtract")) {

                        result = value1 - value2;

                    } else if (operation.equals("Multiply")) {

                        result = value1 * value2;

                    } else if (operation.equals("Divide")) {

                        if (value2 != 0) {

                            result = value1 / value2;

                        }
