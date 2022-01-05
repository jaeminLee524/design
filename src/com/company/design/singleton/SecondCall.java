package com.company.design.singleton;

public class SecondCall {

    private SocketClient socketClient;

    public SecondCall() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
