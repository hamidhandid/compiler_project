package codegen.ast.statement_block.statements;

import codegen.ast.statement_block.Statement;
import codegen.utils.AssemblyFileWriter;

public class Return extends Statement {

    @Override
    public void compile() {
        AssemblyFileWriter.appendCommandToCode("# return");
        AssemblyFileWriter.appendCommandToCode("li", "$v0", "10");
        AssemblyFileWriter.appendCommandToCode("syscall");
    }
}
