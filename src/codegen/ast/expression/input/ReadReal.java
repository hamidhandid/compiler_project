package codegen.ast.expression.input;

import codegen.CodeGenerator;
import codegen.ast.expression.Expression;
import codegen.symbol_table.dscp.variables.LocalVariableDescriptor;
import codegen.symbol_table.stacks.SemanticStack;
import codegen.utils.AssemblyFileWriter;
import scanner.classes.Type;

public class ReadReal extends Expression {

    @Override
    public void compile() {
        AssemblyFileWriter.appendComment("read real");
        AssemblyFileWriter.appendCommandToCode("li", "$v0", "6");
        AssemblyFileWriter.appendCommandToCode("syscall");
        AssemblyFileWriter.appendCommandToCode("mov.s", "$f1", "$f0");
        String variableName = CodeGenerator.getVariableName();
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode("la", "$t1", variableName);
        AssemblyFileWriter.appendCommandToCode("s.s", "$f1", "0($t1)");
        SemanticStack.push(new LocalVariableDescriptor(variableName, Type.REAL_NUMBER));
    }
}
