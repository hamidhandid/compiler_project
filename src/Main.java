import codegen.CodeGenerator;
import parser.Parser;
import scanner.classes.CompilerScanner;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            CompilerScanner scanner = new CompilerScanner(new FileReader("src/scanner/files/code1.txt"));
            CodeGenerator codeGen = new CodeGenerator(scanner);
            Parser parser = new Parser(scanner, codeGen, "src/parser/table.npt");
            parser.parse();
//            AssemblyFileWriter writer = new AssemblyFileWriter("src/codegen/utils/");
//
//            ArrayList<String> strings = new ArrayList<>(Arrays.asList("t1", "t2", "t3"));
//            ArrayList<String> strings2 = new ArrayList<>(Arrays.asList("t4", "t5", "t6"));
//
//            AssemblyFileWriter.appendCommand(new CommandLine("ann", strings));
//            AssemblyFileWriter.appendCommand(new CommandLine("ann2", strings2));
//            writer.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Can not read file");
            fileNotFoundException.printStackTrace();
        } catch (RuntimeException re) {
            System.err.println("Compile Error occurred");
            re.printStackTrace();
        }
    }
}
