package com.app.android_mysql;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendDataTask extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... strings) {
        try {
            // API endpoint URL
            URL url = new URL("PASTE_YOUR_API_ENDPOINT_HERE");

            // Create HttpURLConnection object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Enable input/output streams
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // Set request headers
            connection.setRequestProperty("Content-Type", "application/json");

            // Create JSON data to send
            String jsonInputString = strings[0];

            // Write JSON data to the request body
            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.writeBytes(jsonInputString);
                outputStream.flush();
            }

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Handle response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response if needed
            } else {
                // Handle error response
            }

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
