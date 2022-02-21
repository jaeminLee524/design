package com.company.design;

import com.company.design.aop.AopBrowser;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;
import com.company.design.singleton.FirstCall;
import com.company.design.singleton.SecondCall;
import com.company.design.singleton.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {

        // singleton
        /*FirstCall firstCall = new FirstCall();
        SecondCall secondCall = new SecondCall();

        SocketClient firstClient = firstCall.getSocketClient();
        SocketClient secondClient = secondCall.getSocketClient();

        System.out.println("두개의 객체가 동일한지 비교");
        System.out.println(firstClient.equals(secondClient));*/

        // proxy
        Browser naver = new Browser("www.naver.com");
        naver.show();
        naver.show();
        naver.show();
        naver.show();

        IBrowser browserProxy = new BrowserProxy("www.daum.net");
        browserProxy.show();
        browserProxy.show();
        browserProxy.show();
        browserProxy.show();

        //시간체크 - 동시성 ㅐ결
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();


        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());

                }
                );

        aopBrowser.show();
        System.out.println("loading time : " + end.get());

        aopBrowser.show();
        System.out.println("loading time : " + end.get());
    }


}
