package com.dianacosmetics;

import com.dianacosmetics.controller.ChatbotController;
import com.dianacosmetics.model.Product;
import com.dianacosmetics.model.ProductCatalog;
import com.dianacosmetics.model.Chatbot;
import com.dianacosmetics.view.ChatbotUI;

public class Main {
    public static void main(String[] args) {
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.addProduct(new Product("Lipstick", 10.0, "Long-lasting lipstick"));
        productCatalog.addProduct(new Product("Mascara", 15.0, "Volumizing mascara"));
        Chatbot chatbot = new Chatbot(productCatalog);
        ChatbotUI chatbotUI = new ChatbotUI(chatbot);
        ChatbotController chatbotController = new ChatbotController(chatbotUI, chatbot);
        chatbotController.init();
    }
}
