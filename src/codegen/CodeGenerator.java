package codegen;

import codegen.ast.expression.binary_expression.arithmetic.Add;
import codegen.ast.expression.constant.IntegerConstant;
import codegen.ast.expression.input.ReadInteger;
import codegen.ast.statement_block.statements.Print;
import codegen.ast.statement_block.statements.Assignment;
import codegen.ast.statement_block.statements.Return;
import codegen.symbol_table.dscp.Descriptor;
import codegen.symbol_table.dscp.variables.LocalVariableDescriptor;
import codegen.symbol_table.stacks.SemanticStack;
import codegen.symbol_table.stacks.SymbolTableStack;
import codegen.utils.AssemblyFileWriter;
import scanner.classes.CompilerScanner;
import scanner.classes.Type;

public class CodeGenerator implements parser.CodeGenerator {
    private CompilerScanner lexical;
    private static int variableIndex = 0;

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
        switch (sem) {
            case "add":
                System.out.println("code gen of add");
                Descriptor secondOperand = (Descriptor) SemanticStack.pop();
                Descriptor firstOperand = (Descriptor) SemanticStack.pop();
                new Add(firstOperand, secondOperand).compile();
                break;
            case "sub":
                System.out.println("code gen of subtract");
                break;
            case "mult":
                System.out.println("code gen of multiply");
                break;
            case "div":
                System.out.println("code gen of division");
                break;
            case "and":
                System.out.println("code gen of and");
                break;
            case "or":
                System.out.println("code gen of or");
                break;
            case "not":
                System.out.println("code gen of not");
                break;
            case "biggerThan":
                System.out.println("code gen of biggerThan");
                break;
            case "biggerThanAndEqual":
                System.out.println("code gen of biggerThanAndEqual");
                break;
            case "smallerThan":
                System.out.println("code gen of smallerThan");
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
                System.out.println("code gen of if");
                break;
            case "else":
                System.out.println("code gen of else");
                break;
            case "while":
                System.out.println("code gen of while");
                break;
            case "push":
                System.out.println("code gen of push");
                break;
            case "pushInteger":
                System.out.println("code gen of push integer");
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
            case "pushIdDcl":
                SemanticStack.push(lexical.currentSymbol.getToken());
                break;
            case "pushId":
                SemanticStack.push(SymbolTableStack.top().getDescriptor(lexical.currentSymbol.getToken()));
                break;
            case "addDescriptor":
                String name = (String) SemanticStack.pop();
                Type type = (Type) SemanticStack.pop();
                if (!SymbolTableStack.top().contains(name)) {
                    LocalVariableDescriptor lvs = new LocalVariableDescriptor(getVariableName(), type);
                    SymbolTableStack.top().addDescriptor(name, lvs);
                    AssemblyFileWriter.appendCommandToData(lvs.getName(), "word", "0");
                } else {
                    System.err.println("Variable is defined before");
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
