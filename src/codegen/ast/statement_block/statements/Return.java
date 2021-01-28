package codegen.ast.statement_block.statements;

import codegen.ast.statement_block.Statement;
import codegen.symbol_table.dscp.Descriptor;
import codegen.utils.AssemblyFileWriter;

public class Return extends Statement {

    private Descriptor value;

    public Return(Descriptor value) {
        this.value = value;
    }

    @Override
    public void compile() {
        AssemblyFileWriter.appendComment("return " + value.getName());
        AssemblyFileWriter.appendCommandToCode("li", "$v0", "10");
        AssemblyFileWriter.appendCommandToCode("la", "$t0", value.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
        AssemblyFileWriter.appendCommandToCode("move", "$a0", "$t0");
        AssemblyFileWriter.appendCommandToCode("syscall");
    }
}
