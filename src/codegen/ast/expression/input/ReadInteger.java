package codegen.ast.expression.input;

import codegen.ast.expression.Expression;
import codegen.utils.AssemblyFileWriter;

public class ReadInteger extends Expression {
    @Override
    public void compile() {
        AssemblyFileWriter.appendCommandToCode("# read integer");
        AssemblyFileWriter.appendCommandToCode("li", "$v0", "5");
        AssemblyFileWriter.appendCommandToCode("syscall");
        AssemblyFileWriter.appendCommandToCode("move", "$t0", "$v0");
    }
}
