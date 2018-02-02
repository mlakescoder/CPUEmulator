package com.example.cpusimulator.instructions;

import com.example.cpusimulator.Register;

public class Inc extends Instruction {
    int registerNumber;

    Inc(Register registerNumber ) {
        this.registerNumber = registerNumber.getNumber();
    }

    @Override
    public Integer[] execute(int programCounter, Integer[] registers) {
        if ( registers[registerNumber] == null ) {
            registers[registerNumber] = 0;
        }

        registers[registerNumber] += 1;

        this.programCounter = ++programCounter;
        return registers;
    }
}
