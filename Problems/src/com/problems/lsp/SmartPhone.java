package com.problems.lsp;

public class SmartPhone implements MobilePhone,PlayGame{
    @Override
    public void call() {
        System.out.println("Calling in a smart phone");
    }

    @Override
    public void listen() {
        System.out.println("Listening music in smart phone");
    }

    @Override
    public void playGame() {
        System.out.println("Playing game in smart phone");
    }
}
