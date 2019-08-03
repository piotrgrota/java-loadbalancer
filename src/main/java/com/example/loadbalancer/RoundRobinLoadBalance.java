package com.example.loadbalancer;

import java.util.List;

class RoundRobinLoadBalance implements LoadBalance {

    private int selected = 0;
    private List<Server> servers;

    RoundRobinLoadBalance(List<Server> servers) {
        this.servers = servers;
    }

    @Override
    public Server getServer() {
        Server server = servers.get(selected);
        selected = (selected + 1) % servers.size();
        return server;
    }
}
