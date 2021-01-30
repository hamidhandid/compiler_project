package codegen;

import codegen.ast.expression.binary_expression.arithmetic.*;
import codegen.ast.expression.binary_expression.cast.DoubleToInt;
import codegen.ast.expression.binary_expression.cast.IntToDouble;
import codegen.ast.expression.binary_expression.logical.logical_expressions.*;
import codegen.ast.expression.constant.IntegerConstant;
import codegen.ast.expression.constant.RealConstant;
import codegen.ast.expression.constant.StringConstant;
import codegen.ast.expression.input.ReadInteger;
import codegen.ast.expression.input.ReadLine;
import codegen.ast.expression.input.ReadReal;
import codegen.ast.expression.unary_expression.arithmetic.MinusMinus;
import codegen.ast.expression.unary_expression.arithmetic.PlusPlus;
import codegen.ast.expression.unary_expression.logical.Not;
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
import codegen.symbol_table.dscp.record.RecordDescriptor;
import codegen.symbol_table.dscp.record.RecordElement;
import codegen.symbol_table.dscp.variables.GlobalVariableDescriptor;
import codegen.symbol_table.dscp.variables.LocalVariableDescriptor;
import codegen.symbol_table.dscp.variables.RecordVariableDescriptor;
import codegen.symbol_table.dscp.variables.VariableDescriptor;
import codegen.symbol_table.stacks.records.RecordVariable;
import codegen.symbol_table.stacks.records.Records;
import codegen.symbol_table.stacks.SemanticStack;
import codegen.symbol_table.stacks.SymbolTableStack;
import codegen.utils.AssemblyFileWriter;
import codegen.utils.DescriptorChecker;
import codegen.utils.errors.CastError;
import codegen.utils.errors.TypeError;
import codegen.utils.type.TypeChecker;
import scanner.classes.CompilerScanner;
import scanner.classes.Type;

import java.util.ArrayList;

public class CodeGenerator implements parser.CodeGenerator {
    private static CompilerScanner lexical;
    private static int variableIndex = 0;
    private static int labelIndex = 0;

    public static void initCodeGenerator(CompilerScanner scanner) {
        lexical = scanner;
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

    VariableDescriptor index = null;
    Descriptor arrName = null;
    String str = null;
    String str2 = null;

    @Override
    public void doSemantic(String sem) {
        debugPrint(sem);
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
                    DescriptorChecker.checkNotContainsDescriptor(lexical.currentSymbol.getToken());
                    DescriptorChecker.checkNotContainsDescriptorGlobal(lexical.currentSymbol.getToken());
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
                    VariableDescriptor sizeDescriptor = (VariableDescriptor) SemanticStack.pop();
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
                    AssemblyFileWriter.appendCommandToData(nameOfArrayDes.getName(), "space", String.valueOf(4 * Integer.parseInt(sizeDescriptor.getValue())));
                    break;
                case "arrayAccess":
                    index = (VariableDescriptor) SemanticStack.pop();
                    arrName = (Descriptor) SemanticStack.pop();
                    AssemblyFileWriter.appendComment("array access with name " + arrName.getName() + " at " + index.getValue());
                    AssemblyFileWriter.appendCommandToCode("la", "$t0", arrName.getName());
                    AssemblyFileWriter.appendCommandToCode("li", "$t4", "4");
                    AssemblyFileWriter.appendCommandToCode("li", "$t1", String.valueOf(index.getValue()));
                    AssemblyFileWriter.appendCommandToCode("mul", "$t1", "$t1", "$t4");
                    AssemblyFileWriter.appendCommandToCode("add", "$t0", "$t0", "$t1");
                    AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
                    LocalVariableDescriptor lvd = new LocalVariableDescriptor(getVariableName(), changeArrayTypeToElementType(arrName.getType()));
                    AssemblyFileWriter.appendCommandToData(lvd.getName(), "word", "0");
                    SemanticStack.push(lvd);
                    AssemblyFileWriter.appendCommandToCode("sw", "$t0", lvd.getName());
                    break;
                case "popArrayAccess":
                    SemanticStack.pop();
                    SemanticStack.push(arrName);
                    SemanticStack.push(index);
                    break;
                case "arrayAssignment":
                    Descriptor rightSide = (Descriptor) SemanticStack.pop();
                    Descriptor des = (Descriptor) SemanticStack.pop();
                    AssemblyFileWriter.appendComment("left array assignment");
                    if (TypeChecker.isArrayType(des.getType())) {
                        VariableDescriptor des2 = (VariableDescriptor) SemanticStack.pop();
                        Descriptor nameOfArrayDesc = (Descriptor) SemanticStack.pop();
                        int idx = Integer.parseInt(des2.getValue());
                        int rightIndex = Integer.parseInt(((VariableDescriptor) rightSide).getValue());
                        //right
                        AssemblyFileWriter.appendCommandToCode("li", "$t0", String.valueOf(rightIndex));
                        AssemblyFileWriter.appendCommandToCode("la", "$t1", des.getName());
                        AssemblyFileWriter.appendCommandToCode("li", "$t4", String.valueOf(4)); //TODO: convert 4 to size of
                        AssemblyFileWriter.appendCommandToCode("mul", "$t0", "$t0", "$t4");
                        AssemblyFileWriter.appendCommandToCode("add", "$t1", "$t1", "$t0");
                        AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t1)");
                        //left
                        AssemblyFileWriter.appendCommandToCode("li", "$t2", String.valueOf(idx));
                        AssemblyFileWriter.appendCommandToCode("la", "$t3", nameOfArrayDesc.getName());
                        AssemblyFileWriter.appendCommandToCode("mul", "$t2", "$t2", "$t4");
                        AssemblyFileWriter.appendCommandToCode("add", "$t3", "$t3", "$t2");
                        //assign
                        AssemblyFileWriter.appendCommandToCode("sw", "$t1", "0($t3)");
                        AssemblyFileWriter.appendDebugLine("0($t3)");

                    } else {
                        VariableDescriptor arrIndex = (VariableDescriptor) des;
                        Descriptor nameOfArrDes = (Descriptor) SemanticStack.pop();
                        AssemblyFileWriter.appendCommandToCode("li", "$t1", String.valueOf(arrIndex.getValue()));
                        AssemblyFileWriter.appendCommandToCode("la", "$t2", nameOfArrDes.getName());
                        AssemblyFileWriter.appendCommandToCode("li", "$t4", String.valueOf(4)); //TODO: convert 4 to size of
                        AssemblyFileWriter.appendCommandToCode("mul", "$t1", "$t1", "$t4");
                        AssemblyFileWriter.appendCommandToCode("add", "$t1", "$t1", "$t2");
                        AssemblyFileWriter.appendCommandToCode("la", "$t3", rightSide.getName());
                        AssemblyFileWriter.appendCommandToCode("lw", "$t3", "0($t3)");
                        AssemblyFileWriter.appendCommandToCode("sw", "$t3", "0($t1)");
                        AssemblyFileWriter.appendDebugLine("0($t1)");
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
                    IntegerConstant intConst = new IntegerConstant(lexical.intValue);
                    intConst.compile();
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
                    DescriptorChecker.checkNotContainsDescriptor(lexical.currentSymbol.getToken());
                    DescriptorChecker.checkNotContainsDescriptorGlobal(lexical.currentSymbol.getToken());

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
                    Object t1 = SemanticStack.pop();
                    if (t1 instanceof String) { // record
                        o = null;
                        try {
                            if (!SemanticStack.isEmpty()) {
                                o = SemanticStack.pop();
                                String isRecord = (String) o;
                                if (isRecord.equals("record")) {
                                    String recName = (String) t1;
                                    if (!Records.contains(recName)) {
                                        Records.noRecordWithThisName(recName);
                                    } else {
                                        RecordDescriptor recordDescriptor = new RecordDescriptor(getVariableName());
                                        recordDescriptor.setTypeName(recName);
                                        ArrayList<RecordElement> recordElements = new ArrayList<>();
                                        ArrayList<RecordVariable> recordVariables = Records.getVars(recName);
                                        for (int i = 0; i < recordVariables.size(); i++) {
                                            RecordVariable r = recordVariables.get(i);
                                            recordElements.add(new RecordElement(i, new LocalVariableDescriptor(r.getId(), r.getType())));
                                        }
                                        recordDescriptor.setRecordElements(recordElements);
                                        GlobalSymbolTable.getSymbolTable().addDescriptor(name, recordDescriptor);
                                        AssemblyFileWriter.appendCommandToData(recordDescriptor.getName(), "space", String.valueOf(4 * recordElements.size()));
                                    }
                                } else {
                                    SemanticStack.push(o);
                                }
                            }
                        } catch (Exception e) {
                            SemanticStack.push(o);
                        }
                    } else if (t1 instanceof Type) {
                        Type t = (Type) t1;
                        if (TypeChecker.isArrayType(t)) {
                            ArrayDescriptor lad = (ArrayDescriptor) SymbolTableStack.top().getDescriptor(name);
                            lad.setRealName(name);
                        } else {
                            if (!SymbolTableStack.top().contains(name)) {
                                lvd = new LocalVariableDescriptor(getVariableName(), t);
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
                    }
                    break;
                case "addDescriptorGlobal":
                    name = (String) SemanticStack.pop();
                    Type t = (Type) SemanticStack.pop();
                    if (TypeChecker.isArrayType(t)) {
                        GlobalArrayDescriptor lad = new GlobalArrayDescriptor(getVariableName(), t);
                        lad.setRealName(name);
                        GlobalSymbolTable.getSymbolTable().addDescriptor(name, lad);
                    } else {
                        if (!GlobalSymbolTable.getSymbolTable().contains(name)) {
                            GlobalVariableDescriptor gvd = new GlobalVariableDescriptor(getVariableName(), t);
                            GlobalSymbolTable.getSymbolTable().addDescriptor(name, gvd);
                            if (t != Type.STRING) {
                                AssemblyFileWriter.appendCommandToData(gvd.getName(), "word", "0");
                            } else {
                                AssemblyFileWriter.appendCommandToData(gvd.getName(), "space", "20");
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
                        String srcType = des.getType().toString();
                        String destType = type.toString();
                        new CastError(srcType, destType).error();
                    }
                    break;
                case "addAssign":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    SemanticStack.push(firstOperand);
                    new Add(firstOperand, secondOperand).compile();
                    new Assignment().compile();
                    break;
                case "subAssign":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    SemanticStack.push(firstOperand);
                    new Subtract(firstOperand, secondOperand).compile();
                    new Assignment().compile();
                    break;
                case "multAssign":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    SemanticStack.push(firstOperand);
                    new Multiply(firstOperand, secondOperand).compile();
                    new Assignment().compile();
                    break;
                case "divAssign":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    SemanticStack.push(firstOperand);
                    new Divide(firstOperand, secondOperand).compile();
                    new Assignment().compile();
                    break;
                case "andAssign":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    SemanticStack.push(firstOperand);
                    new And(firstOperand, secondOperand).compile();
                    new Assignment().compile();
                    break;
                case "orAssign":
                    secondOperand = (Descriptor) SemanticStack.pop();
                    firstOperand = (Descriptor) SemanticStack.pop();
                    SemanticStack.push(firstOperand);
                    new Or(firstOperand, secondOperand).compile();
                    new Assignment().compile();
                    break;
                case "assignment":
                    new Assignment().compile();
                    break;
                case "recordAddName":
                    SemanticStack.push(lexical.currentSymbol.getToken());
                    Records.put(lexical.currentSymbol.getToken(), new ArrayList<>());
                    break;
                case "pushRecordType":
                    SemanticStack.push(lexical.currentSymbol.getToken());
                    break;
                case "pushIdRecordDcl":
                    type = changeStringToType((String) SemanticStack.pop());
                    name = (String) SemanticStack.pop();
                    Records.addVar(name, new RecordVariable(name, type));
                    break;
                case "pushRecord":
                    SemanticStack.push("record");
                    break;
                case "checkHasRecord":
                    if (Records.contains(lexical.currentSymbol.getToken())) {
                        SemanticStack.push(lexical.currentSymbol.getToken());
                    } else {
                        Records.noRecordWithThisName(lexical.currentSymbol.getToken());
                    }
                    break;
                case "recordVarAndPush":
                    str = lexical.currentSymbol.getToken();
                    str2 = (String) SemanticStack.pop();
                    try {
                        RecordDescriptor descriptor = (RecordDescriptor) GlobalSymbolTable.getSymbolTable().getDescriptor(str);
                        int index = descriptor.getIndex(str2);
                        AssemblyFileWriter.appendCommandToCode("la", "$t0", descriptor.getName());
                        AssemblyFileWriter.appendCommandToCode("li", "$t1", String.valueOf(index));
                        AssemblyFileWriter.appendCommandToCode("li", "$t4", "4");
                        AssemblyFileWriter.appendCommandToCode("mul", "$t1", "$t1", "$t4");
                        AssemblyFileWriter.appendCommandToCode("add", "$t0", "$t0", "$t1");
                        String newAdr = getVariableName();
                        AssemblyFileWriter.appendCommandToData(newAdr, "word", "0");
                        AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
                        AssemblyFileWriter.appendCommandToCode("sw", "$t0", newAdr);
                        SemanticStack.push(new LocalVariableDescriptor(newAdr, Type.INTEGER_NUMBER));
                    } catch (Exception e) {
                        Records.noRecordWithThisName(str);
                    }
                    break;
                case "popRecord":
                    SemanticStack.pop();
                    SemanticStack.push(str2);
                    SemanticStack.push(str);
                    break;
                case "recordAssignment":
                    rightSide = (Descriptor) SemanticStack.pop();
                    String recVar = (String) SemanticStack.pop();
                    String recName = (String) SemanticStack.pop();
                    try {
                        if (Records.contains(recName)) {
                            RecordDescriptor descriptor = (RecordDescriptor) GlobalSymbolTable.getSymbolTable().getDescriptor(recName);
                            int index = descriptor.getIndex(recVar);
                            AssemblyFileWriter.appendCommandToCode("la", "$t0", rightSide.getName());
                            AssemblyFileWriter.appendCommandToCode("lw", "$t0", "0($t0)");
                            AssemblyFileWriter.appendCommandToCode("li", "$t1", String.valueOf(index));
                            AssemblyFileWriter.appendCommandToCode("li", "$t4", "4");
                            AssemblyFileWriter.appendCommandToCode("mul", "$t1", "$t1", "$t4");
                            AssemblyFileWriter.appendCommandToCode("la", "$t2", descriptor.getName());
                            AssemblyFileWriter.appendCommandToCode("add", "$t2", "$t2", "$t1");
                            AssemblyFileWriter.appendCommandToCode("sw", "$t0", "0($t2)");
                        } else {
                            Records.noRecordWithThisName(recName);
                        }
                    } catch (Exception e) {
                        System.err.println("Compile Error Occurred");
                    }
                    break;
                default:
                    System.out.println("Rest");
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println("Compile Error Occurred");
            // e.printStackTrace();
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

    Type changeArrayTypeToElementType(Type arrType) {
        Type res;
        switch (arrType) {
            case DOUBLE_ARRAY:
                res = Type.REAL_NUMBER;
                break;
            case INT_ARRAY:
                res = Type.INTEGER_NUMBER;
                break;
            case STRING_ARRAY:
                res = Type.STRING;
                break;
            default:
                res = null;
        }
        return res;
    }

    private void debugPrint(String sem) {
        System.out.println("sem = " + sem);
        try {
            System.out.println("token = " + lexical.currentSymbol.getToken());
            SemanticStack.print();
            SymbolTableStack.top().print();
        } catch (Exception e) {
        }
    }
}
