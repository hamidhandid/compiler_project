package codegen;

public class CodeGenerator implements parser.CodeGenerator {

    @Override
    public void doSemantic(String sem) {
        switch (sem) {
            case "add":
                System.out.println("code gen of add");
                break;
            case "sub":
                System.out.println("code gen of substract");
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
            case "pop":
                System.out.println("code gen of pop");
                break;
            default:
                System.out.println("Rest");
        }
    }
}
