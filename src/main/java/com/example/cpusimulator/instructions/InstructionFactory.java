package com.example.cpusimulator.instructions;

import com.example.cpusimulator.Register;

public class InstructionFactory {
    public Instruction getInstruction(String instruction) {
        if (instruction == null) {
            throw new IllegalArgumentException("No instruction given");
        }

        System.out.println("Compiling instruction: [" + instruction + "]" );

        // Create instructions with no parameters
        String[] params = instruction.split(" ");
        if (params.length == 1 && params[0].equals("NOP")) {
            return new Nop();
        }

        // Create instructions that have a comma seperated list
        if (params.length == 2 && !params[1].contains(",")) {
            if (params[0].equals("JZ")) {
                return new Jz(Integer.parseUnsignedInt(params[1]), new Register("R00"));
            }

            if (params[0].equals("JMP")) {
                return new Jmp(Integer.parseUnsignedInt(params[1]));
            }

            if (params[0].equals("INV")) {
                return new Inv(new Register(params[1]));
            }

            if (params[0].equals("INC")) {
                return new Inc(new Register(params[1]));
            }

            if (params[0].equals("DEC")) {
                return new Dec(new Register(params[1]));
            }
        }

        // Create instructions that have a single parameter
        if ( params.length == 2 ) {
            String[] operands = params[1].split(",");
            if (params[0].equals("ADD")) {
                return new Add(new Register(operands[0]), new Register(operands[1]));
            }

            if (params[0].equals("MOV")) {
                try {
                    return new Mov(new Register(operands[0]), new Register(operands[1]));
                } catch (Exception e) {
                    return new Movc(Integer.parseUnsignedInt(operands[0]), new Register(operands[1]));
                }
            }
        }

        throw new IllegalArgumentException("Failed to compile: " + instruction);
    }
}
