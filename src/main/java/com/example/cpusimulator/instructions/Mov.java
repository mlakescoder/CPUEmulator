package com.example.cpusimulator.instructions;

import com.example.cpusimulator.Register;

public class Mov extends Instruction {
    private int fromRegister;
    private int toRegister;

    Mov(Register from, Register to) {
        fromRegister = from.getNumber();
        toRegister = to.getNumber();
    }

    @Override
    public Integer[] execute(int programCounter, Integer[] registers) {
        registers[toRegister] = registers[fromRegister];
        this.programCounter = ++programCounter;
        return registers;
    }
}