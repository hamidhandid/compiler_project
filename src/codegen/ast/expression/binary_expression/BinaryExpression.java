package codegen.ast.expression.binary_expression;

import codegen.CodeGenerator;
import codegen.ast.expression.Expression;
import codegen.symbol_table.dscp.Descriptor;
import codegen.symbol_table.dscp.variables.LocalVariableDescriptor;
import codegen.symbol_table.stacks.SemanticStack;
import codegen.utils.AssemblyFileWriter;
import codegen.utils.DescriptorChecker;
import codegen.utils.errors.TypeError;
import codegen.utils.type.TypeChecker;
import scanner.classes.Type;

import java.util.ArrayList;

public abstract class BinaryExpression extends Expression {

    protected Descriptor firstOperand;
    protected Descriptor secondOperand;
    protected String operation;

    private ArrayList<Object> PendingProcess = new ArrayList<>();

    public BinaryExpression(Descriptor firstOperand, Descriptor secondOperand, String operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }

    private String loadAndOperate(Descriptor firstOperandDes, Descriptor secondOperandDes, String operationCommand, String storeCommand, String loadCommand, String variableName0, String variableName1) {
        String variableName = CodeGenerator.getVariableName();
        AssemblyFileWriter.appendComment("binary " + operationCommand + " expression of " + firstOperandDes.getName() + ", " + secondOperandDes.getName() );
        AssemblyFileWriter.appendCommandToCode("la", "$t0", firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t1", secondOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode(loadCommand, variableName0, "0($t0)");
        AssemblyFileWriter.appendCommandToCode(loadCommand, variableName1, "0($t1)");
        AssemblyFileWriter.appendCommandToCode(operationCommand, variableName0, variableName0, variableName1);
        return variableName;
    }

    private void generate2OperandCommands(Descriptor firstOperandDes, Descriptor secondOperandDes, Type resultType, String operationCommand, String storeCommand, String loadCommand, String variableName0, String variableName1) {
        String variableName = loadAndOperate(firstOperandDes, secondOperandDes, operationCommand, storeCommand, loadCommand, variableName0, variableName1);

        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode(storeCommand, variableName0, variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDescriptor(variableName, resultType));
    }

    private void multiply(Descriptor firstOperandDes, Descriptor secondOperandDes, Type resultType, String operationCommand, String storeCommand, String loadCommand, String variableName0, String variableName1) {
        String variableName = loadAndOperate(firstOperandDes, secondOperandDes, operationCommand, storeCommand, loadCommand, variableName0, variableName1);
        
        AssemblyFileWriter.appendCommandToCode("mfhi", "$t1");
        AssemblyFileWriter.appendCommandToCode("mflo", "$t0");
        // mfhi $a2
        // mflo $v0
        AssemblyFileWriter.appendCommandToData(variableName, "space", "64");
        AssemblyFileWriter.appendCommandToCode(storeCommand, variableName0, variableName);
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
    
    private void divide(Descriptor firstOperandDes, Descriptor secondOperandDes, Type resultType, String operationCommand, String storeCommand, String loadCommand, String variableName0, String variableName1) {
        String variableName = loadAndOperate(firstOperandDes, secondOperandDes, operationCommand, storeCommand, loadCommand, variableName0, variableName1);
        
        AssemblyFileWriter.appendCommandToCode("mfhi", "$t1");
        AssemblyFileWriter.appendCommandToCode("mflo", "$t0");
        // mfhi $a2
        // mflo $v0
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");

        // Important: sd is changed to sw (check if its okay)
        AssemblyFileWriter.appendCommandToCode(storeCommand, variableName0, variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDescriptor(variableName, resultType));
        /*
            div $a0, $a1
            mfhi $a2
            mflo $v0
         */
    }

    private void generateMinusMinusCommand(Descriptor firstOperandDes, Type resultType, String operationCommand/*, boolean isBeforeExpression*/) {
        String variableName = CodeGenerator.getVariableName();
        AssemblyFileWriter.appendComment("binary " + "--" + " expression of " + firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t0", firstOperandDes.getName());
        // AssemblyFileWriter.appendCommandToCode("la", "$t1", secondOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
        // AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t1)");

        AssemblyFileWriter.appendCommandToCode(operationCommand, "$t0", "$t0", "-1");
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDescriptor(variableName, resultType));
        /*if (isBeforeExpression){
        }
        else {
        }*/
    }

    private void generatePlusPlusCommand(Descriptor firstOperandDes, Type resultType, String operationCommand/*, boolean isBeforeExpression*/) {
        String variableName = CodeGenerator.getVariableName();
        AssemblyFileWriter.appendComment("binary " + "++" + " expression of " + firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t0", firstOperandDes.getName());
        // AssemblyFileWriter.appendCommandToCode("la", "$t1", secondOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
        // AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t1)");

        AssemblyFileWriter.appendCommandToCode(operationCommand, "$t0", "$t0", "0x1");
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDescriptor(variableName, resultType));
        /*if (isBeforeExpression){
        }
        else {
        }*/
    }

    private void generateNotCommand(Descriptor firstOperandDes, Type resultType, String operationCommand) {
        String variableName = CodeGenerator.getVariableName();
        AssemblyFileWriter.appendComment("binary " + operationCommand + " expression of " + firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t0", firstOperandDes.getName());
        // AssemblyFileWriter.appendCommandToCode("la", "$t1", secondOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
        // AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t1)");

        AssemblyFileWriter.appendCommandToCode(operationCommand, "$t0", "$t0");
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode("sw", "$t0", variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDescriptor(variableName, resultType));
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
        String storeCommand = "sw", loadCommand = "lw";
        String variableName0 = "$f0", variableName1 = "$f1";

        String extention = null;

        switch (resultType) {
            case INTEGER_NUMBER:
                extention = "";
                storeCommand = "sw";
                loadCommand = "lw";
                variableName0 = "$t0";
                variableName1 = "$t1";
                break;
            case REAL_NUMBER:
                extention = ".s";
                storeCommand = "s.s";
                loadCommand = "l.s";
                variableName0 = "$f0";
                variableName1 = "$f1";
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
        // Arithmatic
            case "+":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "add"+ extention, storeCommand, loadCommand, variableName0, variableName1);
                //generateAddFloat(firstOperandDes, secondOperandDes, resultType, "add"+ extention, storeCommand, loadCommand);
                // operationCommand = "add";
                break;
            case "-":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "sub"+ extention, storeCommand, loadCommand, variableName0, variableName1);
                // operationCommand = "sub";
                break;
            case "/":
                //TODO: division by 0
                divide(firstOperandDes, secondOperandDes, resultType, "div"+ extention, storeCommand, loadCommand, variableName0, variableName1);
                // operationCommand = "div";
                break;
            case "*":
                multiply(firstOperandDes, secondOperandDes, resultType, "mul"+ extention, resultType==Type.INTEGER_NUMBER ? "sd" : "s.s", loadCommand, variableName0, variableName1);
                // operationCommand = "mul";
                break;
            case "%":
                if(firstOperandDes.getType() == Type.INTEGER_NUMBER && secondOperandDes.getType() == Type.INTEGER_NUMBER ) {
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "rem", storeCommand, loadCommand, variableName0, variableName1);
                }
                else
                    throw new TypeError("%", firstOperandDes.getType(), firstOperandDes.getType());
                break;
        // and, or, xor
            case "&&":
            case "&":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "and", "sw", "lw", variableName0, variableName1);
                break;
            case "||":
            case "|":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "or", "sw", "lw", variableName0, variableName1);
                break;
            case "^":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "xor", "sw", "lw", variableName0, variableName1);
                break;
            case "~":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "nor", "sw", "lw", variableName0, variableName1);
                break;
        // Comparison
            case "==":
                if (firstOperandDes.getType() == Type.REAL_NUMBER){     //TODO (for all). better: firstOperandDes.getType() == secondOperandDes.getType() == Type.REAL_NUMBER
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "c.eq.s", storeCommand, loadCommand, variableName0, variableName1);
                }
                else if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "seq", storeCommand, loadCommand, variableName0, variableName1);
                }
                break;
            case "<":
                if (firstOperandDes.getType() == Type.REAL_NUMBER){
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "c.lt.s", storeCommand, loadCommand, variableName0, variableName1);
                }
                else if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "slt", storeCommand, loadCommand, variableName0, variableName1);
                }
                break;
            case ">=":
                if (firstOperandDes.getType() == Type.REAL_NUMBER){
                    generate2OperandCommands(secondOperandDes, firstOperandDes, resultType, "c.le.s", storeCommand, loadCommand, variableName0, variableName1);
                }
                else if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "sge", storeCommand, loadCommand, variableName0, variableName1);
                }
                break;
            case ">":
                if (firstOperandDes.getType() == Type.REAL_NUMBER){
                    generate2OperandCommands(secondOperandDes, firstOperandDes, resultType, "c.lt.s", storeCommand, loadCommand, variableName0, variableName1);
                }
                else if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "sgt", storeCommand, loadCommand, variableName0, variableName1);
                }
                break;
            case "<=":
                if (firstOperandDes.getType() == Type.REAL_NUMBER){
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "c.le.s", storeCommand, loadCommand, variableName0, variableName1);
                }
                else if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "sle", storeCommand, loadCommand, variableName0, variableName1);
                }
                break;
            case "!=":
                generate2OperandCommands(firstOperandDes, secondOperandDes, resultType, "sne", "sw", "lw", variableName0, variableName1);
                break;
            // Unary
            case "++":
                if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generatePlusPlusCommand(firstOperandDes, resultType, "addi");
                }
                else
                    throw new TypeError("++", firstOperandDes.getType());
                break;
            case "--":
                if(firstOperandDes.getType() == Type.INTEGER_NUMBER) {
                    generateMinusMinusCommand(firstOperandDes, resultType, "addi");
                }
                else
                    throw new TypeError("--", firstOperandDes.getType());
                break;
            case "!":
                //TODO: check if its logical (not int or ...)
                generateNotCommand(firstOperandDes, resultType, "not");
                break;
            // Convert Singe to Integer and vise-versa
            default:
                operationCommand = null;
                resultType = null;
        }
    }

    private void generateAddFloat(Descriptor firstOperandDes, Descriptor secondOperandDes, Type resultType, String operationCommand, String storeCommand, String loadCommand) {
        String variableName = CodeGenerator.getVariableName();
        AssemblyFileWriter.appendComment("binary " + operationCommand + " expression of " + firstOperandDes.getName() + ", " + secondOperandDes.getName() );
        AssemblyFileWriter.appendCommandToCode("la", "$t0", firstOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("la", "$t1", secondOperandDes.getName());
        AssemblyFileWriter.appendCommandToCode("l.s", "$f0", "0($t0)");
        AssemblyFileWriter.appendCommandToCode("l.s", "$f1", "0($t1)");
        AssemblyFileWriter.appendCommandToCode("add.s", "$f0", "$f0", "$f1");
        AssemblyFileWriter.appendCommandToData(variableName, "word", "0");
        AssemblyFileWriter.appendCommandToCode("s.s", "$f0", variableName);
        AssemblyFileWriter.appendDebugLine(variableName);
        SemanticStack.push(new LocalVariableDescriptor(variableName, resultType));
    }
}
