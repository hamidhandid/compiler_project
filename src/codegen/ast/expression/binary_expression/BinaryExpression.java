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

    protected Descriptor firstOperand;
    protected Descriptor secondOperand;
    protected String operation;

    public BinaryExpression(Descriptor firstOperand, Descriptor secondOperand, String operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }

    private String loadAndOperate(Descriptor firstOperandDes, Descriptor secondOperandDes, String operationCommand) {
        String variableName = CodeGenerator.getVariableName();
        AssemblyFileWriter.appendComment("binary " + operationCommand + " expression of " + firstOperandDes.getName() + ", " + secondOperandDes.getName() );
        AssemblyFileWriter.appendCommandToCode("la", "$t0", firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t1", secondOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
        AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t1)");
        AssemblyFileWriter.appendCommandToCode(operationCommand, "$t0", "$t0", "$t1");
        return variableName;
    }

    private void addorsub(Descriptor firstOperandDes, Descriptor secondOperandDes, Type resultType, String operationCommand) {
        String variableName = loadAndOperate(firstOperandDes, secondOperandDes, operationCommand);

        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDescriptor(variableName, resultType));
    }

    private void add(Descriptor firstOperandDes, Descriptor secondOperandDes, Type resultType, String operationCommand) {
        addorsub(firstOperandDes, secondOperandDes, resultType, operationCommand);
    }

    private void subtract(Descriptor firstOperandDes, Descriptor secondOperandDes, Type resultType, String operationCommand) {
        addorsub(firstOperandDes, secondOperandDes, resultType, operationCommand);
    }
    
    private void multiply(Descriptor firstOperandDes, Descriptor secondOperandDes, Type resultType, String operationCommand) {
        String variableName = loadAndOperate(firstOperandDes, secondOperandDes, operationCommand);
        
        AssemblyFileWriter.appendCommandToCode("mfhi", "$t1");
        AssemblyFileWriter.appendCommandToCode("mflo", "$t0");
        // mfhi $a2
        // mflo $v0
        AssemblyFileWriter.appendCommandToData(variableName, "space", "64");
        AssemblyFileWriter.appendCommandToCode("sd", "$t0", variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDescriptor(variableName, resultType));
        
        /*
            li $a0, 5
            li $a1, 3
            mult $a0, $a1
            mfhi $a2
            mflo $v0
         */
    }
    
    private void divide(Descriptor firstOperandDes, Descriptor secondOperandDes, Type resultType, String operationCommand) {
        String variableName = loadAndOperate(firstOperandDes, secondOperandDes, operationCommand);
        
        AssemblyFileWriter.appendCommandToCode("mfhi", "$t1");
        AssemblyFileWriter.appendCommandToCode("mflo", "$t0");
        // mfhi $a2
        // mflo $v0
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode("sd", "$t0", variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDescriptor(variableName, resultType));
        /*
            div $a0, $a1
            mfhi $a2
            mflo $v0
         */
    }

    @Override
    public void compile() {
        System.out.println("BinaryExpr");
        Descriptor firstOperandDes = firstOperand;
        Descriptor secondOperandDes = secondOperand;
        TypeChecker.checkType(firstOperandDes.getType(), secondOperandDes.getType(), "add");
        DescriptorChecker.checkContainsDescriptor(firstOperandDes);
        DescriptorChecker.checkContainsDescriptor(secondOperandDes);
        
        Type resultType = firstOperandDes.getType();
        String operationCommand;

        
         String extention = null;

        switch (resultType) {
            case INTEGER_NUMBER:
                extention = "";
                break;
            case REAL_NUMBER:
                extention = ".d";
                break;
            case STRING:
                // extention = "";
                // TODO
                break;
            // case for boolean comparison and cvt's
            default:
                operationCommand = null;
                resultType = null;
        }

        switch (operation) {
            case "+":
                add(firstOperandDes, secondOperandDes, resultType, "add"+ extention);
                // operationCommand = "add";
                break;
            case "-":
                subtract(firstOperandDes, secondOperandDes, resultType, "sub"+ extention);
                // operationCommand = "sub";
                break;
            case "/":
                divide(firstOperandDes, secondOperandDes, resultType, "div"+ extention);
                // operationCommand = "div";
                break;
            case "*":
                multiply(firstOperandDes, secondOperandDes, resultType, "mul"+ extention);
                // operationCommand = "mul";
                break;
            default:
                operationCommand = null;
                resultType = null;
        }
    }
}
