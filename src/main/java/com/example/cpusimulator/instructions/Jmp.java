package com.example.cpusimulator.instructions;

public class Jmp extends Instruction {
    int instuctionNumber;

    Jmp(int instructionNumber ) {
        this.instuctionNumber = instructionNumber;
    }

    @Override
    public Integer[] execute(int programCounter, Integer[] registers) {
        this.programCounter = instuctionNumber - 1;
        return registers;
    }
}
