package com.example.cpusimulator.instructions;

import com.example.cpusimulator.Register;

public class Inv extends Instruction {
    int registerNumber;

    Inv(Register registerNumber ) {
        this.registerNumber = registerNumber.getNumber();
    }

    @Override
    public Integer[] execute(int programCounter, Integer[] registers) {
        if ( registers[registerNumber] == null ) {
            registers[registerNumber] = 0;
        }

        registers[registerNumber] = ~registers[registerNumber];

        this.programCounter = ++programCounter;
        return registers;
    }
}

