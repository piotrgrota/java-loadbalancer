package com.example.loadbalancer;

interface Request {
    int getId();
    String getMethod();
    String getRequestURI();
}
