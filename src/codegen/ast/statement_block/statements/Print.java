package codegen.ast.statement_block.statements;

import codegen.ast.statement_block.Statement;
import codegen.symbol_table.dscp.Descriptor;
import codegen.utils.AssemblyFileWriter;
import scanner.classes.Type;

public class Print extends Statement {

    private Descriptor value;

    public Print(Descriptor value) {
        this.value = value;
    }

    @Override
    public void compile() {
        boolean isInteger = value.getType() == Type.INTEGER_NUMBER;
        String outputType = isInteger ? "1" : "4";
        String comment = isInteger ? "integer" : "string";
        AssemblyFileWriter.appendComment("print" + " " + comment + " -> " + value.getName());
        AssemblyFileWriter.appendCommandToCode("li", "$v0", outputType);
        AssemblyFileWriter.appendCommandToCode("la", "$t0", value.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
        AssemblyFileWriter.appendCommandToCode("move", "$a0", "$t0");
        AssemblyFileWriter.appendCommandToCode("syscall");
        AssemblyFileWriter.appendComment("new line");
        AssemblyFileWriter.appendCommandToCode("li", "$v0", "4");
        AssemblyFileWriter.appendCommandToCode("la", "$a0", "nl");
        AssemblyFileWriter.appendCommandToCode("syscall");
    }
}
