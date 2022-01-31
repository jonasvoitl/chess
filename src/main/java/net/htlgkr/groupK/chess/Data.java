package net.htlgkr.groupK.chess;

import net.htlgkr.groupK.chess.sockets.Client;
import net.htlgkr.groupK.chess.sockets.Server;

public class Data {
    private Server server;
    private Client client;

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
