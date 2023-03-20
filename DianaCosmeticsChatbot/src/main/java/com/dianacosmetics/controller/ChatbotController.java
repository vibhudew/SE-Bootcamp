package com.dianacosmetics.controller;

import com.dianacosmetics.model.ProductCatalog;
import com.dianacosmetics.model.Chatbot;
import com.dianacosmetics.view.ChatbotUI;

import javax.swing.event.EventListenerList;
import java.util.EventObject;

public class ChatbotController {
    private ChatbotUI ui;
    private ProductCatalog catalog;
    private Chatbot chatbot;

    private EventListenerList listenerList = new EventListenerList();

    public ChatbotController() {
        // Create UI, product catalog, and chatbot objects
        ui = new ChatbotUI(chatbot);
        catalog = new ProductCatalog();
        chatbot = new Chatbot(catalog);

        // Register input and API response listeners
        ui.addInputListener(new ChatbotUI.InputListener() {
            @Override
            public void onInput(String input) {
                // Dispatch user input event
                UserInputEvent event = new UserInputEvent(input);
                fireEvent(event);
            }
        });

        chatbot.addResponseListener(new Chatbot.ResponseListener() {
            @Override
            public void onResponse(String response) {
                // Display API response in UI
                ui.showMessage(response);
            }
        });
    }

    public ChatbotController(ChatbotUI chatbotUI, Chatbot chatbot) {
    }

    // Add event listener
    public void addEventListener(EventListener listener) {
        listenerList.add(EventListener.class, listener);
    }

    // Fire event
    protected void fireEvent(EventObject event) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == EventListener.class) {
                ((EventListener) listeners[i + 1]).handleEvent(event);
            }
        }
    }

    // User input event class
    public static class UserInputEvent extends EventObject {
        private String input;

        public UserInputEvent(String input) {
            super(input);
            this.input = input;
        }

        public String getInput() {
            return input;
        }
    }

    // Event listener interface
    public interface EventListener extends java.util.EventListener {
        void handleEvent(EventObject event);
    }

    public void init() {
        // set up input listener
        ui.addInputListener(input -> {
            // send input to chatbot
            String response = chatbot.getResponse(input);
            // update UI with response
            ui.displayResponse(response);
            // notify response listeners
            chatbot.notifyResponseListeners(response);
        });

        // initialize chatbot
        ProductCatalog productCatalog = new ProductCatalog();
        chatbot = new Chatbot(productCatalog);
        chatbot.addResponseListener(response -> {
            // update UI with response
            ui.displayResponse(response);
        });
    }



}
