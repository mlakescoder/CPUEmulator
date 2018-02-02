package com.example.cpusimulator;

import com.example.cpusimulator.instructions.InstructionFactory;
import com.example.cpusimulator.instructions.Instruction;

import java.util.ArrayList;
import java.util.List;

public class Cpu {
    final int NUM_REGISTERS = 43;
    Integer[] registers = new Integer[NUM_REGISTERS];
    String[] instructions;
    List<Instruction> compiledInstructions = new ArrayList<>();
    InstructionFactory instructionFactory = new InstructionFactory();

    public Cpu() {
        for ( int i = 0; i < NUM_REGISTERS; i++ ) {
            registers[i] = 0;
        }
    }

    /**
     * Loads a subroutine
     * @param subroutine
     */
    public void loadSubRoutine(String[] subroutine) {
        instructions = subroutine;
        for ( int i = 0; i < instructions.length; i++ ) {
            Instruction compileInstruction = instructionFactory.getInstruction(instructions[i]);
            compiledInstructions.add(compileInstruction);
        }
    }

    public String execute() {
        int programCounter = 0;

        while ( programCounter < instructions.length) {
            Instruction instruction = compiledInstructions.get(programCounter);

            //System.out.println("Exec instruction" + instruction.toString() + " at pc:" + Integer.toString(programCounter));
            instruction.execute(programCounter, registers);

            programCounter = instruction.getProgramCounter();
            //System.out.println("  Finished new pc:" + Integer.toString(programCounter));
        }

        return Integer.toUnsignedString(registers[42]);
    }
}
