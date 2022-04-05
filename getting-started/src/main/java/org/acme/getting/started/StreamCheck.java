package org.acme.getting.started;

import org.json.*;
import java.io.IOException;
import java.net.URI;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Callable;
import java.util.Queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;

public class StreamCheck implements Callable {
    public String url;

    public StreamCheck(String url) {
        this.url = url;
    }

    public Integer call() throws Exception {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET() // GET is default
                .build();

        JSONObject response = new JSONObject(
            client.send(request,HttpResponse.BodyHandlers.ofString()).body()
        );
        return response.getInt("quality");

    }
  }