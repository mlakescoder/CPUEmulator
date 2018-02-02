package com.example.cpusimulator.instructions;

import com.example.cpusimulator.Register;

public class Movc extends Instruction {
    int value;
    int toRegister;

    Movc(Integer value, Register to) {
        this.value = value;
        toRegister = to.getNumber();
    }

    @Override
    public Integer[] execute(int programCounter, Integer[] registers) {
        registers[toRegister] = value;
        this.programCounter = ++programCounter;
        return registers;
    }
}