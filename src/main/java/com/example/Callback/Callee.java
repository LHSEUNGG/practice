package com.example.Callback;

import java.util.Scanner;

public class Callee {
    private String msg;
    private CallBack callback;

    @FunctionalInterface
    public interface CallBack{
        public void onGetMessage(Callee callee);
    }

    public Callee() {
        this.msg = "";
        this.callback = null;
    }

    public String getMsg() {
        return msg;
    }

    public void setCallback(CallBack callback) {
        this.callback = callback;
    }

    public void onInputMessage() {
        Scanner sc = new Scanner(System.in);
        this.msg = ""; //초기화
        System.out.println("메세지입력 : ");
        this.msg = sc.nextLine();

        if(this.callback != null) { //callback 처리
            this.callback.onGetMessage(Callee.this);
        }

    }

}
