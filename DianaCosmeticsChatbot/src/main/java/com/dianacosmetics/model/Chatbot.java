package com.dianacosmetics.model;

import com.dianacosmetics.model.ProductCatalog;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class Chatbot {
    private static final String API_KEY = "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";
    private static final String API_URL = "https://api.openai.com/v1/engine/davinci-codex/completions";

    private ProductCatalog productCatalog;

    private List<ResponseListener> responseListeners;

    public Chatbot(ProductCatalog productCatalog) {

        this.productCatalog = this.productCatalog;
    }

    public String getResponse(String input) {
        String prompt = "Q: " + input + "\nA:";

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(API_URL);
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.addHeader("Authorization", "Bearer " + API_KEY);

            JSONObject json = new JSONObject();
            json.put("prompt", prompt);
            json.put("max_tokens", 100);
            json.put("n", 1);
            json.put("stop", ".");
            json.put("temperature", 0.7);

            StringEntity entity = new StringEntity(json.toString());
            httpPost.setEntity(entity);

            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();

            if (responseEntity != null) {
                String responseBody = EntityUtils.toString(responseEntity);
                JSONObject jsonResponse = new JSONObject(responseBody);
                String chatbotResponse = jsonResponse.getJSONArray("choices").getJSONObject(0).getString("text");
                return chatbotResponse.trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Sorry, I couldn't understand your question.";
    }

    public interface ResponseListener {
        void onResponse(String response);
    }

    public void addResponseListener(ResponseListener listener) {
        responseListeners.add(listener);
    }

    public void notifyResponseListeners(String response) {
        for (ResponseListener listener : responseListeners) {
            listener.onResponse(response);
        }
    }

}

