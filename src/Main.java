import codegen.CodeGenerator;
import codegen.symbol_table.SymbolTable;
import codegen.symbol_table.stacks.SymbolTableStack;
import codegen.utils.AssemblyFileWriter;
import codegen.utils.command.CommandLine;
import codegen.utils.command.DataLine;
import parser.Parser;
import scanner.classes.CompilerScanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            AssemblyFileWriter writer = new AssemblyFileWriter("src/codegen/utils/");
            SymbolTableStack.push(new SymbolTable("main"));
            CompilerScanner scanner = new CompilerScanner(new FileReader("src/scanner/files/code1.txt"));
            CodeGenerator codeGen = new CodeGenerator(scanner);
            Parser parser = new Parser(scanner, codeGen, "src/parser/table.npt");
            parser.parse();

            writer.writeOutputFile();
            writer.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Can not read file");
            fileNotFoundException.printStackTrace();
        } catch (RuntimeException re) {
            System.err.println("Compile Error occurred");
            re.printStackTrace();
        }
    }
}
