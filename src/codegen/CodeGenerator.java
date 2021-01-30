package codegen;

import codegen.ast.declaration.variable_declaration.LocalVariableDeclaration;
import codegen.ast.expression.binary_expression.arithmetic.*;
import codegen.ast.expression.binary_expression.cast.DoubleToInt;
import codegen.ast.expression.binary_expression.cast.IntToDouble;
import codegen.ast.expression.binary_expression.logical.logical_expressions.*;
/*import codegen.ast.expression.binary_expression.logical.logical_expressions.Not;
import codegen.ast.expression.binary_expression.logical.logical_expressions.Or;
import codegen.ast.expression.binary_expression.logical.logical_expressions.SmallerThan;*/
import codegen.ast.expression.constant.IntegerConstant;
import codegen.ast.expression.constant.RealConstant;
import codegen.ast.expression.constant.StringConstant;
import codegen.ast.expression.input.ReadInteger;
import codegen.ast.expression.input.ReadLine;
import codegen.ast.expression.input.ReadReal;
import codegen.ast.expression.unary_expression.arithmetic.MinusMinus;
import codegen.ast.expression.unary_expression.arithmetic.PlusPlus;
import codegen.ast.statement_block.statements.If;
import codegen.ast.statement_block.statements.Print;
import codegen.ast.statement_block.statements.Assignment;
import codegen.ast.statement_block.statements.Return;
import codegen.ast.statement_block.statements.loops.For;
import codegen.ast.statement_block.statements.loops.While;
import codegen.symbol_table.GlobalSymbolTable;
import codegen.symbol_table.dscp.Descriptor;
import codegen.symbol_table.dscp.array.ArrayDescriptor;
import codegen.symbol_table.dscp.array.GlobalArrayDescriptor;
import codegen.symbol_table.dscp.array.LocalArrayDescriptor;
import codegen.symbol_table.dscp.variables.GlobalVariableDescriptor;
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
        try {


            switch (sem) {
                case "add":
                    System.out.println("code gen of add");
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Add(firstOperand, secondOperand).compile();
                    break;
                case "sub":
                    System.out.println("code gen of subtract");
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Subtract(firstOperand, secondOperand).compile();
                    break;
                case "mult":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Multiply(firstOperand, secondOperand).compile();
                    System.out.println("code gen of multiply");
                    break;
                case "div":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Divide(firstOperand, secondOperand).compile();
                    System.out.println("code gen of division");
                    break;
                case "remainder":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Remainder(firstOperand, secondOperand).compile();
                    System.out.println("code gen of remainder");
                    break;
                case "nor":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Nor(firstOperand, secondOperand).compile();
                    System.out.println("code gen of nor");
                    break;
                case "and":
                case "logicalAnd":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new And(firstOperand, secondOperand).compile();
                    System.out.println("code gen of and");
                    break;
                case "or":
                case "logicalOr":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Or(firstOperand, secondOperand).compile();
                    System.out.println("code gen of or");
                    break;
                case "xor":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Xor(firstOperand, secondOperand).compile();
                    System.out.println("code gen of xor");
                    break;
                case "not":
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Not(firstOperand).compile();
                    System.out.println("code gen of not");
                    break;
                case "minusMinus":
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new MinusMinus(firstOperand).compile();
                    System.out.println("code gen of minus minus");
                    break;
                case "plusPlus":
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new PlusPlus(firstOperand).compile();
                    System.out.println("code gen of plus plus");
                    break;
                case "biggerThan":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new BiggerThan(firstOperand, secondOperand).compile();
                    System.out.println("code gen of biggerThan");
                    break;
                case "biggerThanAndEqual":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new BiggerThanAndEqual(firstOperand, secondOperand).compile();
                    System.out.println("code gen of biggerThanAndEqual");
                    break;
                case "smallerThan":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new SmallerThan(firstOperand, secondOperand).compile();
                    break;
                case "smallerThanAndEqual":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new SmallerThanAndEqual(firstOperand, secondOperand).compile();
                    System.out.println("code gen of smallerThanAndEqual");
                    break;
                case "equal":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new Equal(firstOperand, secondOperand).compile();
                    System.out.println("code gen of equal");
                    break;
                case "notEqual":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    new NotEqual(firstOperand, secondOperand).compile();
                    System.out.println("code gen of notEqual");
                    break;
                case "break":
                    //TODO
                    System.out.println("code gen of break");
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
                case "startConditionFor":
                    For.startCondition();
                    break;
                case "forJumpZero":
                    new For((Descriptor) SemanticStack.pop()).compile();
                    break;
                case "completeFor":
                    For.completeFor();
                    For.stepStatement();
                    For.completeStepOfFor();
                    break;
                case "arrayDcl":
                    try {
                        DescriptorChecker.checkNotContainsDescriptor(lexical.currentSymbol.getToken());
                    } catch (Exception e) {
                        DescriptorChecker.checkNotContainsDescriptorGlobal(lexical.currentSymbol.getToken());
                    }
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
                case "arrayDclGlobal":
                    DescriptorChecker.checkNotContainsDescriptorGlobal(lexical.currentSymbol.getToken());
                    arrType = (Type) SemanticStack.top();
                    if (!GlobalSymbolTable.getSymbolTable().contains(lexical.currentSymbol.getToken())) {
                        GlobalArrayDescriptor lad = new GlobalArrayDescriptor(getVariableName(), arrType);
                        GlobalSymbolTable.getSymbolTable().addDescriptor(lexical.currentSymbol.getToken(), lad);
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
                    if (nameOfArrayDes.getIsLocal()) {
                        DescriptorChecker.checkContainsDescriptor(nameOfArrayDes);
                    } else {
                        DescriptorChecker.checkContainsDescriptorGlobal(nameOfArrayDes);
                    }
                    TypeChecker.checkArrayType(nameOfArrayDes.getType(), newArrayType);
                    ArrayDescriptor ad = new LocalArrayDescriptor(nameOfArrayDes.getName(), newArrayType);
                    if (nameOfArrayDes.getIsLocal()) {
                        SymbolTableStack.top().addDescriptor(nameOfArrayDes.getRealName(), ad);
                    } else {
                        GlobalSymbolTable.getSymbolTable().addDescriptor(nameOfArrayDes.getRealName(), ad);
                    }
                    AssemblyFileWriter.appendCommandToData(nameOfArrayDes.getName(), ".space", String.valueOf(4 * Integer.parseInt(sizeDescriptor.getValue())));
                    break;
                case "arrayAssignment":
                    Descriptor rightSide = (Descriptor) SemanticStack.pop();
                    Descriptor des = (Descriptor) SemanticStack.pop();
                    if (TypeChecker.isArrayType(des.getType())) {
                        VariableDescriptor des2 = (VariableDescriptor) SemanticStack.pop();
                        Descriptor nameOfArrayDesc = (Descriptor) SemanticStack.pop();
                        int index = Integer.parseInt(des2.getValue());
                        int rightIndex = Integer.parseInt(((VariableDescriptor) rightSide).getValue());
                        //right
                        AssemblyFileWriter.appendCommandToCode("li", "$t0", String.valueOf(rightIndex));
                        AssemblyFileWriter.appendCommandToCode("la", "$t1", des.getName());
                        AssemblyFileWriter.appendCommandToCode("add", "$t1", "$t1", "$t0");
                        AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t1)");
                        //left
                        AssemblyFileWriter.appendCommandToCode("li", "$t2", String.valueOf(index));
                        AssemblyFileWriter.appendCommandToCode("la", "$t3", nameOfArrayDesc.getName());
                        AssemblyFileWriter.appendCommandToCode("add", "$t3", "$t3", "$t2");
                        //assign
                        AssemblyFileWriter.appendCommandToCode("sw", "$t1", "0($t3)");
                    } else {
                        VariableDescriptor arrIndex = (VariableDescriptor) des;
                        Descriptor nameOfArrDes = (Descriptor) SemanticStack.pop();
                        AssemblyFileWriter.appendCommandToCode("li", "$t1", String.valueOf(arrIndex.getValue()));
                        AssemblyFileWriter.appendCommandToCode("la", "$t2", nameOfArrDes.getName());
                        AssemblyFileWriter.appendCommandToCode("add", "$t1", "$t1", "$t2");
                        AssemblyFileWriter.appendCommandToCode("la", "$t3", rightSide.getName());
                        AssemblyFileWriter.appendCommandToCode("lw", "$t3", "0($t3)");
                        AssemblyFileWriter.appendCommandToCode("sw", "$t3", "0($t1)");
                    }
                    break;
                case "trueCode":
                    new IntegerConstant(1).compile();
                    break;
                case "falseCode":
                    new IntegerConstant(0).compile();
                    break;
                case "pushInteger":
                    System.out.println("code gen of push integer");
                    //TODO (Check if constant is in symbol table)
                    IntegerConstant intConst = new IntegerConstant(lexical.intValue);
                    intConst.compile();
                    break;
                case "pushBool":
//                System.out.println("code gen of push integer");
//                //TODO (Check if constant is in symbol table)
//                IntegerConstant intConst = new IntegerConstant(lexical.intValue);
//                intConst.compile();
                    break;
                case "pushDouble":
                    new RealConstant(lexical.realValue).compile();
                    break;
                case "pushString":
                    System.out.println("push str " + lexical.stringValue);
                    new StringConstant(lexical.stringValue).compile();
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
                case "readLine":
                    new ReadLine().compile();
                    break;
                case "readReal":
                    new ReadReal().compile();
                    break;
                case "returnStatement":
                    new Return((Descriptor) SemanticStack.pop()).compile();
                    break;
                case "pushType":
                    SemanticStack.push(changeStringToType(lexical.currentSymbol.getToken()));
                    break;
                case "popAndPushArrayType":
                    Object o = SemanticStack.pop();
//                System.out.println(o.toString() + "     <- object top");
                    Type type = (Type) o;
                    Type resType = null;
                    switch (type) {
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
                    try {
                        DescriptorChecker.checkNotContainsDescriptor(lexical.currentSymbol.getToken());
                    } catch (Exception e) {
                        DescriptorChecker.checkNotContainsDescriptorGlobal(lexical.currentSymbol.getToken());
                    }
                    SemanticStack.push(lexical.currentSymbol.getToken());
                    break;
                case "pushIdDclGlobal":
                    DescriptorChecker.checkNotContainsDescriptorGlobal(lexical.currentSymbol.getToken());
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
                            if (t != Type.STRING) {
                                AssemblyFileWriter.appendCommandToData(lvd.getName(), "word", "0");
                            } else {
                                AssemblyFileWriter.appendCommandToData(lvd.getName(), "space", "20");
                            }
                        } else {
                            System.err.println("Variable " + name + " is defined before");
                        }
                    }
                    break;
                case "addDescriptorGlobal":
                    name = (String) SemanticStack.pop();
                    t = (Type) SemanticStack.pop();
                    if (TypeChecker.isArrayType(t)) {
                        GlobalArrayDescriptor lad = new GlobalArrayDescriptor(getVariableName(), t);
                        lad.setRealName(name);
                        GlobalSymbolTable.getSymbolTable().addDescriptor(name, lad);
                    } else {
                        if (!GlobalSymbolTable.getSymbolTable().contains(name)) {
                            GlobalVariableDescriptor lvd = new GlobalVariableDescriptor(getVariableName(), t);
                            GlobalSymbolTable.getSymbolTable().addDescriptor(name, lvd);
                            if (t != Type.STRING) {
                                AssemblyFileWriter.appendCommandToData(lvd.getName(), "word", "0");
                            } else {
                                AssemblyFileWriter.appendCommandToData(lvd.getName(), "space", "20");
                            }
                        } else {
                            System.err.println("Variable " + name + " is defined before");
                        }
                    }
                    break;
                case "cast":
                    des = (Descriptor) SemanticStack.pop();
                    type = (Type) SemanticStack.pop();
                    if (type == Type.INTEGER_NUMBER) {
                        new DoubleToInt(des, type).compile();
                    } else if (type == Type.REAL_NUMBER) {
                        new IntToDouble(des, type).compile();
                    } else {
                        //TODO (generator type Exception)
                    }
                    break;
                case "assignment":
                    System.out.println("code gen of assignment");
                    rightSide = (Descriptor) SemanticStack.pop();
                    des = (Descriptor) SemanticStack.pop();
                    if (TypeChecker.isArrayType(des.getType())) {
                        int index = Integer.parseInt(((VariableDescriptor) rightSide).getValue());
                        AssemblyFileWriter.appendCommandToCode("li", "$t0", String.valueOf(index));
                        AssemblyFileWriter.appendCommandToCode("la", "$t1", des.getName());
                        AssemblyFileWriter.appendCommandToCode("add", "$t1", "$t1", "$t0");
                        AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t1)");
                        Descriptor leftSide = (Descriptor) SemanticStack.pop();
                        AssemblyFileWriter.appendCommandToCode("sw", "$t1", leftSide.getName());
                    } else {
                        Descriptor leftSide = (Descriptor) des;
                        new Assignment(leftSide, rightSide).compile();
                    }
                    break;
                default:
                    System.out.println("Rest");
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println("Compile Error Occurred");
            e.printStackTrace();
        }
    }


    Type changeStringToType(String type) {
        Type res;
        switch (type) {
            case "bool":
            case "int":
                res = Type.INTEGER_NUMBER;
                break;
            case "double":
                res = Type.REAL_NUMBER;
                break;
            case "string":
                res = Type.STRING;
                break;
            default:
                res = null;
        }
        return res;
    }
}
