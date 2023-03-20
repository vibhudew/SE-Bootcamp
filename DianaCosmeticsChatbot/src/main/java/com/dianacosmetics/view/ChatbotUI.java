package com.dianacosmetics.view;
import com.dianacosmetics.model.Chatbot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatbotUI {
    private JTextArea output;
    private JTextField input;
    private InputListener inputListener;

    public ChatbotUI(Chatbot chatbot) {
        // Create UI components
        output = new JTextArea(20, 60);
        output.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(output);
        input = new JTextField(60);

        // Add UI components to frame
        JFrame frame = new JFrame("Diana Cosmetics Store Chatbot");
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(input, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

        // Listen for input events
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = input.getText().trim();
                input.setText("");
                // Dispatch input event to listener
                if (inputText.length() > 0 && inputListener != null) {
                    inputListener.onInput(inputText);
                }
            }
        });
    }

    // Add input listener
    public void addInputListener(InputListener listener) {
        inputListener = listener;
    }

    // Show message in output area
    public void showMessage(String message) {
        output.append(message + "\n");
        output.setCaretPosition(output.getDocument().getLength());
    }

    // Input listener interface
    public interface InputListener {
        void onInput(String input);
    }

    public void displayResponse(String response) {
        // append the response to the output text area
        output.append(response + "\n");
    }


}


