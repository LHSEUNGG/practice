package com.example.Callback;

import org.springframework.boot.autoconfigure.SpringBootApplication;

public class CallBack {

    public static void Caller() {
        Callee callee = new Callee();
        callee.setCallback(new Callee.CallBack() {

            @Override
            public void onGetMessage(Callee callee) {
                System.out.println("입력받은 메세지 : " + callee.getMsg());
            }
        });

        for (int i=0; i<5; i++) {
            callee.onInputMessage();
        }
    }
}
