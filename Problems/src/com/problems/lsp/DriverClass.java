package com.problems.lsp;

public class DriverClass {
    public static void main(String[] args) {
        PlayGame smartPhone = new SmartPhone();  // Instantiating SmartPhone with one of its Parent interface
        smartPhone.playGame();
    }
}
