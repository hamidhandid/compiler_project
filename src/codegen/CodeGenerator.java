package codegen;

import codegen.ast.declaration.variable_declaration.LocalVariableDeclaration;
import codegen.ast.expression.binary_expression.arithmetic.*;
import codegen.ast.expression.binary_expression.logical.logical_expressions.And;
import codegen.ast.expression.binary_expression.logical.logical_expressions.Or;
import codegen.ast.expression.binary_expression.logical.logical_expressions.SmallerThan;
import codegen.ast.expression.constant.IntegerConstant;
import codegen.ast.expression.input.ReadInteger;
import codegen.ast.statement_block.statements.If;
import codegen.ast.statement_block.statements.Print;
import codegen.ast.statement_block.statements.Assignment;
import codegen.ast.statement_block.statements.Return;
import codegen.ast.statement_block.statements.loops.While;
import codegen.symbol_table.dscp.Descriptor;
import codegen.symbol_table.dscp.array.ArrayDescriptor;
import codegen.symbol_table.dscp.array.LocalArrayDescriptor;
import codegen.symbol_table.dscp.variables.LocalVariableDescriptor;
import codegen.symbol_table.dscp.variables.VariableDescriptor;
import codegen.symbol_table.stacks.SemanticStack;
import codegen.symbol_table.stacks.SymbolTableStack;
import codegen.utils.AssemblyFileWriter;
import codegen.utils.DescriptorChecker;
import codegen.utils.type.TypeChecker;
import scanner.classes.CompilerScanner;
import scanner.classes.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CodeGenerator implements parser.CodeGenerator {
    private CompilerScanner lexical;
    private static int variableIndex = 0;
    private static int labelIndex = 0;

    public CodeGenerator(CompilerScanner lexical) {
        this.lexical = lexical;
    }

    public CompilerScanner getLexical() {
        return lexical;
    }

    private static int getVariableIndex() {
        return variableIndex;
    }

    private static void incrementVariableIndex() {
        ++variableIndex;
    }

    public static String getVariableName() {
        incrementVariableIndex();
        return "adr" + getVariableIndex();
    }

    public static String generateNewLabel() {
        ++labelIndex;
        return "lbl" + labelIndex;
    }

    @Override
    public void doSemantic(String sem) {
        System.out.println("sem = " + sem);
        try {
            System.out.println("token = " + lexical.currentSymbol.getToken() + "\n");
            SemanticStack.print();
            System.out.println();
            SymbolTableStack.top().print();
        } catch (Exception e) {
        }
        Descriptor firstOperand, secondOperand;
        switch (sem) {
            case "add":
                System.out.println("code gen of add");
                secondOperand = (Descriptor) SemanticStack.pop();
                firstOperand = (Descriptor) SemanticStack.pop();
                new Add(firstOperand, secondOperand).compile();
                break;
            case "sub":
                System.out.println("code gen of subtract");
                firstOperand = (Descriptor) SemanticStack.pop();
                secondOperand = (Descriptor) SemanticStack.pop();
                new Subtract(firstOperand, secondOperand).compile();
                break;
            case "mult":
                firstOperand = (Descriptor) SemanticStack.pop();
                secondOperand = (Descriptor) SemanticStack.pop();
                new Multiply(firstOperand, secondOperand).compile();
                System.out.println("code gen of multiply");
                break;
            case "div":
                firstOperand = (Descriptor) SemanticStack.pop();
                secondOperand = (Descriptor) SemanticStack.pop();
                new Divide(firstOperand, secondOperand).compile();
                System.out.println("code gen of division");
                break;
            case "and":
                firstOperand = (Descriptor) SemanticStack.pop();
                secondOperand = (Descriptor) SemanticStack.pop();
                new And(firstOperand, secondOperand).compile();
                System.out.println("code gen of and");
                break;
            case "or":
                firstOperand = (Descriptor) SemanticStack.pop();
                secondOperand = (Descriptor) SemanticStack.pop();
                new Or(firstOperand, secondOperand).compile();
                System.out.println("code gen of or");
                break;
            case "not":
                firstOperand = (Descriptor) SemanticStack.pop();
                // new Not(firstOperand).compile();
                System.out.println("code gen of not");
                break;
            case "biggerThan":
                System.out.println("code gen of biggerThan");
                break;
            case "biggerThanAndEqual":
                System.out.println("code gen of biggerThanAndEqual");
                break;
            case "smallerThan":
                Descriptor des2 = (Descriptor) SemanticStack.pop();
                Descriptor des1 = (Descriptor) SemanticStack.pop();
                new SmallerThan(des1, des2).compile();
                break;
            case "smallerThanAndEqual":
                System.out.println("code gen of smallerThanAndEqual");
                break;
            case "equal":
                System.out.println("code gen of equal");
                break;
            case "notEqual":
                System.out.println("code gen of notEqual");
                break;
            case "return":
                System.out.println("code gen of return");
                break;
            case "break":
                System.out.println("code gen of break");
                break;
            case "for":
                System.out.println("code gen of for");
                break;
            case "if":
                new If((Descriptor) SemanticStack.pop()).compile();
                break;
            case "completeIf":
                If.completeIf();
                break;
            case "else":
                If.elseCode();
                break;
            case "completeElse":
                If.completeElse();
                break;
            case "startConditionWhile":
                While.startCondition();
                break;
            case "whileJumpZero":
                new While((Descriptor) SemanticStack.pop()).compile();
                break;
            case "completeWhile":
                While.completeWhile();
                break;
            case "arrayDcl":
                DescriptorChecker.checkNotContainsDescriptor(lexical.currentSymbol.getToken());
                Type arrType = (Type) SemanticStack.top();
                if (!SymbolTableStack.top().contains(lexical.currentSymbol.getToken())) {
                    LocalArrayDescriptor lad = new LocalArrayDescriptor(getVariableName(), arrType);
                    SymbolTableStack.top().addDescriptor(lexical.currentSymbol.getToken(), lad);
//                    AssemblyFileWriter.appendCommandToData(lad.getName(), "word", "0");
                    SemanticStack.push(lexical.currentSymbol.getToken());
                } else {
                    System.err.println("Variable is defined before");
                }
                break;
            case "setArrayDescriptor":
                Type newArrayType = (Type) SemanticStack.pop();
                LocalVariableDescriptor sizeDescriptor = (LocalVariableDescriptor) SemanticStack.pop();
                ArrayDescriptor nameOfArrayDes = (ArrayDescriptor) SemanticStack.pop();
                DescriptorChecker.checkContainsDescriptor(nameOfArrayDes);
                TypeChecker.checkArrayType(nameOfArrayDes.getType(), newArrayType);
                ArrayDescriptor ad = new LocalArrayDescriptor(nameOfArrayDes.getName(), newArrayType);
                SymbolTableStack.top().addDescriptor(nameOfArrayDes.getRealName(), ad);
//                SemanticStack.push(ad);
                int arrSize = Integer.parseInt(sizeDescriptor.getValue());
                int[] arrInts = new int[arrSize];
                String[] arrIntsStrings = new String[arrSize];
                for (int i = 0; i < arrSize; i++) {
                    arrIntsStrings[i] = String.valueOf(arrInts[i]);
                }
                String arr = String.join(",", arrIntsStrings);
                AssemblyFileWriter.appendCommandToData(nameOfArrayDes.getName(), ".word", arr);
                break;
            case "arrayAccessAssignment":
                Descriptor rightSideArr = (Descriptor) SemanticStack.pop();
                VariableDescriptor indexDes = (VariableDescriptor) SemanticStack.pop();
                Descriptor nameOfArrayDesc = (Descriptor) SemanticStack.pop();
                int index = Integer.parseInt(indexDes.getValue());
                AssemblyFileWriter.appendCommandToCode("la", "$t0", rightSideArr.getName());
                AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
                AssemblyFileWriter.appendCommandToCode("li", "$t1", String.valueOf(index));
                AssemblyFileWriter.appendCommandToCode("la", "$t2", nameOfArrayDesc.getName());
                AssemblyFileWriter.appendCommandToCode("add", "$t1", "$t1", "$t2");
                AssemblyFileWriter.appendCommandToCode("sw", "t0", "0($t1)");
                AssemblyFileWriter.appendDebugLine("0($t1)");
                break;
            case "pushInteger":
                System.out.println("code gen of push integer");
                //TODO (Check if constant is in symbol table)
                IntegerConstant intConst = new IntegerConstant(lexical.intValue);
                intConst.compile();
                break;
            case "pop":
                System.out.println("code gen of pop");
                break;
            case "print":
                new Print((Descriptor) SemanticStack.pop()).compile();
                break;
            case "readInteger":
                new ReadInteger().compile();
                break;
            case "returnStatement":
                new Return((Descriptor) SemanticStack.pop()).compile();
                break;
            case "pushType":
                SemanticStack.push(changeStringToType(lexical.currentSymbol.getToken()));
                break;
            case "popAndPushArrayType":
                Object o = SemanticStack.pop();
                System.out.println(o.toString() + "     <- object top");
                Type type = (Type) o;
                Type resType = null;
                switch (type) {
                    case BOOLEAN:
                        resType = Type.BOOL_ARRAY;
                        break;
                    case INTEGER_NUMBER:
                        resType = Type.INT_ARRAY;
                        break;
                    case REAL_NUMBER:
                        resType = Type.DOUBLE_ARRAY;
                        break;
                    case STRING:
                        resType = Type.STRING_ARRAY;
                        break;
                }
                SemanticStack.push(resType);
                break;
            case "pushIdDcl":
                DescriptorChecker.checkNotContainsDescriptor(lexical.currentSymbol.getToken());
                SemanticStack.push(lexical.currentSymbol.getToken());
                break;
            case "pushId":
                SemanticStack.push(SymbolTableStack.top().getDescriptor(lexical.currentSymbol.getToken()));
                break;
            case "addDescriptor":
                String name = (String) SemanticStack.pop();
                Type t = (Type) SemanticStack.pop();
                if (TypeChecker.isArrayType(t)) {
                    LocalArrayDescriptor lad = new LocalArrayDescriptor(getVariableName(), t);
                    lad.setRealName(name);
                    SymbolTableStack.top().addDescriptor(name, lad);
                } else {
                    if (!SymbolTableStack.top().contains(name)) {
                        LocalVariableDescriptor lvd = new LocalVariableDescriptor(getVariableName(), t);
                        SymbolTableStack.top().addDescriptor(name, lvd);
                        AssemblyFileWriter.appendCommandToData(lvd.getName(), "word", "0");

                    } else {
                        System.err.println("Variable " + name + " is defined before");
                    }
                }
                break;
            case "assignment":
                System.out.println("code gen of assignment");
                Descriptor rightSide = (Descriptor) SemanticStack.pop();
                Descriptor leftSide = (Descriptor) SemanticStack.pop();
                new Assignment(leftSide, rightSide).compile();
                break;
            default:
                System.out.println("Rest");
        }
        System.out.println();
    }

    Type changeStringToType(String type) {
        Type res;
        switch (type) {
            case "int":
                res = Type.INTEGER_NUMBER;
                break;
            default:
                res = null;
        }
        return res;
    }
}
