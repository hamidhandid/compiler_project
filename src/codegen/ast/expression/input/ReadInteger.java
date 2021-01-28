package codegen.ast.expression.input;

import codegen.CodeGenerator;
import codegen.ast.expression.Expression;
import codegen.symbol_table.dscp.variables.LocalVariableDescriptor;
import codegen.symbol_table.stacks.SemanticStack;
import codegen.utils.AssemblyFileWriter;
import scanner.classes.Type;

public class ReadInteger extends Expression {
    @Override
    public void compile() {
        AssemblyFileWriter.appendComment("read integer");
        AssemblyFileWriter.appendCommandToCode("li", "$v0", "5");
        AssemblyFileWriter.appendCommandToCode("syscall");
        AssemblyFileWriter.appendCommandToCode("move", "$t0", "$v0");
        String variableName = CodeGenerator.getVariableName();
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode("la", "$t1", variableName);
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", "0($t1)");
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDescriptor(variableName, Type.INTEGER_NUMBER));
    }
}
