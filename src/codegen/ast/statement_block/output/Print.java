package codegen.ast.statement_block.output;

import codegen.ast.statement_block.Statement;
import codegen.utils.AssemblyFileWriter;

public class Print extends Statement {

    private String typeOfOutput;

    public Print(String typeOfOutput) {
        this.typeOfOutput = typeOfOutput;
    }

    @Override
    public void compile() {
        String outputType = typeOfOutput.equals("int") ? "1" : "4";
        String comment = typeOfOutput.equals("int") ? "integer" : "string";
        AssemblyFileWriter.appendCommandToCode("# print" + " " + comment);
        AssemblyFileWriter.appendCommandToCode("li", "$v0", outputType);
        AssemblyFileWriter.appendCommandToCode("move", "$a0", "$t0");
        AssemblyFileWriter.appendCommandToCode("syscall");
        // New Line
        AssemblyFileWriter.appendCommandToCode("li", "$v0", "4");
        AssemblyFileWriter.appendCommandToCode("la", "$a0", "nl");
        AssemblyFileWriter.appendCommandToCode("syscall");
    }
}
