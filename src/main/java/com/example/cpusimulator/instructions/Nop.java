package com.example.cpusimulator.instructions;

class Nop extends Instruction {
    Nop( ) {  }

    public Integer[] execute(int programCounter, Integer[] registers) {
        this.programCounter = ++programCounter;
        return registers;
    }
}