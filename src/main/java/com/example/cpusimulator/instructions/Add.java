package com.example.cpusimulator.instructions;

import com.example.cpusimulator.Register;

public class Add extends Instruction {
    int resultRegister;
    int extensionRegister;

    Add(Register result, Register extension) {
        resultRegister = result.getNumber();
        extensionRegister = extension.getNumber();
    }

    @Override
    public Integer[] execute(int programCounter, Integer[] registers) {
        if ( registers[resultRegister] == null ) {
            registers[resultRegister] = 0;
        }

        registers[resultRegister] += registers[extensionRegister];
        this.programCounter = ++programCounter;
        return registers;
    }
}
