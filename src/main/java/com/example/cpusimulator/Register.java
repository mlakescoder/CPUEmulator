package com.example.cpusimulator;

public class Register {
    private int number;

    public Register(String label) {
        String[] temp = label.split("R");
        if ( temp.length == 2) {
            number = Integer.parseInt(temp[1]);
        } else {
            throw new IllegalArgumentException("Not a register value");
        }
    }

    public int getNumber() { return number; }
}
