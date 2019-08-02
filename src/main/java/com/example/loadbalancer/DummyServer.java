package com.example.loadbalancer;

import java.util.Random;

public class DummyServer implements Server {

    private final Random random;
    private final String host;
    private final int port;

    public DummyServer(String host, int port) {
        this.host = host;
        this.port = port;
        this.random = new Random();
    }

    @Override
    public float getLoad() {
        return this.random.nextFloat();
    }

    @Override
    public void handleRequest(Request request) {
        System.out.println("Handling Request: " + request.getId());
    }
}
