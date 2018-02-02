package com.example.cpusimulator.instructions;

import com.example.cpusimulator.Register;

public class Dec extends Instruction {
    int registerNumber;

    Dec(Register registerNumber ) {
        //System.out.println("Created Dec instruction ");
        this.registerNumber = registerNumber.getNumber();
    }

    @Override
    public Integer[] execute(int programCounter, Integer[] registers) {
        if ( registers[registerNumber] == null ) {
            registers[registerNumber] = 0;
        }

        registers[registerNumber] -= 1;

        this.programCounter = ++programCounter;
        return registers;
    }
}

