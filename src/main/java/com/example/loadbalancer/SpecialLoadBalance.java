package com.example.loadbalancer;

import java.util.List;
import java.util.Optional;

class SpecialLoadBalance implements LoadBalance {

    private static final float THRESHOLD = 0.75f;
    private List<Server> servers;

    SpecialLoadBalance(List<Server> servers) {
        this.servers = servers;
    }

    @Override
    public Server getServer() {
        servers.sort((Server s1, Server s2) -> Float.compare(s1.getLoad(), s2.getLoad()));
        Optional<Server> serverUnderLoad= servers.stream().filter(x -> x.getLoad() < THRESHOLD).findFirst();
        if(serverUnderLoad.isPresent()){
            return serverUnderLoad.get();
        }
        return servers.stream().findFirst().get();
    }
}
