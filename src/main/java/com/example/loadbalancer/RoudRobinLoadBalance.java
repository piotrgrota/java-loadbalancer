package com.example.loadbalancer;

import java.util.List;

class RoudRobinLoadBalance implements LoadBalance {

    private int selected = 0;
    private List<Server> servers;

    public RoudRobinLoadBalance(List<Server> servers) {
        this.servers = servers;
    }

    @Override
    public Server getServer() {
        Server server = servers.get(selected);
        selected = (selected + 1) % servers.size();
        return server;
    }
}
