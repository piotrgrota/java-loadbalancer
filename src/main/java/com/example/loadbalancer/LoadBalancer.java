package com.example.loadbalancer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class LoadBalancer {

    private final LoadBalance internalBalancer;
    private Map<LoadBalancerType, Function<List<Server>, LoadBalance>> loadBalancers
                = new HashMap<LoadBalancerType, Function<List<Server>, LoadBalance>>() {{
        put(LoadBalancerType.ROUND_ROBIN, RoundRobinLoadBalance::new);
        put(LoadBalancerType.SPECIAL, SpecialLoadBalance::new);
    }};

    public LoadBalancer(List<Server> servers, LoadBalancerType balancerTypeType) {
        if(servers == null || servers.isEmpty()){
            throw new IllegalArgumentException("Server list for Load Balancing should be not empty");
        }
        internalBalancer = loadBalancers.get(balancerTypeType).apply(servers);
    }

    public void handleRequest(Request request) {
        internalBalancer.getServer().handleRequest(request);
    }
}
