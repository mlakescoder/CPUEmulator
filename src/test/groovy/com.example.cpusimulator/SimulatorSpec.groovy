package com.example.cpusimulator;


import spock.lang.Specification;


class SimulatorSpec extends Specification {

    def setup() {

    }

    def "Test Case 1"() {
        given:
        String[] subroutine = ["MOV 5,R00",
                      "MOV 10,R01",
                      "JZ 7",
                      "ADD R02,R01",
                      "DEC R00",
                      "JMP 3",
                      "MOV R02,R42"]
        Cpu cpu = new Cpu();

        when:
        cpu.loadSubRoutine(subroutine)
        String result = cpu.execute()


        then:
        result.equals("50")

    }

    def "Test Case 2"() {
        given:
        String[] subroutine = ["MOV 32,R00",
                               "MOV 1,R41",
                               "JZ 8",
                               "MOV R41,R42",
                               "ADD R41,R42",
                               "DEC R00",
                               "JMP 3",
                               "NOP"]
        Cpu cpu = new Cpu();

        when:
        cpu.loadSubRoutine(subroutine)
        String result = cpu.execute()


        then:
        result.equals("2147483648")

    }

    def "Test Case 3"() {
        given:
        String[] subroutine = ["MOV 32,R00",
                               "MOV 1,R41",
                               "JZ 7",
                               "ADD R41,R41",
                               "DEC R00",
                               "JMP 3",
                               "NOP",
                               "MOV R41,R42"]
        Cpu cpu = new Cpu();

        when:
        cpu.loadSubRoutine(subroutine)
        String result = cpu.execute()


        then:
        result.equals("0")

    }

    def "Test Case 4"() {
        given:
        String[] subroutine = ["INV R41",
                               "ADD R42,R41"]
        Cpu cpu = new Cpu();

        when:
        cpu.loadSubRoutine(subroutine)
        String result = cpu.execute()


        then:
        result.equals("4294967295")

    }

    def "Test Case 5"() {
        given:
        String[] subroutine = ["DEC R42",
                               "INC R01",
                               "ADD R02,R01",
                               "ADD R00,R02",
                               "ADD R00,R42",
                               "JZ 1"]
        Cpu cpu = new Cpu();

        when:
        cpu.loadSubRoutine(subroutine)
        String result = cpu.execute()


        then:
        result.equals("4294967294")

    }

    def "Test Case 6"() {
        given:
        String[] subroutine = ["MOV 12499,R00",
                               "JZ 6",
                               "DEC R00",
                               "DEC R42",
                               "JMP 2",
                               "NOP",
                               "NOP"]
        Cpu cpu = new Cpu();

        when:
        cpu.loadSubRoutine(subroutine)
        String result = cpu.execute()


        then:
        result.equals("4294954797")

    }

    def "Test Case 7"() {
        given:
        String[] subroutine = ["DEC R39",
                               "DEC R39",
                               "MOV R39,R42",
                               "DEC R42",
                               "MOV 4294967295,R41",
                               "ADD R42,R41"]
        Cpu cpu = new Cpu();

        when:
        cpu.loadSubRoutine(subroutine)
        String result = cpu.execute()


        then:
        result.equals("4294967292")

    }

    def "Test Case 8"() {
        given:
        String[] subroutine = ["INV R42",
                               "MOV 101,R00",
                               "JZ 13",
                               "MOV R00,R08",
                               "MOV 100,R00",
                               "JZ 10",
                               "INC R42",
                               "DEC R00",
                               "JMP 6",
                               "MOV R08,R00",
                               "DEC R00",
                               "JMP 3",
                               "INC R42"]
        Cpu cpu = new Cpu();

        when:
        cpu.loadSubRoutine(subroutine)
        String result = cpu.execute()


        then:
        result.equals("10100")

    }

    def "Test Case 9"() {
        given:
        String[] subroutine = ["ADD R03,R33"]
        Cpu cpu = new Cpu();

        when:
        cpu.loadSubRoutine(subroutine)
        String result = cpu.execute()


        then:
        result.equals("0")

    }
}