This is a project that I did for the Space X bot on the website www.code fights.com.

Here are the directions for the project:

Space X is testing flight software subroutines (i.e., programs that consist of sequences of instructions) for a custom
rocket CPU. To ensure that the software runs correctly before it's loaded into the rocket, you need to create a CPU
simulator.

The CPU has 43 32-bit unsigned integer registers, which are named R00..R42. At the start of the program,
all the registers contain 0. The CPU supports the following instructions:

* MOV Rxx,Ryy - copies the value from register Rxx to register Ryy;
* MOV d,Rxx - copies the numeric constant d (specified as a decimal) to register Rxx;
* ADD Rxx,Ryy - calculates (Rxx + Ryy) MOD 232 and stores the result in Rxx;
* DEC Rxx - decrements Rxx by one. Decrementing 0 causes an overflow and results in 232-1;
* INC Rxx - increments Rxx by one. Incrementing 232-1 causes an overflow and results in 0;
* INV Rxx - performs a bitwise inversion of register Rxx;
* JMP d - unconditionally jumps to instruction number d (1-based). d is guaranteed to be a valid instruction number;
* JZ d - jumps to instruction d (1-based) only if R00 contains 0;
* NOP - does nothing.

After the last instruction has been executed, the contents of R42 are considered to be the result of the subroutine.
Write a software emulator for this CPU that executes the subroutines and returns the resulting value from R42.
All the commands in the subroutine are guaranteed to be syntactically correct and have valid register numbers,
numeric constants, and jump addresses. The maximum program length is 1024instructions. The maximum total number
of instructions that will be executed until the value is returned is 5 · 104. (Keep in mind that the same
instruction will be counted as many times as it will be executed.)
