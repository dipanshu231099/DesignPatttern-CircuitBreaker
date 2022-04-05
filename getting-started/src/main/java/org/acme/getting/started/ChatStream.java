package org.acme.getting.started;

import org.json.*;
import java.io.IOException;
import java.net.URI;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Callable;

public class ChatStream implements Callable {
    public String call() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String redirect = "http://localhost:8000/getChatMsg/";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(redirect))
                .GET() // GET is default
                .build();

        JSONObject response = new JSONObject(
          client.send(request,HttpResponse.BodyHandlers.ofString()).body()
        );
        System.out.println(response.getInt("quality"));
        return "Execution terminated";
    }
  }