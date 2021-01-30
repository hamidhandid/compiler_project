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

public class RealConstant extends ConstantExpression {
    protected float realConst;

    public RealConstant(float realConst) {
        this.realConst = realConst;
    }

    @Override
    public void compile() {
        System.out.println(realConst);
        VariableDescriptor descriptor = (VariableDescriptor) GlobalSymbolTable.getSymbolTable().getDescriptor("$" + realConst);
        boolean hasDescriptor = descriptor != null;
        if (!hasDescriptor) {
            String variableName = CodeGenerator.getVariableName();
            descriptor = new GlobalVariableDescriptor(variableName, Type.REAL_NUMBER);
            descriptor.setValue(String.valueOf(realConst));
            AssemblyFileWriter.appendComment("integer constant");
            AssemblyFileWriter.appendCommandToCode("li.s", "$f0", String.valueOf(realConst));
            AssemblyFileWriter.appendCommandToCode("s.s", "$f0", variableName);
            GlobalSymbolTable.getSymbolTable().addDescriptor("$" + realConst, descriptor);
            AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
            AssemblyFileWriter.appendDebugLine(variableName);
        }
        SemanticStack.push(descriptor);
    }
}
