package codegen.ast.expression.binary_expression.cast;

import codegen.CodeGenerator;
import codegen.ast.Compilable;
import codegen.ast.expression.binary_expression.BinaryExpression;
import codegen.symbol_table.dscp.Descriptor;
import codegen.symbol_table.dscp.variables.LocalVariableDescriptor;
import codegen.symbol_table.stacks.SemanticStack;
import codegen.utils.AssemblyFileWriter;
import scanner.classes.Type;

public abstract class Cast implements Compilable {

    protected Descriptor operand;
    protected Type type;
    protected String operation;

    public Cast(Descriptor operand, Type type, String operation) {
        this.operand = operand;
        this.type = type;
        this.operation = operation;
    }


    protected void convert(Descriptor firstOperandDes, Type resultType, String operationCommand, String storeCommand, String loadCommand) {
//        String variableName = CodeGenerator.getVariableName();
        AssemblyFileWriter.appendComment("binary " + operation + " expression of " + firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t0", firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");

        AssemblyFileWriter.appendCommandToCode("mtc1", "$t0", "$f0");
        AssemblyFileWriter.appendCommandToCode(operationCommand, "$f1", "$f0");
//        AssemblyFileWriter.appendCommandToData(firstOperandDes.getName(), "word", "0");

        AssemblyFileWriter.appendCommandToCode(storeCommand, "$f1", firstOperandDes.getName());
//        AssemblyFileWriter.appendDebugLine(firstOperandDes.getName());
        SemanticStack.push(new LocalVariableDescriptor(firstOperandDes.getName(), resultType));
    }
}
