package com.company.design.singleton;

public class SocketClient {

    private static SocketClient socketClient;

    private SocketClient() {}

    // static으로 선언함으로 다른 곳에서도 접근할 수 있도록
    public static SocketClient getInstance() {
        // 초기에는 인스턴스 생성
        if( socketClient == null ) {
            socketClient = new SocketClient();
        }
        // 생성된 인스턴스를 재활용
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }
}
