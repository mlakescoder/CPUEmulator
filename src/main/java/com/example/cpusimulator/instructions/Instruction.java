package com.example.cpusimulator.instructions;

public abstract class Instruction {
    protected int programCounter;

    public Instruction() {
    }

    public abstract Integer[] execute(int programCounter, Integer[] registers);

    public int getProgramCounter() { return this.programCounter; }
}
