package com.company.design;

import com.company.design.singleton.FirstCall;
import com.company.design.singleton.SecondCall;
import com.company.design.singleton.SocketClient;

public class Main {

    public static void main(String[] args) {

        FirstCall firstCall = new FirstCall();
        SecondCall secondCall = new SecondCall();

        SocketClient firstClient = firstCall.getSocketClient();
        SocketClient secondClient = secondCall.getSocketClient();

        System.out.println("두개의 객체가 동일한지 비교");
        System.out.println(firstClient.equals(secondClient));

    }
}
