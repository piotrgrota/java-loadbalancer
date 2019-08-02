package com.example.loadbalancer;

public class DummyHttpRequest implements Request {

    private static final String METHOD = "GET";
    private static final String HOSTNAME = "example.com";
    private final int id;

    public DummyHttpRequest(int id) {
        this.id = id;
    }

    @Override
    public int getId() { return id; }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public String getRequestURI() {
        return HOSTNAME;
    }
}
