package codegen;

import codegen.ast.expression.binary_expression.arithmetic.Add;
import codegen.ast.expression.constant.IntegerConstant;
import codegen.symbol_table.stacks.SemanticStack;
import scanner.classes.CompilerScanner;

public class CodeGenerator implements parser.CodeGenerator {
    private CodeGenerator() {
    }

    private CompilerScanner lexical;

    public CompilerScanner getLexical() {
        return lexical;
    }

    public void initLexical(CompilerScanner lexical) {
        this.lexical = lexical;
    }

    private static CodeGenerator instance = new CodeGenerator();

    public static CodeGenerator getInstance() {
        return instance;
    }

    @Override
    public void doSemantic(String sem) {
        switch (sem) {
            case "add":
                System.out.println("code gen of add");
//                int secondOperand = (Integer) SemanticStack.getInstance().pop();
//                int firstOperand = (Integer) SemanticStack.getInstance().pop();
//                Add add = new Add(firstOperand, secondOperand);
//                add.compile();
//                System.out.println(SemanticStack.getInstance().peek());
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
            case "print":
                System.out.println("code gen of print");
                break;
            /* case "assignment":
                System.out.println("code gen of or");
                break; */
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
            default:
                System.out.println("Rest");
        }
    }
}
