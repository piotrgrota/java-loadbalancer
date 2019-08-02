package com.example.loadbalancer;

public interface Server {
    float getLoad();
    void handleRequest(Request request);
}
