package codegen.ast.expression.constant;

import codegen.CodeGenerator;
import codegen.symbol_table.GlobalSymbolTable;
import codegen.symbol_table.SymbolTable;
import codegen.symbol_table.dscp.Descriptor;
import codegen.symbol_table.dscp.variables.GlobalVariableDescriptor;
import codegen.symbol_table.dscp.variables.LocalVariableDescriptor;
import codegen.symbol_table.dscp.variables.VariableDescriptor;
import codegen.symbol_table.stacks.SemanticStack;
import codegen.symbol_table.stacks.SymbolTableStack;
import codegen.utils.AssemblyFileWriter;
import scanner.classes.Type;

public class StringConstant extends ConstantExpression {
    protected String stringConst;

    public StringConstant(String stringConst) {
        this.stringConst = stringConst;
    }

    @Override
    public void compile() {
        System.out.println(stringConst);
        VariableDescriptor descriptor = (VariableDescriptor) GlobalSymbolTable.getSymbolTable().getDescriptor("$$" + stringConst);
        boolean hasDescriptor = descriptor != null;
        if (!hasDescriptor) {
            String variableName = CodeGenerator.getVariableName();
            descriptor = new GlobalVariableDescriptor(variableName, Type.STRING);
            descriptor.setValue(stringConst);
            SemanticStack.push(descriptor);
            AssemblyFileWriter.appendComment("string constant");
            GlobalSymbolTable.getSymbolTable().addDescriptor("$$" + stringConst, descriptor);
            AssemblyFileWriter.appendCommandToData(variableName, "asciiz", "\"" + stringConst + "\"");
            AssemblyFileWriter.appendDebugLine(variableName);
        }
    }
}
