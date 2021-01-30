package codegen.ast.expression.constant;

import codegen.CodeGenerator;
import codegen.symbol_table.GlobalSymbolTable;
import codegen.symbol_table.dscp.variables.GlobalVariableDescriptor;
import codegen.symbol_table.dscp.variables.VariableDescriptor;
import codegen.symbol_table.stacks.SemanticStack;
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
        VariableDescriptor descriptor = (VariableDescriptor) GlobalSymbolTable.getSymbolTable().getDescriptor("$" + intConst);
        boolean hasDescriptor = descriptor != null;
        if (!hasDescriptor) {
            String variableName = CodeGenerator.getVariableName();
            descriptor = new GlobalVariableDescriptor(variableName, Type.INTEGER_NUMBER);
            descriptor.setValue(String.valueOf(intConst));
            AssemblyFileWriter.appendComment("integer constant");
            AssemblyFileWriter.appendCommandToCode("li", "$t0", String.valueOf(intConst));
            AssemblyFileWriter.appendCommandToCode("sw", "$t0", variableName);
            GlobalSymbolTable.getSymbolTable().addDescriptor("$" + intConst, descriptor);
            AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
            AssemblyFileWriter.appendDebugLine(variableName);
        }
        SemanticStack.push(descriptor);
    }
}
