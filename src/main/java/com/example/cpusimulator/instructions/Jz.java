package com.example.cpusimulator.instructions;

import com.example.cpusimulator.Register;

public class Jz extends Instruction {
    int checkRegister;
    int instructionNumber;

    Jz(int instructionNumber, Register checkRegister ) {
        this.checkRegister = checkRegister.getNumber();
        this.instructionNumber = instructionNumber;
    }

    @Override
    public Integer[] execute(int programCounter, Integer[] registers) {
        if (registers[checkRegister] == 0 ) {
            this.programCounter = instructionNumber - 1;
        } else {
            this.programCounter = ++programCounter;
        }

        return registers;
    }
}

