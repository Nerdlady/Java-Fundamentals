package com.company.main.io;


public class OutputWriter {
    public static void writeMessage(String message){
        System.out.print(message);
    }

    public static void writeMessageOnNewLine(String message){
        System.out.println(message);
    }

    public static void writeEmptyLine(){
        System.out.println();
    }

    public static void displayException(String message){
        System.out.println("\u001B[31m" + message + "\u001B[0m");
    }

    /**
     * This method doesn't belong in the OutputWriter.
     *
     * @deprecated use {@link #writeMessageOnNewLine(String message)}
     * with String.format() and methods from the Student class instead.
     */
    @Deprecated
    public static void printStudents(String name,Double mark){
        String output = String.format("%s - %f",name,mark);
        OutputWriter.writeMessageOnNewLine(output);
    }
}
