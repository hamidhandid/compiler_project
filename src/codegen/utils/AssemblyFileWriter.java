package codegen.utils;

import codegen.utils.command.CommandLine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class AssemblyFileWriter {

    private String filePath;
    private static BufferedWriter writer;

    private static String OUTPUT_ASSEMBLY_FILE_NAME = "compiled_code.s";
    private static String SPACE = "\t\t";

    public AssemblyFileWriter(String filePath) {
        this.filePath = filePath;
        createCompiledFile();
    }

    public static void appendCommand(CommandLine commandLine) {
        ArrayList<String> command = new ArrayList<>(Collections.singletonList(commandLine.getCommand()));
        command.addAll(commandLine.getOperands());
        String res = String.join(", ", command);
        try {
            writer.write(SPACE + res + "\n");
            writer.flush();
        } catch (IOException e) {
            System.err.println("Can not append command " + commandLine + " to output file");
            e.printStackTrace();
        }
    }

    private void createCompiledFile() {
        try {
            writer = new BufferedWriter(new FileWriter(filePath + OUTPUT_ASSEMBLY_FILE_NAME));
            writer.write(".text\n" + ".globl main\n");
            writer.write("main:\n");
            writer.flush();
        } catch (IOException e) {
            System.err.println("Can not create output file");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.err.println("Can not close output file");
            e.printStackTrace();
        }
    }
}
