package com.company.design.singleton;

public class FirstCall {

    private SocketClient socketClient;

    public FirstCall() {
        // 새로 인스턴스를 생성하지 못하게 private로 객체 생성을 막아논 상태
        // this.socketClient = new SocketClient();
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
