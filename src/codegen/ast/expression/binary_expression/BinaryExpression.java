package codegen.ast.expression.binary_expression;

import codegen.CodeGenerator;
import codegen.ast.expression.Expression;
import codegen.symbol_table.dscp.Descriptor;
import codegen.symbol_table.dscp.variables.LocalVariableDescriptor;
import codegen.symbol_table.stacks.SemanticStack;
import codegen.utils.AssemblyFileWriter;
import codegen.utils.DescriptorChecker;
import codegen.utils.type.TypeChecker;
import scanner.classes.Type;

public abstract class BinaryExpression extends Expression {

    protected Object firstOperand;
    protected Object secondOperand;
    protected String operation;

    public BinaryExpression(Object firstOperand, Object secondOperand, String operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }

    @Override
    public void compile() {
        System.out.println("BinaryExpr");
        Descriptor firstOperandDes = (Descriptor) firstOperand;
        Descriptor secondOperandDes = (Descriptor) secondOperand;
        TypeChecker.checkType(firstOperandDes.getType(), secondOperandDes.getType(), "add");
        DescriptorChecker.checkContainsDescriptor(firstOperandDes);
        DescriptorChecker.checkContainsDescriptor(secondOperandDes);

        String operationCommand;
        Type type;
        switch (operation) {
            case "+":
                operationCommand = "add";
                type = Type.INTEGER_NUMBER;
                break;
            default:
                operationCommand = null;
                type = null;
        }
        String variableName = CodeGenerator.getVariableName();
        AssemblyFileWriter.appendComment("binary " + operationCommand + " expression of " + firstOperandDes.getName() + ", " + secondOperandDes.getName() );
        AssemblyFileWriter.appendCommandToCode("la", "$t0", firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t1", secondOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
        AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t1)");
        AssemblyFileWriter.appendCommandToCode(operationCommand, "$t0", "$t0", "$t1");
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDescriptor(variableName, type));
    }
}
