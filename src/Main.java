import codegen.CodeGenerator;
import parser.Parser;
import scanner.classes.CompilerScanner;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            CompilerScanner scanner = new CompilerScanner(new FileReader("src/scanner/files/code1.txt"));
            CodeGenerator codeGen = new CodeGenerator();
            Parser parser = new Parser(scanner, codeGen, "src/parser/table.npt", true);
            parser.parse();
        } catch (FileNotFoundException e) {
            System.err.println("Can not read file");
            e.printStackTrace();
        }
        catch (RuntimeException re){
            System.err.println("Compile Error occurred!");
            re.printStackTrace();
        }
    }
}
