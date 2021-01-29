package codegen.ast.expression.input;

import codegen.CodeGenerator;
import codegen.ast.expression.Expression;
import codegen.ast.expression.constant.StringConstant;
import codegen.symbol_table.dscp.Descriptor;
import codegen.symbol_table.dscp.variables.LocalVariableDescriptor;
import codegen.symbol_table.stacks.SemanticStack;
import codegen.utils.AssemblyFileWriter;
import scanner.classes.Type;

public class ReadLine extends Expression {
    @Override
    public void compile() {
        AssemblyFileWriter.appendComment("read string");
        AssemblyFileWriter.appendCommandToCode("li", "$v0", "8");
        AssemblyFileWriter.appendCommandToCode("la", "$a0", "strbuffer");
        AssemblyFileWriter.appendCommandToCode("li", "$a1", "20");
        AssemblyFileWriter.appendCommandToCode("move", "$t0", "$a0");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", "stradr");
        String varName = CodeGenerator.getVariableName();
        LocalVariableDescriptor lvd = new LocalVariableDescriptor(varName, Type.STRING);
        AssemblyFileWriter.appendCommandToData(varName, "space", "20");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", lvd.getName());
        SemanticStack.push(lvd);
        AssemblyFileWriter.appendCommandToCode("syscall");
    }
}
