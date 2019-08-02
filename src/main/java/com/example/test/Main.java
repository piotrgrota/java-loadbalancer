package com.example.test;

import com.example.loadbalancer.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Server> servers = Arrays.asList(new Server[]{
                new DummyServer("example1",443),
                new DummyServer("example2",443),
                new DummyServer("example3",443),
                new DummyServer("example4",443)
        });
        LoadBalancer loadBalancer = new LoadBalancer(servers, LoadBalancerType.SPECIAL);
        IntStream.range(1,100).forEach( x-> loadBalancer.handleRequest(new DummyHttpRequest(x)));
    }
}
