package codegen.ast.expression.constant;

import codegen.CodeGenerator;
import codegen.symbol_table.SymbolTable;
import codegen.symbol_table.dscp.Descriptor;
import codegen.symbol_table.dscp.variables.LocalVariableDescriptor;
import codegen.symbol_table.stacks.SemanticStack;
import codegen.symbol_table.stacks.SymbolTableStack;
import codegen.utils.AssemblyFileWriter;
import scanner.classes.Type;

public class IntegerConstant extends ConstantExpression{
    protected int intConst;

    public IntegerConstant(int intConst) {
        this.intConst = intConst;
    }

    @Override
    public void compile() {
        System.out.println(intConst);
        String variableName = CodeGenerator.getVariableName();
        Descriptor descriptor = new LocalVariableDescriptor(variableName, Type.INTEGER_NUMBER);
        SemanticStack.push(descriptor);
        AssemblyFileWriter.appendComment("integer constant");
        AssemblyFileWriter.appendCommandToCode("li", "$t0", String.valueOf(intConst));
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", variableName);
        SymbolTableStack.top().addDescriptor("$" + intConst, descriptor);
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendDebugLine(variableName);
    }
}
