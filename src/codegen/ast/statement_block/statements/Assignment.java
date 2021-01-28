package codegen.ast.statement_block.statements;

import codegen.ast.statement_block.Statement;
import codegen.symbol_table.dscp.Descriptor;
import codegen.utils.AssemblyFileWriter;

public class Assignment extends Statement {
    private Descriptor leftSide;
    private Descriptor rightSide;

    public Assignment(Descriptor leftSide, Descriptor rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    @Override
    public void compile() {
        AssemblyFileWriter.appendComment("assignment " + leftSide.getName() + " = " + rightSide.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t0", leftSide.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t1", rightSide.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t1)");
        AssemblyFileWriter.appendCommandToCode("sw", "$t1", "0($t0)");
        AssemblyFileWriter.appendDebugLine(leftSide.getName());
    }
}
