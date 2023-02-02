package com.example.passgenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasswordGenerator {
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*_=+-/";

    private static final int PASSWORD_LENGTH = 12;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Generator");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Password: ");
        JTextField passwordField = new JTextField(PASSWORD_LENGTH);
        JButton generateButton = new JButton("Generate");

        passwordField.setEditable(false);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.setText(generatePassword());
            }
        });

        panel.add(label);
        panel.add(passwordField);
        panel.add(generateButton);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static String generatePassword() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int charSet = random.nextInt(4);
            if (charSet == 0) {
                password.append(LOWERCASE_CHARS.charAt(random.nextInt(26)));
            } else if (charSet == 1) {
                password.append(UPPERCASE_CHARS.charAt(random.nextInt(26)));
            } else if (charSet == 2) {
                password.append(NUMERIC_CHARS.charAt(random.nextInt(10)));
            } else {
                password.append(SPECIAL_CHARS.charAt(random.nextInt(13)));
            }
        }

        return password.toString();
    }
}
